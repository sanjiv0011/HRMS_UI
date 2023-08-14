package com.hrms.ReUseAble.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReUseAbleElement {
	public WebDriver driver=null;
	
	public ReUseAbleElement(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	//========START=======Actions Elements===========TO USE ANY ONE OF THIS FIRST SEARCH IT SO THAT IT COMES AT TOP=========//
	//to search the leave balance
		@FindBy(xpath = "//input[@placeholder='Search…']")
		@CacheLookup
		public WebElement searchBox;
		public void searchLeaveBalance_RU(String leaveTypeSearchKey)
		{
			searchBox.sendKeys(leaveTypeSearchKey,Keys.ENTER);
		}
	
		// Action button three dot for
		@FindBy(xpath = "//tbody/tr[1]/td[5]/div[1]//*[name()='svg']")
		@CacheLookup
		public WebElement btnAction;
		// Action method to click the Action button
	    public void clickActionButton_RU() {
	        btnAction.click();
	    }

		
	  //===========START=======ACTIVATE AND DEACTIVATE==================//
	    
		//ACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Active')])[1]")
		@CacheLookup
		public WebElement actionActivate;
		// Action method to click the Archive action
	    public void clickArchiveAction_RU() {
	        actionActivate.click();
	    }
		
		//DEACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Deactive')])[1]")
		@CacheLookup
		public WebElement actionDeactivate;
		 // Action method to click the Restore action
	    public void clickRestoreAction_RU() {
	        actionDeactivate.click();
	    }
	    
	 // No button before confirm the action
	 		@FindBy(xpath = "//div[contains(text(),'Leave Type Activated Successfully.')]")
	 		@CacheLookup
	 		public WebElement msgActivated;
	 		 // Action method to get the message after archiving
	 	    public String getArchivedMessage_RU() {
	 	        return msgActivated.getText();
	 	    }
	 		
	 	    // No button before confirm the action
	  		@FindBy(xpath = "//div[contains(text(),'Leave Deactivated Successfully.')]")
	  		@CacheLookup
	  		public WebElement msgDeactivated;
	 	    // Action method to get the message after restoring
	 	    public String getRestoredMessage_RU() {
	 	        return msgDeactivated.getText();
	 	    }
	 		
	 	    //TO CHECK LABLE INACTIVE
	 	    @FindBy(xpath="//span[normalize-space()='InActive']")
	 	    @CacheLookup
	 	    public WebElement inactiveLabel;
	 	    public boolean isAlreadyInActiveDisplayed_RU() {
	 	        boolean flag = false;
	 	        if (inactiveLabel.isDisplayed()) {
	 	            flag = true;
	 	            System.out.println("InActive label present: "+flag);
	 	        }
	 	        return flag;
	 	    }
	 	    
	 	    //TO CHECK LABLE ACTIVE 
	 	    @FindBy(xpath="//span[normalize-space()='Active']")
	 	    @CacheLookup
	 	    public WebElement activeLabel;
	 	    public boolean isAlreadyActiveDisplayed_RU() {
	 	        boolean flag = false;
	 	        if (activeLabel.isDisplayed()) {
	 	            flag = true;
	 	            System.out.println("InActive label present: "+flag);
	 	        }
	 	        return flag;
	 	    }
	 	    
	 	//===========END=======ACTIVATE AND DEACTIVATE==================//
	    
	    //===========START=======ARCHIVE AND RESTORE==================//
	    
	    //Archive Action => To use this first search list item so that it comes at first position
  		@FindBy(xpath = "(//div[contains(text(),'Archive')])[1]")
  		@CacheLookup
  		WebElement actionArchive;
  		// Action method to click the Archive action
  	    public void clickArchiveAction() {
  	        actionArchive.click();
  	    }
  		
  		//Restore Action => To use this first search list item so that it comes at first position
  		@FindBy(xpath = "(//div[contains(text(),'Restore')])[1]")
  		@CacheLookup
  		WebElement actionRestore;
  		 // Action method to click the Restore action
  	    public void clickRestoreAction() {
  	        actionRestore.click();
  	    }
		
  	    // No button before confirm the action
		@FindBy(xpath = "//div[contains(text(),'Leave Balance Restored Successfully.')]")
		@CacheLookup
		WebElement msgArchived;
		 // Action method to get the message after archiving
	    public String getArchivedMessage() {
	        return msgArchived.getText();
	    }
		
	    // No button before confirm the action
 		@FindBy(xpath = "//div[contains(text(),'Leave Balance Archived Successfully.')]")
 		@CacheLookup
 		WebElement msgRestored;
	    // Action method to get the message after restoring
	    public String getRestoredMessage() {
	        return msgRestored.getText();
	    }
		
	    //TO CHECK ALLREADY ARCHIVED
	    @FindBy(xpath="//span[text()='Archived']")
	    @CacheLookup
	    WebElement archivedLabel;
	    public boolean isAlreadyArchivedDisplayed() {
	        boolean flag = false;
	        if (archivedLabel.isDisplayed()) {
	            flag = true;
	            System.out.println(flag);
	        }
	        return flag;
	    }
	  //===========END=======ARCHIVE AND RESTORE==================//
	    
	    
		//Edit Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Edit')])[1]")
		@CacheLookup
		public WebElement actionEdit;
		// Action method to click the Edit action
	    public void clickEditAction_RU() {
	        actionEdit.click();
	    }
		
	    
	    //===========START=======FOR THE BUTTON YES, NO, SAVE CHANGES, AND DELETE==================//
	    
		// Yes button before confirm the action
		@FindBy(xpath = "//p[normalize-space()='Yes']")
		@CacheLookup
		public WebElement btnYes;
		 // Action method to click the Yes button
	    public void clickYesButton_RU() {
	        btnYes.click();
	    }
		
		// No button before confirm the action
		@FindBy(xpath = "//p[normalize-space()='No']")
		@CacheLookup
		public WebElement btnNo;
		// Action method to click the No button
	    public void clickNoButton_RU() {
	        btnNo.click();
	    }
	    
	    //DELETE BUTTON
	    @FindBy(xpath = "(//div[contains(text(),'Delete')])[1]")
	    @CacheLookup
	    public WebElement btnDelete;
	    public void clickOnBtnDelete_RU() {
	    	btnDelete.click();
	    }
	    
	    //SAVE CHANGES BUTTON
	    @FindBy(xpath = "//p[normalize-space()='Save Changes']")
		@CacheLookup
		public WebElement btnSaveChanges;
	    public void clickOnBtnSaveChanges() {
			btnSaveChanges.click();
		}
		
	  //===========END=======FOR THE BUTTON YES, NO, SAVE CHANGES, AND DELETE==================//

		//========START=======Actions Elements=========TO USER ANY ONE OF THIS FIRST SEARCH IT SO THAT IT COMES AT TOP===========//

}
