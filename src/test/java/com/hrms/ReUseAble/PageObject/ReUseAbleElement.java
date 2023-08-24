package com.hrms.ReUseAble.PageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projectUtility.TimePicker;


public class ReUseAbleElement {
	
	//CONSTRUCTOR INITIALIZATIONS
	public WebDriver driver=null;
	public static final Logger logger = LogManager.getLogger(ReUseAbleElement.class);
	public static WebDriverWait wait = null;
	static Actions action;
	
	//CREATE PAGE FACTORY METHODS WITH DRIVERS
	public ReUseAbleElement(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		action = new Actions(driver);
	}
	
	
	
	//========START=======Actions Elements===========TO USE ANY ONE OF THIS FIRST SEARCH IT SO THAT IT COMES AT TOP=========//
		//SEARCH BOX
		@FindBy(xpath = "//input[@placeholder='Search…']")
		@CacheLookup
		public WebElement searchBox_RU;
		public void searchBox_RU(String SearchKey) throws InterruptedException
		{	Thread.sleep(200);
			searchBox_RU.sendKeys(SearchKey,Keys.ENTER);
			logger.info("Searched the search keys in the search box: "+SearchKey);
			Thread.sleep(1000);
		}
	
		//ACTION BUTTON THREE DOTS
		@FindBy(xpath = "//div[@class='pointer']//*[name()='svg']")
		@CacheLookup
		public WebElement btnAction_RU;
		// Action method to click the Action button
	    public void clickOnActionButton_RU() throws InterruptedException {
	    	btnAction_RU.click();
	        logger.info("Clicked on the Three dot Action button");
	        Thread.sleep(1000);
	    }

		
	  //===========START=======ACTIVATE AND DEACTIVATE==================//
	    
		//ACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Active')])[1]")
		@CacheLookup
		public WebElement actionActivate;
		// Action method to click the Archive action
	    public void clickOnActivateAction_RU() throws InterruptedException {
	        actionActivate.click();
	        logger.info("Clicked on the Action_Activate button");
	        Thread.sleep(300);
	    }
		
		//DEACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Deactive')])[1]")
		@CacheLookup
		public WebElement actionDeactivate;
		 // Action method to click the Restore action
	    public void clickOnDeactivateAction_RU() throws InterruptedException {
	        actionDeactivate.click();
	        logger.info("Clicked on the Action_Deactivated button");
	        Thread.sleep(300);
	    }
	    
    	//MESSAGE ACTIVATED
 		@FindBy(xpath = "//div[contains(text(),'Leave Type Activated Successfully.')]")
 		@CacheLookup
 		public WebElement msgActivated;
 		 // Action method to get the message after activation
 	    public boolean getActivatedSuccessfullyMessage_RU() throws InterruptedException {
 	    	boolean flag = false;
 	        if (msgActivated.isDisplayed()) {
 	            flag = true;
 	           logger.info("InActive label present: "+flag);
 	        }
 	        Thread.sleep(300);
 	        return flag;
 	    }
 		
 	    //MESSAGE DEACTIVATED
  		@FindBy(xpath = "//div[contains(text(),'Leave Deactivated Successfully.')]")
  		@CacheLookup
  		public WebElement msgDeactivated;
 	    // Action method to get the message after deactivation
 	    public boolean isDeactivatedSuccessfullyMessage_RU() throws InterruptedException {
 	    	boolean flag = false;
 	        if (msgDeactivated.isDisplayed()) {
 	            flag = true;
 	           logger.info("Active label present: "+flag);
 	        }
 	        Thread.sleep(300);
 	        return flag;
 	    }
 		
 	    //TO CHECK LABLE INACTIVE
 	    @FindBy(xpath="//span[normalize-space()='InActive']")
 	    @CacheLookup
 	    public WebElement inactiveLabel;
 	    public boolean isAlreadyInActiveDisplayed_RU() throws InterruptedException {
 	        boolean flag = false;
 	        if (inactiveLabel.isDisplayed()) {
 	            flag = true;
 	           logger.info("InActive label present: "+flag);
 	        }
 	        Thread.sleep(300);
 	        return flag;
 	    }
 	    
