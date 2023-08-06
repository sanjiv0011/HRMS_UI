package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_LeaveBalance {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	
	public PO_LeaveBalance(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	//=====START====Organization page and Create organization page object============//
	@FindBy(xpath = "//p[.='Create Leave Balance']")
	@CacheLookup
	WebElement btnCreateLeaveBalance;

	@FindBy(xpath = "(//input[@id=\":r1k:\"]")
	@CacheLookup
	WebElement dateStart;

	@FindBy(xpath = "//input[@id=\":r1m:\"]")
	@CacheLookup
	WebElement dateEnd;
	
	@FindBy(xpath = "//input[@id=\"leaveType\"]")
	@CacheLookup
	WebElement textEnterLeaveType;

	@FindBy(xpath = "//input[@id=\"balance\"]")
	@CacheLookup
	WebElement textEnterLeaveBalance;
	
	@FindBy(xpath = "//p[normalize-space()=\"Create\"]")
	@CacheLookup
	WebElement btnCreate;
	
	@FindBy(xpath = "//p[normalize-space()=\"Cancel\"]")
	@CacheLookup
	WebElement btnCancel;
	
	
	
	public void clickOnBtnCreateLeaveBalance()
	{
		btnCreateLeaveBalance.click();
		logger.info("Click on Create leave type button");
	}
	
	public void setLeaveBalanceStartDate(String startDate)
	{
		dateStart.sendKeys(startDate);
		logger.info("Entered leave startDate");
	}
	
	public void setLeaveBalanceEndDate(String endDate)
	{
		dateEnd.sendKeys(endDate);
		logger.info("Enterd leave endDate");
	}
	
	public void setLeaveName(String leaveName)
	{
		textEnterLeaveType.sendKeys(leaveName);
		logger.info("Entered leave leaveName");
	}
	
	public void setLeaveBalance(String leaveBalance)
	{
		textEnterLeaveBalance.sendKeys(leaveBalance);
		logger.info("Enterd leave leaveBalance");
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
	
	public PO_HomePage createLeaveBalance(String startDate, String endDate, String leaveName, String leaveBalance) throws InterruptedException
	{
		logger.info("Entered create leave types Methods");
		
		btnCreateLeaveBalance.click();
		logger.info("Click on Create leave balance button");
		Thread.sleep(2000);
		
		dateStart.sendKeys(startDate);
		logger.info("Entered leave startDate");
		Thread.sleep(1000);
		
		dateEnd.sendKeys(endDate);
		logger.info("Enterd leave endDate");
		Thread.sleep(1000);
		
		textEnterLeaveType.sendKeys(leaveName);
		logger.info("Entered leave leaveName");
		
		textEnterLeaveBalance.sendKeys(leaveBalance);
		logger.info("Enterd leave leaveBalance");
		
		btnCreate.click();
		logger.info("clicked on Create button");
		Thread.sleep(2000);
		
		return new PO_HomePage(driver);
		
		
	}
		
	
}
