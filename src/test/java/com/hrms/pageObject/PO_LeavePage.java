package com.hrms.pageObject;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

import projectUtility.DatePicker;
import projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_LeavePage extends ReUseAbleElement {
	
	//CONSTRUCTOR AND OTHRE VARIABLE INITIALIZATION
	public WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public Logger logger = LogManager.getLogger(getClass());
	
	//APPLY PAGE FACTORY CONCEPT THRUGH INHERITANCE(RE USE ABLE ELEMENT CLASS)
	public PO_LeavePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);	
	}
	
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
	
	//DROPDOWN ICON TO SELECT LEAVE TYPES ADDRESS
	@FindBy(xpath = "//button[@title='Open']//*[name()='svg']")
	@CacheLookup
	WebElement iconDropdown;
	public void clickOnIconDropDown() throws InterruptedException {
		iconDropdown.click();
        logger.info("Clicked on the icon dropdown");
        Thread.sleep(1000);
    }
	
	//LEAVE TYPES LIST ADDRESS
	@FindBy(xpath = "//ul[@id='leaveType-listbox']//li")
	@CacheLookup
	List <WebElement> listLeaveTypes;
	public void selectLeaveTypes(String leaveTypeName) throws InterruptedException {
		clickOnIconDropDown();
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
	    logger.info("Select radio button half leave");
    }
	
	//RADIO BUTTON SECOND HALF LEAVE
	@FindBy(xpath = "//input[@value='second-half']")
	@CacheLookup
	WebElement radioBtnSecondHalfLeave;
	public void selectSecondHalfLeave() throws InterruptedException {
		radioBtnSecondHalfLeave.click();
	    Thread.sleep(1000);
	    logger.info("Select radio button half leave");
    }
	
	//RADIO BUTTON HALF LEAVE
	@FindBy(xpath = "//input[@value='full-day']")
	@CacheLookup
	WebElement radioBtnFullLeave;
	public void selectFullLeave() throws InterruptedException {
		radioBtnFirstHalfLeave.click();
	    Thread.sleep(1000);
	    logger.info("Select radio button full leave");
    }
	
	//ACTION METHOD TO SELECT THE LEAVE START DATE
	public void selectStartDate(String leaveStartDate, int x) throws InterruptedException {

		//THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE AND CORRESPONDING ADDRESSES IS PRESENT UNDER THE RE_USEABLE_PAGEOBJECT PACKAGE
	    DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver, leaveStartDate, x);
	    logger.info("Leave start date, month and year entered");
	    Thread.sleep(2000);
	}

	//ACTION METHOD TO SELECT LEAVE END DATE
	public void selectEndDate(String leaveEndDate, int x) throws InterruptedException {
	
		//THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE AND CORRESPONDING ADDRESSES IS PRESENT UNDER THE RE_USEABLE_PAGEOBJECT PACKAGE
	    DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver, leaveEndDate, x);
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
	
	//TEXT FIELD
	@FindBy(xpath = "(//p[text()='Apply Leave'])[2]")
	@CacheLookup
	WebElement btnApplyLeaveFinal;
	public void clickOnBtnApplyLeaveFinal() throws InterruptedException {
		btnApplyLeaveFinal.click();
	    Thread.sleep(300);
	    logger.info("Clicked on the apply leave button");
    }
	
	
	//TO APPLY LEAVE
	public PO_HomePage applyLeave(String leaveTypeName,String leaveDuration,String leaveStartDate,String leaveEndDate, String reason) throws InterruptedException
	{	logger.info("Entered into apply leave methods");
		clickOnBtnApplyLeave();
		selectLeaveTypes(leaveTypeName);
		
		//TO SELECT LEAVE DURATION
		if(leaveDuration.equals("First half")) {
			selectFirstHalfLeave();
		}else if(leaveDuration.equals("Second half")) {
			selectSecondHalfLeave();
		}else if(leaveDuration.equals("Full half")) {
			selectFullLeave();
		}else {
			logger.info("Invalid leave types: "+leaveTypeName);
		}
		
		selectStartDate(leaveStartDate, 1);
		selectEndDate(leaveEndDate, 2);
		setLeaveReason(reason);
		clickOnBtnApplyLeaveFinal();
		ruae.clickOnCancelButton_RU();
		
		return new PO_HomePage(driver);
	}
}