 	    //TO CHECK LABLE ACTIVE 
 	    @FindBy(xpath="//span[normalize-space()='Active']")
 	    @CacheLookup
 	    public WebElement activeLabel;
 	    public boolean isAlreadyActiveDisplayed_RU() throws InterruptedException {
 	        boolean flag = false;
 	        if (activeLabel.isDisplayed()) {
 	            flag = true;
 	           logger.info("InActive label present: "+flag);
 	        }
 	        Thread.sleep(300);
 	        return flag;
 	    }
	 	    
	 	//===========END=======ACTIVATE AND DEACTIVATE==================//
	    
	 	    
	    //===========START=======ARCHIVE AND RESTORE==================//
	    
	    //Archive Action => To use this first search list item so that it comes at first position
  		@FindBy(xpath = "(//div[contains(text(),'Archive')])[1]")
  		@CacheLookup
  		public WebElement actionArchive;
  		// Action method to click the Archive action
  	    public void clickOnArchiveAction_RU() throws InterruptedException {
  	        actionArchive.click();
  	        logger.info("Clicked on the Action_Archive button");
  	        Thread.sleep(300);
  	    }
  		
  		//Restore Action => To use this first search list item so that it comes at first position
  		@FindBy(xpath = "(//div[contains(text(),'Restore')])[1]")
  		@CacheLookup
  		public WebElement actionRestore;
  		 // Action method to click the Restore action
  	    public void clickOnRestoreAction_RU() throws InterruptedException{
  	        actionRestore.click();
  	        logger.info("Clicked on the Action_Restore button");
  	        Thread.sleep(300);
  	    }
		
  	    //MESSAGE RESTORED
		@FindBy(xpath = "//div[contains(text(),'Leave Balance Restored Successfully.')]")
		@CacheLookup
		public WebElement msgArchived;
		 // Action method to get the message after archiving
	    public boolean isArchivedSuccessfullyMessage_RU() throws InterruptedException {
	    	boolean flag = false;
	        if (msgArchived.isDisplayed()) {
	            flag = true;
	            logger.info("Confirmation message is Archived successfully: "+flag);
	        }
	        Thread.sleep(300);
	        return flag;
	    }
		
	    //MESSAGE ARCHIVED
 		@FindBy(xpath = "//div[contains(text(),'Leave Balance Archived Successfully.')]")
 		@CacheLookup
 		public WebElement msgRestored;
	    // Action method to get the message after restoring
	    public boolean isRestoredSuccessfullyMessage_RU() throws InterruptedException {
	    	boolean flag = false;
	        if (msgRestored.isDisplayed()) {
	            flag = true;
	            logger.info("Confirmation message is Restored successfully: "+flag);
	        }
	        Thread.sleep(300);
	        return flag;
	    }
		
	    //TO CHECK ALLREADY ARCHIVED
	    @FindBy(xpath="//span[text()='Archived']")
	    @CacheLookup
	    public WebElement archivedLabel;
	    public boolean isAlreadyArchivedDisplayed_RU() throws InterruptedException {
	        boolean flag = false;
	        if (archivedLabel.isDisplayed()) {
	            flag = true;
	            logger.info("Confirmation message is already archived: "+flag);
	        }
	        Thread.sleep(300);
	        return flag;
	    }
	  //===========END=======ARCHIVE AND RESTORE==================//
	    
	    
		//Edit Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Edit')])[1]")
		@CacheLookup
		public WebElement actionEdit_RU;
		// Action method to click the Edit action
	    public void clickOnEditAction_RU() throws InterruptedException {
	    	actionEdit_RU.click();
	        logger.info("Clicked on the Action_Edit button");
	        Thread.sleep(300);
	    }
		
	    
	    //===========START=======FOR THE BUTTON YES, NO, SAVE CHANGES, CROSS BUTTON, SAVE & GO TO HOME, AND DELETE, PROFILE ICON, EYE ICON===================//
	    
	  
	    
