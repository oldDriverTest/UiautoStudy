package com.uiauto.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiauto.util.GetLocator;

public class LoginPage {
	private WebElement element = null;
	private WebDriver webdriver;
	GetLocator gl = new GetLocator();

	public LoginPage(WebDriver webdriver) {
		// TODO Auto-generated constructor stub
		this.webdriver = webdriver;
	}

	// 返回登录界面的用户名输入框的对象
	public WebElement userName() throws Exception {
		element = webdriver.findElement(gl.getLocator("login.username"));
		return element;
	}

	// 返回登录界面的密码输入框的对象
	public WebElement passWord() throws Exception {
		element = webdriver.findElement(gl.getLocator("login.password"));
		return element;
	}

	// 返回登录界面的登录按钮的对象
	public WebElement loginBtn() throws Exception {
		element = webdriver.findElement(gl.getLocator("login.btn"));
		return element;
	}
}
