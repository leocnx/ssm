package top.auok.cbps.ssm.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import top.auok.cbps.ssm.dao.AuthorizationDao;
import top.auok.cbps.ssm.dao.base.impl.BaseDaoImpl;
import top.auok.cbps.ssm.model.Authorization;

@Repository
public class AuthorizationDaoImpl extends BaseDaoImpl<Authorization> implements AuthorizationDao {

	@Override
	public List<Authorization> getByIds(String idStr) {
		List<String> ids = Arrays.asList(idStr.split(","));
		return this.getSqlSession().selectList(getStatement("getByIds"), ids);
	}

}
