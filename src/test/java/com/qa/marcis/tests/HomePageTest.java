package com.qa.marcis.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.marcis.basepage.BaseTest;
import com.qa.marcis.pages.HomePage;
import com.qa.marcis.utils.Constants;

public class HomePageTest extends BaseTest{
	
		HomePage homepage;
		
	
		@BeforeClass
		public void homePageSetup() {
			
			homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
			
		}
		
		@Test(priority=2)
		
		public void verifyHomePageTitleTest() {
			
			String title=homepage.getHomePageTitle();
			System.out.println("Home Page title is:" + title);
			
			Assert.assertEquals(title,Constants.HOME_PAGE_TITLE);
		}
		
		@Test(priority=1)
		public void verifyHomePageHeaderTest() {
			
			String header=homepage.getHomePageHeader();
			System.out.println("Home Page Header is:"+ header);
			Assert.assertEquals(header,Constants.HOME_PAGE_HEADER);
			
		}

	
	}
