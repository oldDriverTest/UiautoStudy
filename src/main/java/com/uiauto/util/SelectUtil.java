package com.uiauto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtil {

	public static void selectByValue(WebElement element,String value)
	{
		Select selectlist=new Select(element);
		selectlist.selectByValue(value);
	}
	//根据value选择
	public static void selectByIndex(WebElement element,int index)
	{
		Select selectlist=new Select(element);
		selectlist.selectByIndex(index);
	}
	
	//根据选项文字选择
	public static void selectByVisible(WebElement element,String visibletext)
	{
		Select selectlist=new Select(element);
		selectlist.selectByVisibleText(visibletext);
	}

	//select中option的数量
	public static int getOptionNum(WebElement element)
	{
		Select selectlist=new Select(element);
		List<WebElement> list=selectlist.getOptions();
		return list.size();
	}
	
	//获取下拉列表的所有option集合
	public static List<String>  getOpthonList(WebElement element)
	{
		Select selectlist=new Select(element);
		List<WebElement> list=selectlist.getOptions();
		List<String> optionlist=new ArrayList<String>();
		for(WebElement elements:list)
		{
			optionlist.add(elements.getText());
		}
		return optionlist;
	}
	
	//从下拉框中随机取一个值
	public static String getRandomOption(WebElement element)
	{
		List<String> optionlist=SelectUtil.getOpthonList(element);
		int num=SelectUtil.getOptionNum(element);
		Random random=new Random();
		int number=random.nextInt(num);
		String randomstr=optionlist.get(number);
		return randomstr;
	}
}
