package com.xiaoyun.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.xiaoyun.uiframework.Locator;
import com.xiaoyun.uiframework.Locator.ByType;

//将读取xml文件的类纳入到框架中
public class xmlUtil {

	public static HashMap<String,Locator> readElementInfo(String filePath) throws DocumentException{
		String xfp = filePath;
//		System.out.println(filePath);
		//定义一个Map,把xml内容都读取到map中
		Map<String,Locator> elementinfos = new HashMap<String,Locator>();
		SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(xfp));
		Element root = document.getRootElement();
		List<Element> childList = root.elements("locator");
		for(Element e:childList){
			String value = e.attributeValue("value").toString();
			int timeOut =Integer.parseInt(e.attributeValue("timeout").toString());
			String name = e.attributeValue("name").toString();
			String type = e.attributeValue("type").toString();
			Locator locator = new Locator(value,timeOut,getType(type),name); 
			String keyName = e.getText();
			elementinfos.put(keyName, locator);
		}
		return (HashMap<String, Locator>) elementinfos;
	}
		
		
		
	public static ByType getType(String value){
		ByType type = null;
		switch(value){
		case "css":
			type = ByType.ceeSelector;
			break;
		case "xpath":
			type = ByType.xpath;
			break;
		case "id":
			type = ByType.id;
			break;
		case "tagName":
		    type = ByType.tagName;
		    break;
		 default:
			type = ByType.linkText; 
			break;
		}
		return type;
	}
	
	
}
