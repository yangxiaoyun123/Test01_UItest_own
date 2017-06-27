package com.xiaoyun.uiframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseUtil {

//	鼠标事件不需要用到driver
//	private WebDriver driver;
	private Actions action;

	public MouseUtil(WebDriver dr){
//		this.driver=dr;
		action = new Actions(dr);
	}
	
	//鼠标右击
	public void rightClick(WebElement e){
//      同一个类中的不同方法中，多次定义同一对象，可考虑把对象提取出来定位为一个类对象		
//		Actions action = new Actions(driver);
		action.contextClick(e).perform();
	}
	
	//双击
	public void doubleClick(WebElement e){
//		Actions action = new Actions(driver);
		action.doubleClick(e).perform();
	}
	
	
	//鼠标移动
	public void moveToElement(WebElement e){
		action.moveToElement(e).perform();
	}


}
