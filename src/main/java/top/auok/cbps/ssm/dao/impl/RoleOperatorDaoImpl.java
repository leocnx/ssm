package top.auok.cbps.ssm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import top.auok.cbps.ssm.dao.RoleOperatorDao;
import top.auok.cbps.ssm.dao.base.impl.BaseDaoImpl;
import top.auok.cbps.ssm.model.RoleOperator;

@Repository
public class RoleOperatorDaoImpl extends BaseDaoImpl<RoleOperator> implements RoleOperatorDao {

	@Override
	public List<RoleOperator> listByOperatorId(Long operatorId) {
		return super.getSqlSession().selectList(getStatement("listByOperatorId"), operatorId);
	}
	
}
