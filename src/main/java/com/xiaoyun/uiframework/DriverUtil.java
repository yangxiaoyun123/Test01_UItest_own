package com.xiaoyun.uiframework;

import org.openqa.selenium.WebDriver;

import com.xiaoyun.utils.Log;

//浏览器基本操作
public class DriverUtil {
	
	protected WebDriver driver;
	protected static MouseUtil mouse;  //引入平行类MouseUtil中的对象
	protected static KeyBoardUtil keyboard; //引入平行类KeyBoardUtil中的对象 
	protected static Log log = new Log(DriverUtil.class);
	
	public DriverUtil(WebDriver dr){
		driver=dr;
		mouse = new MouseUtil(driver);
		keyboard = new KeyBoardUtil(driver);

		
	}
	
	//打开浏览器
	public void openWeb(String url){
		driver.get(url);
		log.info("打开网址成功");
	}
	
	//前进
	public void forword(){
		driver.navigate().forward();
		log.info("前往下一页");
	}
	
	//后退
	public void back(){
		driver.navigate().back();
		log.info("返回上一页");
	}
	
	//刷新
	public void refresh(){
		driver.navigate().refresh();
		log.info("刷新网页");
	}
	
	//退出
	public void quit(){
		driver.quit();
		log.info("退出当前driver");
	}
	
	
	//关闭浏览器
	public void close(){
		driver.close();
		log.info("关闭浏览器");
	}
	
	//获取网页标题
	public String  getTitle(){
		log.info("获取网页标题");
		return driver.getTitle();
	}
	
	
	//显示等待时间
	public void WaitTime(int second){
		try {
			Thread.sleep(second*1000);
			log.info("显式等待"+second+"秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	

	

}
