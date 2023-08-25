package com.hrms.pageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;
import com.hrms.projectUtility.DatePicker;
import com.hrms.projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_UserProfilePage_PersonalInfo extends ReUseAbleElement {
	
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	
	public PO_UserProfilePage_PersonalInfo(WebDriver driver)
	{  
		super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	}
	
	//==========START======PERSONAL INFO PAGE OBJECT===============//
	@FindBy(xpath = "//input[@name=\"phoneNumber\"]")
	@CacheLookup
	WebElement textEnterPhoneNumber;
	
	
	// to select the gender
	@FindBy(xpath = "//ul[@id=\"gender-listbox\"]//li")
	@CacheLookup
	List <WebElement> selectGender;

	@FindBy(xpath = "//ul[@id=\"maritalStatus-listbox\"]//li")
	@CacheLookup
	List <WebElement> selectMaritalStatus;
	
	@FindBy(xpath = "//input[@name='bio']")
	@CacheLookup
	WebElement textBio;

	@FindBy(xpath = "//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-10yb37c']//*[name()='svg']")
	@CacheLookup
	WebElement imgageProfile;
	
	//=====END====Personal info Page objects============//
	
	
	public void setPhoneNumber(String phoneNumber) throws InterruptedException {
		textEnterPhoneNumber.sendKeys(Keys.CONTROL, "a"); // Select all text
		Thread.sleep(300);
		textEnterPhoneNumber.sendKeys(Keys.DELETE);	 // Delete all text
		Thread.sleep(300);
		textEnterPhoneNumber.sendKeys(phoneNumber);
		Thread.sleep(500);
		logger.info("Phone number entered");
	}
	
	
	public void selectDateOfBirth(String dob, int x) throws InterruptedException {
		DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver, dob, x);
		Thread.sleep(1000);
		logger.info("Date of birth entered");
	}
	
	public void selectGender(String gnd) throws InterruptedException {
		clickOnDropdown_1_RU();
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(selectGender,gnd) ;
		Thread.sleep(1000);
		logger.info("Gender selected: "+gnd);
	}
	public void selectMaritalStatus(String marri) throws InterruptedException {
		clickOnDropdown_2_RU();
		Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(selectMaritalStatus,marri) ;
		Thread.sleep(1000);
		logger.info("Selected MaritalStatus: "+marri);
	}
	
	public void settBio(String bio) throws InterruptedException {
		textBio.sendKeys(Keys.CONTROL, "a"); // Select all text
		Thread.sleep(300);
		textBio.sendKeys(Keys.DELETE);	 // Delete all text
		Thread.sleep(300);
		textBio.sendKeys(bio);
		Thread.sleep(500);
		logger.info("Bio entered");
	}
	
	public void selectUserProfileImage() {
		imgageProfile.click();
	}
	
	//PERSONAL DETAILS WITH RETRUN TYPE(PO_HomePage)
	public PO_HomePage personalInfoDetails(String phoneNumber,String dateOfBirth, String gender, String marri,String bio, String buttonNextOrGoToHome) throws InterruptedException, IOException
	{	
		setPhoneNumber(phoneNumber);
		selectDateOfBirth(dateOfBirth, 1);
		selectGender(gender);
		selectMaritalStatus(marri);
		settBio(bio);
		ruae.clickOnUserProfileIcon_1_RU();
		Runtime.getRuntime().exec("D://Sanjiv_QA/Eclipse Project/HRMS_UI/autoIt.exe");
		if(buttonNextOrGoToHome.equals("saveAndGoToHome")){
			clickOnBtnSaveAndGoToHome_1_RU();
			Thread.sleep(1000);
		}else if(buttonNextOrGoToHome.equals("next")) {
			clickOnBtnNext_1_RU();
			Thread.sleep(1000);
		}
		return new PO_HomePage(driver);
	}
	
	//PERSONAL DETAILS WITH RETRUN TYPE(PO_UserProfilePage_AddressDetails)
	public PO_UserProfilePage_AddressDetails personalInfoDetails_ReturnTypeAddressDetails(String phoneNumber,String dateOfBirth, String gender, String marri,String bio, String buttonNextOrGoToHome) throws InterruptedException
	{	
		setPhoneNumber(phoneNumber);
		selectDateOfBirth(dateOfBirth, 1);
		selectGender(gender);
		selectMaritalStatus(marri);
		settBio(bio);
		
		if(buttonNextOrGoToHome.equals("saveAndGoToHome")){
			clickOnBtnSaveAndGoToHome_1_RU();
			Thread.sleep(1000);
		}else if(buttonNextOrGoToHome.equals("next")) {
			clickOnBtnNext_1_RU();
			Thread.sleep(1000);
		}
		return new PO_UserProfilePage_AddressDetails(driver);
	}
	//=====END====Personal info Action Methods============//


}
