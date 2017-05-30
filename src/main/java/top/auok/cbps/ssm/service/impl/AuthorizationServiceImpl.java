package top.auok.cbps.ssm.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.auok.cbps.ssm.dao.AuthorizationDao;
import top.auok.cbps.ssm.model.Authorization;
import top.auok.cbps.ssm.service.AuthorizationService;

@Service("authorizationService")
public class AuthorizationServiceImpl implements AuthorizationService {
	
	@Resource
	private AuthorizationDao authorizationDao;
	
	@Override
	//@Transactional(rollbackFor = Exception.class)
	public void createAuthorization(Authorization authorization) {
		authorizationDao.insert(authorization);
		int i = 1 / 0;
	}

	@Override
	public Authorization getByAuthorizationName(String authorizationName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("authorizationName", authorizationName);
		return authorizationDao.getByColumn(paramMap);
	}

}
