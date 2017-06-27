package work01.Test02_UItest_own;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.xiaoyun.uiframework.DriverFactory;

public class demo {

	public static void main(String[] args) {
//		PropertiesUtil  propertiesUtil = new PropertiesUtil("local.properties");
//		String url = propertiesUtil.getPropertiesValue("url");
//		System.out.println(url);

		
		WebDriver driver = DriverFactory.ChromeDriver();
		driver.get("https://www.jd.com");
		
   

	}

}
