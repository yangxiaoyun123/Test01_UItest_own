package com.xiaoyun.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.xiaoyun.configs.LocalConfig;

public class ScreenShot {
	
	private static WebDriver driver;
	private static Log log = new Log(ScreenShot.class);

	public static void takeScreenShot(String...pngName){
		String fileName;
		String filePath = LocalConfig.SCERRNSHOTPATH;
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdir();
		}
		if(pngName.length == 0){
			fileName = "shotImage";
		}
		else{
			fileName = pngName[0];
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String dateStr = sf.format(date);
		String path = "\\"+filePath+"\\"+fileName+"_"+dateStr+".png";
		takeScreenShot(driver,path);			
	}
	
	public static void takeScreenShot(WebDriver drivername,String path){
		String currentPath = System.getProperty("user.dir");
		File scrFile = ((TakesScreenshot) drivername).getScreenshotAs(OutputType.FILE); //关键代码，执行屏幕截图，默认会把截图保存到temp目录
		File picFile = new File(currentPath+path); //利用FileUtils工具类的picFile()方法保存getScreenshotAs()返回的文件对象。 
		try{
			FileUtils.copyFile(scrFile,picFile);
			Log.info("截图成功");
		}catch(Exception e){
			e.printStackTrace();
			Log.error("截图失败");
		}
		
	}
	
	

	
}
