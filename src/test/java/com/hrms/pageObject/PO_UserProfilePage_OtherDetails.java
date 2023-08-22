package com.hrms.pageObject;

import java.time.Duration;

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

public class PO_UserProfilePage_OtherDetails extends ReUseAbleElement {
	
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	

	public PO_UserProfilePage_OtherDetails(WebDriver driver) {
		super(driver);
        this.driver = driver;
        jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	}
	
	//=====START====Other details Page objects============//
	@FindBy(xpath = "//input[@name='emergencyContactName']")
	@CacheLookup
	WebElement textEmergencyContactName;

	@FindBy(xpath = "//input[@name='emergencyContactPhone']")
	@CacheLookup
	WebElement textEmergencyContactNumber;

	@FindBy(xpath = "//input[@name='socialSecurityNumber']")
	@CacheLookup
	WebElement textSocialSecurityNumber;

	//=====END====Others Details Page objects============//
	
	
	//=====START====Others Details Action Methods============//
		public void setEmergencyContactName(String emergencyContactName) throws InterruptedException {
			textEmergencyContactName.sendKeys(Keys.CONTROL, "a"); // Select all text
			Thread.sleep(300);
			textEmergencyContactName.sendKeys(Keys.DELETE);	 // Delete all text
			Thread.sleep(300);
			textEmergencyContactName.sendKeys(emergencyContactName);
			Thread.sleep(500);
			logger.info("Entered emergency contact name");
		}
		
		public void setEmegencyContactNumber(String emergencyContactNumber) throws InterruptedException{
			textEmergencyContactNumber.sendKeys(Keys.CONTROL, "a"); // Select all text
			Thread.sleep(300);
			textEmergencyContactNumber.sendKeys(Keys.DELETE);	 // Delete all text
			Thread.sleep(300);
			textEmergencyContactNumber.sendKeys(emergencyContactNumber);
			Thread.sleep(500);
			logger.info("Entered emergency contact number");
		}
		
		public void setSocialSecurityNumber(String socialSecuritynumber) throws InterruptedException {
			textSocialSecurityNumber.sendKeys(Keys.CONTROL, "a"); // Select all text
			Thread.sleep(300);
			textSocialSecurityNumber.sendKeys(Keys.DELETE);	 // Delete all text
			Thread.sleep(300);
			textSocialSecurityNumber.sendKeys(socialSecuritynumber);
			Thread.sleep(500);
			logger.info("Entered social security contact number");
		}
					
		
		//TO FILL OTHERES INFORMTIONS WITH RETURN TYPE(PO_HomePage)
		public PO_HomePage fillOthersDetails(String emergencyContactName, String emergencyContactNumber, String socialSecuritynumber, String buttonNextOrGoToHome) throws InterruptedException
		{
			setEmergencyContactName(emergencyContactName);
			setEmegencyContactNumber(emergencyContactNumber);
			setSocialSecurityNumber(socialSecuritynumber);
			
			if(buttonNextOrGoToHome.equals("saveAndGoToHome") || buttonNextOrGoToHome.equals("next")){
				clickOnBtnSaveAndGoToHome_3_RU();
			}else {
				logger.info("Invalid button choise: "+buttonNextOrGoToHome);
			}
			
			return new PO_HomePage(driver);
		}
		//=====END====Others Details Action Methods============//


}
