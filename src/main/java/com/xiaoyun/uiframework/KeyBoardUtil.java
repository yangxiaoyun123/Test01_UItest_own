package com.xiaoyun.uiframework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardUtil {

	Actions action;
	
	public KeyBoardUtil(WebDriver dr){
		action = new Actions(dr);
	}
	
	//向下按多次
	public void pressDown(int times){
	    try {
			Robot robot = new Robot();
			for(int i=0;i<times;i++){
				robot.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(1000);//每按一次方向键停顿1秒
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	//Ctrl+C
	public void copyClick(WebElement e){
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
	}
	

	//Alt+F4关闭窗口
	public void closeWindow(){
		action.keyDown(Keys.ALT).sendKeys(Keys.F4).keyUp(Keys.ALT).perform();
	}
	
	
}
