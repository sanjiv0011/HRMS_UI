package com.hrms.pageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

import my_support.DatePicker;
import my_support.Generic_Method_ToSelect_Boostrape_Dropdown;
import my_support.TimePicker;

public class PO_DailyUpdates extends ReUseAbleElement{
	
	//CONSTRUCTOR AND OTHRE VARIABLE DECLARATIOIN
	public WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public Logger logger = LogManager.getLogger(getClass());
	public WebDriverWait wait;
	public Actions action;

	
	//APPLY PAGE FACTORY CONCEPT THRUGH INHERITANCE(RE USE ABLE ELEMENT CLASS)
	public PO_DailyUpdates(WebDriver driver){	
		super(driver);
		this.driver = driver;
		jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		action = new Actions(driver);
	}
	
	//=====START====Organization page and Create organization page object============//
		//PROJECT LIST ADDRESS
		@FindBy(xpath = "//ul[@id='myProjectObj-listbox']//li")
		@CacheLookup
		public List <WebElement> listProject;
		
		//ACTION METHOD TO CLICK ON THE PROJECT LIST DROPDOWN AND SELECT THE GIVEN PROJECT NAME
		public void selectProject(String projectName) throws InterruptedException {
			//TO CLICK ON THE DROPDOWN ICON 
			clickOnProjectDropdown_RU();
		    //THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE
		    Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listProject, projectName);
		    logger.info("Project name selected");
		    Thread.sleep(1000);
		}
		
		//DESCRIPTION ADDRESS
		@FindBy(xpath = "//div[contains(@data-placeholder,'Enter The Description')]")
		@CacheLookup
		WebElement textDescription;
		public void setDescription(String description) {
			textDescription.sendKeys(description);
		}
		
		//DESCRIPTION ADDRESS
		@FindBy(xpath = "//div[contains(text(),'Your update has been sent successfully.')]")
		@CacheLookup
		WebElement msgSuccessFullDailyUpdates;
		public boolean isSuccessFullDailyUpdatesMSGDisplayed( ) {
			boolean flag = false;
			try {
				wait.until(ExpectedConditions.elementToBeClickable(msgSuccessFullDailyUpdates));
				String text = msgSuccessFullDailyUpdates.getText();
				if(text != null) {
					flag = true;
					logger.info("msgSuccessFullDailyUpdates is Displayed: "+msgSuccessFullDailyUpdates.isDisplayed());
				}
			}catch(Exception e) {
				logger.info("Message from isSuccessFullDailyUpdatesMSGDisplayed methods: "+e.getCause());
			}
			
			return flag;
		}
				
		
		//TO CREATE DAILY UPDATES
		public PO_HomePage createDailyUpdates(WebDriver driver, String dailyUpdateDate, String hoursStart, String mintuesStart, String AMPMStart,String hoursEnd, String mintuesEnd, String AMPMEnd, String projectName, String description ) throws InterruptedException
		{	
			//IT WILL CLICK ON THE START DATE ICON
			clickOnDateIconFirst_RU();
			//THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE AND CORRESPONDING ADDRESSES IS PRESENT UNDER THE RE_USEABLE_PAGEOBJECT PACKAGE
		    DatePicker.DatePicker_GenericMethod_WithoutDropDown(toggleBtnYearAndDate, elementCurrentMonthYearDisplayed, arrowNextMonth, arrowPreviousMonth, selectDate, selectYear, dailyUpdateDate);
		    logger.info("Daily update date, month and year entered");
		    Thread.sleep(2000);	
		    
		    
		    clickOnTimeIcon_2_RU();
		    //TO SELECT THE END TIME IT IS CALLING FORM THE MY SUPPORT PACKAGE HAVNG CLASS TIME PICKER
		    TimePicker.selectTime(driver, hoursEnd, mintuesEnd, AMPMEnd, btnAM_RU, btnPM_RU, listHours_RU, listMinutes_RU);
		    clickOnTimeIcon_1_RU();
		    //TO SELECT THE START TIME IT IS CALLING FORM THE MY SUPPORT PACKAGE HAVNG CLASS TIME PICKER
		    TimePicker.selectTime(driver,hoursStart, mintuesStart, AMPMStart, btnAM_RU, btnPM_RU, listHours_RU, listMinutes_RU);
		   
		    //TO SELECT THE PROJECT
		    selectProject(projectName);
		    
		    //TO SET THE DESCRIPTION
		    setDescription(description);
		    
		    ruae.clickOnCreateButton_RU();
		    if(isSuccessFullDailyUpdatesMSGDisplayed()) {
		    	logger.info("Daily updates created successfully");
		    }else {
		    	logger.info("Does not caught the daily updates message");
		    }
		    return new PO_HomePage(driver);
		}
		
		
		

}
