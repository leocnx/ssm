package top.auok.cbps.ssm.schedule.quartz.extend;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public class CbpsQuartzJobFactory extends SpringBeanJobFactory {

	@Autowired
	private AutowireCapableBeanFactory beanFactory;

	/**
	 * 
	 * 这里覆盖了super的createJobInstance方法，对其创建出来的类再进行autowire。
	 * 
	 */
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {

		Object jobInstance = super.createJobInstance(bundle);

		beanFactory.autowireBean(jobInstance);

		return jobInstance;

	}
}
