package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_ManageLeaveTypes {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	
	public PO_ManageLeaveTypes(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	//=====START====Organization page and Create organization page object============//
	@FindBy(xpath = "//p[.='Create Leave Type']")
	@CacheLookup
	WebElement btnCreateLeaveType;

	@FindBy(xpath = "//input[@placeholder=\"Enter Leave Type\"]")
	@CacheLookup
	WebElement textEnterLeaveTypeName;

	@FindBy(xpath = "//textarea[@placeholder=\"Enter Description\"]")
	@CacheLookup
	WebElement textEnterLeaveTypeDescription;
	
	@FindBy(xpath = "//p[normalize-space()=\"Create\"]")
	@CacheLookup
	WebElement btnCreate;
	
	@FindBy(xpath = "//p[normalize-space()=\"Cancel\"]")
	@CacheLookup
	WebElement btnCancel;
	
	
	
	public void clickOnBtnCreateLeaveTypes()
	{
		btnCreateLeaveType.click();
		logger.info("Click on Create leave type button");
	}
	
	public void setLeaveTypeName(String leaveType)
	{
		textEnterLeaveTypeName.sendKeys(leaveType);
		logger.info("Entered leave type");
	}
	
	public void setLeaveTypeDescription(String leaveDescription)
	{
		textEnterLeaveTypeDescription.sendKeys(leaveDescription);
		logger.info("Enterd leave types description");
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
	
	public PO_HomePage createLeaveType(String leaveType, String leaveDescription) throws InterruptedException
	{
		logger.info("Entered create leave types Methods");
		
		btnCreateLeaveType.click();
		logger.info("Click on Create leave type button");
		Thread.sleep(2000);
		
		textEnterLeaveTypeName.sendKeys(leaveType);
		logger.info("Entered leave type");
		Thread.sleep(1000);
		
		textEnterLeaveTypeDescription.sendKeys(leaveDescription);
		logger.info("Enterd leave types description");
		Thread.sleep(1000);
		
		btnCreate.click();
		logger.info("clicked on Create button");
		Thread.sleep(2000);
		
		return new PO_HomePage(driver);
		
		
	}
		
	
}
