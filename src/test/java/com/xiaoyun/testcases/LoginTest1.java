package com.xiaoyun.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.xiaoyun.utils.AssertUtil;
import com.xiaoyun.utils.Log;

public class LoginTest1 {

	AssertUtil assertUtil;
	
	@BeforeTest
	public void setUp(){
		assertUtil = new AssertUtil();
	}
	
	@Test
	public void f1(){
		assertUtil.checkIntNum(2, 1);
	}
	
	
	
	@Test
	public void f2(){
		assertUtil.checkIntNum(2, 2);
	}
	
	
	@AfterTest
	public void tearDown(){
		
	}
}
