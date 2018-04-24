package com.uiauto.service;

import org.openqa.selenium.WebDriver;

import com.uiauto.pageobject.LoginPage;
import com.uiauto.util.Helputil;
import com.uiauto.util.Log;

public class Login_Action {
/** @author huluxia
 *  @param username:登录的用户名   password:登录的密码
 *  这个方法就是登录功能，调用LoginPage中已经分装好的文本框、按钮的定位方法，为他们赋予事件
 * */
	public void Login(WebDriver webdriver,String username,String password)throws Exception{
		LoginPage lg=new LoginPage(webdriver);
		String url=Helputil.getBaseinfo("url");
		
		Log.info("访问链接"+url);
		webdriver.get(url);
		
		Log.info("输入用户名"+username);
		lg.userName().sendKeys(username);
		
		Log.info("输入密码"+password);
		lg.passWord().sendKeys(password);
		
		Log.info("点击登录按钮");
		lg.loginBtn().click();
		Log.info("点击按钮后等待3s，为了等待页面跳转");
		
		Thread.sleep(3000);
	}
	
}
