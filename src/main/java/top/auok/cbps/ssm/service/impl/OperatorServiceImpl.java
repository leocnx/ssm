package top.auok.cbps.ssm.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.auok.cbps.ssm.dao.OperatorDao;
import top.auok.cbps.ssm.model.Operator;
import top.auok.cbps.ssm.service.OperatorService;

@Service("operatorService")
public class OperatorServiceImpl implements OperatorService {
	
	@Resource
	private OperatorDao operatorDao;

	@Override
	public Operator getByLoginName(String loginName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("loginName", loginName);
		return operatorDao.getByColumn(paramMap);
	}

	@Override
	public void testSchedule() {
	}
	
}
