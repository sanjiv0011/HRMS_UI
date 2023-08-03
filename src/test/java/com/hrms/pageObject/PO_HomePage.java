package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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
	
	@FindBy(xpath = "//a[@href='/organization']")
	@CacheLookup
	WebElement tabOrganizations;
	
	@FindBy(xpath = "//span[normalize-space()='Leave']")
	@CacheLookup
	WebElement tabLeave;
	
	@FindBy(xpath = "//span[normalize-space()='Clients']")
	@CacheLookup
	WebElement tabClients;
	
	@FindBy(xpath = "//span[normalize-space()='Users']")
	@CacheLookup
	WebElement tabUsers;
	
	@FindBy(xpath = "//span[normalize-space()='Projects']")
	@CacheLookup
	WebElement tabProjects;
	
	@FindBy(xpath = "//span[normalize-space()='Daily Updates']")
	@CacheLookup
	WebElement tabDailyUpdates;
	
	@FindBy(xpath = "//span[normalize-space()='Assets']")
	@CacheLookup
	WebElement tabAssets;
	
	@FindBy(xpath = "//span[normalize-space()='My Calender']")
	@CacheLookup
	WebElement tabMyCalender;
	
	@FindBy(xpath = "//span[normalize-space()='Manage Leave Types']")
	@CacheLookup
	WebElement tabManageLeaveTypes;
	
	
	@FindBy(xpath = "//li//div[contains(.,'Leave Balances')]")
	@CacheLookup
	WebElement tabLeaveBalances;
	
	@FindBy(xpath = "//button[@aria-label='open drawer']//*[name()='svg']")
	@CacheLookup
	WebElement tabMenu;
	
	@FindBy(xpath = "//img[@alt='Image']")
	@CacheLookup
	WebElement iconHomeImage;
	
	@FindBy(xpath = "//li[normalize-space()='My Profile']")
	@CacheLookup
	WebElement dropdownMyProfile;
	
	@FindBy(xpath = "//li[normalize-space()='Logout']")
	@CacheLookup
	WebElement dropdownLogout;
	
	@FindBy(xpath = "//p[normalize-space()='No']")
	@CacheLookup
	WebElement dropdownLogotNoBtn;
	
	@FindBy(xpath = "//p[normalize-space()=\"Yes\"]")
	@CacheLookup
	WebElement dropdownLogotYesBtn;
	
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body2 deactiveText css-6plnes']")
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
		
		return new PO_LoginPage(driver);
	}
	
	
	

}
