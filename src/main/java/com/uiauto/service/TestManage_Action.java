package com.uiauto.service;

import org.openqa.selenium.WebDriver;

import com.uiauto.pageobject.TestManagePage;
import com.uiauto.util.Helputil;

public class TestManage_Action {

	public void addBug(WebDriver webdriver,String product,String title,
			String level,String step)throws Exception
	{
		TestManagePage tmp=new TestManagePage(webdriver);
		tmp.testMangementbtn().click();
		tmp.bugLink().click();
		tmp.addBug().click();
		Thread.sleep(1000);
		
		//选择下拉框中的这个option
		tmp.productChoose(product); 
		
		//这里要等待，不然会刷新导致填充不到，选择影响版本
		Thread.sleep(1500);
		tmp.chooseAffectversion("trunk");
		
		//测试标题
		tmp.addBugtitle().sendKeys(title);;
		
		//级别
		tmp.chooseLevel(level);
		
		//切换ifame框架，输入重现步骤的内容
		Helputil.switchFrame(webdriver, "ke-edit-iframe");
		tmp.addRecur().clear();
		tmp.addRecur().sendKeys(step);	
		//按下tab键    确保重现步骤可以保存
		Helputil.pressTab(webdriver);  
		//切出iframe、
		webdriver.switchTo().defaultContent();
		
		//点击保存按钮
		tmp.doSubmit().submit();
		
		Thread.sleep(1000);
		//保存后页面左上角的产品选择,并且选择刚刚添加的产品类型
		tmp.clickProduct();
		Thread.sleep(1000);
	    tmp.searchProduct().sendKeys("isTester.com");
	    Thread.sleep(1000);
	    Helputil.pressEnter(webdriver);

	}
}
