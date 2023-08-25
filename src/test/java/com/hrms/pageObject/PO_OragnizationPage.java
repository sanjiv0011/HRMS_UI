package com.hrms.pageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.hrms.ReUseAble.PageObject.ReUseAbleElement;
import com.hrms.projectUtility.Action_Activate;
import com.hrms.projectUtility.Action_Archive;
import com.hrms.projectUtility.Action_DeActivate;
import com.hrms.projectUtility.Action_Restore;
import com.hrms.projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_OragnizationPage extends ReUseAbleElement{
	
	//CONSTRUCTOR AND OTHRE VARIABLE DECLARATIOIN
	public WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public Logger logger = LogManager.getLogger(getClass());
	public WebDriverWait wait;

	
	//APPLY PAGE FACTORY CONCEPT THRUGH INHERITANCE(RE USE ABLE ELEMENT CLASS)
	public PO_OragnizationPage(WebDriver driver){	
		super(driver);
		this.driver = driver;
		jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	}
	

	//=====START====Organization page and Create organization page object============//
	@FindBy(xpath = "//button//p[text()='Create Organization']")
	@CacheLookup
	WebElement btnCreateOrganization;

	@FindBy(xpath = "//input[@name='name']")
	@CacheLookup
	WebElement textEnterName;

	@FindBy(xpath = "//input[@name='code']")
	@CacheLookup
	WebElement textEnterCode;

	@FindBy(xpath = "//input[@name='emailAddress']")
	@CacheLookup
	WebElement textEnterEmail;

	@FindBy(xpath = "//input[@name='phoneNumber']")
	@CacheLookup
	WebElement textEnterPhoneNumber;
	
	@FindBy(xpath = "//input[@name='addressLine1']")
	@CacheLookup
	WebElement textEnterAddress;
	
	@FindBy(xpath = "//input[@name='addressLine2']")
	@CacheLookup
	WebElement textEnterArea;

	@FindBy(xpath = "//input[@name='city']")
	@CacheLookup
	WebElement textEnterCity;

	@FindBy(xpath = "//input[@name='state']")
	@CacheLookup
	WebElement textEnterState;

	@FindBy(xpath = "//input[@name='postalCode']")
	@CacheLookup
	WebElement textEnterPostalCode;

	@FindBy(xpath = "//input[@name='country']")
	@CacheLookup
	WebElement textEnterCountry;
	
	@FindBy(xpath = "//button[@title=\"Open\"]//*[name()=\"svg\"]")
	@CacheLookup
	WebElement iconDropdownTimeZone;
	
	@FindBy(xpath = "//ul[@id=\"timeZone-listbox\"]//li")
	@CacheLookup
	List <WebElement> dropdownTimeZone;
	

	
	//=====START====ACTION METHODS ON THE ORGANIZATION PAGE OBJECTS============//
	public void clickOnBtnCreateOrganization() throws InterruptedException{
		btnCreateOrganization.click();
		logger.info("Click on Create organization button");
		Thread.sleep(2000);
	}
	
	public void setOrgName(String orgName) throws InterruptedException{
		textEnterName.sendKeys(orgName);
		Thread.sleep(1000);
		logger.info("Enterd org name");
	}
	
	public void setOrgCode(String orgCode) throws InterruptedException{
		textEnterCode.sendKeys(orgCode);
		Thread.sleep(1000);
		logger.info("Enterd org code");
	}
	
	public void setOrgEmail(String orgEmail) throws InterruptedException{
		textEnterEmail.sendKeys(orgEmail);
		Thread.sleep(1000);
		logger.info("Enterd org email");
	}
	
	public void setOrgPhoneNumber(String orgPhoneNumber) throws InterruptedException{
		textEnterPhoneNumber.sendKeys(orgPhoneNumber);
		Thread.sleep(1000);
		logger.info("Enterd org phone number");
	}
	
	public void setOrgAddress(String orgAddress) throws InterruptedException{
		textEnterAddress.sendKeys(orgAddress);
		Thread.sleep(1000);
		logger.info("Enterd org address");
	}
	
	public void setOrgArea(String orgArea) throws InterruptedException{
		textEnterArea.sendKeys(orgArea);
		Thread.sleep(1000);
		logger.info("Enterd org area");
	}
	
	public void setOrgCity(String orgCity) throws InterruptedException{
		textEnterCity.sendKeys(orgCity);
		Thread.sleep(1000);
		logger.info("Enterd org city");
	}
	
	public void setOrgState(String orgState) throws InterruptedException{
		textEnterState.sendKeys(orgState);
		Thread.sleep(1000);
		logger.info("Enterd org  state");
	}
	
	public void setOrgPostalCode(String orgPostalCode) throws InterruptedException{
		textEnterPostalCode.sendKeys(orgPostalCode);
		Thread.sleep(1000);
		logger.info("Enterd org postal code");
	}
	
	public void setOrgCountry(String orgCountry) throws InterruptedException{
		textEnterCountry.sendKeys(orgCountry);
		Thread.sleep(1000);
		logger.info("Enterd org  country");
	}
	
	public void clickOnIconDropdownTimeZone() throws InterruptedException{
		iconDropdownTimeZone.click();
		Thread.sleep(1000);
		logger.info("Clicked on the icon drop down for the time zone");
	}
	
	public void selectOrgTimeZone(String orgTimeZone) throws InterruptedException{	
		//"(UTC +05:30) Asia/Kolkata"
		clickOnIconDropdownTimeZone();
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(dropdownTimeZone,orgTimeZone );
		Thread.sleep(1000);
		logger.info("Enterd org  time zone");
	}

	//=====END====ACTION METHODS ON THE ORGANIZATION PAGE OBJECTS============//
	
	
	//TO CREATE ORGANIZATION
	public PO_HomePage createOragnization(String orgName, String orgCode, String orgEmail, String orgPhoneNumber, String orgAddress, String orgArea, String orgCity, String orgState, String orgPostalCode,String orgCountry, String orgTimeZone ) throws InterruptedException
	{ 	logger.info("Entered into create organizatioin methods");
		clickOnBtnCreateOrganization();
		setOrgName(orgName);
		setOrgCode(orgCode);
		setOrgEmail(orgEmail);
		setOrgPhoneNumber(orgPhoneNumber);
		setOrgAddress(orgAddress);
		setOrgArea(orgArea);
		setOrgCity(orgCity);
		setOrgState(orgState);
		setOrgPostalCode(orgPostalCode);
		setOrgCountry(orgCountry);
		selectOrgTimeZone(orgTimeZone);
		ruae.clickOnCreateButton_RU();
		return new PO_HomePage(driver);
	}
	
	//TO ARCHIVE ORGANIZATION
	// THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
   	public PO_HomePage archiveOrganization(String orgName) throws InterruptedException {
       logger.info("Archive organization method called");
       // METHODS TO ARCHIVE THE ORGANIZATION
       Action_Archive.archive(orgName, searchBox_RU, archivedLabel, btnAction_RU, actionArchive, btnYes, driver);
       logger.info("Returned inside archive organization method");
       isOrganizationArchiveSuccessMessageDisplayed();	//TO VARIFIRY CONFIRMATION MESSAGESS
       return new PO_HomePage(driver);
   	}
   
   //TO RESTORE ORGANIZATION
   // THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
   public PO_HomePage restoreOrganization(String orgName) throws InterruptedException {
       logger.info("Restore organization method called");
       // METHODS TO RESTORE THE ORGANIZATION
       Action_Restore.restore(orgName, searchBox_RU, archivedLabel, btnAction_RU, actionRestore, btnYes, driver);
       logger.info("Returned inside restore organization method");
       isOrganizationRestoreSuccessMessageDisplayed(); //TO VARIFIRY CONFIRMATION MESSAGESS
       return new PO_HomePage(driver);
   }
   
   	//TO ACTIVATE ORGANIZATION
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage activateOrganization(String orgName) throws InterruptedException {
		logger.info("Activate organization methods called");
    	//METHODS TO ACTIVATE THE ORGANIZATION
		Action_Activate.activate(orgName, searchBox_RU, inactiveLabel, btnAction_RU, actionActivate, btnYes, driver);
    	 logger.info("Return back inside activate organization method");
    	 isOrganizationActivateSuccessMessageDisplayed();	//TO VARIFIRY CONFIRMATION MESSAGES
    	 return new PO_HomePage(driver);
	}
	
	
	//TO DEACTIVATE ORGANIZATION
	//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	public PO_HomePage deactivateOrganization(String orgName) throws InterruptedException {
		logger.info("De-Activate organization methods called");
    	//METHODS TO DEACTIVATE THE ORGANIZATION 
		Action_DeActivate.deactivate(orgName, searchBox_RU, activeLabel, btnAction_RU, actionDeactivate, btnYes, driver);
    	 logger.info("Return back inside deactivate organization method");
    	 isOrganizationDeactivateSuccessMessageDisplayed();	//TO VARIFIRY CONFIRMATION MESSAGES
    	 return new PO_HomePage(driver);
	}
	
	//TO EDIT ORGANIZATION
	public PO_HomePage editOragnization(String orgName, String newOrgCode, String newOrgEmail,String newOrgPhoneNumber, String newOrgAddress, String newOrgArea, String newOrgCity, String newOrgState, String newOrgPostalCode,String newOrgCountry, String newOrgTimeZone ) throws InterruptedException
	{ 	logger.info("Entered into edit organizatioin methods");
	
		//IT WILL SEARCH FIRST THE SEARCK KEY AND ONCE IT COMES AT THE TOP THEN ONLY IT WILL ABLE TO EDIT THE CORRECT PROJECT
	    ruae.searchBox_RU(orgName); // IT IS PRESENT AT RE USEABLE ELEMENT PACKAGE PAGE OBJECTS 
	    ruae.clickOnActionButton_RU();    // TO CLICK ON THE ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
	    ruae.clickOnEditAction_RU();	//IT WILL CLICK ON THE EDIT ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
		Thread.sleep(1000);
		
		//setOrgName(orgName);	// I AM NOT CHAGNING ORGANIZATION NAMES
		
		//TO CLEAR AND SET NEW TEXT
		callMeAlwaysDuringEditMethodJustBeforeSettingNewTextByPassingElementAdress(textEnterCode);
		setOrgCode(newOrgCode);	
		
		callMeAlwaysDuringEditMethodJustBeforeSettingNewTextByPassingElementAdress(textEnterEmail);
		setOrgEmail(newOrgEmail);
		
		callMeAlwaysDuringEditMethodJustBeforeSettingNewTextByPassingElementAdress(textEnterPhoneNumber);
		setOrgPhoneNumber(newOrgPhoneNumber);

		callMeAlwaysDuringEditMethodJustBeforeSettingNewTextByPassingElementAdress(textEnterAddress);
		setOrgAddress(newOrgAddress);
		
		callMeAlwaysDuringEditMethodJustBeforeSettingNewTextByPassingElementAdress(textEnterArea);
		setOrgArea(newOrgArea);
		
		callMeAlwaysDuringEditMethodJustBeforeSettingNewTextByPassingElementAdress(textEnterCity);
		setOrgCity(newOrgCity);
		
		callMeAlwaysDuringEditMethodJustBeforeSettingNewTextByPassingElementAdress(textEnterState);
		setOrgState(newOrgState);
		
		callMeAlwaysDuringEditMethodJustBeforeSettingNewTextByPassingElementAdress(textEnterPostalCode);
		setOrgPostalCode(newOrgPostalCode);
		
		callMeAlwaysDuringEditMethodJustBeforeSettingNewTextByPassingElementAdress(textEnterCountry);
		setOrgCountry(newOrgCountry);
		
		selectOrgTimeZone(newOrgTimeZone);

		ruae.clickOnBtnSaveChanges_RU(); //RU REPRESENT RE USEABLE ELEMENT
		return new PO_HomePage(driver);
	}
	
	//CALL THIS METHODS ALWAYS IN THE EDIT METHODS CALL JUST BEFORE SETTING NEW TEXT BY PASSING ELEMENT ADDRESS
	public void callMeAlwaysDuringEditMethodJustBeforeSettingNewTextByPassingElementAdress(WebElement elementAddress)
	{	//THIS METHOD WILL CLEAR THE ALREADY WRITTEN TEXT AND WAIT TILL IT IS NOT CLEARED AND JUST AFTER THIS METHOD CALL SET THE ACTION METHODS
		elementAddress.sendKeys(Keys.CONTROL + "a");
		elementAddress.sendKeys(Keys.DELETE);
		wait.until(ExpectedConditions.textToBePresentInElementValue(elementAddress, ""));
		logger.info("Text field cleared: "+elementAddress.getText());
	}
	
	
	
	//============START========CONFIRMATION MESSAGES FORM ORGANIZATIONS PAGE OBJECTS AND ITS ACTION METHODS============//
		//=========START===========ADDRESS==============//
		//ON ORGANIZATION UPDATE 
		String msgOrganizationUpdate_address =  "//div[contains(text(),'Organization Updated Successfully.')]";
		//ON ORGANIZATION CREATE
		String msgOrganizationCreate_address = "//div[contains(text(),'Organization Created Successfully.')]";
		//ON ORGANIZATIONDEACTIVATE
		String msgOrganizationDeactivate_address = "//div[contains(text(),'Organization Deactivated Successfully.')]";
		//ON ORGANIZATION ACTIVATE
		String msgOrganizationActivate_address = "//div[contains(text(),'Organization Activated Successfully.')]";
		//ON ORGANIZATION ARCHIVE
		String msgOrganizationArchive_address = "//div[contains(text(),'Organization Archived Successfully.')]";
		//ON ORGANIZATION RESTORE
		String msgOrganizationRestore_address = "//div[contains(text(),'Organization Restored Successfully.')]";
		//ON ORGANIZATION MENDATORY CONDITION
		String msgMendatoryCondition_address = "//p[contains(text(),'required')]";
		//===========END===========ADDRESS===========//
		
		//========START==========ACTIONS METHODS==========//
		//FOR ORGANIZATION UPDATE
		public boolean isOrganizationUpdateSuccessMessageDisplayed() {
			boolean flag = false;
			try {
				WebElement msgOrganizationUpdate = driver.findElement(By.xpath(msgOrganizationUpdate_address));
				wait.until(ExpectedConditions.visibilityOf(msgOrganizationUpdate));
		        if(msgOrganizationUpdate.isDisplayed()) {
		        	flag = true;
		        	logger.info("Confirmation message caught : "+msgOrganizationUpdate.getText());
		        }else {
		        	logger.info("Confirmation message not caught");
		        }
			}catch(Exception e) {
				logger.info(e);
			}
			
	        return flag;
	    }

		//FOR ORGANIZATION CREATE
	    public boolean isOrganizationCreateSuccessMessageDisplayed() {
	    	boolean flag = false;
	    	try {
	    		WebElement msgOrganizationCreate = driver.findElement(By.xpath(msgOrganizationCreate_address));
	    		wait.until(ExpectedConditions.visibilityOf(msgOrganizationCreate));
		    	if(msgOrganizationCreate.isDisplayed()) {
		        	flag = true;
		        	logger.info("Confirmation message caught : "+msgOrganizationCreate.getText());
		        }else {
		        	logger.info("Confirmation message not caught");
		        }
	    	}catch(Exception e) {
	    		logger.info(e);
	    	}
	    	
	        return flag;
	    }

	  //FOR ORGANIZATION DEACTIVATE
	    public boolean isOrganizationDeactivateSuccessMessageDisplayed() {
	    	boolean flag = false;
	    	try {
	    		WebElement msgOrganizationDeactivate = driver.findElement(By.xpath(msgOrganizationDeactivate_address));
	    		wait.until(ExpectedConditions.visibilityOf(msgOrganizationDeactivate));
		        if(msgOrganizationDeactivate.isDisplayed()) {
		        	flag = true;
		        	logger.info("Confirmation message caught : "+msgOrganizationDeactivate.getText());
		        }else {
		        	logger.info("Confirmation message not caught");
		        }
	    	}catch(Exception e)
	    	{
	    		logger.info(e);
	    	}
 
        	Assert.assertTrue(flag);	//TESTNG ASSERTION IT WILL REFLECT ON THE REPORT
	        return flag;
	    }

	  //FOR ORGANIZATION ACTIVATE
	    public boolean isOrganizationActivateSuccessMessageDisplayed() {
	    	boolean flag = false;
	    	try {
	    		WebElement msgOrganizationActivate = driver.findElement(By.xpath(msgOrganizationActivate_address));
	    		wait.until(ExpectedConditions.visibilityOf(msgOrganizationActivate));
		        if(msgOrganizationActivate.isDisplayed()) {
		        	flag = true;
		        	logger.info("Confirmation message caught : "+msgOrganizationActivate.getText());
		        }else {
		        	logger.info("Confirmation message not caught");
		        }
	    	}catch(Exception e) {
	    		logger.info(e);
	    	}
 
        	Assert.assertTrue(flag);	//TESTNG ASSERTION IT WILL REFLECT ON THE REPORT
	        return flag;
	    }

	  //FOR ORGANIZATION ARCHIVE
	    public boolean isOrganizationArchiveSuccessMessageDisplayed() {
	    	boolean flag = false;
	    	try {
	    		WebElement msgOrganizationArchive = driver.findElement(By.xpath(msgOrganizationArchive_address));
	    		wait.until(ExpectedConditions.visibilityOf(msgOrganizationArchive));
		        if(msgOrganizationArchive.isDisplayed()) {
		        	flag = true;
		        	logger.info("Confirmation message caught : "+msgOrganizationArchive.getText());
		        }else {
		        	logger.info("Confirmation message not caught");
		        }
	    	}catch(Exception e) {
	    		logger.info(e);
	    	}

        	Assert.assertTrue(flag);	//TESTNG ASSERTION IT WILL REFLECT ON THE REPORT
	        return flag;
	    }

	  //FOR ORGANIZATION RESTORE
	    public boolean isOrganizationRestoreSuccessMessageDisplayed() {
	    	boolean flag = false;
	    	try {
	    		WebElement msgOrganizationRestore = driver.findElement(By.xpath(msgOrganizationRestore_address));
	    		wait.until(ExpectedConditions.visibilityOf(msgOrganizationRestore));
		        if(msgOrganizationRestore.isDisplayed()) {
		        	flag = true;
		        	logger.info("Confirmation message caught : "+msgOrganizationRestore.getText());
		        }else {
		        	logger.info("Confirmation message not caught");
		        }
	    	}catch(Exception e) {
	    		logger.info(e);
	    	}

        	Assert.assertTrue(flag);	//TESTNG ASSERTION IT WILL REFLECT ON THE REPORT
	        return flag;
	    }
	    
	  //FOR ORGANIZATION MANDATORY FILED
	    public boolean isMedatoryMessageDisplayed() {
	    	boolean flag = false;
			try {
				WebElement msgMendatoryCondition = driver.findElement(By.xpath(msgMendatoryCondition_address));
				wait.until(ExpectedConditions.visibilityOf(msgMendatoryCondition));
		        if(msgMendatoryCondition.isDisplayed()) {
		        	flag = true;
		        	logger.info("Required message caught : "+msgMendatoryCondition.getText());
		        }else {
		        	logger.info("Required message not caught");
		        }
			}catch(Exception e){
				logger.info(e);
			}

        	Assert.assertTrue(flag);	//TESTNG ASSERTION IT WILL REFLECT ON THE REPORT
	        return flag;
	    }
	  //========END==========ACTIONS METHODS==========//
	  //============START========CONFIRMATION MESSAGES FORM ORGANIZATIONS PAGE OBJECTS AND ITS ACTION METHODS============//
}
