package top.auok.cbps.ssm.service;

import top.auok.cbps.ssm.model.Operator;

public interface OperatorService {
	
	Operator getByLoginName(String loginName);
	
	void testSchedule();
}
