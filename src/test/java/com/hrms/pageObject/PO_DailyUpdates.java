package com.hrms.pageObject;

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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.Actions.Action_Created;
import com.hrms.ReUseAble.PageObject.ReUseAbleElement;
import com.hrms.projectUtility.DatePicker;
import com.hrms.projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;
import com.hrms.projectUtility.TimePicker;

public class PO_DailyUpdates extends ReUseAbleElement{
	
	//CONSTRUCTOR AND OTHRE VARIABLE DECLARATIOIN
	public WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public Logger logger = LogManager.getLogger(getClass());
	public WebDriverWait wait;
	public Actions action;
	public TimePicker tp;

	
	//APPLY PAGE FACTORY CONCEPT THRUGH INHERITANCE(RE USE ABLE ELEMENT CLASS)
	public PO_DailyUpdates(WebDriver driver){	
		super(driver);
		this.driver = driver;
		jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		action = new Actions(driver);
	}
	
	//ALERT CONSTRUCTOR
	public Action_Created confirmationCreated = new Action_Created();
	
	//DAILY UPDATES ALERT MESSAGES 
	String alertCreated_du = "Your update has been sent successfully.";
	
	//=====START====DAILY UPDATES PAGE OBJECT AND ITS ACTION METHODS============//
		//PROJECT LIST ADDRESS
		@FindBy(xpath = "//ul[@id='myProjectObj-listbox']//li")
		@CacheLookup
		public List <WebElement> listProject;
		
		//DESCRIPTION ADDRESS
		@FindBy(xpath = "//div[contains(@data-placeholder,'Enter The Description')]")
		@CacheLookup
		WebElement textDescription;
				
		//ACTION METHOD TO CLICK ON THE PROJECT LIST DROPDOWN AND SELECT THE GIVEN PROJECT NAME
		public void selectProject(String projectName) throws InterruptedException {
			//TO CLICK ON THE DROPDOWN ICON 
			clickOnDropdown_1_RU();
		    //THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE
		    Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listProject, projectName);
		    logger.info("Project name selected");
		    Thread.sleep(1000);
		}
		
		//ACTION METHODS TO SET DESCRIPTION
		public void setDescription(String description) throws InterruptedException {
			textDescription.sendKeys(Keys.CONTROL,"a");
			textDescription.sendKeys(Keys.DELETE);
			textDescription.sendKeys(description);
			logger.info("Project name selected");
			Thread.sleep(500);
		}
		
		
		//TO CREATE DAILY UPDATES
		public PO_HomePage createDailyUpdates(WebDriver driver, String dailyUpdateDate, String hoursStart, String mintuesStart, String AMPMStart,String hoursEnd, String mintuesEnd, String AMPMEnd, String projectName, String description ) throws InterruptedException
		{	
			TimePicker.selectTime(driver, hoursEnd, mintuesEnd, AMPMEnd,2);
			DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver, dailyUpdateDate, 1);
		    TimePicker.selectTime(driver,hoursStart, mintuesStart, AMPMStart,1);
		    //TO SELECT THE PROJECT
		    selectProject(projectName);
		    //TO SET THE DESCRIPTION
		    setDescription(description);
		    
		    ruae.clickOnCreateButton_RU();
		    confirmationCreated.created(driver, alertCreated_du, "");
		    return new PO_HomePage(driver);
		}
		
		
		

}
