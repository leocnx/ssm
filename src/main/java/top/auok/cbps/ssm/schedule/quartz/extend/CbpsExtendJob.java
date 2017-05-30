package top.auok.cbps.ssm.schedule.quartz.extend;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import top.auok.cbps.ssm.service.OperatorService;

public class CbpsExtendJob extends QuartzJobBean {

	@Autowired
	private OperatorService operatorService;
	
	private static Log log = LogFactory.getLog(CbpsExtendJob.class);

	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		log.info("From CbpsExtendJob ...");
		operatorService.testSchedule();
	}

}
