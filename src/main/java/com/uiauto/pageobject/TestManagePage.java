package com.uiauto.pageobject;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiauto.util.GetLocator;
import com.uiauto.util.HelpUtil;


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
		HelpUtil.mouseClick(webdriver, element);
		WebElement element1=webdriver.findElement(gl.getLocator("addbug.productchoose"));
		element1.sendKeys(value);
		HelpUtil.pressEnter(webdriver);
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
		HelpUtil.mouseClick(webdriver, element);
		WebElement element1=webdriver.findElement(By.linkText(value));
		element1.click();
	}
	//重现步骤输入框
	public WebElement addRecur()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("addbug.article"));
		return element;
	}
	
	//影响版本对象
	public void chooseAffectversion(String value)throws Exception
	{
	    element=webdriver.findElement(gl.getLocator("addbug.affectversion"));
	    HelpUtil.mouseClick(webdriver, element);
	    element.sendKeys(value);
	    HelpUtil.pressEnter(webdriver);
	}
	
	
	//重现步骤步骤
	public WebElement addStep()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("addbug.article.step"));	
		return element;
	}
	
	//保存按钮
	public WebElement doSubmit()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("addbug.submit"));
		return element;
	}
	
	
	//测试模块下的左上角产品选择
	public void clickProduct()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("addbug.chooseproduct"));
		element.click();
		
	}
	
	public WebElement searchProduct()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("addbug.searchproduct"));
		return element;
	}
	
	public WebElement keywords()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("addbug.kewword"));
		return element;
	}
	
	//bug标题
	public WebElement bugtitle(String bugtitle)throws Exception
	{
		element=webdriver.findElement(By.linkText(bugtitle));
		return element;
	}
	
	//bug详细界面的重现步骤
	public WebElement search_step()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("searchbug.step"));
		return element;
	}
	
	//bug详细界面的严重级别
	public WebElement search_level()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("searchbug.level"));
		return element;
	}
	
	//测试模块的左上角选择对象
	public WebElement search_choose()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("searchbug.product"));
		return element;
	}
	
	//测试模块左上角点击后的搜索框
	public WebElement search_input()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("addbug.search"));
		return element;
	}
	
	//测试模块的更多链接
	public WebElement search_more()throws Exception
	{
		element=webdriver.findElement(gl.getLocator("searchbug.more"));
		return element;
	}
}
