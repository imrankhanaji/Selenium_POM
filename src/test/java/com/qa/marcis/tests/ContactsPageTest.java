package com.qa.marcis.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.marcis.basepage.BaseTest;
import com.qa.marcis.pages.ContactsPage;
import com.qa.marcis.pages.HomePage;
import com.qa.marcis.utils.Constants;
import com.qa.marcis.utils.ExcelUtil;

public class ContactsPageTest extends BaseTest {

	HomePage homepage;
	ContactsPage contactsPage;
	
	
	@BeforeClass
	public void contactsPageSetup() {
		
		homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homepage.goToContactsPage();
	}
	
	@Test(priority=1)
	
	public void verifyContactsPageTest() {
		
		String title=contactsPage.getContactsPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	
	public void verifyContactsPageHeaderTest() {
		
		String headerValue=contactsPage.getContactsPageHeader();
		System.out.println("Contacts page header is :" + headerValue);
		Assert.assertEquals(headerValue, Constants.CONTACTS_PAGE_HEADER);
		
	}
	
	@DataProvider
	
	public Object[][] getContactsTestData() {
		
		Object data[][]=ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
		return data;
	}
	
	@Test(priority=3, dataProvider="getContactsTestData")
	public void createNewContactTest(String email, String firstName, String lastName, String jobTitle) {
		
		contactsPage.createContact(email, firstName, lastName, jobTitle);
		//Assert.assertEquals(email, "");
		
	}
}
