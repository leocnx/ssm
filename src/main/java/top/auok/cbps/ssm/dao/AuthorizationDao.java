package top.auok.cbps.ssm.dao;

import java.util.List;

import top.auok.cbps.ssm.dao.base.BaseDao;
import top.auok.cbps.ssm.model.Authorization;

public interface AuthorizationDao extends BaseDao<Authorization> {
	
	List<Authorization> getByIds(String ids);
}