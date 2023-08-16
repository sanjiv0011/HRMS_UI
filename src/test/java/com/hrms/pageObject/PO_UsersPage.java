package com.hrms.pageObject;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

import my_support.Action_Activate;
import my_support.Action_Archive;
import my_support.Action_DeActivate;
import my_support.Action_Restore;
import my_support.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_UsersPage extends ReUseAbleElement{
	
	//CONSTRUCTOR AND OTHRE VARIABLE INITIALIZATION
	public WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public Logger logger = LogManager.getLogger(getClass());
	
	//APPLY PAGE FACTORY CONCEPT THRUGH INHERITANCE(RE USE ABLE ELEMENT CLASS)
	public PO_UsersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		
	}
	
	//=====START====PROJECTS PAGE OBJECTS AND ITS ACTION METHODS============//
		//CREATE USERS BUTTON ADDRESS
		@FindBy(xpath = "//p[normalize-space()='Create User']")
		@CacheLookup
		WebElement btnCreateUser;
		public void clickOnBtnCreateUser() throws InterruptedException {
	        btnCreateUser.click();
	        logger.info("Clicked on the create user button");
	        Thread.sleep(1000);     
	    }
		
		//TAB USERS DETAILS ADDRESS
		@FindBy(xpath = "(//button[normalize-space()='User Details'])[1]")
		@CacheLookup
		WebElement tabUserDetails;
		public void clickOnTabUserDetails() throws InterruptedException {
	        tabUserDetails.click();
	        logger.info("Clicked on the user details page");
	        Thread.sleep(1000);
	    }
		
		//TAB PERMISSIONS ADDRESS
		@FindBy(xpath = "(//button[normalize-space()='Permissions'])[1]")
		@CacheLookup
		WebElement tabPermissions;
		public void clickOnTabPermissions() throws InterruptedException {
	        tabPermissions.click();
	        logger.info("Clicked on the permissions tab");
	        Thread.sleep(1000);
	    }
		
		//TEXT FIELD USER NAME ADDRESS
		@FindBy(xpath = "//input[@name='userName']")
		@CacheLookup
		WebElement textUserName;
		public void setUserName(String userName) throws InterruptedException {
	        textUserName.sendKeys(userName);
	        logger.info("Entered username");
	        Thread.sleep(1000);
	    }
		
		//TEXT FIELD USER NAME ADDRESS
		@FindBy(xpath = "//input[@name=\"password\"]")
		@CacheLookup
		WebElement textPassword;
		public void setPassword(String password) throws InterruptedException {
		    textPassword.sendKeys(password);
		    logger.info("Entered password");
	        Thread.sleep(1000);
		}
		
		//DROPDOWN LIST FOR THE ORGANIZATIONS ADDRESS
		@FindBy(xpath = "//input[@id='organizations']")
		@CacheLookup
		WebElement btnDropdownOrganization;
		public void clickOnDropdownBtnOrganization() throws InterruptedException {
		    btnDropdownOrganization.click();
		    Thread.sleep(1000);
		    logger.info("Clicked on the dropdown organizations");
	        Thread.sleep(1000);
		}
		
		//LIST ORGANIZATIONS ADDRESS
		@FindBy(xpath = "//ul[@id='organizations-listbox']//li")
		@CacheLookup
		public List <WebElement> orgnizationsList;
		public void selectOrganization(String organizationName) throws InterruptedException {
			clickOnDropdownBtnOrganization();
			//THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE
		    Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(orgnizationsList, organizationName);
		    logger.info("Organization name selected");
		    Thread.sleep(1000);
	    }
		
		//TEXT FIELD USER FIRST NAME ADDRESS
		@FindBy(xpath = "//input[@name='firstName']")
		@CacheLookup
		WebElement textFirstName;
		public void setFirstName(String firstName) throws InterruptedException {
	        textFirstName.sendKeys(firstName);
	        logger.info("Entered first name");
	        Thread.sleep(1000);
	    }
		
		//TEXT FIELD USER LAST NAME ADDRESS
		@FindBy(xpath = "//input[@name=\"lastName\"]")
		@CacheLookup
		WebElement textLastName;
		public void setLastName(String lastName) throws InterruptedException {
		   textLastName.sendKeys(lastName);
		   logger.info("Entered Last name");
	        Thread.sleep(1000);
		}
		
				
		//TEXT FIELD EMAIL ADDRESS ADDRESS
		@FindBy(xpath = "//input[@name='emailAddress']")
		@CacheLookup
		WebElement textEmailAddress;
		public void setEmailAddress(String emailAddress) throws InterruptedException {
	        textEmailAddress.sendKeys(emailAddress);
	        logger.info("Entered email address");
	        Thread.sleep(1000);
	    }
		
		//DROPDOWN FIELD USER ROLE ADDRESS
		@FindBy(xpath = "//input[@id='userRoles']")
		@CacheLookup
		WebElement btnDropdownUserRole;
		public void clickOnDropdownUserRole() throws InterruptedException {
		    btnDropdownUserRole.click();
		    logger.info("Clicked on the User roles dropdown");
	        Thread.sleep(1000);
		}
		
		//USER ROLES LIST ADDRESS
		@FindBy(xpath = "//ul[@id='userRoles-listbox']//li")
		@CacheLookup
		public List <WebElement> listUserRoles;
		public void selectUserRole(String userRole) throws InterruptedException {
			clickOnDropdownUserRole();
			//THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE
		    Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listUserRoles, userRole);
		    logger.info("User roles selected");
		    Thread.sleep(1000);
	    }
	//=====END====PROJECTS PAGE OBJECTS AND ITS ACTION METHODS============//
	
	
		//CREATE USERS
		public PO_HomePage createUser(String userNameToCreate, String passwordToCreate, String organizationName, String firstName, String lastName, String emailAddress, String userRole) throws InterruptedException
		{
			clickOnBtnCreateUser(); 
			clickOnTabUserDetails();
			setUserName(userNameToCreate);
			setPassword(passwordToCreate);
			selectOrganization(organizationName);
			setFirstName(firstName);
			setLastName(lastName);
			setEmailAddress(emailAddress);
			selectUserRole(userRole);
			ruae.clickOnBtnSaveAndGoToHome_RU();
			return new PO_HomePage(driver);
		}
		
		
			//TO ARCHIVE USER
			// THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
		   	public PO_HomePage archiveUser(String uname) throws InterruptedException {
		       logger.info("Archive user method called");
	
		       // METHODS TO ARCHIVE THE PROJECT
		       Action_Archive.archive(uname, searchBox, archivedLabel, btnAction, actionArchive, btnYes, "confirmMessage");
		       logger.info("Returned inside archive user method");
		       return new PO_HomePage(driver);
		   	}
		   
		   //TO RESTORE USER
		   // THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
		   public PO_HomePage restoreUser(String uname) throws InterruptedException {
		       logger.info("Restore user method called");

		       // METHODS TO RESTORE THE PROJECT
		       Action_Restore.restore(uname, searchBox, archivedLabel, btnAction, actionRestore, btnYes, "confirmMessage");
		       logger.info("Returned inside restore user method");
		       return new PO_HomePage(driver);
		   }
		   
		   	//TO ACTIVATE USER
			//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
			public PO_HomePage activateUser(String uname) throws InterruptedException{
				logger.info("Activate user methods called");
		    	
		    	//METHODS TO ACTIVATE THE USER
				Action_Activate.activate(uname, searchBox, inactiveLabel, btnAction, actionActivateUser, btnYes, "cofirmMessage");
		    	 logger.info("Return back inside activate user method");
		    	 return new PO_HomePage(driver);
			}
			
			
			//TO DEACTIVATE USER
			//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
			public PO_HomePage deactivateUser(String uname) throws InterruptedException{
				logger.info("De-Activate user methods called");
		    	
		    	//METHODS TO DEACTIVATE THE USER 
				Action_DeActivate.deactivate(uname, searchBox, activeLabel, btnAction, actionDeactivateUser, btnYes, "cofirmMessage");
		    	 logger.info("Return back inside deactivate user method");
		    	 return new PO_HomePage(driver);
			}
			
			//EDIT USERS
			public PO_HomePage editUser(String uname,String newUName, String organizationName, String firstName, String lastName, String emailAddress, String userRole) throws InterruptedException
			{	logger.info("Entered edit user methods");
			   	Thread.sleep(2000);
			   	
			    //IT WILL SEARCH FIRST THE SEARCK KEY AND ONCE IT COMES AT THE TOP THEN ONLY IT WILL ABLE TO EDIT THE CORRECT PROJECT
			    ruae.searchBox_RU(uname); // IT IS PRESENT AT RE USEABLE ELEMENT PACKAGE PAGE OBJECTS 
			    ruae.clickOnActionButton_RU();    // TO CLICK ON THE ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
			    ruae.clickOnEditAction_RU();	//IT WILL CLICK ON THE EDIT ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
				clickOnBtnCreateUser(); 
				clickOnTabUserDetails();
				setUserName(newUName);
				selectOrganization(organizationName);
				setFirstName(firstName);
				setLastName(lastName);
				setEmailAddress(emailAddress);
				selectUserRole(userRole);
				ruae.clickOnBtnSaveAndGoToHome_RU();
				return new PO_HomePage(driver);
			}
		
	    

	    

	    

	   

	   

	    

	    

	   

	    

	   

	    

		
}
