package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

import my_support.Action_Archive;
import my_support.Action_Restore;

public class PO_Asserts_CreateAssetsTypes extends ReUseAbleElement {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement rual;
	
	public PO_Asserts_CreateAssetsTypes(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
        rual = new ReUseAbleElement(driver);
	}
	

	//=====START====Assets page and Create Assets Type page object============//
	@FindBy(xpath = "//p[normalize-space()=\"Asset Type\"]")
	@CacheLookup
	WebElement btnCreateAssetsType;

	@FindBy(xpath = "//p[.='Create Asset Type']")
	@CacheLookup
	WebElement btnCreateAssetsTypeInside;

	@FindBy(xpath = "//input[@placeholder='Enter Asset Type Name']")
	@CacheLookup
	WebElement textEnterAssetTypeName;
	
	@FindBy(xpath = "//input[@placeholder=\"Enter Code\"]")
	@CacheLookup
	WebElement textEnterAssetTypeCode;
	
	@FindBy(xpath = "//textarea[@id=\"description\"]")
	@CacheLookup
	WebElement textEnterAssertTypeDescription;
	
	@FindBy(xpath = "//p[normalize-space()=\"Create\"]")
	@CacheLookup
	WebElement btnCreate;
	
	@FindBy(xpath = "//p[normalize-space()=\"Cancel\"]")
	@CacheLookup
	WebElement btnCancel;
	
	
	
	public void clickOnBtnCreateAssertType()
	{
		btnCreateAssetsType.click();
		logger.info("Click on Create Assert Type button");
	}
	
	public void clickOnBtnCreateAssetTypeInside()
	{
		btnCreateAssetsTypeInside.click();
		logger.info("Click on Create Assert Type inside button");
	}
	
	public void setAssetTypeName(String assetTypeName)
	{
		textEnterAssetTypeName.sendKeys(assetTypeName);
		logger.info("Enterd Assert types name");
	}
	
	public void setAssetTypeCode(String assetTypeCode)
	{
		textEnterAssetTypeCode.sendKeys(assetTypeCode);
		logger.info("Enterd assert type code");
	}
	
	public void setAssetTypeDescription(String assetTypeDescription)
	{
		textEnterAssertTypeDescription.sendKeys(assetTypeDescription);
		logger.info("Enterd assetTypeDescription");
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
	
	//TO CREATE ASSETS TYPES
	public PO_HomePage createAssetType(String assetTypeName, String assetTypeCode, String assetTypeDescription ) throws InterruptedException
	{	Thread.sleep(2000);
		logger.info("Entered createCleint Methods");
		
		btnCreateAssetsType.click();
		logger.info("Click on Create Assert Type button");
		Thread.sleep(2000);
		
		btnCreateAssetsTypeInside.click();
		logger.info("Click on Create Assert Type inside button");
		Thread.sleep(1000);
		
		textEnterAssetTypeName.sendKeys(assetTypeName);
		logger.info("Enterd Assert types name");
		
		textEnterAssetTypeCode.sendKeys(assetTypeCode);
		logger.info("Enterd assert type code");
		
		textEnterAssertTypeDescription.sendKeys(assetTypeDescription);
		logger.info("Enterd assetTypeDescription");
		
		btnCreate.click();
		logger.info("clicked on Create button");		
		return new PO_HomePage(driver);
	}
	
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage archiveAssetType(String assetsType) throws InterruptedException
	{	//TO ARCHIVE THE ASSETS TYPES AND RETURN DRIVER TO HOME PAGE 
		Thread.sleep(2000);
		logger.info("Archive assets methods called");
    	
		btnCreateAssetsType.click();
		logger.info("Click on Create Assert Type button");
		Thread.sleep(2000);
		
    	//METHODS TO ARCHIVE THE LEAVE BALNACE 
		Action_Archive.archive(assetsType, searchBox, archivedLabel, btnAction, actionArchive, btnYes, "cofirmMessage");
    	 logger.info("Return back inside archive assets method");
    	 return new PO_HomePage(driver);
	}
	
	
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage restoreAssetType(String assetsType) throws InterruptedException
	{	//TO RESTORE THE ASSETS TYPES AND RETURN DRIVER TO HOME PAGE
		Thread.sleep(2000);
		logger.info("Restore assets methods called");
    	
		btnCreateAssetsType.click();
		logger.info("Click on Create Assert Type button");
		Thread.sleep(2000);
		
    	//METHODS TO ARCHIVE THE LEAVE BALNACE 
		Action_Restore.restore(assetsType, searchBox, archivedLabel, btnAction, actionRestore, btnYes, "cofirmMessage");
    	 logger.info("Return back inside restore assets method");
    	 return new PO_HomePage(driver);
	}
	
	//USE TO EDIT THE LEAVE TYPES
	public PO_HomePage editAssetType(String assetTypeSearchKey, String newAssetTypeDescription, String newAssetTypeName, String newAssetTypeCode) throws InterruptedException
	{	//TO EDIT THE ASSETS TYPES AND RETURN DRIVER TO HOME PAGE
		Thread.sleep(2000);
		logger.info("Entered inside edit assets methods");
		Thread.sleep(2000);
		
		btnCreateAssetsType.click();
		logger.info("Click on Create Assert Type button");
		Thread.sleep(2000);
		
		searchBox.sendKeys(assetTypeSearchKey,Keys.ENTER);
		logger.info("Searched searchKeys");
		Thread.sleep(5000);
		
		btnAction.click();
		logger.info("Clicked on  button btnAction");
		Thread.sleep(2000);
		
		actionEdit.click();
		logger.info("Clicked on  button edit");
		Thread.sleep(2000);
		
		//TO CLEAR THE ALREADY WRITTEN TEXT
		textEnterAssertTypeDescription.clear();
		Thread.sleep(1000);
		textEnterAssetTypeName.clear();
		Thread.sleep(1000);
		
		textEnterAssetTypeName.sendKeys(newAssetTypeName);
		logger.info("Entered leave type");
		Thread.sleep(500);
		
		textEnterAssetTypeCode.sendKeys(newAssetTypeCode);
		logger.info("Enterd assert type code");
		Thread.sleep(500);
		
		textEnterAssertTypeDescription.sendKeys(newAssetTypeDescription);
		logger.info("Enterd leave types description");
		Thread.sleep(500);
		
		btnSaveChanges.click();
		logger.info("clicked on Create button");
		Thread.sleep(300);
		return new PO_HomePage(driver);
	}
	
	
}
