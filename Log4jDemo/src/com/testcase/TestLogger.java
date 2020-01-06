package com.testcase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class TestLogger {
	
	final private static Logger LOGGER = Logger.getLogger(TestLogger.class);
	public static void main(String[] args){
		PropertyConfigurator.configure("log4j.properties");
		LOGGER.debug("This is debug");
		LOGGER.info("This is info");
		LOGGER.warn("This is warn");
		LOGGER.error("This is error");

		
		LOGGER.fatal("This is fatal");
		System.out.println("done");
	}
}
