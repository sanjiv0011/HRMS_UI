package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hrms.utilities.ExtentReport;


public class PO_HomePage{
	
	public Logger logger = LogManager.getLogger(getClass());
	public WebDriver driver = null;
	
	public PO_HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page objects
	@FindBy(xpath = "//div[@class='MuiBox-root css-12an206']")
	@CacheLookup
	WebElement btnSystemManager;
	
	@FindBy(xpath = "//a[@href=\"/organization\"]")
	@CacheLookup
	WebElement tabOrganizations;
	
	@FindBy(xpath = "//span[normalize-space()=\"Leave\"]")
	@CacheLookup
	WebElement tabLeave;
	
	@FindBy(xpath = "//span[normalize-space()=\"Clients\"]")
	@CacheLookup
	WebElement tabClients;
	
	@FindBy(xpath = "//span[normalize-space()=\"Users\"]")
	@CacheLookup
	WebElement tabUsers;
	
	@FindBy(xpath = "//a[@href=\"/project\"]")
	@CacheLookup
	WebElement tabProjects;
	
	@FindBy(xpath = "//span[normalize-space()=\"Daily Updates\"]")
	@CacheLookup
	WebElement tabDailyUpdates;
	
	@FindBy(xpath = "//span[normalize-space()=\"Assets\"]")
	@CacheLookup
	WebElement tabAssets;
	
	@FindBy(xpath = "//span[normalize-space()=\"My Calender\"]")
	@CacheLookup
	WebElement tabMyCalender;
	
	@FindBy(xpath = "//a[@href=\"/job-title\"]")
	@CacheLookup
	WebElement tabJobTitle;
	
	@FindBy(xpath = "//span[normalize-space()=\"Manage Leave Types\"]")
	@CacheLookup
	WebElement tabManageLeaveTypes;
	
	
	@FindBy(xpath = "//span[normalize-space()=\"Leave Balances\"]")
	@CacheLookup
	WebElement tabLeaveBalances;
	
	@FindBy(xpath = "//button[@aria-label=\"open drawer\"]//*[name()=\"svg\"]")
	@CacheLookup
	WebElement tabMenu;
	
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M3 18h18v-')]")
	@CacheLookup
	WebElement iconUserLogged;
	
	@FindBy(xpath = "//img[@alt='Image']")
	@CacheLookup
	WebElement iconHomeImage;
	
	@FindBy(xpath = "//li[normalize-space()='My Profile']")
	@CacheLookup
	WebElement dropdownMyProfile;
	
	@FindBy(xpath = "//li[normalize-space()=\"Logout\"]")
	@CacheLookup
	WebElement dropdownLogout;
	
	@FindBy(xpath = "//p[normalize-space()='No']")
	@CacheLookup
	WebElement dropdownLogotNoBtn;
	
	@FindBy(xpath = "//button[.='Yes']")
	@CacheLookup
	WebElement dropdownLogotYesBtn;
	
	@FindBy(xpath = "//p[@class=\"MuiTypography-root MuiTypography-body2 deactiveText css-6plnes\"]")
	@CacheLookup
	WebElement btnAddressHome;
	
	// ACTION METHODS
	
	public void clickOnbtnSystemManager() 
	{
		btnSystemManager.click();
		logger.info("Clicked on system manager button");
	}
	
	public void clickOntabOrganizations() 
	{
		tabOrganizations.click();
		logger.info("Clicked on tabOrganizations button");
	}
	
	public void clickOntabLeave() 
	{
		tabLeave.click();
		logger.info("Clicked on tabLeave button");
	}
	
	public void clickOntabClients() 
	{
		tabClients.click();
		logger.info("Clicked on tabClients button");
	}
	
	public void clickOntabUsers() 
	{
		tabUsers.click();
		logger.info("Clicked on tabUsers button");
	}
	
	public void clickOntabProjects() 
	{
		tabProjects.click();
		logger.info("Clicked on tabProjects button");
	}
	
	public void clickOntabDailyUpdates() 
	{
		tabDailyUpdates.click();
		logger.info("Clicked on tabDailyUpdates button");
	}
	
	
	public void clickOntabAssets() 
	{
		tabAssets.click();
		logger.info("Clicked on tabAssets button");
	}
	
	public void clickOntabMyCalender() 
	{
		tabMyCalender.click();
		logger.info("Clicked on tabMyCalender button");
	}
	
	public void clickOntabJobTitle()
	{
		tabJobTitle.click();
		logger.info("Clicked on tabMyCalender button");
	}
	
	public void clickOntabManageLeaveTypes() 
	{
		tabManageLeaveTypes.click();
		logger.info("Clicked on tabManageLeaveTypes button");
	}
	
	public void clickOntabLeaveBalances() 
	{
		tabLeaveBalances.click();
		logger.info("Clicked on tabLeaveBalances button");
	}
	
	public void clickOntabMenu() 
	{
		tabMenu.click();
		logger.info("Clicked on tabMenu button");
	}
	
