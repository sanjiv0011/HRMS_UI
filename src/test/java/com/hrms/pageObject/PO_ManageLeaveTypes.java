package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

import my_support.Action_Activate;
import my_support.Action_DeActivate;
import my_support.Action_Delete;


public class PO_ManageLeaveTypes extends ReUseAbleElement{

	public Logger logger = LogManager.getLogger(getClass());
	public static WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement rual;
	
	 public PO_ManageLeaveTypes(WebDriver driver) {
	        super(driver);
	        this.driver = driver; // Set the driver for the current class
	        jsExecutor = (JavascriptExecutor) driver;
	        rual = new ReUseAbleElement(driver); // Pass the driver instance to ReUseAbleElement
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
	
	
	
	public void clickOnBtnCreateLeaveTypes(){
		btnCreateLeaveType.click();
		logger.info("Click on Create leave type button");
	}
	
	public void setLeaveTypeName(String leaveType){
		textEnterLeaveTypeName.sendKeys(leaveType);
		logger.info("Entered leave type");
	}
	
	public void setLeaveTypeDescription(String leaveDescription){
		textEnterLeaveTypeDescription.sendKeys(leaveDescription);
		logger.info("Enterd leave types description");
	}
	
	public void clickBtnCreate(){
		btnCreate.click();
		logger.info("clicked on Create button");
	}
	
	public void clickBtnCancel(){
		btnCancel.click();
		logger.info("Clicked on Cancel button");
	}
	
	// TO CREATE LEAVE TYPES
	public PO_HomePage createLeaveType(String leaveType, String leaveDescription) throws InterruptedException
	{
		logger.info("Entered create leave types Methods");
		Thread.sleep(2000);
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
		Thread.sleep(100);
		return new PO_HomePage(driver);
	}
	
	//TO ACTIVATE LEAVE TYPES
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage activateLeaveTypes(String leaveType) throws InterruptedException
	{
		logger.info("Activate leave types methods called");
    	
    	//METHODS TO ACTIVATE THE LEAVE TYPES
		Action_Activate.activate(leaveType, searchBox, inactiveLabel, btnAction, actionActivate, btnYes, "cofirmMessage");
    	 logger.info("Return back inside activateLeaveTypes method");
    	 return new PO_HomePage(driver);
	}
	
	
	//TO DEACTIVATE LEAVE TYPES
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage deactivateLeaveTypes(String leaveType) throws InterruptedException
	{
		logger.info("De-Activate leave types methods called");
    	
    	//METHODS TO DEACTIVATE THE LEAVE TYPES
		Action_DeActivate.deactivate(leaveType, searchBox, activeLabel, btnAction, actionDeactivate, btnYes, "cofirmMessage");
    	 logger.info("Return back inside deactivateLeaveTypes method");
    	 return new PO_HomePage(driver);
	}
	
	//TO EDIT LEAVE TYPES
	//USE TO EDIT THE LEAVE TYPES
	public PO_HomePage editLeaveType(String leaveTypeSearchKey, String leaveDescription, String newLeaveTypes) throws InterruptedException
	{
		logger.info("Entered edit leave types Methods");
		Thread.sleep(2000);
		
		searchBox.sendKeys(leaveTypeSearchKey,Keys.ENTER);
		logger.info("Searched searchKeys");
		Thread.sleep(2000);
		
		btnAction.click();
		logger.info("Clicked on  button btnAction");
		Thread.sleep(2000);
		
		actionEdit.click();
		logger.info("Clicked on  button edit");
		Thread.sleep(2000);
		
		//TO CLEAR THE ALREADY WRITTEN TEXT
		jsExecutor.executeScript("arguments[0].value = '';", textEnterLeaveTypeName);
		jsExecutor.executeScript("arguments[0].value = '';", textEnterLeaveTypeDescription);
		
		textEnterLeaveTypeName.sendKeys(newLeaveTypes);
		logger.info("Entered leave type");
		Thread.sleep(1000);
		
		textEnterLeaveTypeDescription.sendKeys(leaveDescription);
		logger.info("Enterd leave types description");
		Thread.sleep(1000);
		
		btnSaveChanges.click();
		logger.info("clicked on Create button");
		Thread.sleep(100);
		
		return new PO_HomePage(driver);
	}
	
	//TO DELETE THE LEAVE TYPES
	public PO_HomePage deleteLeaveTypes(String leaveTypeName) throws InterruptedException
	{
		logger.info("Entered delete leave types Methods");
		Thread.sleep(2000);
		
		Action_Delete.delete(leaveTypeName, searchBox, btnAction, btnDelete, btnYes, "cofirmMessage");
		logger.info("Return back delete leave types method");
		return new PO_HomePage(driver);
		
	}
	
}
