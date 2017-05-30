package top.auok.cbps.ssm.schedule.quartz.alone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import top.auok.cbps.ssm.service.OperatorService;

public class CbpsAloneJob {
	
	@Autowired
	private OperatorService operatorService;
	
	private static Log log = LogFactory.getLog(CbpsAloneJob.class);
	
	protected void execute() {
		log.info("From CbpsAloneJob ...");
		operatorService.testSchedule();
	}
}
