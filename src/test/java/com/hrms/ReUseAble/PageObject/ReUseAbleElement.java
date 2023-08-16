package com.hrms.ReUseAble.PageObject;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ReUseAbleElement {
	
	//CONSTRUCTOR INITIALIZATIONS
	public WebDriver driver=null;
	public static final Logger logger = LogManager.getLogger(ReUseAbleElement.class);
	
	//CREATE PAGE FACTORY METHODS WITH DRIVERS
	public ReUseAbleElement(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	//========START=======Actions Elements===========TO USE ANY ONE OF THIS FIRST SEARCH IT SO THAT IT COMES AT TOP=========//
		//SEARCH BOX
		@FindBy(xpath = "//input[@placeholder='Search…']")
		@CacheLookup
		public WebElement searchBox;
		public void searchBox_RU(String SearchKey) throws InterruptedException
		{	Thread.sleep(200);
			searchBox.sendKeys(SearchKey,Keys.ENTER);
			logger.info("Searched the search keys in the search box: "+SearchKey);
			Thread.sleep(5000);
		}
	
		// Action button three dot for
		@FindBy(xpath = "//div[@class='pointer']//*[name()='svg']")
		@CacheLookup
		public WebElement btnAction;
		// Action method to click the Action button
	    public void clickOnActionButton_RU() throws InterruptedException {
	        btnAction.click();
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
	    
	 // No button before confirm the action
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
	 		
	 	    // No button before confirm the action
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
		
  	    // No button before confirm the action
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
		
	    // No button before confirm the action
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
		public WebElement actionEdit;
		// Action method to click the Edit action
	    public void clickOnEditAction_RU() throws InterruptedException {
	        actionEdit.click();
	        logger.info("Clicked on the Action_Edit button");
	        Thread.sleep(300);
	    }
		
	    
	    //===========START=======FOR THE BUTTON YES, NO, SAVE CHANGES, AND DELETE==================//
	    
		@FindBy(xpath = "//p[normalize-space()=\"Create\"]")
		@CacheLookup
		public WebElement btnCreate;
		public void clickOnCreateButton_RU() throws InterruptedException{
		   btnCreate.click();
		   logger.info("Clicked on the Create button");
		   Thread.sleep(300);
		}

		@FindBy(xpath = "//p[normalize-space()=\"Cancel\"]")
		@CacheLookup
		public WebElement btnCancel;
		public void clickOnCancelButton_RU() throws InterruptedException {
		   btnCancel.click();
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
	        Thread.sleep(300);
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
		public WebElement btnSaveChanges;
	    public void clickOnBtnSaveChanges_RU() throws InterruptedException {
			btnSaveChanges.click();
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
	    
	    //SAVE AND GO TO HOME BUTTON
	    @FindBy(xpath = "//p[text()='Save & Go To Home']")
		@CacheLookup
		public WebElement btnSaveAndGoToHome;
	    public void clickOnBtnSaveAndGoToHome_RU() throws InterruptedException {
	    	btnSaveAndGoToHome.click();
	    	logger.info("Clicked on the save and go to home button");
			Thread.sleep(300);
		}
	    
	    //NEXT BUTTON
	    @FindBy(xpath = "//p[normalize-space()='Next']")
		@CacheLookup
		public WebElement btnNext;
	    public void clickOnBtnNext_RU() throws InterruptedException {
	    	btnNext.click();
	    	logger.info("Clicked on the nextbutton");
			Thread.sleep(300);
		}
	    
	  
	    
	    
		
	  //===========END=======FOR THE BUTTON YES, NO, SAVE CHANGES, CROSS BUTTON, SAVE & GO TO HOME, AND DELETE==================//
	//========START=======Actions Elements=========TO USER ANY ONE OF THIS FIRST SEARCH IT SO THAT IT COMES AT TOP===========//
	    
	    
	    
  //==========START=========DATE SELECTION=========THIS ELEMENT NEVER GET CHANSE TO CALLS INDIVISUALLY THAT WHY ACTION METHODS IMPLEMENTED UNDER DATE PICKER CLASS=======//
		// to click on toggle button to select date and year
		@FindBy(xpath = "//button[contains(@aria-label,'calendar view')]")
		@CacheLookup
		public WebElement toggleBtnYearAndDate;
		
		// to select the year
		@FindBy(xpath = "//div[contains(@class, 'MuiYearCalendar-root')]//div")
		@CacheLookup
		public List <WebElement> selectYear;
		
		// to select the next Month
		@FindBy(xpath = "//button[@title=\"Next month\"]")
		@CacheLookup
		public WebElement arrowNextMonth;
		
		// to select the Month
		@FindBy(xpath = "//button[@title=\"Previous month\"]")
		@CacheLookup
		public WebElement arrowPreviousMonth;
		
		// to match exact Month and year
		//@FindBy(xpath = "//div[contains(@class,'MuiPickersCalendarHeader-label')]"
		@FindBy(xpath ="//div[contains(@id,'grid-label')]")
		@CacheLookup
		public WebElement elementCurrentMonthYearDisplayed;
		
		// to select the date
		@FindBy(xpath = "//div[@role='row']//button")
		@CacheLookup
		public List <WebElement> selectDate;
  //==========END=========DATE SELECTION=========THIS ELEMENT NEVER GET CHANSE TO CALLS INDIVISUALS THAT WHY ACTION METHODS IMPLEMENTED UNDER DATE PICKER CLASS=======//
		
		
  //===========START======ACTIVATE AND DEACTIVATE ONLY FOR USER PAGE OBJECT AND ITE ACTION METHODS===========//
		//ACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[normalize-space()='Activate'])[1]")
		@CacheLookup
		public WebElement actionActivateUser;
		// Action method to click the Archive action
	    public void clickOnActivateAction_RU_User() throws InterruptedException {
	        actionActivate.click();
	        logger.info("Clicked on the Action_Activate button");
	        Thread.sleep(300);
	    }
		
		//DEACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Deactivate')])[1]")
		@CacheLookup
		public WebElement actionDeactivateUser;
		 // Action method to click the Restore action
	    public void clickOnDeactivateAction_RU_User() throws InterruptedException {
	        actionDeactivate.click();
	        logger.info("Clicked on the Action_Deactivated button");
	        Thread.sleep(300);
	    }
  //===========END======ACTIVATE AND DEACTIVATE ONLY FOR USER PAGE OBJECT AND ITE ACTION METHODS===========//	

}

