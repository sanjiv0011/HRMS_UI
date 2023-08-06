package com.hrms.pageObject;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import my_support.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_OragnizationPage {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	
	public PO_OragnizationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	//=====START====Organization page and Create organization page object============//
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-ulqyyo']")
	@CacheLookup
	WebElement btnCreateOrganization;

	@FindBy(xpath = "//input[@id=':r7:']")
	@CacheLookup
	WebElement textEnterName;

	@FindBy(xpath = "//input[@id=':r8:']")
	@CacheLookup
	WebElement textEnterCode;

	@FindBy(xpath = "//input[@id=':r9:']")
	@CacheLookup
	WebElement textEnterEmail;

	@FindBy(xpath = "//input[@id=':ra:']")
	@CacheLookup
	WebElement textEnterPhoneNumber;
	
	@FindBy(xpath = "//input[@id=':rb:']")
	@CacheLookup
	WebElement textEnterAddress;
	
	@FindBy(xpath = "//input[@id=':rc:']")
	@CacheLookup
	WebElement textEnterArea;

	@FindBy(xpath = "//input[@id=':rd:']")
	@CacheLookup
	WebElement textEnterCity;

	@FindBy(xpath = "//input[@id=':re:']")
	@CacheLookup
	WebElement textEnterState;

	@FindBy(xpath = "//input[@id=':rf:']")
	@CacheLookup
	WebElement textEnterPostalCode;

	@FindBy(xpath = "//input[@id=':rg:']")
	@CacheLookup
	WebElement textEnterCountry;
	
	@FindBy(xpath = "//input[@id='timeZone']")
	@CacheLookup
	List <WebElement> dropdownTimeZone;
	
	@FindBy(xpath = "//p[normalize-space()='Create']")
	@CacheLookup
	WebElement btnCreate;
	
	@FindBy(xpath = "//p[normalize-space()='Cancel']")
	@CacheLookup
	WebElement btnCancel;
	//=====END====Organization page and Create organization page object============//
	
	public void clickOnBtnCreateOrganization()
	{
		btnCreateOrganization.click();
		logger.info("Click on Create organization button");
	}
	
	public void setOrgName(String orgName)
	{
		textEnterName.sendKeys(orgName);
		logger.info("Enterd org name");
	}
	
	public void setOrgCode(String orgCode)
	{
		textEnterCode.sendKeys(orgCode);
		logger.info("Enterd org code");
	}
	
	public void setOrgEmail(String orgEmail)
	{
		textEnterEmail.sendKeys(orgEmail);
		logger.info("Enterd org email");
	}
	
	public void setOrgPhoneNumber(String orgPhoneNumber)
	{
		textEnterPhoneNumber.sendKeys(orgPhoneNumber);
		logger.info("Enterd org phone number");
	}
	
	public void setOrgAddress(String orgAddress)
	{
		textEnterAddress.sendKeys(orgAddress);
		logger.info("Enterd org address");
	}
	
	public void setOrgArea(String orgArea)
	{
		textEnterArea.sendKeys(orgArea);
		logger.info("Enterd org area");
	}
	
	public void setOrgCity(String orgCity)
	{
		textEnterCity.sendKeys(orgCity);
		logger.info("Enterd org city");
	}
	
	public void setOrgState(String orgState)
	{
		textEnterState.sendKeys(orgState);
		logger.info("Enterd org  state");
	}
	
	public void setOrgPostalCode(String orgPostalCode)
	{
		textEnterPostalCode.sendKeys(orgPostalCode);
		logger.info("Enterd org postal code");
	}
	
	public void setOrgCountry(String orgCountry)
	{
		textEnterCountry.sendKeys(orgCountry);
		logger.info("Enterd org  country");
	}
	
	public void selectOrgTimeZone(String orgTimeZone)//"(UTC +05:30) Asia/Kolkata"
	{
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(dropdownTimeZone,orgTimeZone );
		logger.info("Enterd org  time zone");
	}
	
	public void clickBtnCreate()
	{
		btnCreate.click();
		logger.info("clicked on Create button");
	}
	
	public void clickBtnCancel()
	{
		btnCancel.click();
		logger.info("Clicked on Cancel button");
	}
	
	public PO_HomePage createOragnization(String orgName, String orgCode, String orgEmail, String orgPhoneNumber, String orgAddress, String orgArea, String orgCity, String orgState, String orgPostalCode,String orgCountry, String orgTimeZone ) throws InterruptedException
	{
		
		btnCreateOrganization.click();
		logger.info("Click on Create organization button");
		Thread.sleep(2000);
		
		textEnterName.sendKeys(orgName);
		logger.info("Enterd org name");
		Thread.sleep(1000);
		
		textEnterCode.sendKeys(orgCode);
		logger.info("Enterd org code");
		Thread.sleep(1000);
		
		textEnterEmail.sendKeys(orgEmail);
		logger.info("Enterd org email");
		Thread.sleep(1000);
		
		textEnterPhoneNumber.sendKeys(orgPhoneNumber);
		logger.info("Enterd org phone number");
		Thread.sleep(1000);
		
		textEnterAddress.sendKeys(orgAddress);
		logger.info("Enterd org address");
		Thread.sleep(1000);
		
		textEnterArea.sendKeys(orgArea);
		logger.info("Enterd org area");
		Thread.sleep(1000);
		
		textEnterCity.sendKeys(orgCity);
		logger.info("Enterd org city");
		Thread.sleep(1000);
		
		textEnterState.sendKeys(orgState);
		logger.info("Enterd org  state");
		Thread.sleep(1000);
		
		textEnterPostalCode.sendKeys(orgPostalCode);
		logger.info("Enterd org postal code");
		Thread.sleep(1000);
		
		textEnterCountry.sendKeys(orgCountry);
		logger.info("Enterd org  country");
		Thread.sleep(1000);
		
		System.out.println(dropdownTimeZone);
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(dropdownTimeZone,orgTimeZone );
		logger.info("Enterd org  time zone");
		Thread.sleep(5000);
		
		btnCreate.click();
		logger.info("clicked on Create button");
		Thread.sleep(5000);
		
		return new PO_HomePage(driver);
		
		
	}
	
	
}
