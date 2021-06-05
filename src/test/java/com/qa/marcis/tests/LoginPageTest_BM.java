package com.qa.marcis.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.marcis.basepage.BasePage;
import com.qa.marcis.pages.LoginPage;
import com.qa.marcis.utils.Constants;

public class LoginPageTest_BM {
	
			WebDriver driver;
			Properties prop;
			BasePage basepage;
			LoginPage loginpage;
			
		@BeforeMethod
		public void setUp() {
			
			basepage =new BasePage();
			prop=basepage.init_prop();
			driver= basepage.init_driver(prop);
			loginpage=new LoginPage(driver);
			
		}
		
		
		@Test(priority=1)
		
		public void verifySignUpLinkTest() {
			
			//loginpage.isSignUpLinkExist();
			Assert.assertEquals(loginpage.isSignUpLinkExist(), true);
			
		}
		
		@Test(priority=2)
		
		public void verifyLoginPageTitleTest() {
			
			String title=loginpage.getLoginPageTitle();
			System.out.println("Login page title is:" +" "+title);
			Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		}
		
		@Test(priority=3)
		
		public void loginTest() {
			
			loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
			
			
		}
		
		@AfterMethod
		
		public void tearDown() {
			driver.quit();
		}

}
