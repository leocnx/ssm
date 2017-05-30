package top.auok.cbps.ssm.dao;

import java.util.List;

import top.auok.cbps.ssm.dao.base.BaseDao;
import top.auok.cbps.ssm.model.RoleAuthorization;

public interface RoleAuthorizationDao extends BaseDao<RoleAuthorization> {
	
	List<RoleAuthorization> listByRoleIds(String roleIdsStr);
}