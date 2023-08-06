package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_JobTitles {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	
	public PO_JobTitles(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	//=====START====Organization page and Create organization page object============//
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
	
	
	
	public void clickOnBtnCreateJobTitle()
	{
		btnCreateJobTitle.click();
		logger.info("Click on Create Job title button");
	}
	
	public void setJObTitleName(String jobTitleName)
	{
		textEnterJobTitleName.sendKeys(jobTitleName);
		logger.info("Entered job tilte");
	}
	
	public void setJobTitleDescription(String jobtitleDescription)
	{
		textEnterJobTitleDescription.sendKeys(jobtitleDescription);
		logger.info("Enterd job title description");
	}
	
	public void clickBtnCreate()
	{
		btnCreate.click();
		logger.info("clicked on Create button");
	}
	
	public void clickBtnCancel()
	{
		btnCancel.click();
		logger.info("Clicked on Cancel button");
	}
	
	public PO_HomePage createJobTitle(String jobTitleName, String jobtitleDescription) throws InterruptedException
	{
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
		
	
}
