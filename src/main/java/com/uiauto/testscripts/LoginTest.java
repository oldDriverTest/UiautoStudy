package com.uiauto.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uiauto.service.Login_Action;
import com.uiauto.util.Helputil;
import com.uiauto.util.Log;
import com.uiauto.util.TestListener;

public class LoginTest {
public WebDriver webdriver;
  @BeforeTest
  public void startChrome()
  {
	  //在执行用例前，删除本地的LOG文件
	  Helputil.deleteLocalLog();
      //Helputil.deleteFailurePic();
	  System.setProperty("webdriver.chrome.driver", "E:/chromenew/chromedriver.exe");
	  webdriver=new ChromeDriver();
	  TestListener.driver=webdriver;
	  TestManageTest.webdriver=webdriver;
	  webdriver.manage().window().maximize();
  }
  @Test
  public void loginTest() throws Exception {
	  Login_Action login = new Login_Action();
	  login.Login(webdriver, "tester1", "123456");
	  //断言判断是否登录跳转到主页，根据页面中是否包含“后台首页”字样来判断是否登录成功 
	  String title=webdriver.getTitle();
	  Log.info("进行断言判断");
	  Assert.assertEquals(title, "我的地盘 - 禅道");
	  Log.info("登录成功");
  }
  
 
 
  public WebDriver getWebdriver()
  {
	  return this.webdriver;
  }
}
