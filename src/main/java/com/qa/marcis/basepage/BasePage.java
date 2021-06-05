package com.qa.marcis.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	/**
	 * this method is used to initialise the browser on the basis of given browser name
	 * @param browserName
	 * @return driver
	 */
	
	public  WebDriver init_driver(Properties prop) {
		
		String browserName=prop.getProperty("browser").trim();
		
		System.out.println("Browser name is: "+ " "+browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver= new SafariDriver();
		}
		
		else {
			System.out.println(browserName+ " "+ "is not found. plz pass the correct browser name");
		}
			
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	/**
	 * this method is used to initialise the properties from config.properties file
	 * @return Properties
	 */
	
		public Properties init_prop() {
			
			prop=new Properties();
			
			try {
				FileInputStream ip= new FileInputStream("C:\\Users\\Imran Khan\\eclipse-workspace\\Selenium_POM\\"
						+ "src\\main\\java\\com\\qa\\marcis\\config\\config.properties");
				
				prop.load(ip);
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return prop;
		
	}

}
