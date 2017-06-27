package com.xiaoyun.pages;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.xiaoyun.configs.LocalConfig;
import com.xiaoyun.uiframework.BasePage;
import com.xiaoyun.uiframework.DriverFactory;
import com.xiaoyun.uiframework.Locator;
import com.xiaoyun.utils.ScreenShot;




public class LoginPage extends BasePage{

	//继承，父类已有driver，无需再定义driver
//	protected WebElement login;
//	protected WebElement loginCheck;
//	protected WebElement usernameInputBox;
//	protected WebElement passwordInputBox;
//	protected WebElement loginButton;

	
	
	public LoginPage(WebDriver driver){
	super(driver);
	openWeb(LocalConfig.URL);   //	driver.get(LocalConfig.URL);  继承openWeb方法
	}
	
	//继承webElementUtil类中的getLocator方法：                                               //继承webElementUtil类中的findElement方法
    Locator login = getLocator("login");             //login = findElement("cssSelector","ttbar-login"); //login = driver.findElement(By.cssSelector("ttbar-login"));
	Locator loginCheck = getLocator("loginCheck");       		//	logincheck = findElement("cssSelector","checked");    //logincheck = driver.findElement(By.cssSelector("checked"));
	Locator usernameInputBox = getLocator("usernameInputBox");       		//	usernameInputBox = findElement("cssSelector","loginname");    //usernameInputBox = driver.findElement(By.cssSelector("loginname"));
	Locator passwordInputBox = getLocator("passwordInputBox");       		//	passwordInputBox = findElement("cssSelector","nloginpwd");   //passwordInputBox = driver.findElement(By.cssSelector("nloginpwd"));
	Locator loginButton = getLocator("loginButton");       		//	loginbutton = findElement("cssSelector","loginsubmit");   //loginbutton = driver.findElement(By.cssSelector("loginsubmit"));


	
	//在LoginPage页面只做元素的单操作，把登录业务代码写到loginPageOperate页面中
//	public MainPage loginOperate(String name,String password){
//		//登录操作，输入用户名。密码，调用webElementUtil的input方法
//		click(login);
//		click(loginCheck);
//		input(usernameInputBox,name);   //usernameInputBox.sendKeys(name);
//		input(passwordInputBox,password);    //passwordInputBox.sendKeys(password);
//		click(loginButton);    //loginbutton.click();
//		return new MainPage(driver);
//	}
//	
//	
//	public String loginOperateFail(String name,String password){
//		//登录操作，输入用户名。密码，调用webElementUtil的input方法
//		input(usernameInputBox,name);   //usernameInputBox.sendKeys(name);
//		input(passwordInputBox,password);    //passwordInputBox.sendKeys(password);
//		click(loginButton);    //loginbutton.click();
//		WaitTime(3);
//		String value = alertGetText(); 
//		//alert = driver.switchTo().alert();
//		//String value = alert.getText();
//		alertAccept();
////		alert.accept();
//		return value;
//	}
//
//	
//	
//	//调用鼠标MouseUtil类方法
//	public void aaa(){
////		为了不每次执行鼠标事件都需要定义一个鼠标对象，处理方法：DriverUtil、MouseUtil是平行类，所以可以在DriverUtil中引入mouse对象
////		MouseUtil mouse = new MouseUtil(driver);
//		mouse.rightClick(findElement(loginButton)); //DriverUtil中定义的对象,层级继承下来的对象
//	}
//
//	public void bbb(){
//		mouse.doubleClick(findElement(loginButton));
//	}

	
	
	//只执行单操作
	public void Login(){
		click(login);
	}
	
	public void loginCheck(){
		click(loginCheck);
	}
	
	public void inputUserName(String name){
		input(usernameInputBox,name);
	}
	
	public void inputPassword(String password){
		input(passwordInputBox,password);
	}
	
	public void clickLoginButton(){
		click(loginButton);
	}
	
}
