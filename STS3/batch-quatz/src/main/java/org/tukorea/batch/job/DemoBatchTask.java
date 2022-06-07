package org.tukorea.batch.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoBatchTask {
	private static Logger logger = LoggerFactory.getLogger(DemoBatchTask.class);
	
	public void doTask() {
		logger.info("DemoBatchTask.doTask();");
	}
}