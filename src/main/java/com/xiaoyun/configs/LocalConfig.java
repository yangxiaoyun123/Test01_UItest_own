package com.xiaoyun.configs;

import com.xiaoyun.uiframework.PropertiesUtil;

public class LocalConfig {

	//定义一个属性，初始化的时候给到路径，接下来即可根据key取value
	static PropertiesUtil propertiesUtil = new PropertiesUtil("local.properties");
	//根据key取value
	public static final String URL = propertiesUtil.getPropertiesValue("url");    
	public static final String CHROME_PATH = propertiesUtil.getPropertiesValue("chromeDriverPath"); 
	public static final String FIREFOX_PATH = propertiesUtil.getPropertiesValue("fireFoxDriverPath");
	public static final String IE_PATH = propertiesUtil.getPropertiesValue("ieDriverPath");
	public static final String SCERRNSHOTPATH = propertiesUtil.getPropertiesValue("shotPath");

}
