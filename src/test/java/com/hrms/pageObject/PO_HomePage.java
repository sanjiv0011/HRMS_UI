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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;
import com.hrms.utilities.ExtentReport;


public class PO_HomePage extends ReUseAbleElement{
	
	 // Constructor to initialize the page and its elements
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	
	public PO_HomePage(WebDriver driver)
	{	
		super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));

	}
	
	//Page objects
//	@FindBy(xpath = "//div[@class='MuiBox-root css-12an206']")
//	@CacheLookup
//	public WebElement btnSystemManager;
	
	@FindBy(xpath = "//a[@href=\"/organization\"]")
	@CacheLookup
	public WebElement tabOrganizations;
	
	@FindBy(xpath = "//span[normalize-space()=\"Leave\"]")
	@CacheLookup
	public WebElement tabLeave;
	
	@FindBy(xpath = "//span[normalize-space()=\"Clients\"]")
	@CacheLookup
	public WebElement tabClients;
	
	@FindBy(xpath = "//span[normalize-space()=\"Users\"]")
	@CacheLookup
	public WebElement tabUsers;
	
	@FindBy(xpath = "//a[@href=\"/project\"]")
	@CacheLookup
	public WebElement tabProjects;
	
	@FindBy(xpath = "//span[normalize-space()=\"Daily Updates\"]")
	@CacheLookup
	public WebElement tabDailyUpdates;
	
	@FindBy(xpath = "//span[normalize-space()=\"Assets\"]")
	@CacheLookup
	public WebElement tabAssets;
	
