package top.auok.cbps.ssm.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import top.auok.cbps.ssm.dao.RoleDao;
import top.auok.cbps.ssm.dao.RoleOperatorDao;
import top.auok.cbps.ssm.model.Role;
import top.auok.cbps.ssm.model.RoleOperator;
import top.auok.cbps.ssm.service.OperatorRoleService;

@Service("operatorRoleService")
public class OperatorRoleServiceImpl implements OperatorRoleService {
	
	@Resource
	private RoleOperatorDao roleOperatorDao;
	
	@Resource
	private RoleDao roleDao;
	
	@Override
	public Set<String> getRoleCodeByOperatorId(Long operatorId) {
		// 得到操作员和角色列表
		List<RoleOperator> rpList = roleOperatorDao.listByOperatorId(operatorId);
		Set<String> roleCodeSet = new HashSet<String>();

		for (RoleOperator rp : rpList) {
			Long roleId = rp.getRoleId();
			Role role = roleDao.getById(roleId);
			if (role == null) {
				continue;
			}
			roleCodeSet.add(role.getRoleCode());
		}

		return roleCodeSet;
	}

	@Override
	public String getRoleIdsByOperatorId(Long operatorId) {
		// 得到操作员和角色列表
		List<RoleOperator> rpList = roleOperatorDao.listByOperatorId(operatorId);
		// 构建StringBuffer来拼字符串
		StringBuffer roleIdsBuf = new StringBuffer("");
		for (RoleOperator rp : rpList) {
			roleIdsBuf.append(rp.getRoleId()).append(",");
		}
		String roleIds = roleIdsBuf.toString();
		// 截取字符串
		if (StringUtils.isNotBlank(roleIds) && roleIds.length() > 0) {
			roleIds = roleIds.substring(0, roleIds.length() - 1);
		}
		return roleIds;
	}

}
