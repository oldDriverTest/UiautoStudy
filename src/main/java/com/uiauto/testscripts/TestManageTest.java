package com.uiauto.testscripts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiauto.dao.impl.BugDaoImpl;
import com.uiauto.dao.impl.Factory;
import com.uiauto.service.TestManage_Action;
import com.uiauto.vo.Addbug;

public class TestManageTest {
public static WebDriver webdriver=null;
BugDaoImpl bdi=Factory.getBugdaoimplObject();
  
  @BeforeTest
  public void prepare()
  {
	  bdi.returnDefault();
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
	  
	  TestManage_Action tma=new TestManage_Action();
	  tma.addBug(webdriver,addbug.getProduct(),addbug.getBugtitle(),
			  addbug.getErrolevel(),addbug.getRepetestep());
  }
  
}
