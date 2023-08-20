package com.hrms.pageObject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

public class PO_LoginPage extends ReUseAbleElement {
	
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	
	public  PO_LoginPage(WebDriver driver)
	{   super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
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
	
	@FindBy(xpath = "//span[@class='MuiBox-root css-1bd5wky']")
	@CacheLookup
	WebElement forgetPasswordLink;
	
	
	// apply set method for each variable 
	// here get method not required beacues we are using config.properties files

	public void setUserName(String userName) throws InterruptedException 
	{
		textUserName.sendKeys(userName);
		logger.info("Enteterd userName");
		Thread.sleep(1000);
	}
		
	public void setTextpassword(String password) throws InterruptedException {
		textpassword.sendKeys(password);
		logger.info("Entered password");
		Thread.sleep(1000);
	}

	public void clickBtnsubmit() throws InterruptedException {
		btnsubmit.click();
		logger.info("clicke on login submit button");
		Thread.sleep(5000);
	}
	
	public void clickOnCheckBox() {
		checkBox.click();
	}
	
	public void clickForgetPassword() {
		forgetPasswordLink.click();
	}
	
	public PO_HomePage Login(String userName, String password) throws InterruptedException
	{
		setUserName(userName);
		setTextpassword(password);
		clickBtnsubmit();

		if(driver.getPageSource().contains("Dashboard"))
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
