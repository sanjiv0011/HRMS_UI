package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_ClientPage {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	
	public PO_ClientPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	//=====START====Organization page and Create organization page object============//
	@FindBy(xpath = "//p[.=\"Create Client\"]")
	@CacheLookup
	WebElement btnCreateClient;

	@FindBy(xpath = "//input[@name='clientName']")
	@CacheLookup
	WebElement textEnterName;

	@FindBy(xpath = "//textarea[@name=\"description\"]")
	@CacheLookup
	WebElement textEnterDescripton;
	
	@FindBy(xpath = "//p[normalize-space()=\"Create\"]")
	@CacheLookup
	WebElement btnCreate;
	
	@FindBy(xpath = "//p[normalize-space()=\"Cancel\"]")
	@CacheLookup
	WebElement btnCancel;
	
	
	
	public void clickOnBtnCreateClient()
	{
		btnCreateClient.click();
		logger.info("Click on Create client button");
	}
	
	public void setOrgName(String clientDescription)
	{
		textEnterDescripton.sendKeys(clientDescription);
		logger.info("Enterd client description");
	}
	
	public void setOrgCode(String clientName)
	{
		textEnterName.sendKeys(clientName);
		logger.info("Enterd client name");
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
	
	public PO_HomePage createClient(String clientName, String clientDescription) throws InterruptedException
	{
		logger.info("Entered createCleint Methods");
		
		btnCreateClient.click();
		logger.info("Click on Create client button");
		Thread.sleep(2000);
		
		textEnterName.sendKeys(clientName);
		logger.info("Enterd client name");
		Thread.sleep(1000);
		
		textEnterDescripton.sendKeys(clientDescription);
		logger.info("Enterd client description");
		Thread.sleep(1000);
		
		btnCreate.click();
		logger.info("clicked on Create button");
		Thread.sleep(2000);
		
		return new PO_HomePage(driver);
		
		
	}
		
	
}
