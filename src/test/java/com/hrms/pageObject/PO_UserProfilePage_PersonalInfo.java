package com.hrms.pageObject;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import my_support.DatePicker;
import my_support.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_UserProfilePage_PersonalInfo {
	
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	
	
	public PO_UserProfilePage_PersonalInfo(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//==========START======PERSONAL INFO PAGE OBJECT===============//
	@FindBy(xpath = "//input[@name=\"phoneNumber\"]`")
	@CacheLookup
	WebElement textEnterPhoneNumber;

	
	//==========START=========SELECTINO DATE OF BIRTH================//
	
	//Click on date of birth icon
	@FindBy(xpath = "(//button[@aria-label='Choose date'])[1]")
	@CacheLookup
	WebElement iconDateOfBirth;
	
	// to click on toggle button to select date and year
	@FindBy(xpath = "//button[@aria-label=\"calendar view is open, switch to year view\"]")
	@CacheLookup
	WebElement toggleBtnToSelectYearAndDate;
	
	// to select the year
	@FindBy(xpath = "//div[contains(@class, 'MuiYearCalendar-root')]//div")
	@CacheLookup
	List <WebElement> selectDateOfBirthYear;
	
	// to select the next Month
	@FindBy(xpath = "//button[@title=\"Next month\"]")
	@CacheLookup
	WebElement iconDateOfBirthNextMonth;
	
	// to select the Month
	@FindBy(xpath = "//button[@title=\"Previous month\"]")
	@CacheLookup
	WebElement iconDateOfBirthPreviousMonth;
	
	// to match exact Month and year
	//@FindBy(xpath = "//div[contains(@class,'MuiPickersCalendarHeader-label')]"
	@FindBy(xpath ="//div[contains(text(), 'August')]")
	@CacheLookup
	WebElement currentMonthYearDisplayed;
	
	// to select the date
	@FindBy(xpath = "//div[@role='row']//button")
	@CacheLookup
	List <WebElement> selectDateOfBirthDate;
	
	//==========END=========SELECTINO DATE OF BIRTH================//
	
	
	
	
	// to select the gender
	@FindBy(xpath = "//ul[@id=\"gender-listbox\"]//li")
	@CacheLookup
	List <WebElement> selectGender;

	@FindBy(xpath = "//ul[@id=\"maritalStatus-listbox\"]//li")
	@CacheLookup
	List <WebElement> selectMaritalStatus;

	@FindBy(xpath = "//ul[@id=\"employmentStatus-listbox\"]//li")
	@CacheLookup
	List <WebElement> selectEmploymentStatus;

	@FindBy(xpath = "//input[@name=\"department\"]")
	@CacheLookup
	WebElement textDepartment;

	@FindBy(xpath = "//input[@name=\"bio\"]")
	@CacheLookup
	WebElement textBio;

	@FindBy(xpath = "//input[@id=':r3j:']")
	@CacheLookup
	WebElement selectHireDate;

	@FindBy(xpath = "//ul[@id=\"jobTitleId-listbox\"]//li")
	@CacheLookup
	List <WebElement> selectJobTitle;
	
	@FindBy(xpath = "//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-10yb37c']//*[name()='svg']")
	@CacheLookup
	WebElement imgageProfile;

	@FindBy(xpath = "//div[@class='MuiBox-root css-deejpe']//div[1]//button[1]//p[1]")
	@CacheLookup
	WebElement btnPersonalInfoSaveandGoToHome;

	@FindBy(xpath = "//div[@class='MuiBox-root css-deejpe']//div[1]//button[1]//p[1]")
	@CacheLookup
	WebElement btnPersonalInfoNext;
	//=====END====Personal info Page objects============//
	
	
	public void setPhoneNumber(String phoneNumber) 
	{
		textEnterPhoneNumber.sendKeys(phoneNumber);
		logger.info("Phone number entered");
	}
	
	
	public void selectDateOfBirth(String dob) throws InterruptedException 
	{
		iconDateOfBirth.click();
		DatePicker.DatePicker_GenericMethod_WithoutDropDown(toggleBtnToSelectYearAndDate, currentMonthYearDisplayed, iconDateOfBirthNextMonth, iconDateOfBirthPreviousMonth, selectDateOfBirthDate,selectDateOfBirthYear,  dob);
		logger.info("Date of birth entered");
	}
	
	
	public void setGender(String gnd)
	{
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(selectGender,gnd) ;
		logger.info("Gender selected: "+gnd);
	}
	public void selectMaritalStatus(String marri) 
	{
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(selectMaritalStatus,marri) ;
		logger.info("Selected MaritalStatus: "+marri);
	}
	public void selectEmploymentStatus(String empStatus) 
	{
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(selectEmploymentStatus,empStatus) ;
		logger.info("Selected employmentStatus: "+empStatus);
	}
	
	public void setDepartment(String deparment) 
	{
		textDepartment.sendKeys(deparment);
		logger.info("Entered textDepartment");
	}
	
	public void settBio(String bio) 
	{
		textBio.sendKeys(bio);
		logger.info("Bio entered");
	}
	public void selectHireDate(String hireDate) 
	{
		String[] hitedate = hireDate.split("-");
		selectHireDate.sendKeys(hitedate[0]);// mm
		selectHireDate.sendKeys(hitedate[1]);// dd
		selectHireDate.sendKeys(hitedate[2]);// yyyy
		logger.info("Hire date entered");
	}
	
	public void selectJobTitle(String jobTitle) 
	{
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(selectJobTitle,jobTitle) ;
		logger.info("Selected jobTitle: "+jobTitle);
	}
	
	public void selectUserProfileImage()
	{
		imgageProfile.click();
	}
	public void clickOnbtnSaveandGoToHome() 
	{
		btnPersonalInfoSaveandGoToHome.click();
		logger.info("Clicked on btnSaveandGoToHome");
	}
	
	public void clickOnbtnNext() 
	{
		btnPersonalInfoNext.click();
		logger.info("Clicked on btnNext");
	}
	
	public PO_UserProfilePage PersonalInfoDetails(String phoneNumber,String dob, String gnd, String marri, String empStatus, String deparment, String bio, String hireDate , String jobTitle, String btnChoice) throws InterruptedException
	{	
		textEnterPhoneNumber.sendKeys(phoneNumber);
		logger.info("Phone number entered");
		Thread.sleep(500);
		

		String[] dateofbirth = dob.split("-");
		logger.info("Date of birth entered");
		Thread.sleep(500);
		
		// to selecet gender
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(selectGender,gnd) ;
		logger.info("Gender selected: "+gnd);
		Thread.sleep(1000);
		
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(selectMaritalStatus,marri) ;
		logger.info("Selected MaritalStatus: "+marri);
		Thread.sleep(1000);
		
		// to select employee status
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(selectEmploymentStatus,empStatus) ;
		logger.info("Selected employmentStatus: "+empStatus);
		Thread.sleep(500);
		
		textDepartment.sendKeys(deparment);
		logger.info("Entered textDepartment");
		Thread.sleep(1000);
		
		textBio.sendKeys(bio);
		logger.info("Bio entered");
		Thread.sleep(500);
		
		String[] hitedate = hireDate.split("/");
		selectHireDate.sendKeys(hitedate[0]);// mm
		selectHireDate.sendKeys(hitedate[1]);// dd
		selectHireDate.sendKeys(hitedate[2]);// yyyy
		logger.info("Hire date entered");
		Thread.sleep(500);
		
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(selectJobTitle,jobTitle) ;
		logger.info("Selected jobTitle: "+jobTitle);
		Thread.sleep(500);
		
		if(btnChoice == "saveAndHome")
		{
			btnPersonalInfoSaveandGoToHome.click();
			logger.info("Clicked on btnSaveandGoToHome");
		}
		else if(btnChoice =="next") {
			btnPersonalInfoNext.click();
			logger.info("Clicked on btnNext");
		}
		
		Thread.sleep(1000);
		
		return new PO_UserProfilePage(driver);
		
	}
	//=====END====Personal info Action Methods============//
	
	

}
