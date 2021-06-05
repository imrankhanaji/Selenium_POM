package com.qa.marcis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.marcis.basepage.BasePage;
import com.qa.marcis.utils.Constants;
import com.qa.marcis.utils.ElementUtil;

public class HomePage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	By header=By.cssSelector("h1.dashboard-selector__title");
	By text=By.cssSelector("span.isc-help-widget__help-button");
	By contactsPrimaryLink=By.xpath("//a[@id='nav-primary-contacts-branch']");
	By contactsSecondaryLink=By.xpath("//a[@id='nav-secondary-contacts']");
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(this.driver);
	}
	
	public String getHomePageTitle() {
		
		return elementUtil.doGetPageTitleWithIstitle(10, Constants.HOME_PAGE_TITLE);
		
	}
	
	public String getHomePageHeader() {
		
//		if(driver.findElement(header).isDisplayed()) 
//			return driver.findElement(header).getText();
//			return null;
			
		if(elementUtil.doIsDisplayed(header))
			return elementUtil.doGetText(header);
			return null;
	}
	
	public ContactsPage goToContactsPage() {
		
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	//Below is encapsulation. will hide the method.
	
	private void clickOnContacts() {
		
		elementUtil.waitForElementWithFluentWaitConcept(contactsPrimaryLink, 10);
		elementUtil.doActionsClick(contactsPrimaryLink);
		elementUtil.waitForElementWithFluentWaitConcept(contactsSecondaryLink, 5);
		elementUtil.doClick(contactsSecondaryLink);
		
	}
	


}
