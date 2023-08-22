package com.hrms.pageObject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

public class PO_UserProfilePage_BankDetails extends ReUseAbleElement {
	
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;

	public PO_UserProfilePage_BankDetails(WebDriver driver) {
		super(driver);
        this.driver = driver;
        jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	}
	

	//=====START====Bank Details Page objects============//
	@FindBy(xpath = "//input[@name='bankName']")
	@CacheLookup
	WebElement textBankName;

	@FindBy(xpath = "//input[@name='accountName']")
	@CacheLookup
	WebElement textAccountName;

	@FindBy(xpath = "//input[@name='accountNumber']")
	@CacheLookup
	WebElement textAccountNumber;
					
	@FindBy(xpath = "//input[@name='ifscCode']")
	@CacheLookup
	WebElement textISFCCode;

	//=====END====Bank Details Page objects============//
	
	//=====START====Bank Details Action Methods============//
		public void setBankName(String bankName) throws InterruptedException {
			textBankName.sendKeys(Keys.CONTROL, "a"); // Select all text
			Thread.sleep(300);
			textBankName.sendKeys(Keys.DELETE);	 // Delete all text
			Thread.sleep(300);
			textBankName.sendKeys(bankName);
			Thread.sleep(500);
			logger.info("Entered bank nane");
		}
		
		public void setAccountName(String accountName) throws InterruptedException {
			textAccountName.sendKeys(Keys.CONTROL, "a"); // Select all text
			Thread.sleep(300);
			textAccountName.sendKeys(Keys.DELETE);	 // Delete all text
			Thread.sleep(300);
			textAccountName.sendKeys(accountName);
			Thread.sleep(500);
			logger.info("Entered bank number");
		}
		
		public void setAccounNumber(String accountNumber) throws InterruptedException {
			textAccountNumber.sendKeys(Keys.CONTROL, "a"); // Select all text
			Thread.sleep(300);
			textAccountNumber.sendKeys(Keys.DELETE);	 // Delete all text
			Thread.sleep(300);
			textAccountNumber.sendKeys(accountNumber);
			Thread.sleep(500);
			logger.info("Entered accountName");
		}
		
		public void setISFCCode(String isfcCode) throws InterruptedException {
			textISFCCode.sendKeys(Keys.CONTROL, "a"); // Select all text
			Thread.sleep(300);
			textISFCCode.sendKeys(Keys.DELETE);	 // Delete all text
			Thread.sleep(300);
			textISFCCode.sendKeys(isfcCode);
			Thread.sleep(500);
			logger.info("Entered isfc code");
		}

		//TO FILL THE USER BANK DETAILS WITH RETURN TYPE(PO_HomePage)
		public PO_HomePage fillBankDetails(String bankName, String bankNumber, String accountName,String isfcCode) throws InterruptedException
		{
			setBankName(bankName);		
			setAccountName(accountName);
			setAccounNumber(bankNumber);
			setISFCCode(isfcCode);
			ruae.clickOnBtnSave_1_RU();
			
			return new PO_HomePage(driver);
			
		}
		//=====END====Bank Details Action Methods============//

}