	public void clickOnIconUserLogged()
	{
		iconUserLogged.click();
		logger.info("Clicked on the Icon user logged");
	}
	public void clickOniconHomeImage() 
	{
		iconHomeImage.click();
		logger.info("Clicked on iconHomeImage button");
	}
	
	public void clickOndropdownMyProfile() 
	{
		dropdownMyProfile.click();
		logger.info("Clicked on dropdownMyProfile button");
	}
	
	public void clickOndropdownLogout() 
	{
		dropdownLogout.click();
		logger.info("Clicked on dropdownLogout button");
	}
	
	public void clickOndropdownLogotNoBtn() 
	{
		dropdownLogotNoBtn.click();
		logger.info("Clicked on dropdownLogotNoBtn button");
	}
	
	public void clickOndropdownLogotYesBtn()
	{
		dropdownLogotYesBtn.click();
		logger.info("Clicked on dropdownLogotYesBtn button");
	}
	
	public void clickOnBtnAddressHome()
	{
		btnAddressHome.click();
		logger.info("Clicked on address HOME button");
	}
	
	public PO_LoginPage Logout() throws InterruptedException
	
	{
		btnSystemManager.click();
		Thread.sleep(1000);
		logger.info("Clicked on btnSystemManager button");
		
		dropdownLogout.click();
		Thread.sleep(1000);
		logger.info("Clicked on dropdownLogout button");
		
		dropdownLogotYesBtn.click();
		Thread.sleep(1000);
		logger.info("Clicked on dropdownLogotYesBtn button");
		
		if(driver.getTitle().equals("Login to HRMS")){
			Assert.assertTrue(true);
			logger.info("Logout successful...");
		}else{
			Assert.assertTrue(false);
			logger.info("Logout failed!!!");
		}
		
		return new PO_LoginPage(driver);
	}
	
	public PO_HomePage HomePageTesting() throws InterruptedException
	{
		tabOrganizations.click();
		logger.info("Clicked on tabOrganizations button");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Organization List")){
			Assert.assertTrue(true);
			logger.info("Organization tab working fine");
		}else {
			Assert.assertTrue(false);
			logger.info("Organization not tab working");
		}
		
		
		tabLeave.click();
		logger.info("Clicked on tabLeave button");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Leave Request List")){
			Assert.assertTrue(true);
			logger.info("Leave tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Leave tab not working fine");
		}
		
		
		tabClients.click();
		logger.info("Clicked on tabClients button");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Client List")){
			Assert.assertTrue(true);
			logger.info("Client tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Client tab working not fine");
		}
		
		tabUsers.click();
		logger.info("Clicked on tabUsers button");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("User List")){
			Assert.assertTrue(true);
			logger.info("User tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("User tab not working fine");
		}
		
		tabProjects.click();
		logger.info("Clicked on tabProjects button");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Project List")){
			Assert.assertTrue(true);
			logger.info("Project tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Project tab not working fine");
		}
		
		tabDailyUpdates.click();
		logger.info("Clicked on tabDailyUpdates button");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Start Time")){
			Assert.assertTrue(true);
			logger.info("tabDailyUpdates working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("tabDailyUpdates not working fine");
		}
		
		tabAssets.click();
		logger.info("Clicked on tabAssets button");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Asset List")){
			Assert.assertTrue(true);
			logger.info("Asset tab not working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Asset tab not working fine");
		}
		
		tabMyCalender.click();
		logger.info("Clicked on tabMyCalender button");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Month")){
			Assert.assertTrue(true);
			logger.info("Calendar tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Calendar tab not working fine");
		}
		
		tabJobTitle.click();
		logger.info("Clicked on tabMyCalender button");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Job Title List")){
			Assert.assertTrue(true);
			logger.info("Job Title tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Job Title tab not working fine");
		}
		
		tabManageLeaveTypes.click();
		logger.info("Clicked on tabManageLeaveTypes button");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Leave Type List")){
			Assert.assertTrue(true);
			logger.info("Leave Type tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Leave Type tab not working fine");
		}
		
		tabLeaveBalances.click();
		logger.info("Clicked on tabLeaveBalances button");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Leave Balance List")){
			Assert.assertTrue(true);
			logger.info("Leave Balance tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Leave Balance tab not working fine");
		}
		
		tabMenu.click();
		logger.info("Clicked on tabMenu button");
		Thread.sleep(2000);
		
		btnAddressHome.click();
		logger.info("Clicked on address HOME button");
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Organization List")){
			Assert.assertTrue(true);
			logger.info("Home address tab working fine");
		}else {	
			Assert.assertTrue(false);
			logger.info("Home address not working fine");
		}
		
//		Thread.sleep(2000);
//		tabMenu.click();
//		logger.info("Clicked on tabMenu button");
//		Thread.sleep(2000);

		iconUserLogged.click();
		logger.info("Clicked on the Icon user logged");
		Thread.sleep(4000);
		
		return new PO_HomePage(driver);
	}
}
