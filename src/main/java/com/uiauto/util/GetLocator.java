package com.uiauto.util;

import java.util.Map;

import org.openqa.selenium.By;

public class GetLocator {
private Map<String, String> locatorinfo;
/** @author huluxia
 *  @param String name 传入的参数是需要定位的按钮、文本框、选择框等的名称，传入的这个名称需要和保存
 *  在数据库中的name保持一致
 *  @return 返回的是传入的name对于的定位方式，可以是id，name，cssselector，linktext等等，方便
 *  在元素对象中使用 
 *
 */
	public By getLocator(String name) throws Exception
	{
	ReadFromSql rfs=new ReadFromSql();
	locatorinfo=rfs.getLocator(name);
	String type=locatorinfo.get("type");
	String value=locatorinfo.get("value");
	if(type.equals("id"))
		return By.id(value);
	
	else if(type.equals("name"))
		return By.name(value);
	
	else if(type.equals("classname"))
		return By.className(value);
	
	else if(type.equals("cssselector"))
		return By.cssSelector(value);
	
	else if(type.equals("link"))
		return By.linkText(value);
	
	else if(type.equals("xpath"))
		return By.xpath(value);
	else if(type.equals("tagname"))
		return By.tagName(value);
	else
		throw new Exception(value+"定位方式为在程序中定义，请检查...");
	}

}
