package com.xiaoyun.actions;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;

import com.xiaoyun.pages.LoginPage;
import com.xiaoyun.pages.MainPage;
import com.xiaoyun.uiframework.DriverUtil;
import com.xiaoyun.utils.ScreenShot;


public class LoginOperate {

	private static WebDriver driver;
	
	//封装
	public static WebDriver getDriver(){
		return driver;
	}
	
	public static void setDriver(WebDriver driver){
		LoginOperate.driver = driver;
	}
	
	static LoginPage loginPage;
	static MainPage mainPage;

	
	public static MainPage LoginSuess(String name,String password){
		loginPage = new LoginPage(getDriver());
		loginPage.Login();
		loginPage.loginCheck();
		loginPage.inputUserName(name);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		return new MainPage(getDriver());
	}
	
	

	
	public static String getLoginName(String name,String password){
		mainPage = LoginSuess(name,password);
//		ScreenShot.takeScreenShot("登录成功");
		return mainPage.getLoginUserInfo();
	}
	
	

}
