package org.tukorea.batch.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class DemoBatchJob extends QuartzJobBean{
	
	private DemoBatchTask demoBatchTask;
	
	private static Logger logger = LoggerFactory.getLogger(DemoBatchJob.class);
	
	public void setDemoBatchTask(DemoBatchTask task) {
		this.demoBatchTask = task;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("DemoBatchJob Start Task()");
		demoBatchTask.doTask();
		logger.info("DemoBatchJob End Task()");
		
	}
	
}