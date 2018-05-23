package com.uiauto.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.uiauto.service.TestManage_Action;

public class TestManageTest {
public static WebDriver webdriver=null;
  @Test
  public void addBUG() throws Exception {

	  TestManage_Action tma=new TestManage_Action();
	  tma.addBug(webdriver);
  }
  
}
