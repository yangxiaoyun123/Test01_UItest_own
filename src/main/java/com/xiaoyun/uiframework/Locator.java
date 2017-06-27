package com.xiaoyun.uiframework;

//实例类
public class Locator {

	public enum ByType{
		xpath,id,linkText,name,className,ceeSelector,partialLinkText,tagName;
	}
	private String elementName; //元素名称
	private String locatorInfo;   //定位信息
	private int timeOut;   //识别等待时间
	private ByType byType;   //识别类型
	
	
	public Locator(String element,int waitSec,ByType byType,String name){
		this.elementName = name;
		this.locatorInfo = element;
		this.timeOut = waitSec;
		this.byType = byType;
	}


	//封装
	public String getElementName() {
		return elementName;
	}


	public String getLocatorInfo() {
		return locatorInfo;
	}


	public int getTimeOut() {
		return timeOut;
	}


	public ByType getByType() {
		return byType;
	}
	
	
}
