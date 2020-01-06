package com.testcasetwo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class TestLoggerTwo {
	
	final private static Logger LOGGER = Logger.getLogger(TestLoggerTwo.class);
	public static void main(String[] args){
		PropertyConfigurator.configure("log4j.properties");
		LOGGER.debug("TestLoggerTwo : This is debug");
		LOGGER.info("TestLoggerTwo : This is info");
		LOGGER.warn("TestLoggerTwo : This is warn");
		LOGGER.error("TestLoggerTwo : This is error");
		LOGGER.fatal("TestLoggerTwo : This is fatal");
		System.out.println("TestLoggerTwo : done");
	}
}
