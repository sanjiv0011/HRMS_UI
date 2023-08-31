package com.hrms.pageObject;

import java.sql.SQLException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.Actions.Action_Archive;
import com.hrms.Actions.Action_Created;
import com.hrms.Actions.Action_Restore;
import com.hrms.Actions.Action_Updated;
import com.hrms.DataBaseTesting.DB_Testing_Action_Activate;
import com.hrms.DataBaseTesting.DB_Testing_Action_Archive;
import com.hrms.DataBaseTesting.DB_Testing_Action_Deactivate;
import com.hrms.DataBaseTesting.DB_Testing_Action_Restore;
import com.hrms.DataBaseTesting.DB_Testing_Client_CreateAndUpdate;
import com.hrms.DataBaseTesting.DB_Testing_Organization_CreateAndUpdate;
import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

public class PO_ClientPage extends ReUseAbleElement {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public Actions actoin = null;
	public WebDriverWait wait = null;
	
	public PO_ClientPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
        ruae = new ReUseAbleElement(driver);
        action = new Actions(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//ACTION OPTIONS CONSTRUCTOR
	public Action_Archive actionArchive = new Action_Archive();
	public Action_Restore actionRestore = new Action_Restore();
	public Action_Created confirmationCreated = new Action_Created();
	public Action_Updated confirmationUpdated = new Action_Updated();
	
	//CLIENT ALERT MESSAGES
	String alertRestored_cl = "Client Restored Successfully.";
	String alertArchived_cl = "Client Archived Successfully.";
	String alertCreated_cl = "Client Created Successfully.";
	String alertUpdated_cl = "Client Updated Successfully.";
	String alertAleradyExist_cl = "Client already exists.";
			
	//CONSTRUCTOR DECLARATION AND INITIALIAZATION FOR DATA BASE ACTIONS
	public DB_Testing_Action_Archive  db_actionArchive = new DB_Testing_Action_Archive();
	public DB_Testing_Action_Restore  db_actionRestore = new DB_Testing_Action_Restore();
	public DB_Testing_Action_Activate  db_actionActivate = new DB_Testing_Action_Activate();
	public DB_Testing_Action_Deactivate  db_actionDeactivate = new DB_Testing_Action_Deactivate();
	public DB_Testing_Client_CreateAndUpdate db_clientCreateUpdate = new DB_Testing_Client_CreateAndUpdate();
	
	
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

	//=====END====CLIENT PAGE OBJECTS============//
	
	//=====START====CLIENT PAGE OBJECTS ACTIONS METHODS ============//
	//TO CLICKL ON THE CREATE CLIENT BUTTON
	public void clickOnBtnCreateClient() throws InterruptedException{
		btnCreateClient.click();
		Thread.sleep(1000);
		logger.info("Click on Create client button");
	}
	
	//TO SET CLIENT DESCRIPTION
	public void setClientDescription(String clientDescription) throws InterruptedException{
		textEnterDescripton.sendKeys(Keys.CONTROL,"a");
		textEnterDescripton.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textEnterDescripton.sendKeys(clientDescription);
		logger.info("Enterd client description");
		Thread.sleep(200);
	}
	
	//TO SET CLEINT NAME
	public void setClientName(String clientName) throws InterruptedException{
		textEnterName.sendKeys(Keys.CONTROL,"a");
		textEnterName.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textEnterName.sendKeys(clientName);
		Thread.sleep(200);
		logger.info("Enterd client name");
	}
	

	//=====END====CLIENT PAGE OBJECTS ACTIONS METHODS============//
	
	
	//TO CREATE CLIENT 
	public PO_HomePage createClient(String clientName, String clientDescription) throws InterruptedException, SQLException {	
		clickOnBtnCreateClient();
		setClientName(clientName);
		setClientDescription(clientDescription);
		ruae.clickOnCreateButton_RU();
		boolean flag = confirmationCreated.created(driver, alertCreated_cl, alertAleradyExist_cl);
		//DATABASE TESTING
		if(flag) {
			db_clientCreateUpdate.test_DB_CreateClient(clientName, clientDescription);
		}
		logger.info("createClient call DONE");
				
		return new PO_HomePage(driver);	
	}
	

	//METHODS TO ARCHIVE THE CLEINT 
	public PO_HomePage archiveClient(String clientName) throws InterruptedException, SQLException {	
		logger.info("Archive Client methods called");
		boolean flag = actionArchive.archive(clientName, driver, alertArchived_cl);
		//DATABASE TESTING
		String searchString_DB_ColumnName = "cleint_name";
	    if(flag) {
    	   String querry = "select * from public.client order by updated_at desc limit 1";
    	   db_actionArchive.test_DB_Archive(clientName,querry,searchString_DB_ColumnName);
        }
	    logger.info("archiveClient call DONE");
    	return new PO_HomePage(driver);
	}
	
	
	//METHODS TO RESTORE THE CLIENT
	public PO_HomePage restoreClient(String clientName) throws InterruptedException, SQLException {
		logger.info("Restore Client methods called");
		boolean flag = actionRestore.restore(clientName, driver,alertRestored_cl );
		
		//DATABASE TESTING
		String searchString_DB_ColumnName = "cleint_name";
        if(flag) {
        	String querry = "select * from public.client order by updated_at desc limit 1";
        	db_actionRestore.test_DB_Restore(clientName,querry,searchString_DB_ColumnName);
        }
   		logger.info("restoreClient call DONE");
   		
		return new PO_HomePage(driver);
	}
	
	//USE TO EDIT THE CLIENT
	public PO_HomePage editClient(String clientNameSearchKey, String clientDescription, String clientName) throws InterruptedException, SQLException
	{	logger.info("Entered edit job titles methods");
		//IT WILL SEARCH FIRST THE SEARCK KEY AND ONCE IT COMES AT THE TOP THEN ONLY IT WILL ABLE TO EDIT THE CORRECT PROJECT
	    ruae.searchBox_RU(clientNameSearchKey); // IT IS PRESENT AT RE USEABLE ELEMENT PACKAGE PAGE OBJECTS 
	    ruae.clickOnActionButton_RU();    // TO CLICK ON THE ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
	    ruae.clickOnEditAction_RU();	//IT WILL CLICK ON THE EDIT ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
	    Thread.sleep(2000);
	    setClientName(clientName);
	    setClientDescription(clientDescription);
	    ruae.clickOnBtnSaveChanges_RU();
		boolean flag = confirmationUpdated.updated(driver, alertUpdated_cl, alertAleradyExist_cl);
		
		//DATABASE TESTING
        if(flag) {
        	db_clientCreateUpdate.test_DB_CreateClient(clientName, clientDescription);
        }
		logger.info("editClient call DONE");
		
		return new PO_HomePage(driver);
	}
		
	
}
