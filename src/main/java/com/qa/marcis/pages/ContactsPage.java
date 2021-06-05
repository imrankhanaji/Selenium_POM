package com.qa.marcis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.marcis.basepage.BasePage;
import com.qa.marcis.utils.Constants;
import com.qa.marcis.utils.ElementUtil;

public class ContactsPage extends BasePage {
	
	ElementUtil elementutil;
	
	By header=By.xpath("//h1[@class='IndexPageRedesignHeader__StyledH1-ljkrr-1 dTXiYC']");
	By createContactPrimary=By.xpath("//span[text()='Create contact']");
	By email=By.xpath("//input[@data-field='email']");
	By firstName=By.xpath("//input[@data-field='firstname']");
	By lastName=By.xpath("//input[@data-field='lastname']");
	By jobTitle=By.xpath("//input[@data-field='jobtitle']");
	By createContactSecondary=By.xpath("(//span[text()='Create contact'])[position()=2]");
	By contactsBackLik=By.xpath("(//*[text()='Contacts'])[position()=1]");
	
	public ContactsPage(WebDriver driver) {
			
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}
	
	public String getContactsPageTitle() {
		
		return elementutil.doGetPageTitleWithIstitle(10, Constants.CONTACTS_PAGE_TITLE);
	}
	
	public String getContactsPageHeader() {
		
		elementutil.waitForElementWithFluentWaitConcept(header, 10);
		return elementutil.doGetText(header);
		
	}
	
	public void createContact(String email,String firstName,String lastName,String jobTitle) {
		
		elementutil.clickWhenReady(createContactPrimary, 10);
		
		elementutil.doSendKeys(this.email, email);
		elementutil.doSendKeys(this.firstName, firstName);
		elementutil.doSendKeys(this.lastName, lastName);
		elementutil.doSendKeys(this.jobTitle, jobTitle);
		
		
		//elementutil.clickWhenReady(createContactSecondary, 5);
		
		elementutil.doClick(createContactSecondary);
		elementutil.clickWhenReady(contactsBackLik, 10);
	}
	
}
