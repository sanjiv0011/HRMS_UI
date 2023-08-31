package com.hrms.pageObject;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
import com.hrms.DataBaseTesting.DB_Testing_User_CreateAndUpdate;
import com.hrms.ReUseAble.PageObject.ReUseAbleElement;
import com.hrms.dataBase.DatabaseConnectionAndQuery_GenericMethods;
import com.hrms.projectUtility.DatePicker;
import com.hrms.projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_UsersPage extends ReUseAbleElement{
	
	//CONSTRUCTOR AND OTHRE VARIABLE DECLARATIOIN
	public WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public Runtime runtime;
	public Logger logger = LogManager.getLogger(getClass());
	public PO_UserPermissions userpermission;
	
	//APPLY PAGE FACTORY CONCEPT THRUGH INHERITANCE(RE USE ABLE ELEMENT CLASS)
	public PO_UsersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		userpermission = new PO_UserPermissions(driver);
	}
	
	//ACTION OPTIONS CONSTRUCTOR
	public Action_Archive actionArchive = new Action_Archive();
	public Action_Restore actionRestore = new Action_Restore();
	public Action_Created confirmationCreated = new Action_Created();
	public Action_Updated confirmationUpdated = new Action_Updated();
	public Action_Activate actionActivate = new Action_Activate();
	public Action_Deactivate actionDeactivate = new Action_Deactivate();
	
	
	//ALERT USERS MESSAGES
	public String alertActivated_user = "User Activated Successfully.";
	public String alertDeActivated_user = "User DeActivated Successfully.";
	public String alertRestored_user = "User Restored Successfully.";
	public String alertArchived_user = "User Archived Successfully.";
	public String alertCreated_user = "User Created Successfully.";
	public String alertUpdated_user = "User Updated Successfully.";
	public String alertAleradyExist_user = "User already exists for given username.";
	public String alertProjectAlreadyAssignedToUser = "Project is already assigned";
	public String alertProjectAssignedToTheUser = "Project assigned successfully.";
	
	//CONSTRUCTOR DECLARATION AND INITIALIAZATION FOR DATA BASE ACTIONS
	public DB_Testing_Action_Archive  db_actionArchive = new DB_Testing_Action_Archive();
	public DB_Testing_Action_Restore  db_actionRestore = new DB_Testing_Action_Restore();
	public DB_Testing_Action_Activate  db_actionActivate = new DB_Testing_Action_Activate();
	public DB_Testing_Action_Deactivate  db_actionDeactivate = new DB_Testing_Action_Deactivate();
	public DB_Testing_User_CreateAndUpdate db_clientCreateUpdate = new DB_Testing_User_CreateAndUpdate();
			
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
			textUserName.sendKeys(Keys.CONTROL,"a");
			textUserName.sendKeys(Keys.DELETE);
	        textUserName.sendKeys(userName);
	        logger.info("Entered username");
	        Thread.sleep(500);
	    }
		
		//TEXT FIELD USER NAME ADDRESS
		@FindBy(xpath = "//input[@name=\"password\"]")
		@CacheLookup
		WebElement textPassword;
		public void setPassword(String password) throws InterruptedException {
			textPassword.sendKeys(Keys.CONTROL,"a");
			textPassword.sendKeys(Keys.DELETE);
		    textPassword.sendKeys(password);
		    logger.info("Entered password");
	        Thread.sleep(500);
		}
		
		//DROPDOWN LIST FOR THE ORGANIZATIONS ADDRESS
		@FindBy(xpath = "//input[@id='organizations']")
		@CacheLookup
		WebElement btnDropdownOrganization;
		public void clickOnDropdownBtnOrganization() throws InterruptedException {
		    btnDropdownOrganization.click();
		    Thread.sleep(500);
		    logger.info("Clicked on the dropdown organizations");
	        Thread.sleep(500);
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
		    Thread.sleep(500);
	    }
		
		//TEXT FIELD USER FIRST NAME ADDRESS
		@FindBy(xpath = "//input[@name='firstName']")
		@CacheLookup
		WebElement textFirstName;
		public void setFirstName(String firstName) throws InterruptedException {
			textFirstName.sendKeys(Keys.CONTROL,"a");
			textFirstName.sendKeys(Keys.DELETE);
	        textFirstName.sendKeys(firstName);
	        logger.info("Entered first name");
	        Thread.sleep(500);
	    }
		
		//TEXT FIELD USER LAST NAME ADDRESS
		@FindBy(xpath = "//input[@name=\"lastName\"]")
		@CacheLookup
		WebElement textLastName;
		public void setLastName(String lastName) throws InterruptedException {
			textLastName.sendKeys(Keys.CONTROL,"a");
			textLastName.sendKeys(Keys.DELETE);
		   textLastName.sendKeys(lastName);
		   logger.info("Entered Last name");
	        Thread.sleep(500);
		}
		
				
		//TEXT FIELD EMAIL ADDRESS ADDRESS
		@FindBy(xpath = "//input[@name='emailAddress']")
		@CacheLookup
		WebElement textEmailAddress;
		public void setEmailAddress(String emailAddress) throws InterruptedException {
			textEmailAddress.sendKeys(Keys.CONTROL,"a");
			textEmailAddress.sendKeys(Keys.DELETE);
	        textEmailAddress.sendKeys(emailAddress);
	        logger.info("Entered email address");
	        Thread.sleep(500);
	    }
		
		//DROPDOWN FIELD USER ROLE ADDRESS
		@FindBy(xpath = "//input[@id='userRoles']")
		@CacheLookup
		WebElement btnDropdownUserRole;
		public void clickOnDropdownUserRole() throws InterruptedException {
		    btnDropdownUserRole.click();
		    logger.info("Clicked on the User roles dropdown");
	        Thread.sleep(500);
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
		    Thread.sleep(500);
	    }
	//=====END====PROJECTS PAGE OBJECTS AND ITS ACTION METHODS============//
	
	
		//CREATE USERS WITH RETURN TYPE(PO_HomePage)
		public PO_HomePage createUser(String userNameToCreate, String passwordToCreate, String organizationName, String firstName, String lastName, String emailAddress, String userRole) throws InterruptedException, SQLException
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
			Thread.sleep(2000);
			boolean flag  = confirmationCreated.created(driver, alertCreated_user, alertAleradyExist_user);
			//DATABASE TESTING
			if(flag) {
				db_clientCreateUpdate.test_DB_createUser(userNameToCreate,organizationName,firstName,lastName,emailAddress,userRole);
			}
			logger.info("createUser call DONE");
			return new PO_HomePage(driver);
		}
		
		//CREATE USERS WITH RETURN TYPE(PO_UserPermissions)
		public PO_UserPermissions createUser_ReturnType_PO_UserPermissions(String userNameToCreate, String passwordToCreate, String organizationName, String firstName, String lastName, String emailAddress, String userRole) throws InterruptedException, SQLException
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
			userpermission.userPermissionsAdminCheckbox();
			Thread.sleep(2000);
			boolean flag  = confirmationCreated.created(driver, alertCreated_user, alertAleradyExist_user);
			//DATABASE TESTING
			if(flag) {
				db_clientCreateUpdate.test_DB_createUser(userNameToCreate,organizationName,firstName,lastName,emailAddress,userRole);
			}
			logger.info("createUser_ReturnType_PO_UserPermissions call DONE");
			return new PO_UserPermissions(driver);
		}
		
		
		
		//TO ARCHIVE USER
	   	public PO_HomePage archiveUser(String uname) throws InterruptedException, SQLException {
	       logger.info("Archive user method called");
	       // METHODS TO ARCHIVE THE USER
	       boolean flag = actionArchive.archive(uname, driver, alertArchived_user );
	       String searchString_DB_ColumnName = "user_name";
		   if(flag) {
	    	   String querry = "select * from public.users order by updated_at desc limit 1";
	    	   db_actionArchive.test_DB_Archive(uname,querry,searchString_DB_ColumnName);
	       }
		    logger.info("archiveUser call DONE");
	       return new PO_HomePage(driver);
	   	}
	   
	   //TO RESTORE USER
	   public PO_HomePage restoreUser(String uname) throws InterruptedException, SQLException {
	       logger.info("Restore user method called");
	       // METHODS TO RESTORE THE USER
	       boolean flag = actionRestore.restore(uname, driver, alertRestored_user);
	       //DATABASE TESTING
	       String searchString_DB_ColumnName = "user_name";
	       if(flag) {
	        	String querry = "select * from public.users order by updated_at desc limit 1";
	        	db_actionRestore.test_DB_Restore(uname,querry,searchString_DB_ColumnName);
	       }
	   	   logger.info("restoreUser call DONE");
	       return new PO_HomePage(driver);
	   }
	   
	   	//TO ACTIVATE USER
		public PO_HomePage activateUser(String uname) throws InterruptedException, SQLException{
			logger.info("Activate user methods called");
	    	//METHODS TO ACTIVATE THE USER
			boolean flag = actionActivate.activate(uname, driver,alertActivated_user );
			//DATABASE TESTING
	        String searchString_DB_ColumnName = "user_name";
	        if(flag) {
	        	String querry = "select * from public.users order by updated_at desc limit 1";
	        	db_actionActivate.test_DB_Activate(uname,querry,searchString_DB_ColumnName);
	        }
	   	    logger.info("activateUser call DONE");
	    	return new PO_HomePage(driver);
		}
		
		
		//TO DEACTIVATE USER
		public PO_HomePage deactivateUser(String uname) throws InterruptedException, SQLException{
			logger.info("De-Activate user methods called");
	    	//METHODS TO DEACTIVATE THE USER 
			boolean flag = actionDeactivate.deactivate(uname, driver, alertDeActivated_user);
			//DATABASE TESTING
	        String searchString_DB_ColumnName = "user_name";
	        if(flag) {
	        	String querry = "select * from public.users order by updated_at desc limit 1";
	        	db_actionDeactivate.test_DB_Deactivate(uname,querry,searchString_DB_ColumnName);
	        }
	   	    logger.info("deactivateUser call DONE");
	    	return new PO_HomePage(driver);
		}
			
		//EDIT USERS
		public PO_HomePage editUser(String uname,String newUName, String newOrganizationName, String NewFirstName, String newLastName, String newEmailAddress,String newUserRole) throws InterruptedException, SQLException
		{	logger.info("Entered edit user methods");
		  
		    //IT WILL SEARCH FIRST THE SEARCK KEY AND ONCE IT COMES AT THE TOP THEN ONLY IT WILL ABLE TO EDIT THE CORRECT PROJECT
		    ruae.searchBox_RU(uname); // IT IS PRESENT AT RE USEABLE ELEMENT PACKAGE PAGE OBJECTS 
		    ruae.clickOnActionButton_RU();    // TO CLICK ON THE ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
		    ruae.clickOnEditAction_RU();	//IT WILL CLICK ON THE EDIT ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
			//clickOnTabUserDetails();
			Thread.sleep(1000);
			setUserName(newUName);
			selectOrganization(newOrganizationName);
			setFirstName(NewFirstName);
			setLastName(newLastName);
			setEmailAddress(newEmailAddress);
			selectUserRole(newUserRole);
			ruae.clickOnBtnSaveAndGoToHome_1_RU();
			boolean flag = confirmationUpdated.updated(driver, alertUpdated_user, alertAleradyExist_user);
			//DATABASE TESTING
			if(flag) {
				db_clientCreateUpdate.test_DB_createUser(newUName,newOrganizationName,NewFirstName,newLastName,newEmailAddress,newUserRole);
			}
			logger.info("editUser call DONE");
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

	   
		   //PROJECT LIST ADDRESS TO ASSIGN THE PROJECT TO THE USER
		   @FindBy(xpath="//ul[@id='project-listbox']//li")
		   @CacheLookup
		   public List <WebElement> listProjectToAssingUser;
		   public void selectUserForProjectAssignment(String projectName) throws InterruptedException{
			   ruae.clickOnDropdown_1_RU(); // IT CLICK ON THE DROPDWON SELECT PROJECT
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
			
			//ACTION METHOD TO SELECT THE PROJECT START DATE
			public void selectStartDate(String projectStartDate, int x) throws InterruptedException {
				//THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE AND CORRESPONDING ADDRESSES IS PRESENT UNDER THE RE_USEABLE_PAGEOBJECT PACKAGE
			    DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver, projectStartDate, 1);
			    logger.info("Project start date, month and year entered");
			    Thread.sleep(1000);
			}

			//ACTION METHOD TO SELECT PROJECT END DATE
			public void selectEndDate(String projectEndDate, int x) throws InterruptedException {
				//THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE AND CORRESPONDING ADDRESSES IS PRESENT UNDER THE RE_USEABLE_PAGEOBJECT PACKAGE
			    DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver, projectEndDate, 2);
			    logger.info("Project end date, month and year entered");
			    Thread.sleep(1000);
			}
			
			
		 //CONFIRMATION MESSAGE AFTER PROJECT ASSIGNMETN "PROJECT IS ALREADY ASSIGNED" AND IT WILL THE BOOLEAN VALUES
		   @FindBy(xpath="//div[contains(text(),'Project is already assigned')]")
		   @CacheLookup
		   WebElement msgProjectAdreadyAssigned;
		   public boolean confirmationProjecAssignToUser() throws InterruptedException{
			   boolean flag = false;
			   String alertContent = snakeAlertMessagesDisplayedContent_RU();
			   int x =0;
			  while(x < 500) {
				  try {
					  if(alertContent.contains(alertProjectAlreadyAssignedToUser)) {
						   logger.info("===>>> "+alertProjectAlreadyAssignedToUser);
						   flag = true;
						   logger.info("Is project alerady assigned to the user: "+flag);
						   ruae.clickOnCancelButton_RU();
					   }else if(alertContent.equals(alertProjectAssignedToTheUser)) {
						   logger.info("===>>> "+alertProjectAssignedToTheUser);
						   flag = true;
						   logger.info("Is project assigned to the user successfully: "+flag);
					   }else {
						   logger.info("Alert message content: "+ alertContent);
						   flag = true;
						   ruae.clickOnCancelButton_RU();
					   }
				  }catch(Exception e) {
					  logger.info(e.getMessage());
				  }
				  if(flag) {
					  break;
				  }
			  }
			  return flag;
		   }
		   	   
		 
	//===========END==========PROJECT ASSIGNMENT PAGE OBJECTS AND ITS ACTIONS METHODS===========// 
		  //ASSIGN PROJECTS TO THE USER
		   public PO_HomePage assignUserToProject(String userSearchKey, String projectName, String assignProjectStartDate, String assignProjectEndDate) throws InterruptedException, SQLException
		   {	logger.info("Entered assign User To Project methods");
		   		ruae.searchBox_RU(userSearchKey); // IT IS PRESENT AT RE USEABLE ELEMENT PACKAGE PAGE OBJECTS 
		   		clickOnAssignProjectBtn();	//IT CLICK ON THE ASSIGN USER BUTTON
		   		selectUserForProjectAssignment(projectName); 	//IT CLICK ON THE USER SELECTION DORPDOWN ICON AND SELECT THE GIVEN USER FROM THE LIST
		   		selectStartDate(assignProjectStartDate, 1);    //SELECT THE ASSIGN PROJECT START DATE 
		   		//selectEndDate(assignProjectEndDate, 2);    //SELECT THE ASSIGN PROJECT END DATE 
		   		setDateWithoutUsingDatePicker_RU(assignProjectEndDate,2);  //SELECT THE PROJECT END DATE 
		   		clickOnBtnAssign(); //IT CLICK ON THE ON THE ASSGIN BUTTON AFTER FILLING THE DETAILS
		   		boolean flag = confirmationProjecAssignToUser();
		   		Thread.sleep(1000);
		   		//DATABASE TESTING
		   		if(flag) {
		   			//For DataBase Testing
		   			
		   			//TO GET THE USER ID
		   			String querryUser = "SELECT * FROM public.users where user_name = "+userSearchKey;
		   			String userId_fromUserTable = null;
		   			ResultSet resultsetUser = DatabaseConnectionAndQuery_GenericMethods.dataBaseCollectionAndQuerry(querryUser);
		   			while(resultsetUser.next()) {
		   				String userName = resultsetUser.getString("user_name");
		   				if(userSearchKey.equals(userName)) {
		   					userId_fromUserTable = resultsetUser.getString("id");
			   				System.out.println("UserId from user table: "+userId_fromUserTable+" and user name is : "+resultsetUser.getString("user_name"));
			   			
		   				}
		   			}
		   			
		   			//TO GET THE PROJECT NAME
		   			String querryProject = "SELECT * FROM public.projects where project_name = "+projectName;
		   			String projectId_fromProjectTable = null;
		   			ResultSet resultsetProject = DatabaseConnectionAndQuery_GenericMethods.dataBaseCollectionAndQuerry(querryProject);
		   			while(resultsetUser.next()) {
		   				String projName = resultsetProject.getString("project_name");
		   				if(projectName.equals(projName)) {
		   					projectId_fromProjectTable = resultsetProject.getString("id");
			   				System.out.println("ProjectId from project table: "+projectId_fromProjectTable+" and project name is : "+resultsetProject.getString("project_name"));
			   			
		   				}
		   			}
		   			
		   			
		   			String querry = "SELECT * FROM public.project_assignment ORDER BY updated_at ASC";
					ResultSet resultset = DatabaseConnectionAndQuery_GenericMethods.dataBaseCollectionAndQuerry(querry);
					int count =0;
			
					while(resultset.next())
					{	
						String userId_FromProAssTable = resultset.getString("user_id");
						String projectId_FromProAssTable = resultset.getString("project_id");
						
						if(userId_FromProAssTable.equals(userId_fromUserTable) && projectId_FromProAssTable.equals(projectId_fromProjectTable)) {
							String db_startDate[] = resultset.getString("start_date").replaceAll("\\s", "").split("-");
							//db format yyyy-mm-dd
							String db_startDateYR = db_startDate[0];
							String db_startDateMT = db_startDate[1];
							String db_startDateDE = db_startDate[2];
							String db_endDate[] =  resultset.getString("end_date").replaceAll("\\s", "").split("-");
							String db_endDateYR = db_endDate[0];
							String db_endDateMT = db_endDate[1];
							String db_endDateDE = db_endDate[2];
							
							//input format dd-month-yyyy
							String ProjStartDate[] = assignProjectStartDate.split(" ");
							String ProjEndDate[] = assignProjectEndDate.split(" ");
							
							String[] monthNames = {
						            "January", "February", "March", "April", "May", "June",
						            "July", "August", "September", "October", "November", "December"
						        };
							
							int x = 0;
							boolean flag2 = false;
							for(String name : monthNames) {
								x++;
								if(name.equals(ProjStartDate[1]));
								{
									flag2 = true;
									break;
								}
								
							}
							String y=null;
							if(flag2) {
								if(x<10) {
									 y = "0"+x;
								}
							}
							Assert.assertEquals(db_startDateYR, ProjStartDate[2], "To Match start date year");
							Assert.assertEquals(db_startDateMT, y, "To Match start date month");
							Assert.assertEquals(db_startDateDE, ProjStartDate[0], "To Match start date date");
							
							
							int z = 0;
							boolean flag3 = false;
							for(String name : monthNames) {
								z++;
								if(name.equals(ProjEndDate[1]));
								{
									flag3 = true;
									break;
								}
								
							}
							String a=null;
							if(flag3) {
								if(z<10) {
									a = "0"+z;
								}
							}
							Assert.assertEquals(db_endDateYR, ProjEndDate[2], "To Match start date year");
							Assert.assertEquals(db_endDateMT, a, "To Match start date month");
							Assert.assertEquals(db_endDateDE, ProjEndDate[0], "To Match start date date");
						}
					}
						
		   		}
		   		return new PO_HomePage(driver); // TO RETURN THE DRIVER AT HOME PAGE
		   }   		
}