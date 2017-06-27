package com.xiaoyun.uiframework;

import java.util.HashMap;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.xiaoyun.uiframework.Locator.ByType;
import com.xiaoyun.utils.Log;
import com.xiaoyun.utils.ScreenShot;
import com.xiaoyun.utils.xmlUtil;

public class webElementUtil extends DriverUtil{

	protected HashMap<String,Locator> locatorMap;
	protected String path;
	
	public webElementUtil(WebDriver driver){
		super(driver);
		path = System.getProperty("user.dir")+"/webelementdata/"+this.getClass().getSimpleName()+".xml";
//		path = "D:\\新建文件夹\\JAVA//workplace\\Test02_UItest_own\\webelementdata\\LoginPage.xml";
	    try {
			locatorMap = xmlUtil.readElementInfo(path);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	//获取元素的方法一
	public WebElement getElement(Locator locator){

		WebElement el=null;
		ByType type = locator.getByType();
		try{
		switch(type){
			case id:
				el=driver.findElement(By.id(locator.getLocatorInfo()));
				break;
			case name:
				el=driver.findElement(By.name(locator.getLocatorInfo()));
				break;
			case xpath:
				el=driver.findElement(By.xpath(locator.getLocatorInfo()));
				break;
			case ceeSelector:
				el=driver.findElement(By.cssSelector(locator.getLocatorInfo()));
				break;
		    default:
		    	el=driver.findElement(By.linkText(""));
			break;
			}  }catch(Exception e){
				ScreenShot.takeScreenShot("findElementErrorImage");
				Log.info("元素："+locator.getElementName()+"识别异常");
				Assert.fail("查找元素异常，退出当前测试用例");
			}
		return el;
		}
		
	
	//获取元素的方法二：获取任意一个元素的时候均有等待时间
	public WebElement findElement(final Locator loc){
		//等待10s
		WebDriverWait wait = new WebDriverWait(driver,loc.getTimeOut());
		WebElement el = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return getElement(loc);
			}
		});
		return el;
	}
	
	
	//取元素方法
	public Locator getLocator(String locatorname){
		Locator locator = locatorMap.get(locatorname);
		return locator;
	}
	
	
	
	
	
	//元素的封装：点击
	public void click(Locator locator){
		WebElement e = findElement(locator);
		e.click();
		log.info("点击元素："+locator.getElementName());
	}
	
	//输入
	public void input(Locator locator,String content){
		WebElement e = findElement(locator);
		e.sendKeys(content);
		log.info("在元素："+locator.getElementName()+"输入："+content);
	}
	
	//提交
	public void submit(Locator locator){
		WebElement e = findElement(locator);
	    e.submit();
	    log.info("在元素："+locator.getElementName()+"处提交");
	}
	//获取元素属性
	public String getAttribute(Locator locator,String attribute){
		WebElement e = findElement(locator);
		String value=e.getAttribute(attribute);
		log.info("获取元素："+locator.getElementName()+"的"+attribute+"属性");
		return value;
	}
	
	//获取元素文本
	public String getText(Locator locator){
		WebElement e = findElement(locator);
		String value=e.getText();
		log.info("获取元素："+locator.getElementName()+"文本值");
		return value;
	}

}
