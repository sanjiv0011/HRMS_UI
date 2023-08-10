package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PO_LoginPage {
	
	public Logger logger = LogManager.getLogger(getClass());
	
	// initiate page factory constructor
	public WebDriver driver= null;
	
	public  PO_LoginPage(WebDriver driver)
	{ 
		this.driver = driver;
		//this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	// to find page elements
	@FindBy(name = "userName")
	@CacheLookup
	WebElement textUserName;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement textpassword;
	
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	@CacheLookup
	WebElement btnsubmit;
	
	@FindBy(xpath = "input[type=\"checkbox\"]")
	@CacheLookup
	WebElement checkBox;
	
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M12 7c2.76')]")
	@CacheLookup
	WebElement viewPasswordBtn;
	
	@FindBy(xpath = "//span[@class='MuiBox-root css-1bd5wky']")
	@CacheLookup
	WebElement forgetPasswordLink;
	
	
	// apply set method for each variable 
	// here get method not required beacues we are using config.properties files

	public void setUserName(String userName) 
	{
		textUserName.sendKeys(userName);
	}
		
	public void setTextpassword(String password) {
		textpassword.sendKeys(password);
	}

	public void clickBtnsubmit() {
		btnsubmit.click();
	}
	
	public void clickViewPasswordBtn() {
		viewPasswordBtn.click();
	}
	
	public void clickOnCheckBox() {
		checkBox.click();
	}
	
	public void clickForgetPassword() {
		forgetPasswordLink.click();
	}
	
	public PO_HomePage login(String userName, String password) throws InterruptedException
	{
		textUserName.sendKeys(userName);
		logger.info("Enteterd userName");
		Thread.sleep(1000);
		
		textpassword.sendKeys(password);
		logger.info("Entered password");
		Thread.sleep(1000);
		
		btnsubmit.click();
		logger.info("clicke on login submit button");
		Thread.sleep(5000);
	
		if(driver.getPageSource().contains("super-admin"))
		{
			Assert.assertTrue(true);
			logger.info("Login success...");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login failed!!!");
		}
		
		return new PO_HomePage(driver);

	}
	
}
