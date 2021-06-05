package com.qa.marcis.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.marcis.basepage.BasePage;
import com.qa.marcis.basepage.BaseTest;
import com.qa.marcis.pages.LoginPage;
import com.qa.marcis.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	// Not required below bcos we are going to extend basetest
	
//		WebDriver driver;
//		Properties prop;
//		BasePage basepage;
//		LoginPage loginpage;
//		
		
	// TestNG- unit testing framework-- using for Automation Testing also.
	// Precondition --> Testcases/ Steps (act vs exp)-- (Assertions)--TearDown (close the browser)
	// BeforeTest --->@Test-->Assertions--->@AfterTest-->TearDown
	// Launch Browser, Url-->title test->close the browser
	
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
	
	
	
	

}
