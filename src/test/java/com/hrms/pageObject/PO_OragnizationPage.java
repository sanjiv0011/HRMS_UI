package com.hrms.pageObject;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.Actions.Action_Activate;
import com.hrms.Actions.Action_Archive;
import com.hrms.Actions.Action_Created;
import com.hrms.Actions.Action_Deactivate;
import com.hrms.Actions.Action_Restore;
import com.hrms.Actions.Action_Updated;
import com.hrms.DataBaseTesting.DB_Testing_Action_Activate;
import com.hrms.DataBaseTesting.DB_Testing_Action_Archive;
import com.hrms.DataBaseTesting.DB_Testing_Action_Deactivate;
import com.hrms.DataBaseTesting.DB_Testing_Action_Restore;
import com.hrms.DataBaseTesting.DB_Testing_Organization_CreateAndUpdate;
import com.hrms.ReUseAble.PageObject.ReUseAbleElement;
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

	//CONSTRUCTOR DECLARATION AND INITIALIZATON FOR ACTIONS
	public Action_Activate actionActivate = new Action_Activate();
	public Action_Deactivate actionDeactivate = new Action_Deactivate();
	public Action_Archive actionArchive = new Action_Archive();
	public Action_Restore actionRestore = new Action_Restore();
	public Action_Created confirmationCreated = new Action_Created();
	public Action_Updated confirmationUpdated = new Action_Updated();
	
	//ALERT MESSAGES
	String alertRestored_org = "Organization Restored Successfully.";
	String alertArchived_org = "Organization Archived Successfully.";
	String alertCreated_org = "Organization Created Successfully.";
	String alertUpdated_org = "Organization Updated Successfully.";
	String alertDeactivated_org = "Organization Deactivated Successfully.";
	String alertActivated_org = "Organization Activated Successfully.";
	String alertAleradyExist_org = "LeaOrganizationve already exists.";
	
	//CONSTRUCTOR DECLARATION AND INITIALIAZATION FOR DATA BASE ACTIONS
	public DB_Testing_Action_Archive  db_actionArchive = new DB_Testing_Action_Archive();
	public DB_Testing_Action_Restore  db_actionRestore = new DB_Testing_Action_Restore();
	public DB_Testing_Action_Activate  db_actionActivate = new DB_Testing_Action_Activate();
	public DB_Testing_Action_Deactivate  db_actionDeactivate = new DB_Testing_Action_Deactivate();
	public DB_Testing_Organization_CreateAndUpdate db_orgCreateUpdate = new DB_Testing_Organization_CreateAndUpdate();
	
	
		
	
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
		textEnterName.sendKeys(Keys.CONTROL,"a");
		textEnterName.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textEnterName.sendKeys(orgName);
		Thread.sleep(300);
		logger.info("Enterd org name");
	}
	
	public void setOrgCode(String orgCode) throws InterruptedException{
		textEnterCode.sendKeys(Keys.CONTROL,"a");
		textEnterCode.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textEnterCode.sendKeys(orgCode);
		Thread.sleep(300);
		logger.info("Enterd org code");
	}
	
	public void setOrgEmail(String orgEmail) throws InterruptedException{
		textEnterEmail.sendKeys(Keys.CONTROL,"a");
		textEnterEmail.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textEnterEmail.sendKeys(orgEmail);
		Thread.sleep(300);
		logger.info("Enterd org email");
	}
	
	public void setOrgPhoneNumber(String orgPhoneNumber) throws InterruptedException{
		textEnterPhoneNumber.sendKeys(Keys.CONTROL,"a");
		textEnterPhoneNumber.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textEnterPhoneNumber.sendKeys(orgPhoneNumber);
		Thread.sleep(300);
		logger.info("Enterd org phone number");
	}
	
	public void setOrgAddress(String orgAddress) throws InterruptedException{
		textEnterAddress.sendKeys(Keys.CONTROL,"a");
		textEnterAddress.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textEnterAddress.sendKeys(orgAddress);
		Thread.sleep(300);
		logger.info("Enterd org address");
	}
	
	public void setOrgArea(String orgArea) throws InterruptedException{
		textEnterArea.sendKeys(Keys.CONTROL,"a");
		textEnterArea.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textEnterArea.sendKeys(orgArea);
		Thread.sleep(300);
		logger.info("Enterd org area");
	}
	
	public void setOrgCity(String orgCity) throws InterruptedException{
		textEnterCity.sendKeys(Keys.CONTROL,"a");
		textEnterCity.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textEnterCity.sendKeys(orgCity);
		Thread.sleep(300);
		logger.info("Enterd org city");
	}
	
	public void setOrgState(String orgState) throws InterruptedException{
		textEnterState.sendKeys(Keys.CONTROL,"a");
		textEnterState.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textEnterState.sendKeys(orgState);
		Thread.sleep(300);
		logger.info("Enterd org  state");
	}
	
	public void setOrgPostalCode(String orgPostalCode) throws InterruptedException{
		textEnterPostalCode.sendKeys(Keys.CONTROL,"a");
		textEnterPostalCode.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textEnterPostalCode.sendKeys(orgPostalCode);
		Thread.sleep(300);
		logger.info("Enterd org postal code");
	}
	
	public void setOrgCountry(String orgCountry) throws InterruptedException{
		textEnterCountry.sendKeys(Keys.CONTROL,"a");
		textEnterCountry.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textEnterCountry.sendKeys(orgCountry);
		Thread.sleep(300);
		logger.info("Enterd org  country");
	}
	
	public void clickOnIconDropdownTimeZone() throws InterruptedException{
		iconDropdownTimeZone.click();
		Thread.sleep(300);
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
	public PO_HomePage createOragnization(String orgName, String orgCode, String orgEmail, String orgPhoneNumber, String orgAddress, String orgArea, String orgCity, String orgState, String orgPostalCode,String orgCountry, String orgTimeZone ) throws InterruptedException, SQLException
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
		//FOR CONFIRMATION
		boolean flag = confirmationCreated.created(driver, alertCreated_org, alertAleradyExist_org);

		//DATABASE TESTING
		if(flag) {
			db_orgCreateUpdate.test_DB_CreateOrganization(orgName, orgCode, orgEmail, orgPhoneNumber, orgAddress, orgArea, orgCity, orgState, orgPostalCode, orgCountry, orgTimeZone);
		}
		logger.info("createOragnization call DONE");
		return new PO_HomePage(driver); 
	}
	
	//TO ARCHIVE ORGANIZATION
   	public PO_HomePage archiveOrganization(String orgName) throws InterruptedException, SQLException {
       logger.info("Archive organization method called");
       //TO ARCHIVE
       boolean flag = actionArchive.archive(orgName, driver, alertArchived_org);
       String searchString_DB_ColumnName = "name";
       //DATABASE TESTING
       if(flag) {
    	   String querry = "select * from public.organizations order by updated_at desc limit 1";
    	   db_actionArchive.test_DB_Archive(orgName,querry,searchString_DB_ColumnName);
       }
       logger.info("archiveOrganization call DONE");
       return new PO_HomePage(driver);
   	}
   
   //TO RESTORE ORGANIZATION
   public PO_HomePage restoreOrganization(String orgName) throws InterruptedException, SQLException {
        logger.info("Restore organization method called");
        //TO RESTORE
        boolean flag = actionRestore.restore(orgName, driver,alertRestored_org );
        String searchString_DB_ColumnName = "name";
   		//DATABASE TESTING
        if(flag) {
        	String querry = "select * from public.organizations order by updated_at desc limit 1";
        	db_actionRestore.test_DB_Restore(orgName,querry,searchString_DB_ColumnName);
        }
   		logger.info("restoreOrganization call DONE");
   		return new PO_HomePage(driver);
   }
   
   	//TO ACTIVATE ORGANIZATION
	public PO_HomePage activateOrganization(String orgName) throws InterruptedException, SQLException {
		logger.info("Activate organization methods called");
		//TO  ACTIVATE
		boolean flag = actionActivate.activate(orgName, driver, alertActivated_org);
		String searchString_DB_ColumnName = "name";
		//DATABASE TESTING
        if(flag) {
        	String querry = "select * from public.organizations order by updated_at desc limit 1";
        	db_actionActivate.test_DB_Activate(orgName,querry,searchString_DB_ColumnName);
        }
		logger.info("activateOrganization call DONE");
    	return new PO_HomePage(driver);
	}
	
	
	//TO DEACTIVATE ORGANIZATION
	public PO_HomePage deactivateOrganization(String orgName) throws InterruptedException, SQLException {
		logger.info("De-Activate organization methods called");
		//TO DEACTIVATE
		boolean flag = actionDeactivate.deactivate(orgName, driver, alertDeactivated_org);
		String searchString_DB_ColumnName = "name";
		//DATABASE TESTING
        if(flag) {
        	String querry = "select * from public.organizations order by updated_at desc limit 1";
        	db_actionDeactivate.test_DB_Deactivate(orgName,querry,searchString_DB_ColumnName);
        }
		logger.info("deactivateOrganization call DONE");
		return new PO_HomePage(driver);
	}
	
	//TO EDIT ORGANIZATION
	public PO_HomePage editOragnization(String orgName, String newOrgCode, String newOrgEmail,String newOrgPhoneNumber, String newOrgAddress, String newOrgArea, String newOrgCity, String newOrgState, String newOrgPostalCode,String newOrgCountry, String newOrgTimeZone ) throws InterruptedException, SQLException
	{ 	logger.info("Entered into edit organizatioin methods");
	
		//IT WILL SEARCH FIRST THE SEARCK KEY AND ONCE IT COMES AT THE TOP THEN ONLY IT WILL ABLE TO EDIT THE CORRECT PROJECT
	    ruae.searchBox_RU(orgName); // IT IS PRESENT AT RE USEABLE ELEMENT PACKAGE PAGE OBJECTS 
	    ruae.clickOnActionButton_RU();    // TO CLICK ON THE ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
	    ruae.clickOnEditAction_RU();	//IT WILL CLICK ON THE EDIT ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
		Thread.sleep(1000);
		
		setOrgName(orgName);	
		setOrgCode(newOrgCode);	
		setOrgEmail(newOrgEmail);
		setOrgPhoneNumber(newOrgPhoneNumber);
		setOrgAddress(newOrgAddress);
		setOrgArea(newOrgArea);
		setOrgCity(newOrgCity);
		setOrgState(newOrgState);
		setOrgPostalCode(newOrgPostalCode);
		setOrgCountry(newOrgCountry);		
		selectOrgTimeZone(newOrgTimeZone);
		ruae.clickOnBtnSaveChanges_RU(); //RU REPRESENT RE USEABLE ELEMENT
		boolean flag = confirmationUpdated.updated(driver, alertUpdated_org,alertAleradyExist_org);
		
		//DATABASE TESTING
        if(flag) {
        	db_orgCreateUpdate.test_DB_CreateOrganization(orgName, newOrgCode, newOrgEmail, newOrgPhoneNumber, newOrgAddress, newOrgArea, newOrgCity, newOrgState, newOrgPostalCode, newOrgCountry, newOrgTimeZone);
        }
		logger.info("editOragnization call DONE");
		
		return new PO_HomePage(driver);
	}	
}
