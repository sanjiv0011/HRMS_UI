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

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

import projectUtility.Action_Activate;
import projectUtility.Action_DeActivate;
import projectUtility.Action_Delete;


public class PO_ManageLeaveTypes extends ReUseAbleElement{

	public Logger logger = LogManager.getLogger(getClass());
	public static WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement rual;
	public WebDriverWait wait;
	public Actions action;
	
	 public PO_ManageLeaveTypes(WebDriver driver) {
	        super(driver);
	        this.driver = driver; // Set the driver for the current class
	        jsExecutor = (JavascriptExecutor) driver;
	        rual = new ReUseAbleElement(driver); // Pass the driver instance to ReUseAbleElement
	        wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	        action = new Actions(driver);
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
	
	public void clickOnBtnCreateLeaveTypes() throws InterruptedException{
		btnCreateLeaveType.click();
		Thread.sleep(1000);
		logger.info("Click on Create leave type button");
	}
	
	public void setLeaveTypeName(String leaveType) throws InterruptedException{
		textEnterLeaveTypeName.sendKeys(leaveType);
		Thread.sleep(1000);
		logger.info("Entered leave type");
	}
	
	public void setLeaveTypeDescription(String leaveDescription) throws InterruptedException{
		textEnterLeaveTypeDescription.sendKeys(leaveDescription);
		Thread.sleep(1000);
		logger.info("Enterd leave types description");
	}

	// TO CREATE LEAVE TYPES
	public PO_HomePage createLeaveType(String leaveType, String leaveDescription) throws InterruptedException
	{
		logger.info("Entered create leave types Methods");
		clickOnBtnCreateLeaveTypes();
		setLeaveTypeName(leaveType);
		setLeaveTypeDescription(leaveDescription);
		rual.clickOnCreateButton_RU();
		return new PO_HomePage(driver);
	}
	
	//TO ACTIVATE LEAVE TYPES
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage activateLeaveTypes(String leaveType) throws InterruptedException
	{
		logger.info("Activate leave types methods called");
    	
    	//METHODS TO ACTIVATE THE LEAVE TYPES
		Action_Activate.activate(leaveType, searchBox_RU, inactiveLabel, btnAction_RU, actionActivate, btnYes, "cofirmMessage");
    	logger.info("Return back inside activateLeaveTypes method");
    	return new PO_HomePage(driver);
	}
	
	
	//TO DEACTIVATE LEAVE TYPES
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage deactivateLeaveTypes(String leaveType) throws InterruptedException
	{
		logger.info("De-Activate leave types methods called");
    	
    	//METHODS TO DEACTIVATE THE LEAVE TYPES
		Action_DeActivate.deactivate(leaveType, searchBox_RU, activeLabel, btnAction_RU, actionDeactivate, btnYes, "cofirmMessage");
    	logger.info("Return back inside deactivateLeaveTypes method");
    	return new PO_HomePage(driver);
	}
	
	//TO EDIT LEAVE TYPES
	//USE TO EDIT THE LEAVE TYPES
	public PO_HomePage editLeaveType(String leaveTypeSearchKey, String leaveDescription, String LeaveTypes) throws InterruptedException
	{
		logger.info("Entered edit leave types Methods");
		Thread.sleep(2000);
		searchBox_RU(leaveTypeSearchKey);
//		searchBox_RU.sendKeys(leaveTypeSearchKey,Keys.ENTER);
//		logger.info("Searched searchKeys");
		
		wait.until(ExpectedConditions.elementToBeClickable(btnAction_RU));
		rual.clickOnActionButton_RU();
		
		clickOnEditAction_RU();
		
		//TO CLEAR THE ALREADY WRITTEN TEXT
		textEnterLeaveTypeName.sendKeys(Keys.CONTROL,"a");
		textEnterLeaveTypeName.sendKeys(Keys.CONTROL,"DELETE");;
		textEnterLeaveTypeDescription.sendKeys(Keys.CONTROL,"a");
		textEnterLeaveTypeDescription.sendKeys(Keys.CONTROL,"DELETE");;
		
		setLeaveTypeName(LeaveTypes);
		setLeaveTypeDescription(leaveDescription);
		clickOnBtnSaveChanges_RU();
		return new PO_HomePage(driver);
	}
	
	//TO DELETE THE LEAVE TYPES
	public PO_HomePage deleteLeaveTypes(String leaveTypeName) throws InterruptedException
	{
		logger.info("Entered delete leave types Methods");
		Thread.sleep(2000);
		
		Action_Delete.delete(leaveTypeName, searchBox_RU, btnAction_RU, btnDelete, btnYes, "cofirmMessage");
		logger.info("Return back delete leave types method");
		return new PO_HomePage(driver);
		
	}
	
}
