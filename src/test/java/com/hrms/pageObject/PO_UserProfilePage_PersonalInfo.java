package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_UserProfilePage_PersonalInfo {
	
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	
	
	public PO_UserProfilePage_PersonalInfo(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//==========START======PERSONAL INFO PAGE OBJECT===============//
	@FindBy(xpath = "//input[@id=':r2t:']")
	@CacheLookup
	WebElement textEnterPhoneNumber;

	@FindBy(xpath = "//input[@id=':r2v:']")
	@CacheLookup
	WebElement textDateOfBirth;

	@FindBy(xpath = "//input[@id='gender']")
	@CacheLookup
	WebElement selectGender;

	@FindBy(xpath = "//input[@id='maritalStatus']")
	@CacheLookup
	WebElement selectMaritalStatus;

	@FindBy(xpath = "//input[@id='employmentStatus']")
	@CacheLookup
	WebElement selectEmploymentStatus;

	@FindBy(xpath = "//input[@id=':r3f:']")
	@CacheLookup
	WebElement textDepartment;

	@FindBy(xpath = "//input[@id=':r3h:']")
	@CacheLookup
	WebElement textBio;

	@FindBy(xpath = "//input[@id=':r3j:']")
	@CacheLookup
	WebElement selectHireDate;

	@FindBy(xpath = "//input[@id='jobTitleId']")
	@CacheLookup
	WebElement selectJobTitle;
	
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
	
	public void setDateOfBirth(String dob) 
	{
		textDateOfBirth.sendKeys(dob); //dd
		textDateOfBirth.sendKeys(dob); //mm
		textDateOfBirth.sendKeys(dob); //yyyy
		logger.info("Date of birth entered");
	}
	
	
	public void setGender(String gnd) 
	{
		if(gnd == "Male")
		{
			selectGender.click();
		}
		else if(gnd == "Female")
		{
			selectGender.click();
		}
		else
		{
			System.out.println("Invalid gender key");
		}
		logger.info("Gender selected");
	}
	public void selectMaritalStatus(String marri) 
	{
		if(marri == "Married")
		{
			selectMaritalStatus.click();
		}
		else if(marri == "Unmarried")
		{
			selectMaritalStatus.click();
		}
		else
		{
			System.out.println("Invalid marrital status");
		}
		logger.info("Selected MaritalStatus");
	}
	public void selectEmploymentStatus(String empStatus) 
	{
		if(empStatus == "Part Time")
		{
			selectEmploymentStatus.click();
		}
		else if(empStatus == "Full Time")
		{
			selectEmploymentStatus.click();
		}
		else if(empStatus == "Contract")
		{
			selectEmploymentStatus.click();
		}
		else if(empStatus == "Probation")
		{
			selectEmploymentStatus.click();
		}
		else
		{
			System.out.println("Invalid employee status");
		}
		
		logger.info("Selected employmentStatus");
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
		selectHireDate.sendKeys(hireDate);// dd
		selectHireDate.sendKeys(hireDate);// mm
		selectHireDate.sendKeys(hireDate);// yyyy
		logger.info("Hire date entered");
	}
	
	public void selectJobTitle(String jobTitle) 
	{
		selectJobTitle.click();
		logger.info("Selected selectJobTitle");
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
	
	public PO_UserProfilePage fillPersonalInfoDetails(String phoneNumber,String dob, String gnd, String marri, String empStatus, String deparment, String bio, String hireDate , String jobTitle, String btnChoice) throws InterruptedException
	{	
		textEnterPhoneNumber.sendKeys(phoneNumber);
		logger.info("Phone number entered");
		Thread.sleep(500);
		
		textDateOfBirth.sendKeys(dob); //dd
		textDateOfBirth.sendKeys(dob); //mm
		textDateOfBirth.sendKeys(dob); //yyyy
		logger.info("Date of birth entered");
		Thread.sleep(500);
		
		// to selecet gender
		if(gnd == "male")
		{
			selectGender.click();
		}
		else if(gnd == "female")
		{
			selectGender.click();
		}
		else
		{
			System.out.println("Invalid gender key");
		}
		logger.info("Gender selected");
		Thread.sleep(1000);
		
		// to select marrital status
		if(marri == "Married")
		{
			selectMaritalStatus.click();
		}
		else if(marri == "Unmarried")
		{
			selectMaritalStatus.click();
		}
		else
		{
			System.out.println("Invalid marrital status");
		}
		logger.info("Selected MaritalStatus");
		Thread.sleep(1000);
		
		// to select employee status
		if(empStatus == "Part Time")
		{
			selectEmploymentStatus.click();
		}
		else if(empStatus == "Full Time")
		{
			selectEmploymentStatus.click();
		}
		else if(empStatus == "Contract")
		{
			selectEmploymentStatus.click();
		}
		else if(empStatus == "Probation")
		{
			selectEmploymentStatus.click();
		}
		else
		{
			System.out.println("Invalid employee status");
		}
		logger.info("Selected employmentStatus");
		Thread.sleep(500);
		
		textDepartment.sendKeys(deparment);
		logger.info("Entered textDepartment");
		Thread.sleep(1000);
		
		textBio.sendKeys(bio);
		logger.info("Bio entered");
		Thread.sleep(500);
		
		
		selectHireDate.sendKeys(hireDate);// dd
		selectHireDate.sendKeys(hireDate);// mm
		selectHireDate.sendKeys(hireDate);// yyyy
		logger.info("Hire date entered");
		Thread.sleep(500);
		
		selectJobTitle.click();
		logger.info("Selected selectJobTitle");
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
