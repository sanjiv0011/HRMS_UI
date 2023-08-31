package com.hrms.pageObject;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.Actions.Action_Archive;
import com.hrms.Actions.Action_Created;
import com.hrms.Actions.Action_Restore;
import com.hrms.Actions.Action_Updated;
import com.hrms.DataBaseTesting.DB_Testing_Action_Activate;
import com.hrms.DataBaseTesting.DB_Testing_Action_Archive;
import com.hrms.DataBaseTesting.DB_Testing_Action_Deactivate;
import com.hrms.DataBaseTesting.DB_Testing_Action_Restore;
import com.hrms.DataBaseTesting.DB_Testing_Leave_CreateAndUpdate;
import com.hrms.ReUseAble.PageObject.ReUseAbleElement;
import com.hrms.projectUtility.DatePicker;
import com.hrms.projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_LeavePage extends ReUseAbleElement {
	
	//CONSTRUCTOR AND OTHRE VARIABLE INITIALIZATION
	public WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public Logger logger = LogManager.getLogger(getClass());
	public Actions action;
	public WebDriverWait wait;
	
	//APPLY PAGE FACTORY CONCEPT THRUGH INHERITANCE(RE USE ABLE ELEMENT CLASS)
	public PO_LeavePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);	
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//ACTION OPTIONS CONSTRUCTOR
	public Action_Archive actionArchive = new Action_Archive();
	public Action_Restore actionRestore = new Action_Restore();
	public Action_Created confirmationCreated = new Action_Created();
	public Action_Updated confirmationUpdated = new Action_Updated();
		
		
	//ALERT LEAVE MESSAGES
	String alertRestored_leave = "Leave Restored Successfully.";
	String alertArchived_leave = "Leave Archived Successfully.";
	String alertCreated_leave = "Leave Created Successfully.";
	String alertUpdated_leave = "Leave Updated Successfully.";
	String alertAleradyExist_leave = "Leave already exists.";
	
	//CONSTRUCTOR DECLARATION AND INITIALIAZATION FOR DATA BASE ACTIONS
	public DB_Testing_Action_Archive  db_actionArchive = new DB_Testing_Action_Archive();
	public DB_Testing_Action_Restore  db_actionRestore = new DB_Testing_Action_Restore();
	public DB_Testing_Action_Activate  db_actionActivate = new DB_Testing_Action_Activate();
	public DB_Testing_Action_Deactivate  db_actionDeactivate = new DB_Testing_Action_Deactivate();
	public DB_Testing_Leave_CreateAndUpdate db_leaveCreateUpdate = new DB_Testing_Leave_CreateAndUpdate();
	
		
	//=====START====LEAVE PAGE OBJECTS AND ITS ACTION METHODS============//
	//APLLY LEAVE BUTTON ADDRESS
	@FindBy(xpath = "(//p[text()='Apply Leave'])[1]")
	@CacheLookup
	WebElement btnApplyLeave;
	public void clickOnBtnApplyLeave() throws InterruptedException {
		btnApplyLeave.click();
        logger.info("Clicked on the apply leave button");
        Thread.sleep(1000);     
    }
	
	//LEAVE TYPES LIST ADDRESS
	@FindBy(xpath = "//ul[@id='leaveType-listbox']//li")
	@CacheLookup
	List <WebElement> listLeaveTypes;
	public void selectLeaveTypes(String leaveTypeName) throws InterruptedException {
		clickOnDropdown_1_RU();
        //THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE
	    Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listLeaveTypes, leaveTypeName);
	    Thread.sleep(1000);
	    logger.info("Leave types selected");
    }
	
	//RADIO BUTTON FIRST HALF LEAVE
	@FindBy(xpath = "//input[@value='first-half']")
	@CacheLookup
	WebElement radioBtnFirstHalfLeave;
	public void selectFirstHalfLeave() throws InterruptedException {
		radioBtnFirstHalfLeave.click();
	    Thread.sleep(1000);
	    logger.info("Selected radio button first half");
    }
	
	//RADIO BUTTON SECOND HALF LEAVE
	@FindBy(xpath = "//input[@value='second-half']")
	@CacheLookup
	WebElement radioBtnSecondHalfLeave;
	public void selectSecondHalfLeave() throws InterruptedException {
		radioBtnSecondHalfLeave.click();
	    Thread.sleep(1000);
	    logger.info("Selected radio button second half");
    }
	
	//RADIO BUTTON HALF LEAVE
	@FindBy(xpath = "//input[@value='full-day']")
	@CacheLookup
	WebElement radioBtnFullLeave;
	public void selectFullLeave() throws InterruptedException {
		radioBtnFullLeave.click();
	    Thread.sleep(1000);
	    logger.info("Selected radio button full day");
    }
	
	//ACTION METHOD TO SELECT THE LEAVE START DATE
	public void selectStartDate(String leaveStartDate, int x) throws InterruptedException {
	    DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver, leaveStartDate, x);
		//ruae.setDateWithoutUsingDatePicker_RU(leaveStartDate,x);
	    logger.info("Leave start date, month and year entered");
	    Thread.sleep(1000);
	}

	//ACTION METHOD TO SELECT LEAVE END DATE
	public void selectEndDate(String leaveEndDate, int x) throws InterruptedException {
	    //DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver, leaveEndDate, x);
		ruae.setDateWithoutUsingDatePicker_RU(leaveEndDate,x);
	    logger.info("Leave end date, month and year entered");
	    Thread.sleep(2000);
	}
	
	//TEXT FIELD
	@FindBy(xpath = "//textarea[@id='reason']")
	@CacheLookup
	WebElement textReason;
	public void setLeaveReason(String reason) throws InterruptedException {
		textReason.sendKeys(reason);
	    Thread.sleep(1000);
	    logger.info("Entered leave reason");
    }
	
	//APPLY LEAVE FINAL BUTTON
	@FindBy(xpath = "(//p[text()='Apply Leave'])[2]")
	@CacheLookup
	WebElement btnApplyLeaveFinal;
	public void clickOnBtnApplyLeaveFinal() throws InterruptedException {
		btnApplyLeaveFinal.click();
	    logger.info("Clicked on the apply leave button");
    }

	
	//TO CREATE(APPLY LEAVE)
	public PO_HomePage applyLeave(String leaveTypeName,String leaveDuration,String leaveStartDate,String leaveEndDate, String reason, String orgName) throws InterruptedException, SQLException
	{	logger.info("Entered into apply leave methods");
		clickOnBtnApplyLeave();
		selectLeaveTypes(leaveTypeName);
		
		//TO SELECT LEAVE DURATION
		if(leaveDuration.equals("First half")) {
			selectFirstHalfLeave();
		}else if(leaveDuration.equals("Second half")) {
			selectSecondHalfLeave();
		}else if(leaveDuration.equals("Full day")) {
			selectFullLeave();
		}else {
			logger.info("Invalid leave types: "+leaveTypeName);
		}
		
		selectStartDate(leaveStartDate, 1);
		selectEndDate(leaveEndDate, 2);
		setLeaveReason(reason);
		clickOnBtnApplyLeaveFinal();
		boolean flag = confirmationCreated.created(driver, alertCreated_leave, alertAleradyExist_leave);
		
		//DATABASE TESTING
		if(flag) {
			db_leaveCreateUpdate.test_DB_CreateLeave(leaveTypeName, leaveDuration, leaveStartDate, leaveEndDate, reason, orgName);
		}
		logger.info("createOragnization call DONE");
		clickOnCancelButton_RU();
		
		return new PO_HomePage(driver);
	}
}
