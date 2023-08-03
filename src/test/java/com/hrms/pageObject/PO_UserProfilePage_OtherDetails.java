package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_UserProfilePage_OtherDetails {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());

	public PO_UserProfilePage_OtherDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//=====START====Other details Page objects============//
	@FindBy(xpath = "//input[@id=':r1h:']")
	@CacheLookup
	WebElement textEmergencyContactName;

	@FindBy(xpath = "//input[@id=':r1j:']")
	@CacheLookup
	WebElement textEmergencyContactNumber;

	@FindBy(xpath = "//input[@id=':r1l:']")
	@CacheLookup
	WebElement textSocialSecurityNumber;
					
	
	@FindBy(xpath = "//input[@id=':r1t:']")
	@CacheLookup
	WebElement selectTerminationDate;

	@FindBy(xpath = "//input[@id=':r1d:']")
	@CacheLookup
	WebElement textTerminationReason;

	@FindBy(xpath = "//input[@id=':r1n:']")
	@CacheLookup
	WebElement selectResignationDate;
	
	@FindBy(xpath = "//input[@id=':r1r:']")
	@CacheLookup
	WebElement textResignationReason;
	
	@FindBy(xpath = "//div[4]//button[1]//p[1]")
	@CacheLookup
	WebElement btnOtherDetailsSaveandGoToHome;


	//=====END====Others Details Page objects============//
	
	
	//=====START====Others Details Action Methods============//
			public void setEmergencyContactName(String emergencyContactName)
			{
				textEmergencyContactName.sendKeys(emergencyContactName);
				logger.info("Entered emergency contact name");
			}
			
			public void setEmegencyContactNumber(String emergencyContactNumber)
			{
				textEmergencyContactNumber.sendKeys(emergencyContactNumber);
				logger.info("Entered emergency contact number");
			}
			
			public void setSocialSecurityNumber(String socialSecuritynumber)
			{
				textSocialSecurityNumber.sendKeys(socialSecuritynumber);
				logger.info("Entered social security contact number");
			}
			
			public void setTerminationDate(String terminationDate)
			{
				selectTerminationDate.sendKeys(terminationDate);
				logger.info("Entered termination date");
			}
			public void selectTerminationDate()
			{
				selectTerminationDate.click();
				logger.info("Entered termination date");
				
			}
			
			public void setTerminationReason(String terminationReason)
			{
				textTerminationReason.sendKeys(terminationReason);
				logger.info("Entered TerminationReason");
			}
			
			public void setResignationDate(String resignationDate)
			{
				selectResignationDate.sendKeys(resignationDate);
				logger.info("Entered ResignationDate");
			}
			public void selectResignationDate()
			{
				selectResignationDate.click();
				logger.info("Entered ResignationDate");
				
			}
			
			
			public void setResignationReason(String resignationReason)
			{
				textResignationReason.sendKeys(resignationReason);
				logger.info("Entered ResignationReason");
				
			}
			
			public void clickSaveAndGoToHome()
			{
				btnOtherDetailsSaveandGoToHome.click();
				logger.info("clickSaveAndGoToHome");
			}
			
			
			// all in one
			public PO_UserProfilePage fillOthersDetails(String emergencyContactName, String emergencyContactNumber, String socialSecuritynumber, String terminationDate, String terminationReason, String resignationDate, String resignationReason) throws InterruptedException
			{
				textEmergencyContactName.sendKeys(emergencyContactName);
				logger.info("Entered emergency contact name");
				Thread.sleep(500);

				
				textEmergencyContactNumber.sendKeys(emergencyContactNumber);
				logger.info("Entered emergency contact number");
				Thread.sleep(500);
				
				textSocialSecurityNumber.sendKeys(socialSecuritynumber);
				logger.info("Entered social security contact number");
				Thread.sleep(500);
				
				selectTerminationDate.sendKeys(terminationDate);
				logger.info("Entered termination date");
				Thread.sleep(500);
				
				textTerminationReason.sendKeys(terminationReason);
				logger.info("Entered TerminationReason");
				Thread.sleep(500);
				
				selectResignationDate.sendKeys(resignationDate);
				logger.info("Entered ResignationDate");
				Thread.sleep(500);
				
				textResignationReason.sendKeys(resignationReason);
				logger.info("Entered ResignationReason");
				Thread.sleep(500);
				
				btnOtherDetailsSaveandGoToHome.click();
				logger.info("clicked Save And Go To Home");
				Thread.sleep(500);
				
				return new PO_UserProfilePage(driver);
			}
			
			//=====END====Others Details Action Methods============//


}
