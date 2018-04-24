package com.uiauto.pageobject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiauto.util.GetLocator;
import com.uiauto.util.Helputil;

public class TestManagePage {
private WebElement element=null;
private WebDriver webdriver;
GetLocator gl=new GetLocator();
	public TestManagePage(WebDriver webdriver)
	{
		this.webdriver=webdriver;
	}
	
	//返回测试模块的测试按钮的对象
	public WebElement testMangementbtn() throws Exception
	{
		element=webdriver.findElement(gl.getLocator("testmodel"));
		return element;
	}
	
	//测试模块中子模块Bug连接对象
	public WebElement bugLink() throws Exception
	{
		element=webdriver.findElement(gl.getLocator("testmodel.bug"));
		return element;
	}
	
	//提Bug按钮的对象
	public WebElement addBug()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("testmodel.addbug"));
		return element;
	}
    
	//提bug界面的产品下拉列表
	public void productChoose(String value) throws Exception
	{
		element=webdriver.findElement(gl.getLocator("addbug.product"));
		Helputil.mouseClick(webdriver, element);
		WebElement element1=webdriver.findElement(gl.getLocator("addbug.productchoose"));
		element1.sendKeys(value);
		Helputil.pressEnter(webdriver);
	}
	
	//添加bug标题
	public WebElement addBugtitle() throws Exception
	{
		element=webdriver.findElement(gl.getLocator("addbug.title"));
		return element;	
	}
	
	//严重程度
	public void chooseLevel(String value)throws Exception
	{
		element=webdriver.findElement(gl.getLocator("addbug.errolevel"));
		Helputil.mouseClick(webdriver, element);
		WebElement element1=webdriver.findElement(By.linkText(value));
		element1.click();
	}
	//重现步骤输入框
	public WebElement addRecur()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("addbug.article"));
		return element;
	}
	
	
	
	
	//重现步骤步骤
	public WebElement addStep()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("addbug.article.step"));	
		return element;
	}
}
