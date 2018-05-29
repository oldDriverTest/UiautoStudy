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
import com.uiauto.service.TestManage_Action;
import com.uiauto.vo.Addbug;

public class TestManageTest {
LoginTest lt=new LoginTest();
public static WebDriver webdriver;
BugDaoImpl bdi=Factory.getBugdaoimplObject();
TestManage_Action tma=new TestManage_Action(); 
private static Logger Log = LogManager.getLogger(TestManageTest.class);

  @BeforeTest
  public void prepare()
  {
	  bdi.returnDefault();
	  System.out.println("初始化");
	  bdi.insertBugdata();
  }
  
  @DataProvider(name="addbugdata")
  public Iterator<Object[]> addbugData()
  {
		
		List<Addbug> list=new ArrayList<Addbug>();
		list=bdi.getAddbugdata();
		List<Object[]> bug=new ArrayList<Object[]>();
		for(Object bug1:list)
		{
			bug.add(new Object[]{bug1});
		}
		return bug.iterator();
  }
  
  @Test(dataProvider="addbugdata")
  public void addBUG(Addbug addbug) throws Exception {
	  tma.addBug(webdriver,addbug.getProduct(),addbug.getBugtitle(),
			  addbug.getErrolevel(),addbug.getRepetestep());
	  boolean iscontains=webdriver.getPageSource().contains(addbug.getExpextresult());
      //断言判断是否添加成功，这里的标准就是根据是否包含bugtitle进行判断的
	  System.out.println(iscontains);
	  Log.info("开始判断是否新增成功");
	  Assert.assertTrue(iscontains);
	  Log.info("新增bug成功>>>>>>>>>");
  }
  @AfterTest
  public void quit()
  {
	  webdriver.quit();
  }
  
}
