package com.hrms.pageObject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

public class PO_UserProfilePage extends ReUseAbleElement {

	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;

	public PO_UserProfilePage(WebDriver driver) {
		super(driver);
        this.driver = driver;
        jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	}

	//=====START====Personal info Page objects============//
	@FindBy(xpath = "//button[@id='simple-tab-0']")
	@CacheLookup
	WebElement tabPersonalInfo;

	@FindBy(xpath = "//button[@id='simple-tab-1']")
	@CacheLookup
	WebElement tabAddress;

	@FindBy(xpath = "//button[@id='simple-tab-3']")
	@CacheLookup
	WebElement tabBankDetails;

	@FindBy(xpath = "//button[@id='simple-tab-2']")
	@CacheLookup
	WebElement tabOtherInformation;

	@FindBy(xpath = "//button[@id='simple-tab-4']")
	@CacheLookup
	WebElement tabLeaveHistory;
	
	@FindBy(xpath = "//button[@id='simple-tab-5']")
	@CacheLookup
	WebElement tabResetPassword;

		
	
	//=====START====Personal info Action Methods============//
	public void clickOntabPersonalInfo() throws InterruptedException {
		tabPersonalInfo.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabPersonalInfo");
	}
	
	public void clickOntabAddress() throws InterruptedException {
		tabAddress.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabAddress");
	}
	
	//USE IN GENERAL FLOW
	public void clickOntabBankDetails() throws InterruptedException {
		tabBankDetails.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabBankDetails");
	}
		
	//TO SET THE DRIVER AT BANK DETAILS PAGE
	public PO_UserProfilePage_BankDetails clickOntabBankDetails_ReturnBankDeailsPage() throws InterruptedException {
		tabBankDetails.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabBankDetails");
		return new PO_UserProfilePage_BankDetails(driver);
	}
	
	public void clickOntabOtherInformation() throws InterruptedException {
		tabOtherInformation.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabOtherInformation");
	}
	
	public void clickOntabLeaveHistory() throws InterruptedException {
		tabLeaveHistory.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabLeaveHistory");
	}
	
	//USE IN GENERAL FLOW
	public void clickOntabResetPassword() throws InterruptedException {
		tabResetPassword.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabResetPassword");
	}
	
	//USE IN GENERAL FLOW
	public PO_UserProfilePage_ResetPassword clickOntabResetPassword_ReturnResetPasswordPage() throws InterruptedException {
		tabResetPassword.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabResetPassword");
		return new PO_UserProfilePage_ResetPassword(driver);
	}
	
	//TO TEST THE USER PROFILE PAGE TAB WORKING
	public PO_HomePage UserProfilePageTesting() throws InterruptedException
	{
		clickOntabPersonalInfo();
		clickOntabAddress();
		clickOntabBankDetails();
		clickOntabOtherInformation();
		clickOntabLeaveHistory();
		clickOntabResetPassword();
		return new PO_HomePage(driver);
	}
}


