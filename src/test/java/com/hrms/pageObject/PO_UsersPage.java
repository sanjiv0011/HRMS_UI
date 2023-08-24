package com.hrms.pageObject;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

import projectUtility.Action_Activate;
import projectUtility.Action_Archive;
import projectUtility.Action_DeActivate;
import projectUtility.Action_Restore;
import projectUtility.DatePicker;
import projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_UsersPage extends ReUseAbleElement{
	
	//CONSTRUCTOR AND OTHRE VARIABLE DECLARATIOIN
	public WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public Runtime runtime;
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
		
		//TAB PERMISSIONS ADDRESS(FOR NORMAL USE)
		@FindBy(xpath = "(//button[normalize-space()='Permissions'])[1]")
		@CacheLookup
		WebElement tabPermissions;
		public void clickOnTabPermissions() throws InterruptedException {
	        tabPermissions.click();
	        logger.info("Clicked on the permissions tab");
	        Thread.sleep(1000);
	    }
		
		//TAB PERMISSIONS ADDRESS WITH RETURN TYPE(PERMISSIONS PAGE OBJECTS)
		@FindBy(xpath = "(//button[normalize-space()='Permissions'])[1]")
		@CacheLookup
		WebElement tabPermissionsReturnTypePermissionPage;
		public PO_UserPermissions clickOnTabPermissions_ReturnTypePermissionPage() throws InterruptedException {
			tabPermissionsReturnTypePermissionPage.click();
	        logger.info("Clicked on the permissions tab");
	        Thread.sleep(1000);
	        return new PO_UserPermissions(driver);
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
	
	
		//CREATE USERS WITH RETURN TYPE(PO_HomePage)
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
			
			ruae.clickOnBtnSaveAndGoToHome_1_RU();

			return new PO_HomePage(driver);
		}
		
		//CREATE USERS WITH RETURN TYPE(PO_UserPermissions)
		public PO_UserPermissions createUser_ReturnType_PO_UserPermissions(String userNameToCreate, String passwordToCreate, String organizationName, String firstName, String lastName, String emailAddress, String userRole) throws InterruptedException
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
			ruae.clickOnBtnNext_1_RU();

			return new PO_UserPermissions(driver);
		}
		
			//TO ARCHIVE USER
			// THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
		   	public PO_HomePage archiveUser(String uname) throws InterruptedException {
		       logger.info("Archive user method called");
	
		       // METHODS TO ARCHIVE THE USER
		       Action_Archive.archive(uname, searchBox_RU, archivedLabel, btnAction_RU, actionArchive, btnYes, "confirmMessage");
		       logger.info("Returned inside archive user method");
		       return new PO_HomePage(driver);
		   	}
		   
		   //TO RESTORE USER
		   // THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
		   public PO_HomePage restoreUser(String uname) throws InterruptedException {
		       logger.info("Restore user method called");

		       // METHODS TO RESTORE THE USER
		       Action_Restore.restore(uname, searchBox_RU, archivedLabel, btnAction_RU, actionRestore, btnYes, "confirmMessage");
		       logger.info("Returned inside restore user method");
		       return new PO_HomePage(driver);
		   }
		   
		   	//TO ACTIVATE USER
			//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
			public PO_HomePage activateUser(String uname) throws InterruptedException{
				logger.info("Activate user methods called");
		    	
		    	//METHODS TO ACTIVATE THE USER
				Action_Activate.activate(uname, searchBox_RU, inactiveLabel, btnAction_RU, actionActivateUser, btnYes, "cofirmMessage");
		    	 logger.info("Return back inside activate user method");
		    	 return new PO_HomePage(driver);
			}
			
			
			//TO DEACTIVATE USER
			//THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
			public PO_HomePage deactivateUser(String uname) throws InterruptedException{
				logger.info("De-Activate user methods called");
		    	
		    	//METHODS TO DEACTIVATE THE USER 
				Action_DeActivate.deactivate(uname, searchBox_RU, activeLabel, btnAction_RU, actionDeactivateUser, btnYes, "cofirmMessage");
		    	 logger.info("Return back inside deactivate user method");
		    	 return new PO_HomePage(driver);
			}
			
			//EDIT USERS
			public PO_HomePage editUser(String uname,String newUName, String newOrganizationName, String NewFirstName, String newLastName, String newEmailAddress,String newUserRole) throws InterruptedException
			{	logger.info("Entered edit user methods");
			   	Thread.sleep(2000);
			   	
			    //IT WILL SEARCH FIRST THE SEARCK KEY AND ONCE IT COMES AT THE TOP THEN ONLY IT WILL ABLE TO EDIT THE CORRECT PROJECT
			    ruae.searchBox_RU(uname); // IT IS PRESENT AT RE USEABLE ELEMENT PACKAGE PAGE OBJECTS 
			    ruae.clickOnActionButton_RU();    // TO CLICK ON THE ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
			    ruae.clickOnEditAction_RU();	//IT WILL CLICK ON THE EDIT ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
				//clickOnTabUserDetails();
				Thread.sleep(1000);
			
				textUserName.clear(); //CLAER FIRST
				textUserName.sendKeys(newUName);
		        logger.info("Entered username");
		        Thread.sleep(1000);
		        
		        btnDropdownOrganization.clear(); //CLAER FIRST
		        Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(orgnizationsList, newOrganizationName);
			    logger.info("Organization name selected");
			    Thread.sleep(1000);
			    
			    textFirstName.click();
				setFirstName(NewFirstName);
				textLastName.clear();
				setLastName(newLastName);
				textEmailAddress.clear();
				setEmailAddress(newEmailAddress);
				btnDropdownUserRole.click();
				selectUserRole(newUserRole);
				ruae.clickOnBtnSaveAndGoToHome_1_RU();
				return new PO_HomePage(driver);
			}
		
	//===========START==========PROJECT ASSIGNMENT PAGE OBJECTS AND ITS ACTIONS METHODS===========//
		   //ASSIGN USER TO THE PROJECT  ADDRESS
		   @FindBy(xpath="(//p[contains(text(),'Assign Project')])[1]")
		   @CacheLookup
		   WebElement btnAssignProject;
		   public void clickOnAssignProjectBtn() throws InterruptedException{
			   btnAssignProject.click();
			   Thread.sleep(1000);
			   logger.info("Clicked on the assign project button");
		   }
		   
		   //DROPDOWN ICON ADDRESS FOR PROJECTS SELECTION
		   @FindBy(xpath="//button[@title='Open']//*[name()='svg']")
		   @CacheLookup
		   WebElement iconProjectDropdown;
		   public void clickOnProjectDropdownIcon() throws InterruptedException{
			   iconProjectDropdown.click();
			   Thread.sleep(1000);
			   logger.info("Clicked on the dropdown icon for the project selection");
		   }
		   
		   //PROJECT LIST ADDRESS TO ASSIGN THE PROJECT TO THE USER
		   @FindBy(xpath="//ul[@id='project-listbox']//li")
		   @CacheLookup
		   public List <WebElement> listProjectToAssingUser;
		   public void selectUserForProjectAssignment(String projectName) throws InterruptedException{
			   clickOnProjectDropdownIcon(); // IT CLICK ON THE DROPDWON SELECT PROJECT
			   Thread.sleep(500);
			   //THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE
			   Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listProjectToAssingUser, projectName);
			   Thread.sleep(1000);
			   logger.info("Project selected to assign the user");
		   }
		   
		 //ASSIGN BUTTON ADDRESS
		   @FindBy(xpath="//p[normalize-space()='Assign']")
		   @CacheLookup
		   WebElement btnAssign;
		   public void clickOnBtnAssign() throws InterruptedException{
			   btnAssign.click();
			   Thread.sleep(1000);
			   logger.info("Click on the button assign");
		   }
		   
			//START DATE ICON ADDRESS
			@FindBy(xpath = "(//button[contains(@aria-label,'Choose date')])[1]")
			@CacheLookup
			WebElement iconDateStart;
			//ACTION METHOD TO CLICK ON THE PROJECT START DATE ICON
			public void clickOnStartDateIcon() throws InterruptedException {
				iconDateStart.click();
			    logger.info("Clicked on the start date icon");
			    Thread.sleep(1000);
			}
			
			//END DATE ICON ADDRESS
			@FindBy(xpath = "(//button[contains(@aria-label,'Choose date')])[2]")
			@CacheLookup
			WebElement iconDateEnd;
			//ACTION METHOD TO CLICK ON THE PROJECT END DATE ICON
			public void clickEndDateIcon() throws InterruptedException {
				iconDateEnd.click();
			    logger.info("Clicked on the end date icon");
			    Thread.sleep(1000);
			}
			
			//ACTION METHOD TO SELECT THE PROJECT START DATE
			public void selectStartDate(String projectStartDate, int x) throws InterruptedException {
				
				//THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE AND CORRESPONDING ADDRESSES IS PRESENT UNDER THE RE_USEABLE_PAGEOBJECT PACKAGE
			    DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver, projectStartDate, 1);
			    logger.info("Project start date, month and year entered");
			    Thread.sleep(2000);
			}

			//ACTION METHOD TO SELECT PROJECT END DATE
			public void selectEndDate(String projectEndDate, int x) throws InterruptedException {

				//THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE AND CORRESPONDING ADDRESSES IS PRESENT UNDER THE RE_USEABLE_PAGEOBJECT PACKAGE
			    DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver, projectEndDate, 2);
			    logger.info("Project end date, month and year entered");
			    Thread.sleep(2000);
			}
			
			
		 //CONFIRMATION MESSAGE AFTER PROJECT ASSIGNMETN "PROJECT IS ALREADY ASSIGNED" AND IT WILL THE BOOLEAN VALUES
		   @FindBy(xpath="//div[contains(text(),'Project is already assigned')]")
		   @CacheLookup
		   WebElement msgProjectAdreadyAssigned;
		   public boolean isProjectAlreadyAssignToUser() throws InterruptedException{
			   boolean flag = false;
			   Thread.sleep(300);
			   try {
				   msgProjectAdreadyAssigned.isDisplayed();
				   if(msgProjectAdreadyAssigned.isDisplayed()) {
					   flag = true;
				   }
			   }catch(Exception e) {
				   e.getMessage();
			   }
			   Thread.sleep(1000);
			   return flag;
		   }
		   
		 //CONFIRMATION MESSAGE AFTER PROJECT ASSIGNMETN "PROJECT ASSIGNED SUCCESSFULLY" AND IT WILL THE BOOLEAN VALUES
		   @FindBy(xpath="//div[contains(text(),'Project assigned successfully.')]")
		   @CacheLookup
		   WebElement msgPrjectAssignedSuccessfully;
		   public boolean isProjectAssignToUserSuccessfully() throws InterruptedException{
			   boolean flag = false;
			   Thread.sleep(300);
			   try {
				   msgPrjectAssignedSuccessfully.isDisplayed();
				   if(msgPrjectAssignedSuccessfully.isDisplayed()) {
					   flag = true;
				   }
			   }catch(Exception e) {
				   e.getMessage();
			   }
			   Thread.sleep(1000);
			   return flag;
		   }
		   
		 
	//===========END==========PROJECT ASSIGNMENT PAGE OBJECTS AND ITS ACTIONS METHODS===========// 
		  //ASSIGN PROJECTS TO THE USER
		   public PO_HomePage assignUserToProject(String userSearchKey, String projectName, String assignProjectStartDate, String assignProjectEndDate) throws InterruptedException
		   {	logger.info("Entered edit project methods");
		   		Thread.sleep(2000);
		   		
		   		ruae.searchBox_RU(userSearchKey); // IT IS PRESENT AT RE USEABLE ELEMENT PACKAGE PAGE OBJECTS 
		   		clickOnAssignProjectBtn();	//IT CLICK ON THE ASSIGN USER BUTTON
		   		selectUserForProjectAssignment(projectName); 	//IT CLICK ON THE USER SELECTION DORPDOWN ICON AND SELECT THE GIVEN USER FROM THE LIST
		   		
		   		selectStartDate(assignProjectStartDate, 1);    //SELECT THE ASSIGN PROJECT START DATE 
		   		selectEndDate(assignProjectEndDate, 2);    //SELECT THE ASSIGN PROJECT END DATE 
		   		
		   		clickOnBtnAssign(); //IT CLICK ON THE ON THE ASSGIN BUTTON AFTER FILLING THE DETAILS
		   		
		   		//TAKES THE DECISION BASED ON THE CONFIREMATINO MESSAGES
		   		if(isProjectAlreadyAssignToUser()) {
		   			logger.info("Project already assigned to the given users");
		   			Thread.sleep(3000);
		   			ruae.clickOnCancelButton_RU();
		   		}else if(isProjectAssignToUserSuccessfully()) {
		   			logger.info("Project assigned to the users successfully");
		   		}else {
		   			logger.info("Not captured any confirmatin message");
		   		}
		   		Thread.sleep(3000);
		   		return new PO_HomePage(driver); // TO RETURN THE DRIVER AT HOME PAGE
		   }   		
}