	    //TO CLICK ON THE USER PROFILE ICON FOR ICON UPLOAD
	    @FindBy(xpath = "(//label//div[contains(@class,\"MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault\")])[1]")
		@CacheLookup
		public WebElement iconUserProfileImage_1_RU;
		public void clickOnUserProfileIcon_1_RU() throws InterruptedException{
			iconUserProfileImage_1_RU.click();
		   logger.info("Clicked on the icon to upload the user profile image");
		   Thread.sleep(1000);
		}
		
		
	    //PASSWORD VISIBILITY EYE ICON 1
	    @FindBy(xpath = "(//button[@aria-label='toggle password visibility']//*[name()='svg'])[1]")
		@CacheLookup
		public WebElement iconPasswordVisibility_1_RU;
		public void clickOnEyeIconPasswordView_1_RU() throws InterruptedException{
			iconPasswordVisibility_1_RU.click();
		   logger.info("Clicked on the eye icon to view the password");
		   Thread.sleep(1000);
		}
		
		//PASSWORD VISIBILITY EYE ICON 2
	    @FindBy(xpath = "(//button[@aria-label='toggle password visibility']//*[name()='svg'])[2]")
		@CacheLookup
		public WebElement iconPasswordVisibility_2_RU;
		public void clickOnEyeIconPasswordView_2_RU() throws InterruptedException{
			iconPasswordVisibility_2_RU.click();
		   logger.info("Clicked on the eye icon to view the password");
		   Thread.sleep(1000);
		}
		
		//PASSWORD VISIBILITY EYE ICON 3
		@FindBy(xpath = "(//button[@aria-label='toggle password visibility']//*[name()='svg'])[3]")
		@CacheLookup
		public WebElement iconPasswordVisibility_3_RU;
		public void clickOnEyeIconPasswordView_3_RU() throws InterruptedException{
			iconPasswordVisibility_3_RU.click();
		   logger.info("Clicked on the eye icon to view the password");
		   Thread.sleep(1000);
		}
		
		//CREATE BUTTON
	    @FindBy(xpath = "//p[normalize-space()=\"Create\"]")
		@CacheLookup
		public WebElement btnCreate_RU;
		public void clickOnCreateButton_RU() throws InterruptedException{
			btnCreate_RU.click();
		   logger.info("Clicked on the Create button");
		   Thread.sleep(300);
		}

		//BUTTON CANCEL
		@FindBy(xpath = "//p[normalize-space()=\"Cancel\"]")
		@CacheLookup
		public WebElement btnCancel_RU;
		public void clickOnCancelButton_RU() throws InterruptedException {
			btnCancel_RU.click();
		   logger.info("Clicked on the Cancle button");
		   Thread.sleep(300);
		}
	    
		// Yes button before confirm the action
		@FindBy(xpath = "//p[normalize-space()='Yes']")
		@CacheLookup
		public WebElement btnYes;
		 // Action method to click the Yes button
	    public void clickOnYesButton_RU() throws InterruptedException {
	        btnYes.click();
	        logger.info("Clicked on the Yes button");
	        Thread.sleep(500);
	    }
		
		// No button before confirm the action
		@FindBy(xpath = "//p[normalize-space()='No']")
		@CacheLookup
		public WebElement btnNo;
		// Action method to click the No button
	    public void clickOnNoButton_RU() throws InterruptedException {
	        btnNo.click();
	        logger.info("Clicked on the No button");
	        Thread.sleep(300);
	    }
	    
	    //DELETE BUTTON
	    @FindBy(xpath = "(//div[contains(text(),'Delete')])[1]")
	    @CacheLookup
	    public WebElement btnDelete;
	    public void clickOnBtnDelete_RU() throws InterruptedException {
	    	btnDelete.click();
	    	logger.info("Clicked on the delete button");
	    	Thread.sleep(300);
	    }
	    
	    //SAVE CHANGES BUTTON
	    @FindBy(xpath = "//p[normalize-space()='Save Changes']")
		@CacheLookup
		public WebElement btnSaveChanges_RU;
	    public void clickOnBtnSaveChanges_RU() throws InterruptedException {
	    	btnSaveChanges_RU.click();
			logger.info("Clicked on the save changes button");
			Thread.sleep(300);
		}
	    
