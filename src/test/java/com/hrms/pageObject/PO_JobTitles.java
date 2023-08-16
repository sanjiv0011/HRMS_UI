package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

import my_support.Action_Archive;
import my_support.Action_Restore;

public class PO_JobTitles extends ReUseAbleElement{
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement rual;
	
	public PO_JobTitles(WebDriver driver)
	{	
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
        rual = new ReUseAbleElement(driver);
	}
	

	//=====START====JOB TITLES PAGE OBJECTS============//
	@FindBy(xpath = "//p[.=\"Create Job Title\"]")
	@CacheLookup
	WebElement btnCreateJobTitle;

	@FindBy(xpath = "//input[@name=\"title\"]")
	@CacheLookup
	WebElement textEnterJobTitleName;

	@FindBy(xpath = "//textarea[@name=\"description\"]")
	@CacheLookup
	WebElement textEnterJobTitleDescription;
	
	@FindBy(xpath = "//p[normalize-space()=\"Create\"]")
	@CacheLookup
	WebElement btnCreate;
	
	@FindBy(xpath = "//p[normalize-space()=\"Cancel\"]")
	@CacheLookup
	WebElement btnCancel;
	//=====END====JOB TITLES PAGE OBJECTS============//
	
	//=====START====JOB TITLES ACTIONS METHODS ON THE PAGE OBJECTS============//
	public void clickOnBtnCreateJobTitle(){
		btnCreateJobTitle.click();
		logger.info("Click on Create Job title button");
	}
	
	public void setJObTitleName(String jobTitleName){
		textEnterJobTitleName.sendKeys(jobTitleName);
		logger.info("Entered job tilte");
	}
	
	public void setJobTitleDescription(String jobtitleDescription){
		textEnterJobTitleDescription.sendKeys(jobtitleDescription);
		logger.info("Enterd job title description");
	}
	
	public void clickBtnCreate(){
		btnCreate.click();
		logger.info("clicked on Create button");
	}
	
	public void clickBtnCancel(){
		btnCancel.click();
		logger.info("Clicked on Cancel button");
	}
	//=====START====JOB TITLES ACTIONS METHODS ON THE PAGE OBJECTS============//
	
	// TO CREATE THE JOB TITLES
	public PO_HomePage createJobTitle(String jobTitleName, String jobtitleDescription) throws InterruptedException
	{	// TO CREATE JOB TITLES
		logger.info("Entered create job titles Methods");
		
		btnCreateJobTitle.click();
		logger.info("Click on Create Job title button");
		Thread.sleep(2000);
		
		textEnterJobTitleName.sendKeys(jobTitleName);
		logger.info("Entered job tilte");
		Thread.sleep(1000);
		
		textEnterJobTitleDescription.sendKeys(jobtitleDescription);
		logger.info("Enterd job title description");
		Thread.sleep(1000);
		
		btnCreate.click();
		logger.info("clicked on Create button");
		Thread.sleep(2000);
		
		return new PO_HomePage(driver);
	}
	
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage archiveJobTitles(String jobTitle) throws InterruptedException
	{
		logger.info("Archive job titles methods called");
    	
    	//METHODS TO ARCHIVE THE JOB TITLES
		Action_Archive.archive(jobTitle, searchBox, archivedLabel, btnAction, actionArchive, btnYes, "cofirmMessage");
    	 logger.info("Return back inside archive job titles method");
    	 return new PO_HomePage(driver);
	}
	
	
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage restoreJobTitles(String jobTitle) throws InterruptedException
	{
		logger.info("Restore job titles methods called");
    	
    	//METHODS TO RESTORE THE JOB TITLES 
		Action_Restore.restore(jobTitle, searchBox, archivedLabel, btnAction, actionRestore, btnYes, "cofirmMessage");
    	 logger.info("Return back inside restore job titles method");
    	 return new PO_HomePage(driver);
	}
	
	//USE TO EDIT THE JOB TILTES
	public PO_HomePage editJobTitles(String jobTitlesSearchKey, String newJobDescription, String newJobTitles) throws InterruptedException
	{
		logger.info("Entered edit job titles methods");
		Thread.sleep(2000);
		
		searchBox.sendKeys(jobTitlesSearchKey,Keys.ENTER);
		logger.info("Searched searchKeys");
		Thread.sleep(5000);
		
		btnAction.click();
		logger.info("Clicked on  button btnAction");
		Thread.sleep(2000);
		
		actionEdit.click();
		logger.info("Clicked on  button edit");
		Thread.sleep(2000);
		
		//TO CLEAR THE ALREADY WRITTEN TEXT
		textEnterJobTitleDescription.clear();
		Thread.sleep(1000);
		textEnterJobTitleName.clear();
		Thread.sleep(1000);
		
		textEnterJobTitleName.sendKeys(newJobTitles);
		logger.info("Entered leave type");
		Thread.sleep(1000);
		
		textEnterJobTitleDescription.sendKeys(newJobDescription);
		logger.info("Enterd leave types description");
		Thread.sleep(1000);
		
		btnSaveChanges.click();
		logger.info("clicked on Create button");
		Thread.sleep(100);
		
		return new PO_HomePage(driver);
	}
}
