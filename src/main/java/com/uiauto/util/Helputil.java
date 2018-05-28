package com.uiauto.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Helputil {

	public static String getBaseinfo(String key) throws Exception
	{
		 Properties properties=new Properties();
		 BufferedReader bufferedReader = new BufferedReader(new FileReader("base.properties"));
		 properties.load(bufferedReader);
		 return properties.getProperty(key);
	}
	
	public static void deleteLocalLog()
	{
		File file=new File("F:/test.log");
		if(file.exists())
		{
			file.delete();
		}
	}
	public static void deleteFailurePic()
	{
		File file=new File("Failure");
		if(file.exists())
		{
			file.delete();
		}
	}
	
	public static void mouseClick(WebDriver webdriver,WebElement element)
	{
		Actions action=new Actions(webdriver);
		action.click(element).perform();
	}
	
	//按ENter键盘
	public static void pressEnter(WebDriver webdriver)
	{
		Actions action=new Actions(webdriver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public static void pressTab(WebDriver webdriver)
	{
		Actions action=new Actions(webdriver);
		action.sendKeys(Keys.TAB).perform();
	}
	
	//切换frame，根据classname切换
	public static void switchFrame(WebDriver webdriver,String classname)
	{
		webdriver.switchTo().frame(webdriver.findElement(By.className(classname)));
	}

}
