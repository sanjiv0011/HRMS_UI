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

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;
import com.hrms.projectUtility.Action_Archive;
import com.hrms.projectUtility.Action_Restore;
import com.hrms.projectUtility.DatePicker;
import com.hrms.projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class PO_LeaveBalance extends ReUseAbleElement {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	public WebDriverWait wait;
	public Actions action;
	
	public PO_LeaveBalance(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10)); // Set the timeout duration
		action = new Actions(driver);
	}

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
		setSecondsDateWithoutUsingDatePicker_RU(leaveBalanceEndDate);
		selectLeaveTypesName(leaveTypeName);
		setLeaveBalance(leaveBalance);
		clickOnCreateButton_RU();
		if(isLeaveBalanceCreatedMessageDisplayed()) {
			Assert.assertTrue(true);
		}else if(isLeaveBalanceAlreadyExistMessageDisplayed()){
			logger.info("Already exists");
		}
		return new PO_HomePage(driver);
	}
	
	//TO ARCHIVE LEAVE BALANCE
    public PO_HomePage archiveLeaveBalance(String leaveBalanceName) throws InterruptedException
    {	
    	logger.info("Archive leave balance methods called");
    	
    	//METHODS TO ARCHIVE THE LEAVE BALNACE 
    	Action_Archive.archive(leaveBalanceName, searchBox_RU, archivedLabel, btnAction_RU, actionArchive, btnYes, driver);
    	logger.info("Return to archiveLeaveBalance method");
    	 return new PO_HomePage(driver);
    }
    
    //TO RESTORE LEAVE BALANCE
    public PO_HomePage restoreLeaveBalance(String leaveBalanceName) throws InterruptedException
    {
    	logger.info("Restore leave balance methods called");
    	//METHODS TO ARCHIVE THE LEAVE BALNACE 
    	Action_Restore.restore(leaveBalanceName, searchBox_RU,archivedLabel, btnAction_RU, actionRestore, btnYes, driver);
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
    	selectLeaveBalanceStartDate(leaveBalanceStartDate, 1);
		selectLeaveBalanceEndDate(leaveBalanceEndDate, 2);
		selectLeaveTypesName(leaveTypeName);
		setLeaveBalance(leaveBalance);
		btnSaveChanges_RU.click();
		if(isLeaveBalanceUpdatedMessageDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
    	return new PO_HomePage(driver);
    }
    //==============END=======EDIT LEAVE BALANCE===============//
    
    
		
		//========START======CONFIRMATION MESSAGES VALIDATIONS=========//
	 	//ADDRES MESSAGE ARRCHIVE AND ACTION METHODS
		String msgArchived_Address = "//div[contains(text(),'Leave Balance Archived Successfully.')]";
	    public boolean isArchivedMessageDisplayed() {
	        boolean flag = false;
			try {
				WebElement msgArchived = driver.findElement(By.xpath(msgArchived_Address));
				wait.until(ExpectedConditions.visibilityOf(msgArchived));
		        if(msgArchived.isDisplayed()) {
		        	flag = true;
		        	logger.info("Archived message caught : "+msgArchived.getText());
		        }else {
		        	logger.info("Archived message did not caught");
		        }
			}catch(Exception e){
				logger.info(e);
			}
	        return flag;
	    }
		
	    //ADDRES MESSAGE RESTORED AND ACTION METHODS
 		String msgRestored_address = "//div[contains(text(),'Leave Balance Restored Successfully.')]";
	    public boolean isRestoredMessageDisplayed() {
	    	 boolean flag = false;
				try {
					WebElement msgRestored = driver.findElement(By.xpath(msgRestored_address));
					wait.until(ExpectedConditions.visibilityOf(msgRestored));
			        if(msgRestored.isDisplayed()) {
			        	flag = true;
			        	logger.info("Restored message caught : "+msgRestored.getText());
			        }else {
			        	logger.info("Restored message did not caught");
			        }
				}catch(Exception e){
					logger.info(e);
				}
		        return flag;
	    }
		
	    //TO CHECK ALLREADY ARCHIVED LABEL
	    String archivedLabel_Address = "//span[text()='Archived']";
	    public boolean isAlreadyArchivedLabelPresent() {
	    	 boolean flag = false;
				try {
					WebElement msgAlready_Archived = driver.findElement(By.xpath(archivedLabel_Address));
					wait.until(ExpectedConditions.visibilityOf(msgAlready_Archived));
			        if(msgAlready_Archived.isDisplayed()) {
			        	flag = true;
			        	logger.info("Already arhived message caught : "+msgAlready_Archived.getText());
			        }else {
			        	logger.info("Already arhived did not caught");
			        }
				}catch(Exception e){
					logger.info(e);
				}
		        return flag;
	    }
	    
		
		//MESSAGE LEAVE BALANCE ALREADY EXIST AND ACTION METHODS
		String msgAlreadyExist_Address = "//div[contains(text(),\"Leave balance already exists.\")]";
		public boolean isLeaveBalanceAlreadyExistMessageDisplayed() {
	    	 boolean flag = false;
				try {
					WebElement msgAlreadyLeaveBalanceExist = driver.findElement(By.xpath(msgAlreadyExist_Address));
					wait.until(ExpectedConditions.visibilityOf(msgAlreadyLeaveBalanceExist));
			        if(msgAlreadyLeaveBalanceExist.isDisplayed()) {
			        	flag = true;
			        	logger.info("Leave balance already message caught : "+msgAlreadyLeaveBalanceExist.getText());
			        }else {
			        	logger.info("Leave balance message did not caught");
			        }
				}catch(Exception e){
					logger.info(e);
				}
		        return flag;
	    }
		
		//MESSAGE LEAVE BALANCE CREATED AND ACTION METHODS
		String msgCreated_Address = "//div[contains(text(),\"Leave Balance Created Successfully.\")]";
		public boolean isLeaveBalanceCreatedMessageDisplayed() {
	    	 boolean flag = false;
				try {
					WebElement msgLeaveBalanceCreated = driver.findElement(By.xpath(msgCreated_Address));
					wait.until(ExpectedConditions.visibilityOf(msgLeaveBalanceCreated));
			        if(msgLeaveBalanceCreated.isDisplayed()) {
			        	flag = true;
			        	logger.info("Leave balance created message caught : "+msgLeaveBalanceCreated.getText());
			        }else {
			        	logger.info("Leave balance created did not caught");
			        }
				}catch(Exception e){
					logger.info(e);
				}
		        return flag;
	    }
		
		//MESSAGE LEAVE BALANCE UPDATED AND ACTION METHODS
		String msgUpdated_Address = "//div[contains(text(),\"Leave Balance Updated Successfully.\")]";
		public boolean isLeaveBalanceUpdatedMessageDisplayed() {
	    	 boolean flag = false;
				try {
					WebElement msgLeaveBalanceUpdated = driver.findElement(By.xpath(msgUpdated_Address));
					wait.until(ExpectedConditions.visibilityOf(msgLeaveBalanceUpdated));
			        if(msgLeaveBalanceUpdated.isDisplayed()) {
			        	flag = true;
			        	logger.info("Leave balance updated message caught : "+msgLeaveBalanceUpdated.getText());
			        }else {
			        	logger.info("Leave balance updated did not caught");
			        }
				}catch(Exception e){
					logger.info(e);
				}
		        return flag;
	    }
		//========END=======CONFIRMATION MESSAGES VALIDATIONS===========//
		
	   
	    
	
}
