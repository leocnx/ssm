package top.auok.cbps.ssm.service;

import top.auok.cbps.ssm.model.Authorization;

public interface AuthorizationService {

	void createAuthorization(Authorization authorization);
	
	Authorization getByAuthorizationName(String authorizationName);
}