	    //CROSS BUTTON
	    @FindBy(xpath = "(//*[name()='svg'][@stroke='currentColor'])[1]")
		@CacheLookup
		public WebElement btnCross;
	    public void clickOnBtnCross_RU() throws InterruptedException {
	    	btnCross.click();
	    	logger.info("Clicked on the cross button icon");
			Thread.sleep(300);
		}
	    
	    //SAVE AND GO TO HOME BUTTON 1
	    @FindBy(xpath = "(//p[text()='Save & Go To Home'])[1]")
		@CacheLookup
		public WebElement btnSaveAndGoToHome_1_RU;
	    public void clickOnBtnSaveAndGoToHome_1_RU() throws InterruptedException {
	    	btnSaveAndGoToHome_1_RU.click();
	    	logger.info("Clicked on the save and go to home button");
			Thread.sleep(300);
		}
	    
	    //SAVE AND GO TO HOME BUTTON 2 
	    @FindBy(xpath = "(//p[text()='Save & Go To Home'])[2]")
		@CacheLookup
		public WebElement btnSaveAndGoToHome_2_RU;
	    public void clickOnBtnSaveAndGoToHome_2_RU() throws InterruptedException {
	    	btnSaveAndGoToHome_2_RU.click();
	    	logger.info("Clicked on the save and go to home button");
			Thread.sleep(300);
		}
	    
	    //SAVE AND GO TO HOME BUTTON 3
	    @FindBy(xpath = "(//p[text()='Save & Go To Home'])[3]")
		@CacheLookup
		public WebElement btnSaveAndGoToHome_3_RU;
	    public void clickOnBtnSaveAndGoToHome_3_RU() throws InterruptedException {
	    	btnSaveAndGoToHome_3_RU.click();
	    	logger.info("Clicked on the save and go to home button");
			Thread.sleep(300);
		}
	    
	    //NEXT BUTTON 1
	    @FindBy(xpath = "(//p[normalize-space()='Next'])[1]")
		@CacheLookup
		public WebElement btnNext_1_RU;
	    public void clickOnBtnNext_1_RU() throws InterruptedException {
	    	btnNext_1_RU.click();
	    	logger.info("Clicked on the nextbutton");
			Thread.sleep(300);
		}
	    
	    //NEXT BUTTON 2
	    @FindBy(xpath = "(//p[normalize-space()='Next'])[2]")
		@CacheLookup
		public WebElement btnNext_2_RU;
	    public void clickOnBtnNext_2_RU() throws InterruptedException {
	    	btnNext_2_RU.click();
	    	logger.info("Clicked on the nextbutton");
			Thread.sleep(300);
		}
	    
	    //NEXT BUTTON 3
	    @FindBy(xpath = "(//p[normalize-space()='Next'])[3]")
		@CacheLookup
		public WebElement btnNext_3_RU;
	    public void clickOnBtnNext_3_RU() throws InterruptedException {
	    	btnNext_3_RU.click();
	    	logger.info("Clicked on the nextbutton");
			Thread.sleep(300);
		}
	    
	    //DROPDOWN ADDRESS 1
  		@FindBy(xpath = "(//button[@title='Open']//*[name()='svg'])[1]")
  		@CacheLookup
  		public WebElement iconDropdown_1_RU;
  		public void clickOnDropdown_1_RU() throws InterruptedException {
  			iconDropdown_1_RU.click();
  			logger.info("Clicked on the icon dropdown 1");
  			Thread.sleep(1000);
  		}
  		
  		//DROPDOWN ADDRESS 2
  		@FindBy(xpath = "(//button[@title='Open']//*[name()='svg'])[2]")
  		@CacheLookup
  		public WebElement iconDropdown_2_RU;
  		public void clickOnDropdown_2_RU() throws InterruptedException {
  			iconDropdown_2_RU.click();
  			logger.info("Clicked on the icon dropdown 1");
  			Thread.sleep(1000);
  		}
  		
