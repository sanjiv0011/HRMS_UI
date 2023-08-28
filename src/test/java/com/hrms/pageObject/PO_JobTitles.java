package com.hrms.pageObject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.Actions.Action_Archive;
import com.hrms.Actions.Action_Created;
import com.hrms.Actions.Action_Restore;
import com.hrms.Actions.Action_Updated;
import com.hrms.ReUseAble.PageObject.ReUseAbleElement;
public class PO_JobTitles extends ReUseAbleElement{
	
	//CONSTRUCTOR DECLARATION
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait; 
	
	//CONSTRUCTOR
	public PO_JobTitles(WebDriver driver) {	
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
        ruae = new ReUseAbleElement(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//ACTION OPTIONS CONSTRUCTOR
	public Action_Archive actionArchive = new Action_Archive();
	public Action_Restore actionRestore = new Action_Restore();
	public Action_Created confirmationCreated = new Action_Created();
	public Action_Updated confirmationUpdated = new Action_Updated();

	//JOB TITLES ALERT MESSAGES
	String alertRestored_jt = "Job Title Restored Successfully.";
	String alertArchived_jt = "Job Title Archived Successfully.";
	String alertCreated_jt = "Job Title Created Successfully.";
	String alertUpdated_jt = "Job Title Updated Successfully.";
	String alertAleradyExist_jt = "Job Title already exists.";
			
			
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
	//=====END====JOB TITLES PAGE OBJECTS============//
	
	//=====START====JOB TITLES ACTIONS METHODS ON THE PAGE OBJECTS============//
	public void clickOnBtnCreateJobTitle() throws InterruptedException {
		btnCreateJobTitle.click();
		logger.info("Click on Create Job title button");
		Thread.sleep(2000);
	}
	
	public void setJObTitleName(String jobTitleName) throws InterruptedException {
		textEnterJobTitleName.sendKeys(Keys.CONTROL,"a");
		textEnterJobTitleName.sendKeys(Keys.DELETE);
		textEnterJobTitleName.sendKeys(jobTitleName);
		logger.info("Entered job tilte");
		Thread.sleep(500);
	}
	
	public void setJobTitleDescription(String jobtitleDescription) throws InterruptedException {
		textEnterJobTitleDescription.sendKeys(Keys.CONTROL,"a");
		textEnterJobTitleDescription.sendKeys(Keys.DELETE);
		textEnterJobTitleDescription.sendKeys(jobtitleDescription);
		logger.info("Enterd job title description");
		Thread.sleep(500);
	}
	//=====END====JOB TITLES ACTIONS METHODS ON THE PAGE OBJECTS============//
	
	// TO CREATE THE JOB TITLES
	public PO_HomePage createJobTitle(String jobTitleName, String jobtitleDescription) throws InterruptedException {	
		logger.info("Entered create job titles Methods");
		clickOnBtnCreateJobTitle();
		setJObTitleName(jobTitleName);
		setJobTitleDescription(jobtitleDescription);
		ruae.clickOnCreateButton_RU();
		confirmationCreated.created(driver, alertCreated_jt, alertAleradyExist_jt);
		return new PO_HomePage(driver);
	}
	
	//METHODS TO ARCHIVE THE JOB TITLES
	public PO_HomePage archiveJobTitles(String jobTitle) throws InterruptedException {
		logger.info("Archive job titles methods called");
		actionArchive.archive(jobTitle, driver, alertArchived_jt);
    	logger.info("Return back inside archive job titles method");
    	return new PO_HomePage(driver);
	}
	
	
	//METHODS TO RESTORE THE JOB TITLES 
	public PO_HomePage restoreJobTitles(String jobTitle) throws InterruptedException {
		logger.info("Restore job titles methods called");
		actionRestore.restore(jobTitle, driver, alertRestored_jt);
    	logger.info("Return back inside restore job titles method");
    	return new PO_HomePage(driver);
	}
	
	//TO EDIT THE JOB TILTES
	public PO_HomePage editJobTitles(String jobTitlesSearchKey, String newJobDescription, String newJobTitles) throws InterruptedException
	{	logger.info("Entered edit job titles methods");
		searchBox_RU(jobTitlesSearchKey);
		clickOnActionButton_RU();
		clickOnEditAction_RU();
		setJObTitleName(newJobTitles);
		setJobTitleDescription(newJobDescription);
		btnSaveChanges_RU.click();
		confirmationUpdated.updated(driver, alertUpdated_jt, alertAleradyExist_jt);
		return new PO_HomePage(driver);
	}
}
