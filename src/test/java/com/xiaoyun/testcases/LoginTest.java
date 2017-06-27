package com.xiaoyun.testcases;


import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;






import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.xiaoyun.actions.LoginOperate;
import com.xiaoyun.pages.LoginPage;
import com.xiaoyun.pages.MainPage;
import com.xiaoyun.uiframework.DriverFactory;
import com.xiaoyun.utils.AssertUtil;
import com.xiaoyun.utils.ExcelUtil;
import com.xiaoyun.utils.Log;
import com.xiaoyun.utils.ScreenShot;
import com.xiaoyun.utils.TestCase;



public class LoginTest {
	
	WebDriver driver;
	AssertUtil assertUtil = new AssertUtil();
	
	@BeforeTest
	public void setUp(){
		try{
		driver = DriverFactory.ChromeDriver();
		((WebDriver) driver).manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}catch(Exception e){
//			e.printStackTrace();
			Assert.fail("测试初始化报错，不执行后期代码");
		}
	}
	
	
	@Test
	public void loginTest01() throws DocumentException{
//		业务操作独立之后，loginOperate类中取输入用户名密码的方法
//		LoginPage lp = new LoginPage(driver);
//		MainPage mp = lp.loginOperate("驿恋豆豆", "zjs995115");
//		MainPage mp = LoginOperate.LoginSuess("驿恋豆豆", "zjs995115");
//		String value = mp.getLoginUserInfo();

		List<TestCase> testcases = ExcelUtil.getUITestData("UITestData.xlsx");
		HashMap<String,String> testdata = (HashMap<String, String>) testcases.get(0).getTestdata();
		LoginOperate.setDriver(driver);
		String value = LoginOperate.getLoginName(testdata.get("username"), testdata.get("password"));
		Assert.assertEquals(value.contains(testcases.get(0).getExceptedResult()), true,"登录测试成功");
	}
	
	

	
	@Test
	public void loginTest02() throws DocumentException{
////		业务操作独立之后，loginOperate类中取输入用户名密码的方法
////		LoginPage lp = new LoginPage(driver);
////		MainPage mp = lp.loginOperate("驿恋豆豆", "zjs995115");
//		LoginOperate.setDriver(driver);
//
//		String value = LoginOperate.getLoginName("驿恋豆豆", "zjs995115");
////		String value = mp.getLoginUserInfo();
//		try{
//			Assert.assertEquals(value.contains("退出"), true,"登录测试成功");
//		}catch(AssertionError e){
//			Assert.fail("断言成功");
//		}
		
		
//		业务操作独立之后，loginOperate类中取输入用户名密码的方法
//		LoginPage lp = new LoginPage(driver);
//		MainPage mp = lp.loginOperate("驿恋豆豆", "zjs995115");
//		MainPage mp = LoginOperate.LoginSuess("驿恋豆豆", "zjs995115");
//		String value = mp.getLoginUserInfo();

		List<TestCase> testcases = ExcelUtil.getUITestData("UITestData.xlsx");
		HashMap<String,String> testdata = (HashMap<String, String>) testcases.get(1).getTestdata();
		LoginOperate.setDriver(driver);
		String value = LoginOperate.getLoginName(testdata.get("username"), testdata.get("password"));
		Assert.assertEquals(value.contains(testcases.get(1).getExceptedResult()), true,"登录测试成功");
		
	}

	@AfterTest
	public void tearDown() throws InterruptedException{
		Thread.sleep(3000);
//		driver.close();

	}

}