  		//DROPDOWN ADDRESS 3
  		@FindBy(xpath = "(//button[@title='Open']//*[name()='svg'])[3]")
  		@CacheLookup
  		public WebElement iconDropdown_3_RU;
  		public void clickOnDropdown_3_RU() throws InterruptedException {
  			iconDropdown_3_RU.click();
  			logger.info("Clicked on the icon dropdown 3 ");
  			Thread.sleep(1000);
  		}
  		
  		//DROPDOWN ADDRESS 4
  		@FindBy(xpath = "(//button[@title='Open']//*[name()='svg'])[4]")
  		@CacheLookup
  		public WebElement iconDropdown_4_RU;
  		public void clickOnDropdown_4_RU() throws InterruptedException {
  			iconDropdown_4_RU.click();
  			logger.info("Clicked on the icon dropdown 4");
  			Thread.sleep(1000);
  		}
	   	
  		//SAVE BUTTON 1
  		@FindBy(xpath = "(//p[normalize-space()='Save'])[1]")
  		@CacheLookup
  		public WebElement btnSave_1_RU;
  		public void clickOnBtnSave_1_RU() throws InterruptedException {
  			btnSave_1_RU.click();
  			logger.info("Clicked on the button save");
  			Thread.sleep(300);
  		}
  		
	  //===========END=======FOR THE BUTTON YES, NO, SAVE CHANGES, CROSS BUTTON, SAVE & GO TO HOME, DORPDOWN ICON AND DELETE==================//
	//========START=======Actions Elements=========TO USER ANY ONE OF THIS FIRST SEARCH IT SO THAT IT COMES AT TOP===========//
	    

		
  //===========START======ACTIVATE AND DEACTIVATE ONLY FOR USER PAGE OBJECT AND ITE ACTION METHODS===========//
		//ACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[normalize-space()='Activate'])[1]")
		@CacheLookup
		public WebElement actionActivateUser;
		// Action method to click the Archive action
	    public void clickOnActivateAction_RU_User() throws InterruptedException {
	    	actionActivateUser.click();
	        logger.info("Clicked on the Action_Activate button");
	        Thread.sleep(300);
	    }
		
		//DEACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Deactivate')])[1]")
		@CacheLookup
		public WebElement actionDeactivateUser;
		 // Action method to click the Restore action
	    public void clickOnDeactivateAction_RU_User() throws InterruptedException {
	    	actionDeactivateUser.click();
	        logger.info("Clicked on the Action_Deactivated button");
	        Thread.sleep(300);
	    }
	    
	    //USER ICON DROPDOWN BUTTON
	    @FindBy(xpath="//*[@data-testid='ExpandMoreIcon']")
	    @CacheLookup
	    public WebElement iconDropdownLoggedUser_RU;
	    public void clickOnDropdownIconLoggedUser_RU() throws InterruptedException {
	    	wait.until(ExpectedConditions.elementToBeClickable(iconDropdownLoggedUser_RU));
	    	iconDropdownLoggedUser_RU.click();
	        logger.info("Clicked on the dropdown icon of the already logged in user");
	        Thread.sleep(300);
	    }
  //===========END======ACTIVATE AND DEACTIVATE ONLY FOR USER PAGE OBJECT AND ITE ACTION METHODS===========//	
	    
 
  //==========START==========TIME SELECTION PAGE OBJECTS AND ITS ACTION METHODS=====USE THIS METHODS IF AND ONLY IF TIME PICKRE FAILED TO PICK THE TIME======//
	  //START AND END TIME REQUIRED MESSAGES ADDRESS
	  		String endTimeRequired_RU = "//p[contains(.,'End time is required')]";
	  		String startTimeRequired_RU = "//p[contains(.,'Start time is required')]";
	  		
	  		//START AND END TIME PLACE HOLDER ADDRESS
	  		String textTimePlaceHolder_1_RU = "(//input[@placeholder='hh:mm aa'])[1]";
	  		String textTimePlaceHolder_2_RU = "(//input[@placeholder='hh:mm aa'])[2]";
	  		
	  		//TO CONFFIRM THE END TIME REQUIRED MESSAGE
	  		public boolean isDisplayedEndTimeRequired_RU() {
	  			WebElement endTimeMsg = driver.findElement(By.xpath(endTimeRequired_RU));
	  			return endTimeMsg.isDisplayed();
	  		}
	  		
