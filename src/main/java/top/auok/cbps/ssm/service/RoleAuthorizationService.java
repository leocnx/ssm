package top.auok.cbps.ssm.service;

import java.util.Set;

public interface RoleAuthorizationService {
	
	Set<String> getAuthorizationsByOperatorId(Long operatorId);
	
	String getAuthorizationIdsByRoleIds(String roleIds);
}