//	@FindBy(xpath = "//span[normalize-space()='My Calendar']")
//	@CacheLookup
	public String tabMyCalender = "//span[normalize-space()='My Calendar']";
	
	@FindBy(xpath = "//a[@href=\"/job-title\"]")
	@CacheLookup
	public WebElement tabJobTitle;
	
	@FindBy(xpath = "//span[normalize-space()=\"Manage Leave Types\"]")
	@CacheLookup
	public WebElement tabManageLeaveTypes;
	
	
	@FindBy(xpath = "//span[normalize-space()=\"Leave Balances\"]")
	@CacheLookup
	public WebElement tabLeaveBalances;
	
	@FindBy(xpath = "//button[@aria-label=\"open drawer\"]//*[name()=\"svg\"]")
	@CacheLookup
	public WebElement tabMenu;
	
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M3 18h18v-')]")
	@CacheLookup
	public WebElement iconUserLogged;
	
	@FindBy(xpath = "//li[normalize-space()='My Profile']")
	@CacheLookup
	public WebElement dropdownMyProfile;
	
	@FindBy(xpath = "//li[normalize-space()=\"Logout\"]")
	@CacheLookup
	public WebElement dropdownLogout;
	
	@FindBy(xpath = "//p[normalize-space()='No']")
	@CacheLookup
	public WebElement dropdownLogotNoBtn;
	
	@FindBy(xpath = "//button[.='Yes']")
	@CacheLookup
	public WebElement dropdownLogotYesBtn;
	
	@FindBy(xpath = "//p[@class=\"MuiTypography-root MuiTypography-body2 deactiveText css-6plnes\"]")
	@CacheLookup
	public WebElement btnAddressHome;
	
	// ACTION METHODS
	
	public void clickOnbtnSystemManager() throws InterruptedException 
	{
		clickOnDropdownIconLoggedUser_RU();
		logger.info("Clicked on system manager button");
	}
	
	public void clickOntabOrganizations() throws InterruptedException {
		tabOrganizations.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabOrganizations button");
	}
	
	public void clickOntabLeave() throws InterruptedException {
		tabLeave.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabLeave button");
	}
	
	public void clickOntabClients() throws InterruptedException {
		tabClients.click();
		Thread.sleep(500);
		logger.info("Clicked on tabClients button");
	}
	
	public void clickOntabUsers() throws InterruptedException {
		tabUsers.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabUsers button");
	}
	
	public void clickOntabProjects() throws InterruptedException {
		tabProjects.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabProjects button");
	}
	
	public void clickOntabDailyUpdates() throws InterruptedException {
		tabDailyUpdates.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabDailyUpdates button");
	}
	
	
	public void clickOntabAssets() throws InterruptedException {
		tabAssets.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabAssets button");
	}
	
	public void clickOntabMyCalendar() throws InterruptedException {
		driver.findElement(By.xpath(tabMyCalender)).click();
		Thread.sleep(2000);
		logger.info("Clicked on tabMyCalender button");
	}
	
	public void clickOntabJobTitle() throws InterruptedException {
		tabJobTitle.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabJobTitle button");
	}
	
	public void clickOntabManageLeaveTypes() throws InterruptedException 
	{
		tabManageLeaveTypes.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabManageLeaveTypes button");
	}
	
	public void clickOntabLeaveBalances() throws InterruptedException {
		tabLeaveBalances.click();
		Thread.sleep(2000);
		logger.info("Clicked on tabLeaveBalances button");
	}
	
	public void clickOntabMenu() throws InterruptedException {
		tabMenu.click();
		Thread.sleep(1000);
		logger.info("Clicked on tabMenu button");
	}
	
	public void clickOnIconUserLogged() throws InterruptedException{
		iconUserLogged.click();
		Thread.sleep(1000);
		logger.info("Clicked on the Icon user logged");
	}
	
	public PO_UserProfilePage clickOndropdownMyProfile() throws InterruptedException {
		dropdownMyProfile.click();
		Thread.sleep(1000);
		logger.info("Clicked on dropdownMyProfile button");
		//TO PASS THE DRIVER FROM THE HOME PAGE TO USER PROFILE PAGE
		return new PO_UserProfilePage(driver);
	}
	
	public void clickOndropdownLogout() throws InterruptedException {
		dropdownLogout.click();
		Thread.sleep(1000);
		logger.info("Clicked on dropdownLogout button");
	}
	
	public void clickOnBtnAddressHome() throws InterruptedException {
		btnAddressHome.click();
		Thread.sleep(500);
		logger.info("Clicked on address HOME button");
	}
	
	
	//TO CLICK ON HOME LOGO 
	public String iconHomeImage_RU = "//img[@alt='Image']";
	public void clickOniconHomeImage() throws InterruptedException {
		WebElement iconHomeLogo = driver.findElement(By.xpath(iconHomeImage_RU));
		wait.until(ExpectedConditions.elementToBeClickable(iconHomeLogo));
		iconHomeLogo.click();
		logger.info("Clicked on iconHomeImage button");
	}
		
		
		
	// TO LOGOUT
	public PO_LoginPage Logout() throws InterruptedException
	{	
		clickOniconHomeImage();
		clickOnbtnSystemManager();
		clickOndropdownLogout();
		clickOnYesButton_RU();
		
		if(driver.getTitle().equals("Login to HRMS")){
			Assert.assertTrue(true);
			logger.info("Logout successful...");
		}else{
			Assert.assertTrue(false);
			logger.info("Logout failed!!!");
		}
		
		return new PO_LoginPage(driver);
	}
	
	// TEST HOME PAGE FUNCTIONALITY
	public PO_HomePage HomePageTesting() throws InterruptedException
	{
		clickOntabOrganizations();
		if(driver.getPageSource().contains("Organization List")){
			Assert.assertTrue(true);
			logger.info("Organization tab working fine");
		}else {
			Assert.assertTrue(false);
			logger.info("Organization not tab working");
		}
		
		clickOntabLeave();
		if(driver.getPageSource().contains("Leave Request List")){
			Assert.assertTrue(true);
			logger.info("Leave tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Leave tab not working fine");
		}
		
		
		clickOntabClients();
		if(driver.getPageSource().contains("Client List")){
			Assert.assertTrue(true);
			logger.info("Client tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Client tab working not fine");
		}
		
		clickOntabUsers();
		if(driver.getPageSource().contains("User List")){
			Assert.assertTrue(true);
			logger.info("User tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("User tab not working fine");
		}
		
		clickOntabProjects();
		if(driver.getPageSource().contains("Project List")){
			Assert.assertTrue(true);
			logger.info("Project tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Project tab not working fine");
		}
		
		clickOntabDailyUpdates();
		if(driver.getPageSource().contains("Start Time")){
			Assert.assertTrue(true);
			logger.info("tabDailyUpdates working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("tabDailyUpdates not working fine");
		}
		
		 clickOntabAssets();
		if(driver.getPageSource().contains("Asset List")){
			Assert.assertTrue(true);
			logger.info("Asset tab not working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Asset tab not working fine");
		}
		
		clickOntabMyCalendar();
		if(driver.getPageSource().contains("Month")){
			Assert.assertTrue(true);
			logger.info("Calendar tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Calendar tab not working fine");
		}
		
		clickOntabJobTitle();
		if(driver.getPageSource().contains("Job Title List")){
			Assert.assertTrue(true);
			logger.info("Job Title tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Job Title tab not working fine");
		}
		
		clickOntabManageLeaveTypes();
		if(driver.getPageSource().contains("Leave Type List")){
			Assert.assertTrue(true);
			logger.info("Leave Type tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Leave Type tab not working fine");
		}
		
		clickOntabLeaveBalances();
		if(driver.getPageSource().contains("Leave Balance List")){
			Assert.assertTrue(true);
			logger.info("Leave Balance tab working fine");
		}else {
			
			Assert.assertTrue(false);
			logger.info("Leave Balance tab not working fine");
		}
		
		clickOntabMenu();
		clickOntabMenu();
		return new PO_HomePage(driver);
	}
}
