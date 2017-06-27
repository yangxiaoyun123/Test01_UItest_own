package com.xiaoyun.uiframework;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.xiaoyun.configs.LocalConfig;
import com.xiaoyun.utils.Log;

public class DriverFactory{

	public static WebDriver driver=null;
	public static Runtime runtime = Runtime.getRuntime();
    private static Log log = new Log(DriverFactory.class); //定义日志对象


	
	public static WebDriver ChromeDriver(){
		try {
			runtime.exec("taskkill /f /im chromerdriver.exe");
			log.info("杀死谷歌驱动进程成功");
		} catch (IOException e) {
//			e.printStackTrace();
			log.error("杀死谷歌驱动进程失败");
		}
		try {
			runtime.exec("taskkill /f /im chrome.exe");
			log.info("杀死浏览器进程成功");
		} catch (IOException e){
			log.error("杀死浏览器进程失败");
		}
//		String driverPath=System.getProperty("user.dir")+LocalConfig.CHROME_PATH;
		String key="webdriver.chrome.driver";
		String value="WebDrivers\\chromedriver.exe";		
		System.setProperty(key, value);
		System.setProperty("webdriver.chrome.driver", value);
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("no-sandbox");
        options.addArguments("disable-extensions");
        options.addArguments("no-default-browser-check");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
//      WebDriver driver = new ChromeDriver(options);
        
        
		return new ChromeDriver(options);
	    }

	    

	
	public static WebDriver FirefoxDriver(){
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.firefox.marionette","");
		return new FirefoxDriver();
	}
	
	public static WebDriver InternetExplorerDriver(){
		String key="webdriver.IE.driver";
		String value="WebDrivers\\IEDriverServer.exe";
		System.setProperty(key, value);
		return new InternetExplorerDriver();
	}
}
