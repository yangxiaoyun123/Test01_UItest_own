package com.xiaoyun.utils;

import org.testng.Assert;

public class AssertUtil {

	
	//整形断言
	public void checkIntNum(int actual,int excepted,String...com){
		try{
			Assert.assertEquals(actual, excepted);
		}catch(AssertionError e){
			Assert.fail("断言失败");
			//还可加log/report日志
		}
	}
	
	
	//字符串断言
	public void checkString(String actual,String excepted,String...com){
		try{
			Assert.assertEquals(actual, excepted);
		}catch(AssertionError e){
			Assert.fail("断言失败");
			//还可加log/report日志
		}
	}
	
	
	//字符串包含断言
	public void checkStringContains(String actual,String excepted,String...com){
		try{
			Assert.assertEquals(true, actual.contains(excepted),"登录测试成功");
		}catch(AssertionError e){
			Assert.fail("断言失败");
			//还可加log/report日志
		}
	}
	
	//非空断言
	public void checkNotNull(Object actual,String...com){
		try{
			Assert.assertNotNull(actual);
		}catch(AssertionError e){
			Assert.fail("断言失败");
			//还可加log/report日志
		}
	}
	
	
	
}
