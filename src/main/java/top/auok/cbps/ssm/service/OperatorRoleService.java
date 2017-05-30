package top.auok.cbps.ssm.service;

import java.util.Set;

public interface OperatorRoleService {
	
	Set<String> getRoleCodeByOperatorId(Long operatorId);
	
	String getRoleIdsByOperatorId(Long operatorId);
}
