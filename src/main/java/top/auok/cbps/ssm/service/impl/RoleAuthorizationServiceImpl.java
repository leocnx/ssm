package top.auok.cbps.ssm.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

import top.auok.cbps.ssm.dao.AuthorizationDao;
import top.auok.cbps.ssm.dao.RoleAuthorizationDao;
import top.auok.cbps.ssm.model.Authorization;
import top.auok.cbps.ssm.model.RoleAuthorization;
import top.auok.cbps.ssm.service.OperatorRoleService;
import top.auok.cbps.ssm.service.RoleAuthorizationService;

@Service("roleAuthorizationService")
public class RoleAuthorizationServiceImpl implements RoleAuthorizationService {
	
	@Resource
	private AuthorizationDao authorizationDao;
	
	@Resource
	private OperatorRoleService operatorRoleService;
	
	@Resource
	private RoleAuthorizationDao roleAuthorizationDao;

	@Override
	public Set<String> getAuthorizationsByOperatorId(Long operatorId) {
		// 根据操作员Id查询出关联的所有角色id
		String roleIds = operatorRoleService.getRoleIdsByOperatorId(operatorId);

		String authorizationIdIds = getAuthorizationIdsByRoleIds(roleIds);
		Set<String> authorizationSet = new HashSet<String>();

		// 根据角色ID字符串得到该用户的所有权限拼成的字符串
		if (!StringUtils.isEmpty(authorizationIdIds)) {
			List<Authorization> authorizations = authorizationDao.getByIds(authorizationIdIds);
			for (Authorization authorization : authorizations) {
				authorizationSet.add(authorization.getAuthCode());
			}
		}
		return authorizationSet;
	}

	@Override
	public String getAuthorizationIdsByRoleIds(String roleIds) {
		// 得到角色－权限表中roleiId在ids中的所有关联对象
		List<RoleAuthorization> listRoleAuthorization = roleAuthorizationDao.listByRoleIds(roleIds); // 构建StringBuffer
		StringBuffer authorizationIdsBuf = new StringBuffer("");
		// 拼接字符串
		for (RoleAuthorization roleAuthorization : listRoleAuthorization) {
			authorizationIdsBuf.append(roleAuthorization.getAuthId()).append(",");
		}
		String authorizationIds = authorizationIdsBuf.toString();
		// 截取字符串
		if (StringUtils.isEmpty(authorizationIds) && authorizationIds.length() > 0) {
			authorizationIds = authorizationIds.substring(0, authorizationIds.length() - 1); // 去掉最后一个逗号
		}
		return authorizationIds;
	}
	
}
