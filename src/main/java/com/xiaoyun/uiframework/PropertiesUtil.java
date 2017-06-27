package com.xiaoyun.uiframework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static Properties properties=null;
	private static String propertiesFileName;
	
	public PropertiesUtil(String path){
		this.propertiesFileName = path;
	}
	
	public static String getPropertiesValue(String keyName){
		properties = new Properties();
		InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("com/xiaoyun/configs/"+propertiesFileName);
        String value = null;
		try {
			properties.load(in);
			value = properties.getProperty(keyName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
