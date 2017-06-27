package com.xiaoyun.utils;


import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class TestNGListener extends TestListenerAdapter{

	Log log = new Log(TestNGListener.class);
	//testNG初始化
	@Override
	public void onStart(ITestContext testContext){
		log.info("测试初始化");
		super.onStart(testContext);
		System.setProperty("org.uncommons.reportng.escape-output", "true");
		Reporter.log("<span style=\"color:#16A05D\"><H1>hello</H1>");
	}
	
	//case开始
	@Override
	public void onTestStart(ITestResult tr){
		log.info("【"+tr.getName()+"】测试用例开始执行");
		super.onTestStart(tr);
	}
	
	//case执行成功
	@Override
	public void onTestSuccess(ITestResult tr){
        log.info("【"+tr.getName()+"】测试用例执行成功");
        super.onTestSuccess(tr);
	}
	
	//case执行失败
	@Override
	public void onTestFailure(ITestResult tr){
		log.error("【"+tr.getName()+"】测试用例执行失败");
		super.onTestFailure(tr);
	}
	

	//case被跳过
	@Override
	public void onTestSkipped(ITestResult tr){
		log.error("【"+tr.getName()+"】测试用例被跳过");
		super.onTestSkipped(tr);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//所有case执行完成
	public void inFinish(ITestContext testContext){
		Iterator<ITestResult> listOfFailedTests=
			 testContext.getFailedTests().getAllResults().iterator();
		while(listOfFailedTests.hasNext()){
			ITestResult failedTest = listOfFailedTests.next();
			ITestNGMethod method = failedTest.getMethod();
			if(testContext.getFailedTests().getResults(method).size()>1){
				listOfFailedTests.remove();
			}
			else{
				if(testContext.getPassedTests().getResults(method).size()>0){
					listOfFailedTests.remove();
				}
			}
		}
	}
}

