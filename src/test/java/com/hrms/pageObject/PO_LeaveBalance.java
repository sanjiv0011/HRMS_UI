package com.hrms.pageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import my_support.Action_Archive;
import my_support.Action_Restore;
import my_support.DatePicker;
import my_support.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_LeaveBalance {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	public FluentWait<WebDriver> wait;
	
	public PO_LeaveBalance(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new FluentWait<>(this.driver)  // Initialize FluentWait with the driver
	            .withTimeout(Duration.ofSeconds(10)) // Set the timeout duration
	            .pollingEvery(Duration.ofMillis(500)) // Set how often to check for the condition
	            .ignoring(NoSuchElementException.class); // Specify exceptions to ignore
		
	}

	//=====START====Leave balance page and Create Leave balance page object============//
	// to click on the create leave balance button on the leave balance page
	@FindBy(xpath = "//button//p[.='Create Leave Balance']")
	@CacheLookup
	WebElement btnCreateLeaveBalance;
	
	//==========START=========SELECT LeaveBalanceStartDate================//
		//Click on date of birth icon
		@FindBy(xpath = "(//button[contains(@aria-label,'Choose date')])[1]")
		@CacheLookup
		WebElement iconDateStart;
		
		// to click on toggle button to select date and year
		@FindBy(xpath = "//button[contains(@aria-label,'calendar view')]")
		@CacheLookup
		WebElement toggleBtnYearAndDate;
		
		// to select the year
		@FindBy(xpath = "//div[contains(@class, 'MuiYearCalendar-root')]//div")
		@CacheLookup
		List <WebElement> selectYear;
		
		// to select the next Month
		@FindBy(xpath = "//button[@title=\"Next month\"]")
		@CacheLookup
		WebElement arrowNextMonth;
		
		// to select the Month
		@FindBy(xpath = "//button[@title=\"Previous month\"]")
		@CacheLookup
		WebElement arrowPreviousMonth;
		
		// to match exact Month and year
		//@FindBy(xpath = "//div[contains(@class,'MuiPickersCalendarHeader-label')]"
		@FindBy(xpath ="//div[contains(@id,'grid-label')]")
		@CacheLookup
		WebElement elementCurrentMonthYearDisplayed;
		
		// to select the date
		@FindBy(xpath = "//div[@role='row']//button")
		@CacheLookup
		List <WebElement> selectDate;
		
		//==========END=========LeaveBalanceStartDate================//
		
		
		//==========START=========SELECT LeaveBalanceEndDate================//
		//Click on leave balance start date icon
		@FindBy(xpath = "(//button[contains(@aria-label,'Choose date')])[2]")	//(//button[contains(@aria-label,'Choose date')])[2]
		@CacheLookup
		WebElement iconDateEnd;
		
//		// to click on toggle button to select date and year
//		@FindBy(xpath = "//button[@aria-label=\"calendar view is open, switch to year view\"]")
//		@CacheLookup
//		WebElement toggleBtnToSelect_LeaveBalanceEndDate_YearAndDate;
//		
//		// to select the year
//		@FindBy(xpath = "//div[contains(@class, 'MuiYearCalendar-root')]//div")
//		@CacheLookup
//		List <WebElement> select_LeaveBalanceEndDate_Year;
//		
//		// to select the next Month
//		@FindBy(xpath = "//button[@title=\"Next month\"]")
//		@CacheLookup
//		WebElement icon_LeaveBalanceEndDate_NextMonth;
//		
//		// to select the Month
//		@FindBy(xpath = "//button[@title=\"Previous month\"]")
//		@CacheLookup
//		WebElement icon_LeaveBalanceEndDate_PreviousMonth;
//		
//		// to match exact Month and year
//		//@FindBy(xpath = "//div[contains(@class,'MuiPickersCalendarHeader-label')]"
//		@FindBy(xpath ="//div[contains(@id,'grid-label')]")
//		@CacheLookup
//		WebElement text_LeaveBalanceEndDate_currentMonthYearDisplayed;
//		
//		// to select the date
//		@FindBy(xpath = "//div[@role='row']//button")
//		@CacheLookup
//		List <WebElement> select_LeaveBalanceEndDate_Date;
//		
//		//==========END=========LeaveBalanceEndDate================//

	
	@FindBy(xpath = "//button[@title=\"Open\"]//*[name()=\"svg\"]")
	@CacheLookup
	WebElement iconDropDownEnterLeaveType;
	
	@FindBy(xpath = "//ul[@id=\"leaveType-listbox\"]//li")
	@CacheLookup
	List <WebElement> listLeaveTypes;

	@FindBy(xpath = "//input[@name='balance']")
	@CacheLookup
	WebElement textEnterLeaveBalance;
	
	@FindBy(xpath = "//p[normalize-space()=\"Create\"]")
	@CacheLookup
	WebElement btnCreate;
	
	@FindBy(xpath = "//p[normalize-space()='Save Changes']")
	@CacheLookup
	WebElement btnSaveChanges;
	
	@FindBy(xpath = "//p[normalize-space()=\"Cancel\"]")
	@CacheLookup
	WebElement btnCancel;
	
	// confirmation message
	@FindBy(xpath = "//div[contains(text(),\"Leave balance already exists.\")]")
	@CacheLookup
	WebElement msgAlreadyExist;
	
	@FindBy(xpath = "//div[contains(text(),\"Leave Balance Created Successfully.\")]")
	@CacheLookup
	WebElement msgCreated;
	
		
	
	//Action methods
	public void clickOnBtnCreateLeaveBalance()
	{
		btnCreateLeaveBalance.click();
		logger.info("Click on Create leave type button");
	}
	
//	public void selectLeaveBalanceStartDate(String leaveBalanceStartDate) throws InterruptedException 
//	{
//		DatePicker.DatePicker_GenericMethod_WithoutDropDown(icon_LeaveBalanceStartDate, toggleBtnToSelect_LeaveBalanceStartDate_YearAndDate, text_LeaveBalanceStartDate_currentMonthYearDisplayed, icon_LeaveBalanceStartDate_NextMonth, icon_LeaveBalanceStartDate_PreviousMonth, select_LeaveBalanceStartDate_Date, select_LeaveBalanceStartDate_Year,  leaveBalanceStartDate);
//		logger.info("LeaveBalanceStartDate date, month and year entered");
//	}
//	
//	public void selectLeaveBalanceEndDate(String leaveBalanceEndDate) throws InterruptedException 
//	{
//		DatePicker.DatePicker_GenericMethod_WithoutDropDown(icon_LeaveBalanceEndtDate, toggleBtnToSelect_LeaveBalanceEndDate_YearAndDate, text_LeaveBalanceEndDate_currentMonthYearDisplayed, icon_LeaveBalanceEndDate_NextMonth, icon_LeaveBalanceEndDate_PreviousMonth, select_LeaveBalanceEndDate_Date, select_LeaveBalanceEndDate_Year,  leaveBalanceEndDate);
//		logger.info("Leave balance end date, month and year entered");
//	}
	
	public void clickOnDropDownIconLeaveType()
	{
		iconDropDownEnterLeaveType.click();
		logger.info("Clicked on the dropdown icon leave types");
	}
	
	public void selectLeaveTypesName(String leaveTypeName)
	{
		for(WebElement li : listLeaveTypes )
		{
			System.out.println(li.getText());
		}
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listLeaveTypes,leaveTypeName );
		logger.info("Leave types selected");
	}
	
	public void setLeaveBalance(String leaveBalance)
	{
		textEnterLeaveBalance.sendKeys(leaveBalance);
		logger.info("Enterd leave leaveBalance");
	}
	
	public void clickBtnCreate()
	{
		btnCreate.click();
		logger.info("clicked on Create button");
	}
	
	public void clickOnBtnSaveChanges() {
		btnSaveChanges.click();
		logger.info("Clicked on the button save changes");
	}
	
	public void clickBtnCancel()
	{
		btnCancel.click();
		logger.info("Clicked on Cancel button");
	}
	
	//ALL IN ONE CREATE LEAVE BALANCE
	public PO_HomePage createLeaveBalance(String leaveBalanceStartDate, String leaveBalanceEndDate, String leaveTypeName, String leaveBalance) throws InterruptedException
	{
		logger.info("Entered create leave balance Methods");
		
		btnCreateLeaveBalance.click();
		logger.info("Click on Create leave balance button");
		Thread.sleep(2000);
		
		
//		DatePicker.DatePicker_GenericMethod_WithoutDropDown(icon_LeaveBalanceEndtDate, toggleBtnToSelect_LeaveBalanceEndDate_YearAndDate, text_LeaveBalanceEndDate_currentMonthYearDisplayed, icon_LeaveBalanceEndDate_NextMonth, icon_LeaveBalanceEndDate_PreviousMonth, select_LeaveBalanceEndDate_Date, select_LeaveBalanceEndDate_Year,  leaveBalanceEndDate);
//		logger.info("Leave balance end date, month and year entered");
//		//Thread.sleep(1000);
		
//		DatePicker.DatePicker_GenericMethod_WithoutDropDown(icon_LeaveBalanceStartDate, toggleBtnToSelect_LeaveBalanceEndDate_YearAndDate, text_LeaveBalanceEndDate_currentMonthYearDisplayed, icon_LeaveBalanceEndDate_NextMonth, icon_LeaveBalanceEndDate_PreviousMonth, select_LeaveBalanceEndDate_Date, select_LeaveBalanceEndDate_Year,  leaveBalanceStartDate);
//		logger.info("Leave balance end date, month and year entered");
//		//Thread.sleep(1000);
		
		iconDateEnd.click();
		logger.info("Clicked on the end date icon");
		Thread.sleep(500);
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(toggleBtnYearAndDate));
			toggleBtnYearAndDate.click();
		}catch(Exception e) {
			e.getCause();
		}
		
		DatePicker.DatePicker_GenericMethod_WithoutDropDown(toggleBtnYearAndDate, elementCurrentMonthYearDisplayed , arrowNextMonth, arrowPreviousMonth, selectDate, selectYear,  leaveBalanceEndDate);
		logger.info("Leave balance start date, month and year entered");
		Thread.sleep(2000);
		
		iconDateStart.click();
		logger.info("Clicked on the start date icon");
		Thread.sleep(500);
		DatePicker.DatePicker_GenericMethod_WithoutDropDown(toggleBtnYearAndDate, elementCurrentMonthYearDisplayed , arrowNextMonth, arrowPreviousMonth, selectDate, selectYear,  leaveBalanceStartDate);
		logger.info("Leave balance start date, month and year entered");
		Thread.sleep(2000);
		
		iconDropDownEnterLeaveType.click();
		logger.info("Clicked on the dropdown icon leave types");
		Thread.sleep(1000);
		
		for(WebElement li : listLeaveTypes )
		{
			System.out.println("From create leave balance method: "+li.getText());
		}
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listLeaveTypes,leaveTypeName );
		logger.info("Leave types selected");
		Thread.sleep(1000);
		
		textEnterLeaveBalance.sendKeys(leaveBalance);
		logger.info("Enterd leave leaveBalance");
		Thread.sleep(1000);
		
		btnCreate.click();
		logger.info("clicked on Create button");
		//Thread.sleep(500);
		
		try {
			if(msgCreated.getText().contains("Leave Balance Created Successfully"))
			{
				Assert.assertTrue("Leave balance created ",true);
			}else if(msgCreated.getText().contains("Leave balance already exists")){
				Assert.assertTrue("Leave balance already exist ",true);
			}
		}catch(Exception e){
			e.getCause();
		}
		
		return new PO_HomePage(driver);
	}
	
	
	
	//to use this first that leave balance so that it comes at first
		//to search the leave balance
		@FindBy(xpath = "//input[@placeholder='Search…']")
		@CacheLookup
		WebElement searchBox;
		public void searchLeaveBalance(String leaveBalanceSearchKey)
		{
			searchBox.sendKeys(leaveBalanceSearchKey,Keys.ENTER);
		}
		
		//========START=======Actions Elements===========TO USER ANY ONE OF THIS FIRST SEARCH IT SO THAT IT COMES AT TOP=========//
		// Action button three dot for
		@FindBy(xpath = "//tbody/tr[1]/td[5]/div[1]//*[name()='svg']")
		@CacheLookup
		WebElement btnAction;
		// Action method to click the Action button
	    public void clickActionButton() {
	        btnAction.click();
	    }

		
		
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
		
		
		//Edit Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Edit')])[1]")
		@CacheLookup
		WebElement actionEdit;
		// Action method to click the Edit action
	    public void clickEditAction() {
	        actionEdit.click();
	    }
		
		// Yes button before confirm the action
		@FindBy(xpath = "//p[normalize-space()='Yes']")
		@CacheLookup
		WebElement btnYes;
		 // Action method to click the Yes button
	    public void clickYesButton() {
	        btnYes.click();
	    }
		
		// No button before confirm the action
		@FindBy(xpath = "//p[normalize-space()='No']")
		@CacheLookup
		WebElement btnNo;
		// Action method to click the No button
	    public void clickNoButton() {
	        btnNo.click();
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
	    

		//========START=======Actions Elements=========TO USER ANY ONE OF THIS FIRST SEARCH IT SO THAT IT COMES AT TOP===========//
		
	   
	    //============START========ARCHIVE LEAVE BALANCE=============//
	    public PO_HomePage archiveLeaveBalance(String leaveBalanceName) throws InterruptedException
	    {	
	    	logger.info("Archive leave balance methods called");
	    	
	    	//METHODS TO ARCHIVE THE LEAVE BALNACE 
	    	Action_Archive.archive(leaveBalanceName, searchBox, archivedLabel, btnAction, actionArchive, btnYes, "cofirmMessage");
	    
	    	
	    	 
//	    	 String msg = getArchivedMessage();
//	    	 try {
//	    		 wait.until(ExpectedConditions.invisibilityOf(msgCreated));
//	    		 if(msg.contains("Leave Balance Archived Successfully")) {
//		    		 Assert.assertTrue(true);
//		    		 logger.info("Leave balance archived passed...");
//		    	 }else {
//		    		 Assert.assertTrue(false);
//		    		 logger.info("Leave balance archived failed!!!");
//		    	 }
//	    	 }catch(Exception e)
//	    	 {
//	    		 e.getCause();
//	    	 }
	    	 logger.info("Return to archiveLeaveBalance method");
	    	 return new PO_HomePage(driver);
	    }
	    //==============END=======ARCHIVE LEAVE BALANCE===============//
	    
	    
	  //============START========RESTORE LEAVE BALANCE=============//
	    public PO_HomePage restoreLeaveBalance(String leaveBalanceName) throws InterruptedException
	    {
	    	logger.info("Restore leave balance methods called");
	    	
	    	//METHODS TO ARCHIVE THE LEAVE BALNACE 
	    	Action_Restore.restore(leaveBalanceName, searchBox,archivedLabel, btnAction, actionRestore, btnYes, "confirmMessage" );
	    	
//	    	 String msg = getRestoredMessage();
//	    	 try {
//	    		 wait.until(ExpectedConditions.invisibilityOf(msgCreated));
//	    		 if(msg.contains("Leave Balance Restored Successfully")) {
//		    		 Assert.assertTrue(true);
//		    		 logger.info("Leave balance restored passed...");
//		    	 }else {
//		    		 Assert.assertTrue(false);
//		    		 logger.info("Leave balance restored failed!!!");
//		    	 }
//	    	 }catch(Exception e)
//	    	 {
//	    		 e.getCause();
//	    	 }
	    	 logger.info("Return to restoreLeaveBalance method");
	    	 return new PO_HomePage(driver);
	    }
	    //==============END=======RESTORE LEAVE BALANCE===============//
	    
	    
	    
	  //============START========EDIT LEAVE BALANCE=============//
	    public PO_HomePage editLeaveBalance(String leaveBalanceStartDate, String leaveBalanceEndDate, String leaveTypeName, String leaveBalance) throws InterruptedException
	    {
	    	logger.info("Edit leave balance methods called");
	    	
	    	searchBox.sendKeys(leaveTypeName, Keys.ENTER);
	    	logger.info("Clicked on the search box button");
	    	Thread.sleep(5000);
	    	
	    	btnAction.click();
	    	logger.info("Clicked on the Action button");
	    	Thread.sleep(1000);
	    	
	    	//===========START EDITING=========To edit this details===========//
	    	actionEdit.click();
	    	logger.info("Clicked on the edit button");
	    	Thread.sleep(2000);
	    	
	    	
	    	iconDateEnd.click();
			logger.info("Clicked on the end date icon");
			DatePicker.DatePicker_GenericMethod_WithoutDropDown(toggleBtnYearAndDate, elementCurrentMonthYearDisplayed , arrowNextMonth, arrowPreviousMonth, selectDate, selectYear,  leaveBalanceEndDate);
			logger.info("Leave balance start date, month and year entered");
			Thread.sleep(2000);
			
			iconDateStart.click();
			logger.info("Clicked on the start date icon");
			DatePicker.DatePicker_GenericMethod_WithoutDropDown(toggleBtnYearAndDate, elementCurrentMonthYearDisplayed , arrowNextMonth, arrowPreviousMonth, selectDate, selectYear,  leaveBalanceStartDate);
			logger.info("Leave balance start date, month and year entered");
			Thread.sleep(2000);
			
			iconDropDownEnterLeaveType.click();
			logger.info("Clicked on the dropdown icon leave types");
			Thread.sleep(1000);
			
			for(WebElement li : listLeaveTypes )
			{
				System.out.println("From create leave balance method: "+li.getText());
			}
			Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listLeaveTypes,leaveTypeName );
			logger.info("Leave types selected");
			Thread.sleep(1000);
			
			textEnterLeaveBalance.sendKeys(leaveBalance);
			logger.info("Enterd leave leaveBalance");
			Thread.sleep(1000);
			
			btnSaveChanges.click();
			logger.info("clicked on button save changes");
			Thread.sleep(200);
			
//			try {
//				wait.until(ExpectedConditions.invisibilityOf(msgCreated));
//				if(msgCreated.getText().contains("Leave Balance Created Successfully"))
//				{
//					Assert.assertTrue("Leave balance created ",true);
//				}else if(msgCreated.getText().contains("Leave balance already exists")){
//					Assert.assertTrue("Leave balance already exist ",true);
//				}
//			}catch(Exception e) {
//				e.getCause();
//			}
			//===========END EDITING=========To edit this details===========//
	    	 
			logger.info("Return back inside editLeaveBalance method");
	    	return new PO_HomePage(driver);
	    }
	    //==============END=======EDIT LEAVE BALANCE===============//
	
}
