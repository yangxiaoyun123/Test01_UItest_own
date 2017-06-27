package com.xiaoyun.pages;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.xiaoyun.uiframework.BasePage;
import com.xiaoyun.uiframework.Locator;


public class MainPage extends BasePage{

	
	public MainPage(WebDriver dr){
		super(dr);
	}
	
	//继承webElementUtil方法中的getLocator()方法
	Locator userCenter = getLocator("userCenter");

	
	public String getLoginUserInfo(){
		//继承webElementUtil里的getText()方法、WaitTime()方法
		WaitTime(3);
		refresh();
		String value =  getText(userCenter);
        click(userCenter);
		return value;

	}
	
}
