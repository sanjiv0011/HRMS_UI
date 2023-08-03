package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_UserProfilePage_BankDetails {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());

	public PO_UserProfilePage_BankDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	//=====START====Bank Details Page objects============//
	@FindBy(xpath = "//input[@id=':rv:']")
	@CacheLookup
	WebElement textBankName;

	@FindBy(xpath = "//input[@id=':r1d:']")
	@CacheLookup
	WebElement textBankNumber;

	@FindBy(xpath = "//input[@id=':r1f:']")
	@CacheLookup
	WebElement textSalary;
					
	@FindBy(xpath = "//div[3]//button[1]//p[1]")
	@CacheLookup
	WebElement btnBankDetailsSaveandGoToHome;

	@FindBy(xpath = "//div[3]//button[1]//p[1]")
	@CacheLookup
	WebElement btnBankDetailsNext;
	//=====END====Bank Details Page objects============//
	
	//=====START====Bank Details Action Methods============//
		public void setBankName(String bankName)
		{
			textBankName.sendKeys(bankName);
			logger.info("Entered bank nane");
		}
		
		public void setBankNumber(String bankNumber)
		{
			textBankNumber.sendKeys(bankNumber);
			logger.info("Entered bank number");
		}
		
		public void setSalary(String salary)
		{
			textSalary.sendKeys(salary);
			logger.info("Entered salary");
		}
		
		public void clickOnBtnBankDetailsSaveAndGoToHome()
		{
			btnBankDetailsSaveandGoToHome.click();
			logger.info("clicked On Btn Bank Details Save And Go To Home");
		}
		
		public void clickOnBtnBankDetailsNext()
		{
			btnBankDetailsNext.click();
			logger.info("Entered bank nane");
		}
		
		
		public PO_UserProfilePage fillAddressDetails(String bankName, String bankNumber, String salary, String choice) throws InterruptedException
		{
			textBankName.sendKeys(bankName);
			logger.info("Entered bank nane");
			Thread.sleep(500);		
			
			textBankNumber.sendKeys(bankNumber);
			logger.info("Entered bank number");
			Thread.sleep(500);
			
			textSalary.sendKeys(salary);
			logger.info("Entered salary");
			Thread.sleep(500);
			
			if(choice == "saveAndHome")
			{
				btnBankDetailsSaveandGoToHome.click();
				logger.info("clicked On Btn Bank Details Save And Go To Home");
				Thread.sleep(500);
			}
			else if(choice == "next")
			{
				btnBankDetailsNext.click();
				logger.info("Entered bank nane");
				Thread.sleep(500);
			}
			
			return new PO_UserProfilePage(driver);
			
		}
		
		//=====END====Bank Details Action Methods============//

}
