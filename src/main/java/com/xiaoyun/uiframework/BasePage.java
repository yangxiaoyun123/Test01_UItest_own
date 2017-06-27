package com.xiaoyun.uiframework;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class BasePage extends webElementUtil{

	protected Alert alert;
	
	public BasePage(WebDriver driver){
		super(driver);
//		Alert alert = driver.switchTo().alert();
	}
	

	//获取网页源代码、js弹窗的问题、浮层frame处理...
	public String getSource(){
		WaitTime(3);
		return driver.getPageSource();
	}
	
	//弹窗接受
	public void alertAccept(){
//		多次出现定义对象，可提取出来，做成类对象
//		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
	//弹窗取消
	public void alertDismiss(){
//		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	//弹窗输入内容
	public void alertInput(String value){
//		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
	
	//获取弹窗内容
	public String alertGetText(){
//		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
}
