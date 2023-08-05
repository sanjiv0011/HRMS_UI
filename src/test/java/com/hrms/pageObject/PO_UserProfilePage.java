package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	public PO_HomePage UserProfilePageTesting() throws InterruptedException
	{
		tabPersonalInfo.click();
		logger.info("Clicked on tabPersonalInfo");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Phone Number")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		tabAddress.click();
		logger.info("Clicked on tabAddress");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Phone Number")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}

		tabBankDetails.click();
		logger.info("Clicked on tabBankDetails");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Address Line 1")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		tabOtherInformation.click();
		logger.info("Clicked on tabOtherInformation");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Bank Name")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		tabLeaveHistory.click();
		logger.info("Clicked on tabLeaveHistory");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Emergency Contact Name")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		

		tabLeaveHistory.click();
		logger.info("Clicked on tabLeaveHistory");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Leave History")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		tabResetPassword.click();
		logger.info("Clicked on tabResetPassword");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Old Password")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		return new PO_HomePage(driver);
	}
}


