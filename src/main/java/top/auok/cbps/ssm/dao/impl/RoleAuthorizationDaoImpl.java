package top.auok.cbps.ssm.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import top.auok.cbps.ssm.dao.RoleAuthorizationDao;
import top.auok.cbps.ssm.dao.base.impl.BaseDaoImpl;
import top.auok.cbps.ssm.model.RoleAuthorization;

@Repository
public class RoleAuthorizationDaoImpl extends BaseDaoImpl<RoleAuthorization> implements RoleAuthorizationDao {

	@Override
	public List<RoleAuthorization> listByRoleIds(String roleIdsStr) {
		List<String> roldIds = Arrays.asList(roleIdsStr.split(","));
		return super.getSqlSession().selectList(getStatement("listByRoleIds"), roldIds);
	}

}
