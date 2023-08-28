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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.Actions.Action_Archive;
import com.hrms.Actions.Action_Created;
import com.hrms.Actions.Action_Restore;
import com.hrms.Actions.Action_Updated;
import com.hrms.ReUseAble.PageObject.ReUseAbleElement;


public class PO_Asserts_AssetsTypes extends ReUseAbleElement {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	
	public PO_Asserts_AssetsTypes(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
        ruae = new ReUseAbleElement(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public Action_Archive actionArchive = new Action_Archive();
	public Action_Restore actionRestore = new Action_Restore();
	public Action_Created confirmationCreated = new Action_Created();
	public Action_Updated confirmationUpdated = new Action_Updated();
	
	String alertRestored_assetType = "Asset Type Restored Successfully.";
	String alertArchived_assetType = "Asset Type Archived Successfully.";
	String alertCreated_assetType = "Asset Type Created Successfully.";
	String alertUpdated_assetType = "Asset Type Updated Successfully.";
	String alertAleradyExist_assetType = "Asset types already exists for given organization.";

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
	
	
	
	public void clickOnBtnCreateAssertType() throws InterruptedException {
		btnCreateAssetsType.click();
		logger.info("Click on Create Assert Type button");
		Thread.sleep(1000);
	}
	
	public void clickOnBtnCreateAssetTypeInside() throws InterruptedException {
		btnCreateAssetsTypeInside.click();
		logger.info("Click on Create Assert Type inside button");
		Thread.sleep(1000);
	}
	
	public void setAssetTypeName(String assetTypeName) throws InterruptedException {
		textEnterAssetTypeName.sendKeys(Keys.CONTROL,"a");
		textEnterAssetTypeName.sendKeys(Keys.DELETE);
		textEnterAssetTypeName.sendKeys(assetTypeName);
		logger.info("Enterd Assert types name");
		Thread.sleep(300);
	}
	
	public void setAssetTypeCode(String assetTypeCode) throws InterruptedException {
		textEnterAssetTypeCode.sendKeys(Keys.CONTROL,"a");
		textEnterAssetTypeCode.sendKeys(Keys.DELETE);
		textEnterAssetTypeCode.sendKeys(assetTypeCode);
		logger.info("Enterd assert type code");
		Thread.sleep(300);
	}
	
	public void setAssetTypeDescription(String assetTypeDescription) throws InterruptedException {
		textEnterAssertTypeDescription.sendKeys(Keys.CONTROL,"a");
		textEnterAssertTypeDescription.sendKeys(Keys.DELETE);
		textEnterAssertTypeDescription.sendKeys(assetTypeDescription);
		logger.info("Enterd assetTypeDescription");
		Thread.sleep(300);
	}

	
	//TO CREATE ASSETS TYPES
	public PO_HomePage createAssetType(String assetTypeName, String assetTypeCode, String assetTypeDescription ) throws InterruptedException
	{	Thread.sleep(1000);
		logger.info("Entered createCleint Methods");
		
		clickOnBtnCreateAssertType();
		clickOnBtnCreateAssetTypeInside();
		setAssetTypeName(assetTypeName);
		setAssetTypeCode(assetTypeCode);
		setAssetTypeDescription(assetTypeDescription);
		ruae.clickOnCreateButton_RU();
		confirmationCreated.created(driver, alertCreated_assetType,alertAleradyExist_assetType);
		return new PO_HomePage(driver);
	}
	
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage archiveAssetType(String assetsType) throws InterruptedException {	
		logger.info("Archive assets methods called");
		clickOnBtnCreateAssertType();
    	//METHODS TO ARCHIVE THE LEAVE BALNACE 
		actionArchive.archive(assetsType,driver, alertArchived_assetType);
		//Action_Archive.archive(assetsType, searchBox_RU, archivedLabel, btnAction_RU, actionArchive, btnYes, driver);
    	logger.info("Return back inside archive assets method");
    	 return new PO_HomePage(driver);
	}
	
	
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage restoreAssetType(String assetsType) throws InterruptedException {
		logger.info("Restore assets methods called");
		clickOnBtnCreateAssertType();
    	//METHODS TO ARCHIVE THE LEAVE BALNACE 
		actionRestore.restore(assetsType,driver,alertRestored_assetType);
		//Action_Restore.restore(assetsType, searchBox_RU, archivedLabel, btnAction_RU, actionRestore, btnYes, driver);
    	 logger.info("Return back inside restore assets method");
    	 return new PO_HomePage(driver);
	}
	
	//USE TO EDIT THE LEAVE TYPES
	public PO_HomePage editAssetType(String assetTypeSearchKey, String newAssetTypeDescription, String newAssetTypeName, String newAssetTypeCode) throws InterruptedException
	{	logger.info("Entered inside edit assets methods");
		clickOnBtnCreateAssertType();
		searchBox_RU(assetTypeSearchKey);
    	clickOnActionButton_RU();
    	clickOnEditAction_RU();
    	setAssetTypeName(newAssetTypeName);
		setAssetTypeCode(newAssetTypeCode);
		setAssetTypeDescription(newAssetTypeDescription);
		btnSaveChanges_RU.click();
		confirmationUpdated.updated(driver, alertUpdated_assetType, alertAleradyExist_assetType);
		return new PO_HomePage(driver);
	}
	
	
}
