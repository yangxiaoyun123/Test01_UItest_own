package com.xiaoyun.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	private static Class<?> clazz;
	private static Logger logger;
	
	public Log(Class<?> clazz){
		this.clazz = clazz;
		this.logger = LogManager.getLogger(this.clazz);
	}
	
	public static void info(String message){
		logger.info(clazz.getCanonicalName()+":"+message);	
	}
	
	public void debug(String message){
		logger.debug(clazz.getCanonicalName()+":"+message);	
	}
	
	public static void error(String message){
		logger.error(clazz.getCanonicalName()+":"+message);
	}
	
}
