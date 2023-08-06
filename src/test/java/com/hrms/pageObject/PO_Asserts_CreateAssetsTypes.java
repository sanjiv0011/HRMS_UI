package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_Asserts_CreateAssetsTypes {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	
	public PO_Asserts_CreateAssetsTypes(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
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
	
	public PO_HomePage createAssetType(String assetTypeName, String assetTypeCode, String assetTypeDescription ) throws InterruptedException
	{
		logger.info("Entered createCleint Methods");
		
		btnCreateAssetsType.click();
		logger.info("Click on Create Assert Type button");
		Thread.sleep(2000);
		
		btnCreateAssetsTypeInside.click();
		logger.info("Click on Create Assert Type inside button");
		Thread.sleep(1000);
		
		textEnterAssetTypeName.sendKeys(assetTypeName);
		logger.info("Enterd Assert types name");
		Thread.sleep(1000);
		
		textEnterAssetTypeCode.sendKeys(assetTypeCode);
		logger.info("Enterd assert type code");
		
		textEnterAssertTypeDescription.sendKeys(assetTypeDescription);
		logger.info("Enterd assetTypeDescription");
		
		btnCreate.click();
		logger.info("clicked on Create button");
		Thread.sleep(2000);
		
		return new PO_HomePage(driver);
		
		
	}
		
	
}
