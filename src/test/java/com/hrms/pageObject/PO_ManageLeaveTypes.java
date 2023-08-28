package com.hrms.pageObject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hrms.Actions.Action_Activate;
import com.hrms.Actions.Action_Deactivate;
import com.hrms.Actions.Action_Delete;
import com.hrms.Actions.Action_Created;
import com.hrms.Actions.Action_Updated;
import com.hrms.ReUseAble.PageObject.ReUseAbleElement;



public class PO_ManageLeaveTypes extends ReUseAbleElement{

	public Logger logger = LogManager.getLogger(getClass());
	public static WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public Actions action;
	
	public Action_Activate actionActivate = new Action_Activate();
	public Action_Deactivate actionDeactivate = new Action_Deactivate();
	public Action_Delete actionDelete = new Action_Delete();
	public Action_Created confirmationCreated = new Action_Created();
	public Action_Updated confirmationUpdated = new Action_Updated();
	
	 public PO_ManageLeaveTypes(WebDriver driver) {
	        super(driver);
	        this.driver = driver; // Set the driver for the current class
	        jsExecutor = (JavascriptExecutor) driver;
	        ruae = new ReUseAbleElement(driver); // Pass the driver instance to ReUseAbleElement
	        wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	        action = new Actions(driver);
	 }
	
  	//ALERT MANAGE LEAVE TYPES MESSAGES
  	public String alertActivated_lt = "Leave Type Activated Successfully.";
  	public String alertDeactivated_lt = "Leave Deactivated Successfully.";
  	public String alertCreated_lt = "Leave Type Created Successfully.";
  	public String alertUpdated_lt = "Leave Type Updated Successfully.";
  	public String alertAleradyExist_lt = "Leave Type already exists.";
  	public String alertDeleted_lt = "Leave Type Deleted Successfully.";
  	
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
	
	//TO CLICK ON CREATE LEAVE TYPE BUTTON
	public void clickOnBtnCreateLeaveTypes() throws InterruptedException{
		btnCreateLeaveType.click();
		Thread.sleep(1000);
		logger.info("Click on Create leave type button");
	}
	
	//TO SET THE LEAVE TYPE NAME
	public void setLeaveTypeName(String leaveType) throws InterruptedException {
		textEnterLeaveTypeName.sendKeys(Keys.CONTROL,"a");
		textEnterLeaveTypeName.sendKeys(Keys.DELETE);
		textEnterLeaveTypeName.sendKeys(leaveType);
		Thread.sleep(1000);
		logger.info("Entered leave type");
	}
	
	//TO SET THE LEAVE TYPE DESCRIPTION
	public void setLeaveTypeDescription(String leaveDescription) throws InterruptedException {
		textEnterLeaveTypeDescription.sendKeys(Keys.CONTROL,"a");
		textEnterLeaveTypeDescription.sendKeys(Keys.DELETE);
		textEnterLeaveTypeDescription.sendKeys(leaveDescription);
		Thread.sleep(1000);
		logger.info("Enterd leave types description");
	}

	//TO CREATE LEAVE TYPES
	public PO_HomePage createLeaveType(String leaveType, String leaveDescription) throws InterruptedException
	{
		logger.info("Entered create leave types Methods");
		Thread.sleep(1000);
		clickOnBtnCreateLeaveTypes();
		setLeaveTypeName(leaveType);
		setLeaveTypeDescription(leaveDescription);
		ruae.clickOnCreateButton_RU();
		confirmationCreated.created(driver, alertCreated_lt,alertAleradyExist_lt);
		logger.info("Create leave types methods call done");
		return new PO_HomePage(driver);
	}
	
	//TO ACTIVATE LEAVE TYPES
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage activateLeaveTypes(String leaveType) throws InterruptedException	{
		logger.info("Activate leave types methods called");
		//METHODS TO ACTIVATE THE LEAVE TYPES
    	actionActivate.activate(leaveType, driver, alertActivated_lt);
    	logger.info("Activate leave types methods call done");
    	return new PO_HomePage(driver);
	}
	
	//TO DEACTIVATE LEAVE TYPES
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage deactivateLeaveTypes(String leaveType) throws InterruptedException {
		logger.info("De-Activate leave types methods called");
    	//METHODS TO DEACTIVATE THE LEAVE TYPES
		actionDeactivate.deactivate(leaveType, driver, alertDeactivated_lt);
    	logger.info("Deactivate Leave Types methods call done");
    	return new PO_HomePage(driver);
	}
	
	//TO EDIT LEAVE TYPES
	//USE TO EDIT THE LEAVE TYPES
	public PO_HomePage editLeaveType(String leaveTypeSearchKey, String leaveDescription, String LeaveTypes) throws InterruptedException
	{
		logger.info("Entered edit leave types Methods");
		Thread.sleep(1000);
		searchBox_RU(leaveTypeSearchKey);
		if(!ruae.isSearchKeysNotFound_RU()) {
			ruae.clickOnActionButton_RU();
			ruae.clickOnEditAction_RU();
			//TO CLEAR THE ALREADY WRITTEN TEXT
			textEnterLeaveTypeName.sendKeys(Keys.CONTROL,"a");
			textEnterLeaveTypeName.sendKeys(Keys.CONTROL,"DELETE");
			setLeaveTypeName(LeaveTypes);
			textEnterLeaveTypeDescription.sendKeys(Keys.CONTROL,"a");
			textEnterLeaveTypeDescription.sendKeys(Keys.CONTROL,"DELETE");
			setLeaveTypeDescription(leaveDescription);
			clickOnBtnSaveChanges_RU();
		}
		confirmationUpdated.updated(driver, alertUpdated_lt,alertAleradyExist_lt);
		logger.info("Edit leave types method call done");
		return new PO_HomePage(driver);
	}
	
	//TO DELETE THE LEAVE TYPES
	public PO_HomePage deleteLeaveTypes(String leaveTypeName) throws InterruptedException {
		logger.info("Entered delete leave types Methods");
		//METHODS TO DELETE THE LEAVE TYPES
		actionDelete.delete(leaveTypeName,driver, alertDeleted_lt);
		logger.info("Delete leave types method call done");
		return new PO_HomePage(driver);
	}
	
}
