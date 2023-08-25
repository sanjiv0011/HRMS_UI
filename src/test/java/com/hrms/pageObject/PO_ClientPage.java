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
import com.hrms.projectUtility.Action_Archive;
import com.hrms.projectUtility.Action_Restore;

public class PO_ClientPage extends ReUseAbleElement {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement rual;
	
	public PO_ClientPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
        rual = new ReUseAbleElement(driver);
	}
	
	//=====START====CLIENT PAGE OBJECTS============//
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
	//=====END====CLIENT PAGE OBJECTS============//
	
	//=====START====CLIENT PAGE OBJECTS ACTIONS METHODS ============//
	public void clickOnBtnCreateClient(){
		btnCreateClient.click();
		logger.info("Click on Create client button");
	}
	
	public void setOrgName(String clientDescription){
		textEnterDescripton.sendKeys(clientDescription);
		logger.info("Enterd client description");
	}
	
	public void setOrgCode(String clientName){
		textEnterName.sendKeys(clientName);
		logger.info("Enterd client name");
	}
	
	public void clickBtnCreate(){
		btnCreate.click();
		logger.info("clicked on Create button");
	}
	
	public void clickBtnCancel(){
		btnCancel.click();
		logger.info("Clicked on Cancel button");
	}
	
	//=====END====CLIENT PAGE OBJECTS ACTIONS METHODS============//
	
	
	//TO CREATE CLIENT 
	public PO_HomePage createClient(String clientName, String clientDescription) throws InterruptedException
	{	logger.info("Entered createCleint Methods");
		Thread.sleep(2000);

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
	

	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage archiveClient(String clientName) throws InterruptedException
	{	logger.info("Archive Client methods called");
    	
    	//METHODS TO ARCHIVE THE CLEINT 
		Action_Archive.archive(clientName, searchBox_RU, archivedLabel, btnAction_RU, actionArchive, btnYes, driver);
    	 logger.info("Return back inside archive Client method");
    	 return new PO_HomePage(driver);
	}
	
	
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage restoreClient(String clientName) throws InterruptedException
	{	logger.info("Restore Client methods called");
    	
    	//METHODS TO ARCHIVE THE CLIENT
		Action_Restore.restore(clientName, searchBox_RU, archivedLabel, btnAction_RU, actionRestore, btnYes, driver);
    	 logger.info("Return back inside restore Client method");
    	 return new PO_HomePage(driver);
	}
	
	//USE TO EDIT THE CLIENT
	public PO_HomePage editClient(String clientNameSearchKey, String newClientDescription, String newCleintName) throws InterruptedException
	{	logger.info("Entered edit job titles methods");
		Thread.sleep(2000);
		
		searchBox_RU.sendKeys(clientNameSearchKey,Keys.ENTER);
		logger.info("Searched searchKeys");
		Thread.sleep(5000);
		
		btnAction_RU.click();
		logger.info("Clicked on  button btnAction_RU");
		Thread.sleep(2000);
		
		actionEdit_RU.click();
		logger.info("Clicked on  button edit");
		Thread.sleep(2000);
		
		//TO CLEAR THE ALREADY WRITTEN TEXT
		textEnterName.clear();
		Thread.sleep(1000);
		textEnterDescripton.clear();
		Thread.sleep(1000);
		
		textEnterName.sendKeys(newCleintName);
		logger.info("Entered leave type");
		Thread.sleep(1000);
		
		textEnterDescripton.sendKeys(newClientDescription);
		logger.info("Enterd leave types description");
		Thread.sleep(1000);
		
		btnSaveChanges_RU.click();
		logger.info("clicked on Create button");
		Thread.sleep(100);
		
		return new PO_HomePage(driver);
	}
		
	
}
