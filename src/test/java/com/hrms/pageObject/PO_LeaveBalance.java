package com.hrms.pageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.Actions.Action_Archive;
import com.hrms.Actions.Action_Created;
import com.hrms.Actions.Action_Restore;
import com.hrms.Actions.Action_Updated;
import com.hrms.ReUseAble.PageObject.ReUseAbleElement;
import com.hrms.projectUtility.DatePicker;
import com.hrms.projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class PO_LeaveBalance extends ReUseAbleElement {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	public WebDriverWait wait;
	public Actions action;
	public Action_Archive actionArchive = new Action_Archive();
	public Action_Restore actionRestore = new Action_Restore();
	public Action_Created confirmationCreated = new Action_Created();
	public Action_Updated confirmationUpdated = new Action_Updated();
	
	public PO_LeaveBalance(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10)); // Set the timeout duration
		action = new Actions(driver);
	}

	//ALERT MESSAGES
	String alertRestored_lb = "Leave Balance Restored Successfully.";
	String alertArchived_lb = "Leave Balance Archived Successfully.";
	String alertCreated_lb = "Leave Balance Created Successfully.";
	String alertUpdated_lb = "Leave Balance Updated Successfully.";
	String alertAleradyExist_lb = "Leave balance already exists.";
	
			
	//=====START====Leave balance page and Create Leave balance page object============//
	// to click on the create leave balance button on the leave balance page
	@FindBy(xpath = "//button//p[.='Create Leave Balance']")
	@CacheLookup
	WebElement btnCreateLeaveBalance;

	@FindBy(xpath = "//ul[@id=\"leaveType-listbox\"]//li")
	@CacheLookup
	List <WebElement> listLeaveTypes;

	@FindBy(xpath = "//input[@name='balance']")
	@CacheLookup
	WebElement textEnterLeaveBalance;

	//TO CLICK ON THE LEAVE BALANCE CREATE BUTTON
	public void clickOnBtnCreateLeaveBalance() throws InterruptedException {
		btnCreateLeaveBalance.click();
		Thread.sleep(1000);
		logger.info("Click on Create leave type button");
	}
	
	//TO SELECT THE LEAVE BALANCE START DATE
	public void selectLeaveBalanceStartDate(String leaveBalanceStartDate, int x) throws InterruptedException {
		DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver, leaveBalanceStartDate, x);
		logger.info("Leave balance end date, month and year entered");
		Thread.sleep(500);}
	
	//TO SELECT THE LEAVE BALANCE END DATE
	public void selectLeaveBalanceEndDate(String leaveBalanceEndDate, int x) throws InterruptedException {
		DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver, leaveBalanceEndDate, x);
		logger.info("Leave balance end date, month and year entered");
		Thread.sleep(500);
	}
	
	//TO SELECT THE LEAVE TYPE NAME
	public void selectLeaveTypesName(String leaveTypeName) throws InterruptedException {
		clickOnDropdown_1_RU();
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listLeaveTypes,leaveTypeName );
	}
	
	public void setLeaveBalance(String leaveBalance) throws InterruptedException {
		textEnterLeaveBalance.sendKeys(Keys.CONTROL,"a");
		textEnterLeaveBalance.sendKeys(Keys.DELETE);
		textEnterLeaveBalance.sendKeys(leaveBalance);
		Thread.sleep(500);
		logger.info("Enterd leave leaveBalance");
	}
	
	//TO CREATE LEAVE BALANCE
	public PO_HomePage createLeaveBalance(String leaveBalanceStartDate, String leaveBalanceEndDate, String leaveTypeName, String leaveBalance) throws InterruptedException
	{
		logger.info("Entered create leave balance Methods");
		clickOnBtnCreateLeaveBalance();
		selectLeaveBalanceStartDate(leaveBalanceStartDate, 1);
		//selectLeaveBalanceEndDate(leaveBalanceEndDate, 2);
		
		setDateWithoutUsingDatePicker_RU(leaveBalanceEndDate,2); //WAY 2
		selectLeaveTypesName(leaveTypeName);
		setLeaveBalance(leaveBalance);
		clickOnCreateButton_RU();
		confirmationCreated.created(driver, alertCreated_lb,alertAleradyExist_lb);
		
		return new PO_HomePage(driver);
	}
	
	//TO ARCHIVE LEAVE BALANCE
    public PO_HomePage archiveLeaveBalance(String leaveBalanceName) throws InterruptedException {	
    	logger.info("Archive leave balance methods called");
    	//METHODS TO ARCHIVE THE LEAVE BALNACE 
    	actionArchive.archive(leaveBalanceName,driver, alertArchived_lb);
    	logger.info("Return to archiveLeaveBalance method");
    	 return new PO_HomePage(driver);
    }
    
    //TO RESTORE LEAVE BALANCE
    public PO_HomePage restoreLeaveBalance(String leaveBalanceName) throws InterruptedException {
    	logger.info("Restore leave balance methods called");
    	//METHODS TO ARCHIVE THE LEAVE BALNACE 
    	actionRestore.restore(leaveBalanceName,driver,alertRestored_lb);
    	 logger.info("Return to restoreLeaveBalance method");
    	 return new PO_HomePage(driver);
    }
    
    //TO EDIT LEAVE BALANCE TYPES
    public PO_HomePage editLeaveBalance(String leaveBalanceStartDate, String leaveBalanceEndDate, String leaveTypeName, String leaveBalance) throws InterruptedException
    {
    	logger.info("Edit leave balance methods called");
    	searchBox_RU(leaveTypeName);
    	clickOnActionButton_RU();
    	clickOnEditAction_RU();
    	//WAY 1
    	//selectLeaveBalanceStartDate(leaveBalanceStartDate, 1);
		//selectLeaveBalanceEndDate(leaveBalanceEndDate, 2);
    	//WAY 2
    	setDateWithoutUsingDatePicker_RU(leaveBalanceStartDate,1);
		setDateWithoutUsingDatePicker_RU(leaveBalanceEndDate,2);
		selectLeaveTypesName(leaveTypeName);
		setLeaveBalance(leaveBalance);
		btnSaveChanges_RU.click();
		confirmationUpdated.updated(driver, alertUpdated_lb, alertAleradyExist_lb);
    	return new PO_HomePage(driver);
    }
	
}
