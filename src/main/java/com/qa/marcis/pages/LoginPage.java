package com.qa.marcis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.marcis.basepage.BasePage;
import com.qa.marcis.utils.Constants;
import com.qa.marcis.utils.ElementUtil;

public class LoginPage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	By email = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink=By.linkText("Sign up");
	
	//constructor of the page class
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		elementUtil=new ElementUtil(this.driver);
		
	}
	
	// Page Actions doGetPageTitleWithIstitle
	
	public String getLoginPageTitle() {
		
		//String title=driver.getTitle();
		//return title;
		
		return elementUtil.doGetPageTitleWithIstitle(10, Constants.LOGIN_PAGE_TITLE);
	}
	
	public boolean isSignUpLinkExist() {
		
		//boolean signuplink=driver.findElement(signUpLink).isDisplayed();
		
		return elementUtil.doIsDisplayed(signUpLink);
			
	}
	
	public HomePage doLogin(String username, String pwd) {
		
		
//		driver.findElement(email).sendKeys(username);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginButton).click();
		
		elementUtil.waitForElementWithFluentWaitConcept(email, 10);
		elementUtil.doActionsSendKeys(email, username);
		elementUtil.doActionsSendKeys(password, pwd);
		elementUtil.doActionsClick(loginButton);
		
		return new HomePage(driver);
	}
	

}
