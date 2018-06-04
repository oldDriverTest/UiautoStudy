package com.uiauto.testscripts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiauto.dao.impl.BugDaoImpl;
import com.uiauto.dao.impl.Factory;
import com.uiauto.pageobject.TestManagePage;
import com.uiauto.service.TestManage_Action;
import com.uiauto.vo.Addbug;

public class TestManageTest {
	LoginTest lt = new LoginTest();
	public static WebDriver webdriver;
	BugDaoImpl bdi = Factory.getBugdaoimplObject();
	TestManage_Action tma = new TestManage_Action();
	TestManagePage tmp=new TestManagePage(webdriver);
	private Logger Log = LogManager.getLogger(TestManageTest.class);

	@BeforeTest
	public void prepare() {
		bdi.returnDefault();
		bdi.insertBugdata();
	}

	@DataProvider(name = "addbugdata")
	public Iterator<Object[]> addbugData() {

		List<Addbug> list = new ArrayList<Addbug>();
		list = bdi.getAddbugdata();
		List<Object[]> bug = new ArrayList<Object[]>();
		for (Object bug1 : list) {
			bug.add(new Object[] { bug1 });
		}
		return bug.iterator();
	}
    /**@author huluxia
     * @param Addbug对象
     * 新增bug的测试用例，数据根据dataprovider提供
     * */
	@Test(dataProvider = "addbugdata",description="新增bug")
	public void addBug(Addbug addbug) throws Exception {
		tma.addBug(webdriver, addbug.getProduct(), addbug.getBugtitle(), addbug.getErrolevel(), addbug.getRepetestep());
		boolean iscontains = webdriver.getPageSource().contains(addbug.getExpextresult());
		// 断言判断是否添加成功，这里的标准就是根据是否包含bugtitle进行判断的
		Log.info("开始判断是否新增成功");
		Assert.assertTrue(iscontains);
		Log.info("新增bug成功");
		Log.info("-----------------新增bug用例结束了-----------------");
	}
	
	/**@author huluxia
	 * @param  Addbug对象，里面可以解析到数据库查询出来的新增bug的信息
	 * bug查询，这里的逻辑就是从数据库读取到新增bug的信息，然后点击bug标题就行内容验证
	 * */
	@Test(dataProvider="addbugdata",dependsOnMethods={"addBug"},description="查看bug")
	public void searchBuginformation(Addbug addbug)throws Exception
	{
		tma.searchBuginformation(webdriver, addbug.getProduct(), addbug.getBugtitle(), addbug.getRepetestep(), addbug.getErrolevel());
	}
}
