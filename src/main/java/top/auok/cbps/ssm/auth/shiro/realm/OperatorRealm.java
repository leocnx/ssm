package top.auok.cbps.ssm.auth.shiro.realm;

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import top.auok.cbps.ssm.model.Operator;
import top.auok.cbps.ssm.service.OperatorRoleService;
import top.auok.cbps.ssm.service.OperatorService;
import top.auok.cbps.ssm.service.RoleAuthorizationService;

/**
 * 自定义realm .
 */
public class OperatorRealm extends AuthorizingRealm {

	@Autowired
	private OperatorService operatorService;
	@Autowired
	private OperatorRoleService operatorRoleService;
	@Autowired
	private RoleAuthorizationService roleAuthorizationService;

	@SuppressWarnings("unchecked")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String loginName = (String) principals.getPrimaryPrincipal();

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		Operator operator = (Operator) session.getAttribute("operator");
		if (operator == null) {
			operator = operatorService.getByLoginName(loginName);
			session.setAttribute("operator", operator);
		}
		// 根据登录名查询操作员   角色
		Long operatorId = operator.getId();

		Set<String> roles = (Set<String>) session.getAttribute("ROLES");
		if (roles == null || roles.isEmpty()) {
			roles = operatorRoleService.getRoleCodeByOperatorId(operatorId);
			session.setAttribute("ROLES", roles);
		}
		authorizationInfo.setRoles(roles);

		Set<String> authorizations = (Set<String>) session.getAttribute("AUTHORIZATIONS");
		if (authorizations == null || authorizations.isEmpty()) {
			authorizations = roleAuthorizationService.getAuthorizationsByOperatorId(operatorId);
			session.setAttribute("AUTHORIZATIONS", authorizations);
		}
		// 根据用户名查询权限
		authorizationInfo.setStringPermissions(authorizations);
		return authorizationInfo;
	}

	@Override
	// 验证的核心方法
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String loginName = (String) token.getPrincipal();
		if (StringUtils.isEmpty(loginName.trim())) {
			throw new UnknownAccountException();// 没找到帐号
		}

		// 根据登录名查询操作员
		Operator operator = operatorService.getByLoginName(loginName);

		if (operator == null) {
			throw new UnknownAccountException();// 没找到帐号
		}

		if (!"ACTIVE".equals(operator.getOprStatus())) {
			throw new LockedAccountException(); // 帐号锁定
		}

		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(operator.getLoginName(), // 登录名
				operator.getLoginPwd(), // 密码
				ByteSource.Util.bytes(operator.getCredentialsSalt()), // salt=username+salt
				getName() // realm name
		);

		return authenticationInfo;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
