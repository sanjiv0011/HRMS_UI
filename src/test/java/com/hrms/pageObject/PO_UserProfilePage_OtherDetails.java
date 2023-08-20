package com.hrms.pageObject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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
			textEmergencyContactName.sendKeys(emergencyContactName);
			Thread.sleep(500);
			logger.info("Entered emergency contact name");
		}
		
		public void setEmegencyContactNumber(String emergencyContactNumber) throws InterruptedException{
			textEmergencyContactNumber.sendKeys(emergencyContactNumber);
			Thread.sleep(500);
			logger.info("Entered emergency contact number");
		}
		
		public void setSocialSecurityNumber(String socialSecuritynumber) throws InterruptedException {
			textSocialSecurityNumber.sendKeys(socialSecuritynumber);
			Thread.sleep(500);
			logger.info("Entered social security contact number");
		}
					
		
		//TO FILL OTHERES INFORMTIONS
		public PO_UserProfilePage fillOthersDetails(String emergencyContactName, String emergencyContactNumber, String socialSecuritynumber, String buttonNextOrGoToHome) throws InterruptedException
		{
			setEmergencyContactName(emergencyContactName);
			setEmegencyContactNumber(emergencyContactNumber);
			setSocialSecurityNumber(socialSecuritynumber);
			
			if(buttonNextOrGoToHome.equals("saveAndGoToHome")){
				clickOnBtnSaveAndGoToHome_3_RU();
			} else if(buttonNextOrGoToHome.equals("next")){
				clickOnBtnNext_RU();
			}
			
			return new PO_UserProfilePage(driver);
		}
			
		//=====END====Others Details Action Methods============//


}
