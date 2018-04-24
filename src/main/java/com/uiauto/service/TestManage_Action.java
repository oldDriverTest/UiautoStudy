package com.uiauto.service;

import org.openqa.selenium.WebDriver;

import com.uiauto.pageobject.TestManagePage;
import com.uiauto.util.Helputil;

public class TestManage_Action {

	public void addBug(WebDriver webdriver)throws Exception
	{
		TestManagePage tmp=new TestManagePage(webdriver);
		tmp.testMangementbtn().click();
		tmp.bugLink().click();
		tmp.addBug().click();
		Thread.sleep(3000);
		//选择下拉框中的这个option
		tmp.productChoose("isTester.com 全平台"); 
		tmp.addBugtitle().sendKeys("测试标题");;
		tmp.chooseLevel("3");
		Helputil.switchFrame(webdriver, "ke-edit-iframe");
		tmp.addRecur().clear();
		tmp.addRecur().sendKeys("1重现步骤");
		tmp.addStep().sendKeys("输入用户名面，点击登录按钮");
	}
}
