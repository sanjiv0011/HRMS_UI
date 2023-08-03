package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_UserProfilePage {

	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());

	public PO_UserProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//=====START====Personal info Page objects============//
	@FindBy(xpath = "//button[@id='simple-tab-0']")
	@CacheLookup
	WebElement tabPersonalInfo;

	@FindBy(xpath = "//button[@id='simple-tab-1']")
	@CacheLookup
	WebElement tabAddress;

	@FindBy(xpath = "//button[@id='simple-tab-2']")
	@CacheLookup
	WebElement tabBankDetails;

	@FindBy(xpath = "//button[@id='simple-tab-3']")
	@CacheLookup
	WebElement tabOtherInformation;

	@FindBy(xpath = "//button[@id='simple-tab-4']")
	@CacheLookup
	WebElement tabLeaveHistory;
	
	@FindBy(xpath = "//button[@id='simple-tab-5']")
	@CacheLookup
	WebElement tabResetPassword;

		
	
	//=====START====Personal info Action Methods============//
	public void clickOntabPersonalInfo() 
	{
		tabPersonalInfo.click();
		logger.info("Clicked on tabPersonalInfo");
	}
	
	public void clickOntabAddress() 
	{
		tabAddress.click();
		logger.info("Clicked on tabAddress");
	}
	
	public void clickOntabBankDetails() 
	{
		tabBankDetails.click();
		logger.info("Clicked on tabBankDetails");
	}
	
	public void clickOntabOtherInformation() 
	{
		tabOtherInformation.click();
		logger.info("Clicked on tabOtherInformation");
	}
	
	public void clickOntabLeaveHistory() 
	{
		tabLeaveHistory.click();
		logger.info("Clicked on tabLeaveHistory");
	}
	
	public void clickOntabResetPassword() 
	{
		tabResetPassword.click();
		logger.info("Clicked on tabResetPassword");
	}
}