	  		//TO CONFFIRM THE START TIME REQUIRED MESSAGE
	  		public boolean isDisplayedStartTimeRequired_RU() {
	  			WebElement startTimeMsg = driver.findElement(By.xpath(startTimeRequired_RU));
	  			return startTimeMsg.isDisplayed();
	  		}
	  		
	  		//TO SET END TIME WITHOUT USING END TIME PICKER
	  		public void setEndTimeWithoutUsingTimePicker_RU(WebDriver driver, String hours, String minutes, String AmPm) throws InterruptedException
	  		{
	  			WebElement endTimePlaceHolder = driver.findElement(By.xpath(textTimePlaceHolder_2_RU));
	  			endTimePlaceHolder.sendKeys(Keys.CONTROL, "a");      // Select all text
	  			endTimePlaceHolder.sendKeys(Keys.CONTROL, "DELETE"); // Delete selected text

	  			logger.info("hours: "+hours);
	  			endTimePlaceHolder.sendKeys(hours);
	  			Thread.sleep(300);
	  			endTimePlaceHolder.sendKeys(minutes);
	  			logger.info("minutes: "+minutes);
	  			Thread.sleep(300);
	  			endTimePlaceHolder.sendKeys(AmPm);
	  			logger.info("AmPm: "+AmPm);
	  			Thread.sleep(300);
	  			logger.info("Entered end time");
	  		}
	  		
	  		//TO SET START TIME WITHOUT USING TIME PICKER
	  		public void setStartTimeWithoutUsingTimePicker_RU(WebDriver driver, String hours, String minutes, String AmPm) throws InterruptedException
	  		{
	  			WebElement endTimePlaceHolder = driver.findElement(By.xpath(textTimePlaceHolder_2_RU));
	  			endTimePlaceHolder.sendKeys(Keys.CONTROL, "a");      // Select all text
	  			endTimePlaceHolder.sendKeys(Keys.CONTROL, "DELETE"); // Delete selected text

	  			logger.info("hours: "+hours);
	  			endTimePlaceHolder.sendKeys(hours);
	  			Thread.sleep(300);
	  			endTimePlaceHolder.sendKeys(minutes);
	  			logger.info("minutes: "+minutes);
	  			Thread.sleep(300);
	  			endTimePlaceHolder.sendKeys(AmPm);
	  			logger.info("AmPm: "+AmPm);
	  			Thread.sleep(300);
	  			logger.info("Entered end time");
	  		}

	  	  //==========END==========TIME SELECTION PAGE OBJECTS AND ITS ACTION METHODS=====USE THIS METHODS IF AND ONLY IF TIME PICKRE FAILED TO PICK THE TIME======//
  		
	  		//TO SELECT DATE IF IT IS SECONDS ONE DATE AND DATE FAILED TO PICK THE DATE
	  		String endDateHolder_RU = "(//input[contains(@placeholder,'MM/DD/YYYY')])[2]";
	  		public void setSecondsDateWithoutUsingDatePicker_RU(String leaveEndDate) throws InterruptedException {
	  			WebElement endDate = driver.findElement(By.xpath(endDateHolder_RU));
	  			endDate.sendKeys(Keys.CONTROL,"a");
	  			endDate.sendKeys(Keys.DELETE);
	  			String[] date = leaveEndDate.split(" ");
	  			String dt = date[0];
	  			String mt = date[1];
	  			String yr = date[2];
	  			int x = 0;
	  			String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	  			for(String mon : months)
	  			{	x++;
	  				if(mon.equals(mt)){
	  					break;
	  				}
	  			}
	  			String xAsString = String.valueOf(x);
	  			endDate.sendKeys(xAsString);
	  			Thread.sleep(200);
	  			endDate.sendKeys(dt);
	  			Thread.sleep(200);
	  			endDate.sendKeys(yr);
	  			Thread.sleep(200);
	  			logger.info("Entered second one date");
	  			
	  		}
  
	  		

}

