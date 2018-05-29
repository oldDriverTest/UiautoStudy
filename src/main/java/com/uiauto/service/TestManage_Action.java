package com.uiauto.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;

import com.uiauto.pageobject.TestManagePage;
import com.uiauto.util.Helputil;

public class TestManage_Action {
private static Logger Log = LogManager.getLogger(TestManage_Action.class);
	public void addBug(WebDriver webdriver,String product,String title,
			String level,String step)throws Exception
	{
		Log.info("-----------------新增Bug开始----------------");
		TestManagePage tmp=new TestManagePage(webdriver);
		Log.info("点击禅道的测试模块");
		tmp.testMangementbtn().click();
		Log.info("点击bug");
		tmp.bugLink().click();
		Log.info("点击新增bug按钮");
		tmp.addBug().click();
		Log.info("睡觉1s");
		Thread.sleep(1000);
		
		//选择下拉框中的这个option
		Log.info("从所属产品中选择，选择的产品为:"+product);
		tmp.productChoose(product); 
		
		//这里要等待，不然会刷新导致填充不到，选择影响版本
		Log.info("等待1.5s，防止影响版本选不到");
		Thread.sleep(1500);
		Log.info("选择影响版本");
		tmp.chooseAffectversion("trunk");
		
		//测试标题
		Log.info("输入测试标题，输入的标题为:"+title);
		tmp.addBugtitle().sendKeys(title);;
		
		//级别
		Log.info("选择验证程度，选择的为:"+level);
		tmp.chooseLevel(level);
		//切换ifame框架，输入重现步骤的内容
		
		/*String js = "document.getElementByClassName('ke-edit-iframe').contentDocument.write('pds');";
		((JavascriptExecutor)webdriver).executeScript(js);*/
		Helputil.switchFrame(webdriver, "ke-edit-iframe");
		Log.info("情空重现步骤");
		tmp.addRecur().clear();
		Log.info("输入重现步骤，输入的内容为:"+step);
		tmp.addRecur().sendKeys(step);
		Log.info("   ");
		
		
		//切出iframe、
		webdriver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		//点击关键词
		tmp.keywords().sendKeys("test");;
		
		//点击保存按钮
		Log.info("点击保存按钮");
		tmp.doSubmit().submit();
		
		Thread.sleep(1000);
		Log.info("-----------------新增bug用例结束了-----------------");
		//保存后页面左上角的产品选择,并且选择刚刚添加的产品类型
		tmp.clickProduct();
		Thread.sleep(1000);
	    tmp.searchProduct().sendKeys(product);
	    Thread.sleep(1000);
	    Helputil.pressEnter(webdriver);

	}
}
