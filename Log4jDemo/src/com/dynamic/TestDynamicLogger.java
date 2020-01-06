package com.dynamic;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class TestDynamicLogger {

	public static void main(String[] args){
		PatternLayout layout = new PatternLayout();
		String patten = "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{3}:%L - [%M] %m%n";
		layout.setConversionPattern(patten);
		ConsoleAppender console = new ConsoleAppender();
		console.setName("stdout");
		console.setTarget("System.err");
		console.setLayout(layout);
		console.setThreshold(Level.DEBUG);
		console.activateOptions();
		
		RollingFileAppender rolling = new RollingFileAppender();
		rolling.setName("RFILE");
		rolling.setFile("log/log4j.log");
		rolling.setThreshold(Level.ERROR);
		rolling.setMaxFileSize("1MB");
		rolling.setMaxBackupIndex(10);
		rolling.setLayout(layout);
		rolling.activateOptions();
		
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.addAppender(console);
		rootLogger.addAppender(rolling);
		
		Logger logger = Logger.getLogger(TestDynamicLogger.class);
		for(int i=0 ; i<10000; i++){
			logger.debug("Dynamic debug Logger");
			logger.info("Dynamic info Logger");
			logger.warn("Dynamic warn Logger");
			logger.error("Dynamic error Logger");
			logger.fatal("Dynamic fatal Logger");
		}

		System.out.println("done");
	}
}
