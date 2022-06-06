package org.tukorea.batch.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tukorea.batch.job.DemoBatchTask;

public class BatchMain {
	
	private static ApplicationContext context = null;
	private static Logger logger = LoggerFactory.getLogger(BatchMain.class);
	
	public static void main(String[] args) throws Exception {
		context = new ClassPathXmlApplicationContext(
//				new String[] {"resources/applicationContext.xml"}); // JAR
				new String[] {"applicationContext.xml"});

		logger.info("BatchMain start");
				
	}
}