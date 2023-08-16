package com.hrms.pageObject;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

import my_support.Action_Archive;
import my_support.Action_Restore;
import my_support.DatePicker;
import my_support.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_ProjectPage extends ReUseAbleElement {
	
	//INTIALIATION OF DRIVER AND OTHERS PARAMETER
	public WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public Logger logger = LogManager.getLogger(getClass());
	
	//APPLY PAGE FACTORY CONCEPT THRUGH INHERITANCE
	public PO_ProjectPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
	}
	
	//=====START====PROJECTS PAGE OBJECTS============//
		//CREATE PROJECT BUTTON ADDRESS
		@FindBy(xpath = "//p[normalize-space()='Create Project']")
		@CacheLookup
		WebElement btnCreateProject;
		
		//PROJECT NAME TEXT FIELD ADDRESS
		@FindBy(xpath = "//input[@placeholder=\"Enter Project Name\"]")
		@CacheLookup
		WebElement textEnterProjectName;
		
		//PORJEJCT DESCRIPTION TEXT FIELD ADDRESS
		@FindBy(xpath = "//textarea[@name=\"description\"]")
		@CacheLookup
		WebElement textEnterDescripton;
		
		//CLIENT DROPDOWN ADDRESS
		@FindBy(xpath = "//input[@placeholder='Select Client']")
		@CacheLookup
		public WebElement selectClient;
		
		//CLEINT LIST ADDRESS
		@FindBy(xpath = "//ul[@id='client-listbox']//li")
		@CacheLookup
		public List <WebElement> clientList;
		
		//DOMAIN DROPDOWN ADDRESS
		@FindBy(xpath = "//input[@placeholder='Select Domain']")
		@CacheLookup
		public WebElement selectDomain;
		
		//DOMAIN LIST ADDRESS
		@FindBy(xpath = "//ul[@id='domain-listbox']//li")
		@CacheLookup
		public List <WebElement> domaintList;
		
		
		//START DATE ICON ADDRESS
		@FindBy(xpath = "(//button[contains(@aria-label,'Choose date')])[1]")
		@CacheLookup
		WebElement iconDateStart;

		//END DATE ICON ADDRESS
		@FindBy(xpath = "(//button[contains(@aria-label,'Choose date')])[2]")
		@CacheLookup
		WebElement iconDateEnd;
		
		//TECHNOLOGY DROPDOWN ADDRESS
		@FindBy(xpath = "//input[@id='projectTechnologies']")
		@CacheLookup
		public WebElement selectTechnology;
		
		//TECHNOLOGY LIST ADDRESS
		@FindBy(xpath = "//ul[@id='projectTechnologies-listbox']//li")
		@CacheLookup
		public List <WebElement> technologyList;
		
		//PROJECT ALREADY EIXT MESSAGE ADDRESS
		@FindBy(xpath = "//div[contains(text(),\"Project already exists.\")]")
		@CacheLookup
		WebElement msgAlreadyExist;
		
		//PROJECT UPDATED MESSAGE ADDRESS
		@FindBy(xpath = "//div[contains(text(),'Project Updated Successfully.')]")
		@CacheLookup
		WebElement msgUpdated;
		
		//PROJECT CREATED MESSAGE ADDRESS
		@FindBy(xpath = "//div[contains(text(),\"Project Created Successfully\")]")
		@CacheLookup
		WebElement msgCreated;
		//=====END====PROJECTS PAGE OBJECTS============//
		
				
		
		//=====START====ACTIONS METHODS ON THE PROJECTS PAGE OBJECTS============//
		
		//ACTION METHOD TO CLICK ON THE CREATE PROJECT BUTTON
		public void clickOnCreateProjectBtn() throws InterruptedException {
		    btnCreateProject.click();
		    logger.info("Clicked on the create project button");
		    Thread.sleep(2000);
		}

		//ACTION METHOD TO SET PROJECT NAME
		public void setProjectName(String projectName) throws InterruptedException {
		    textEnterProjectName.sendKeys(projectName);
		    logger.info("Entered project name");
		    Thread.sleep(1000);
		}

		//ACTION METHOD TO SET PROJECT DESCRIPTION
		public void setProjectDescription(String projectDescription) throws InterruptedException {
		    textEnterDescripton.sendKeys(projectDescription);
		    logger.info("Entered project description");
		    Thread.sleep(1000);
		}

		//ACTION METHOD TO CLICK ON THE CLIENT DROPDOWN AND SELECT THE GIVEN CLIENT NAME
		public void selectClient(String clientName) throws InterruptedException {
		    selectClient.click();
		    Thread.sleep(500);
		    logger.info("Clicked on the select client dropdown");
		    //THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE
		    Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(clientList, clientName);
		    logger.info("Client name selected");
		    Thread.sleep(1000);
		}
		
		//ACTION METHOD TO CLICK ON THE DOMAIN NAME DROPDOWN AND SELECT THE GIVEN DOMAIN NAME
		public void selectDomain(String domainName) throws InterruptedException {
		    selectDomain.click();
		    Thread.sleep(500);
		    logger.info("Clicked on the select domain dropdown");
		    //THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE
		    Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(domaintList, domainName);
		    logger.info("Domain name selected");
		    Thread.sleep(1000);
		}
		
		//ACTION METHOD TO CLICK ON THE PROJECT START DATE ICON
		public void clickOnStartDateIcon() throws InterruptedException {
			iconDateStart.click();
		    logger.info("Clicked on the start date icon");
		    Thread.sleep(1000);
		}
		
		//ACTION METHOD TO SELECT THE PROJECT START DATE
		public void selectStartDate(String projectStartDate) throws InterruptedException {
			clickOnStartDateIcon(); //IT WILL CLICK ON THE START DATE ICON
			//THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE AND CORRESPONDING ADDRESSES IS PRESENT UNDER THE RE_USEABLE_PAGEOBJECT PACKAGE
		    DatePicker.DatePicker_GenericMethod_WithoutDropDown(toggleBtnYearAndDate, elementCurrentMonthYearDisplayed, arrowNextMonth, arrowPreviousMonth, selectDate, selectYear, projectStartDate);
		    logger.info("Project start date, month and year entered");
		    Thread.sleep(2000);
		}

		//ACTION METHOD TO CLICK ON THE PROJECT END DATE ICON
		public void clickEndDateIcon() throws InterruptedException {
			iconDateEnd.click();
		    logger.info("Clicked on the end date icon");
		    Thread.sleep(1000);
		}

		//ACTION METHOD TO SELECT PROJECT END DATE
		public void selectEndDate(String projectEndDate) throws InterruptedException {
			clickEndDateIcon();	//IT WILL CLICK ON THE END DATE ICON
			//THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE AND CORRESPONDING ADDRESSES IS PRESENT UNDER THE RE_USEABLE_PAGEOBJECT PACKAGE
		    DatePicker.DatePicker_GenericMethod_WithoutDropDown(toggleBtnYearAndDate, elementCurrentMonthYearDisplayed, arrowNextMonth, arrowPreviousMonth, selectDate, selectYear, projectEndDate);
		    logger.info("Project end date, month and year entered");
		    Thread.sleep(2000);
		}
		
		//ACTION METHOD TO CLICK ON THE TECHNOLOGY DROPDOWN AND SELECT THE GIVEN TECHNOLOGY NAME
		public void selectTechnology(String technologyName) throws InterruptedException {
		    selectTechnology.click();
		    logger.info("Clicked on the select technology dropdown");
		    Thread.sleep(500);
		    //THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE
		    Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(technologyList, technologyName);
		    logger.info("Domain name selected");
		    Thread.sleep(1000);
		}
		
		//ACTION METHOD TO CHECK THE STATUS IF THE PROJECT ALREADY CREATED
		public boolean isProjectAlreadyExistMessageDisplayed() throws InterruptedException {
			Thread.sleep(300);
	        return msgAlreadyExist.isDisplayed();
	    }

		//ACTION METHOD TO CHECK THE STATUS IF THE PROJECT UPDATED
	    public boolean isProjectUpdatedMessageDisplayed() throws InterruptedException {
	    	Thread.sleep(300);
	        return msgUpdated.isDisplayed();
	    }

	  //ACTION METHOD TO CHECK THE STATUS IF THE NEW PROJECT CREATED
	    public boolean isProjectCreatedMessageDisplayed() throws InterruptedException {
	    	Thread.sleep(300);
	        return msgCreated.isDisplayed();
	    }
		// =====END====ACTIONS METHODS ON THE PROJECTS PAGE OBJECTS============//

	    
	  //TO CREATE PROJECTS
	   public PO_HomePage createProject(String projectName, String projectDescription, String domainName, String clientName, String technologyName,String projectStartDate, String projectEndDate) throws InterruptedException
	   {	
		    clickOnCreateProjectBtn();	//TO CLICK ON THE CREATE PROJECT BUTTON
	   		setProjectName(projectName);	//TO ENTER THE PROJECT NAME
	   		setProjectDescription(projectDescription);	//TO ENTER THE PROJECT DESCRIPTION
	   		selectClient(clientName);	//TO SELECT THE CLIENT
	   		selectDomain(domainName);	//TO SELECT THE DOMAIN
	   		selectStartDate(projectStartDate);	//SET SELECT THE PROJECT START DATE 
	   		selectEndDate(projectEndDate);	//SET SELECT THE PROJECT END DATE 
	   		selectTechnology(technologyName);	//TO SELECT THE TECHNOLOGY
	   		ruae.clickOnCreateButton_RU();	//TO CLICK ON THE CREATE BUTTON AFTER FILLING DETAILS
		    return new PO_HomePage(driver);	//TO RETURN THE DRIVER AT HOME PAGE
	   }
	   
	   //TO ARCHIVE PROJECTS
	   // THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	   public PO_HomePage archiveProject(String projectName) throws InterruptedException {
	       logger.info("Archive project method called");

	       // METHODS TO ARCHIVE THE PROJECT
	       Action_Archive.archive(projectName, searchBox, archivedLabel, btnAction, actionArchive, btnYes, "confirmMessage");
	       logger.info("Returned inside archive project method");
	       return new PO_HomePage(driver);
	   }
	   
	   //TO RESTORE PROJECTS
	   // THIS ALL DATA COMES FROM THE RE_USEABLE_ELEMENT CLASS WHICH PRESENCE UNDER THE RE_USERABLE_PACKAGE PAGE OBJECTS
	   public PO_HomePage restoreProject(String projectName) throws InterruptedException {
	       logger.info("Restore project method called");

	       // METHODS TO RESTORE THE PROJECT
	       Action_Restore.restore(projectName, searchBox, archivedLabel, btnAction, actionRestore, btnYes, "confirmMessage");
	       logger.info("Returned inside restore project method");
	       return new PO_HomePage(driver);
	   }

	   // TO EDIT PROJECTS
	   public PO_HomePage editProject(String projectSearchKey,String newProjecName, String newProjecDescription, String newDomainName, String newTechnologyName, String newProjectStartDate, String newProjectEndDate) throws InterruptedException {	
		   logger.info("Entered edit project methods");
		   Thread.sleep(2000);
		   
		   //IT WILL SEARCH FIRST THE SEARCK KEY AND ONCE IT COMES AT THE TOP THEN ONLY IT WILL ABLE TO EDIT THE CORRECT PROJECT
		   ruae.searchBox_RU(projectSearchKey); // IT IS PRESENT AT RE USEABLE ELEMENT PACKAGE PAGE OBJECTS 
		   ruae.clickOnActionButton_RU();    // TO CLICK ON THE ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
		   ruae.clickOnEditAction_RU();	//IT WILL CLICK ON THE EDIT ACTION BUTTON AND IT IS PRESENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
		   setProjectName(newProjecName);    // TO ENTER THE PROJECT NAME
	       setProjectDescription(newProjecDescription);    // TO ENTER THE PROJECT DESCRIPTION
	       selectDomain(newDomainName);    // TO SELECT THE DOMAIN
	       selectStartDate(newProjectStartDate);    //SELECT THE PROJECT START DATE 
	       selectEndDate(newProjectEndDate);    //SELECT THE PROJECT END DATE 
	       selectTechnology(newTechnologyName);    // TO SELECT THE TECHNOLOGY
	       ruae.clickOnBtnSaveChanges_RU();// TO CLICK ON THE SAVE CHANGES BUTTON AFTER FILLING DETAILS AND IT PREENT AT RE_USEABLE_ELEMENT PACKAGE PAGE OBJECT
	       return new PO_HomePage(driver);    // TO RETURN THE DRIVER AT HOME PAGE
	   }
	   
	   
	 //===========START==========PROJECT ASSIGNMENT PAGE OBJECTS AND ITS ACTIONS METHODS===========//
	   //ASSIGN PROJECT TO THE USER ADDRESS
	   @FindBy(xpath="(//p[contains(text(),'Assign User')])[1]")
	   @CacheLookup
	   WebElement btnAssignUser;
	   public void clickOnAssignUserBtn() throws InterruptedException{
		   btnAssignUser.click();
		   Thread.sleep(1000);
		   logger.info("Clicked on the assign user button");
	   }
	   
	   //DROPDOWN ICON ADDRESS FOR USER SELECTION
	   @FindBy(xpath="//button[@title='Open']//*[name()='svg']")
	   @CacheLookup
	   WebElement iconUserDropdown;
	   public void clickOnUserDropdownIcon() throws InterruptedException{
		   iconUserDropdown.click();
		   Thread.sleep(1000);
		   logger.info("Clicked on the dropdown icon for the user");
	   }
	   
	   //USER LIST ADDRESS FOR THE PROJECT ASSIGNMENT
	   @FindBy(xpath="//ul[@id='user-listbox']//li")
	   @CacheLookup
	   public List <WebElement> listUserForProjectAssignment;
	   public void selectUserForProjectAssignment(String userName) throws InterruptedException{
		   clickOnUserDropdownIcon(); // IT CLICK ON THE DROPDWON SELECT USER
		   Thread.sleep(500);
		   //THIS MEHTOD IS CALLED FROM THE MY_SUPPORT PACKAGE
		   Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listUserForProjectAssignment, userName);
		   Thread.sleep(1000);
		   logger.info("User selected for the project assignment");
	   }
	   
	 //USER LIST ADDRESS FOR THE PROJECT ASSIGNMENT
	   @FindBy(xpath="//p[normalize-space()='Assign']")
	   @CacheLookup
	   WebElement btnAssign;
	   public void clickOnBtnAssign() throws InterruptedException{
		   btnAssign.click();
		   Thread.sleep(1000);
		   logger.info("Click on the button assign");
	   }
	   
	 //CONFIRMATION MESSAGE AFTER PROJECT ASSIGNMETN "USER IS ALREADY ASSIGNED" AND IT WILL THE BOOLEAN VALUES
	   @FindBy(xpath="//div[contains(text(),'User is already assigned')]")
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
	   public PO_HomePage assignProjectToUser(String projectSearchKey, String userName, String assignProjectStartDate, String assignProjectEndDate) throws InterruptedException
	   {	logger.info("Entered edit project methods");
	   		Thread.sleep(2000);
	   		
	   		ruae.searchBox_RU(projectSearchKey); // IT IS PRESENT AT RE USEABLE ELEMENT PACKAGE PAGE OBJECTS 
	   		clickOnAssignUserBtn();	//IT CLICK ON THE ASSIGN USER BUTTON
	   		selectUserForProjectAssignment(userName); 	//IT CLICK ON THE USER SELECTION DORPDOWN ICON AND SELECT THE GIVEN USER FROM THE LIST
	   		selectStartDate(assignProjectStartDate);    //SELECT THE ASSIGN PROJECT START DATE 
	   		//selectEndDate(assignProjectEndDate);    //SELECT THE ASSIGN PROJECT END DATE 
	   		clickOnBtnAssign(); //IT CLICK ON THE ON THE ASSGIN BUTTON AFTER FILLING THE DETAILS
	   		
	   		//TAKES THE DECISION BASED ON THE CONFIREMATINO MESSAGES
	   		if(isProjectAlreadyAssignToUser()) {
	   			logger.info("Project already assigned to the given users");
	   		}else if(isProjectAssignToUserSuccessfully()) {
	   			logger.info("Project assigned to the users successfully");
	   		}else {
	   			logger.info("Not captured any confirmatin message");
	   		}
	   		return new PO_HomePage(driver); // TO RETURN THE DRIVER AT HOME PAGE
	   }
	   

}
