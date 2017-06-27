package com.xiaoyun.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;



public class TestngRetry implements IRetryAnalyzer {
 
	Log log = new Log(TestngRetry.class);
	private static int maxRetryCount = 2;
	private int retryCount = 1;
	
	public boolean retry(ITestResult result){
		if (retryCount <= maxRetryCount){
			String message="测试类："+this.getClass().getName()+"中的测试方法："+result.getName()+"执行失败，重试第"+retryCount+"次";
			log.info(message);
			retryCount++;
			return true;
		}
		return false;
	}
}
