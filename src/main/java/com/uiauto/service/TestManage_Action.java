package com.uiauto.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.uiauto.pageobject.TestManagePage;
import com.uiauto.util.HelpUtil;
import com.uiauto.util.SelectUtil;

public class TestManage_Action {
	private  Logger Log = LogManager.getLogger(TestManage_Action.class);

	/**@author huluxia
	 * 新增bug  
	 * @param
	 * webdriver对象、产品名称、bug标题、严重级别、重现步骤
	 * **/
	public void addBug(WebDriver webdriver, String product, String title, String level, String step) throws Exception {
		Log.info("-----------------新增Bug开始----------------");
		TestManagePage tmp = new TestManagePage(webdriver);
		Log.info("点击禅道的测试模块");
		tmp.testMangementbtn().click();
		Log.info("点击bug");
		tmp.bugLink().click();
		Log.info("点击新增bug按钮");
		tmp.addBug().click();
		Log.info("睡觉1s");
		Thread.sleep(1000);

		// 选择下拉框中的这个option
		Log.info("从所属产品中选择，选择的产品为:" + product);
		tmp.productChoose(product);

		// 这里要等待，不然会刷新导致填充不到，选择影响版本
		Log.info("等待1.5s，防止影响版本选不到");
		Thread.sleep(1500);
		Log.info("选择影响版本");
		tmp.chooseAffectversion("trunk");

		// 测试标题
		Log.info("输入测试标题，输入的标题为:" + title);
		tmp.addBugtitle().sendKeys(title);
		;

		// 级别
		Log.info("选择验证程度，选择的为:" + level);
		tmp.chooseLevel(level);
		// 切换ifame框架，输入重现步骤的内容
		HelpUtil.switchFrame(webdriver, "ke-edit-iframe");
		Log.info("情空重现步骤");
		tmp.addRecur().clear();
		Log.info("输入重现步骤，输入的内容为:" + step);
		tmp.addRecur().sendKeys(step);

		// 切出iframe、
		webdriver.switchTo().defaultContent();
		Thread.sleep(1000);

		// 点击关键词
		tmp.keywords().sendKeys("test");
		;

		// 点击保存按钮
		Log.info("点击保存按钮");
		tmp.doSubmit().submit();

		Thread.sleep(1000);
		// 保存后页面左上角的产品选择,并且选择刚刚添加的产品类型
		tmp.clickProduct();
		Thread.sleep(1000);
		tmp.searchProduct().sendKeys(product);
		Thread.sleep(1000);
		HelpUtil.pressEnter(webdriver);
		tmp.bugLink().click();
		Thread.sleep(5);
	}
	

	/**@author huluxia
	 * 查看功能的检查，这里的依据是从数据库查出来新增用例的title，然后点击title，获取到
	 * 的重现步骤内容和新增时的重现步骤内容进行对比
	 *
	 * **/
	public void searchBuginformation(WebDriver webdriver,String product,String bugtitle,
			String step,String level)throws Exception
	{ 
		Log.info("---------------------------");
		Log.info("查看bug详情测试用例开始执行");
		TestManagePage tmp=new TestManagePage(webdriver);
		
		Log.info("点击禅道的测试模块");
		tmp.testMangementbtn().click();
		Thread.sleep(1000);
		
		Log.info("点击更多链接");
		tmp.search_more().click();
		
		Log.info("点击的测试标题为:"+bugtitle);
		tmp.bugtitle(bugtitle).click();
		Thread.sleep(2000);
		
		Log.info("获取界面中重现步骤的内容");
		String str=tmp.search_step().getText();
		Log.info("获取到的重现步骤的内容:"+str);
		
		Assert.assertEquals(str,step);
		Log.info("查看bug详细结束了，查看的测试标题为"+bugtitle);
		Log.info("---------------------------");
	}	
	
	
	/**@author huluxia
	 * 编辑bug
	 * 逻辑:从数据库获取添加的bug的标题，点击他，然后输入备注，
	 * 
	 * */
	public void editBug(WebDriver webdriver,String bugtitle)throws Exception
	{
		TestManagePage tmp=new TestManagePage(webdriver);
		Log.info("--------------------------------");
		Log.info("-----------修改bug测试用例开始了-----------");
		Log.info("点击禅道的测试模块");
		tmp.testMangementbtn().click();
		Thread.sleep(1000);
		
		Log.info("点击更多链接");
		tmp.search_more().click();
		
		Log.info("点击从数据库查询到的bugtitle"+bugtitle);
		tmp.bugtitle(bugtitle).click();
		
		Log.info("点击编辑按钮");
		tmp.edit_editbtn().click();
		
		String option=SelectUtil.getRandomOption(tmp.edit_selectBrowser());
		Log.info("下拉browser选择"+option);
		SelectUtil.selectByVisible(tmp.edit_selectBrowser(),option);
		
		Log.info("点击保存按钮");
		tmp.edit_submit().click();
		Log.info("保存完毕");
		
		String browser1=tmp.getBrowsertext().getText();
		Log.info("获取到的文本为"+browser1);
		Assert.assertEquals(browser1,option);
		Log.info("---------------修改bug用例结束----------------");
		
	}
}
