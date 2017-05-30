package top.auok.cbps.ssm.dao;

import java.util.List;

import top.auok.cbps.ssm.dao.base.BaseDao;
import top.auok.cbps.ssm.model.RoleOperator;

public interface RoleOperatorDao extends BaseDao<RoleOperator> {
	
	List<RoleOperator> listByOperatorId(Long operatorId);
}