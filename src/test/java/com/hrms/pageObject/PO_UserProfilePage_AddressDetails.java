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

public class PO_UserProfilePage_AddressDetails extends ReUseAbleElement {
	
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;

	public PO_UserProfilePage_AddressDetails(WebDriver driver) {
		super(driver);
        this.driver = driver;
        jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	}
	
	
	//=====START====Address info Page objects============//
		@FindBy(xpath = "//input[@name='addressLine1']")
		@CacheLookup
		WebElement textAddressLine1;

		@FindBy(xpath = "//input[@name='addressLine2']")
		@CacheLookup
		WebElement textAddressLine2;

		@FindBy(xpath = "//input[@name='city']")
		@CacheLookup
		WebElement textCity;

		@FindBy(xpath = "//input[@name='state']")
		@CacheLookup
		WebElement textState;

		@FindBy(xpath = "//input[@name='country']")
		@CacheLookup
		WebElement textCountry;

		@FindBy(xpath = "//input[@name='postalCode']")
		@CacheLookup
		WebElement textPostalCode;
		
		//=====END====Address info Page objects============//
	
	//=====START====Address Action Methods============//
		//TO SET ADDRESS LINE 1
		public void setAddressLine1(String addressline1) throws InterruptedException {
			textAddressLine1.sendKeys(Keys.CONTROL, "a"); // Select all text
			Thread.sleep(300);
			textAddressLine1.sendKeys(Keys.DELETE);	 // Delete all text
			Thread.sleep(300);
			textAddressLine1.sendKeys(addressline1);
			Thread.sleep(500);
			logger.info("Entered address line 1");
		}
		
		//TO SET ADDRESS LINE 2
		public void setAddressLine2(String addressline2) throws InterruptedException {
			textAddressLine2.sendKeys(Keys.CONTROL, "a"); // Select all text
			Thread.sleep(300);
			textAddressLine2.sendKeys(Keys.DELETE);	 // Delete all text
			Thread.sleep(300);
			textAddressLine2.sendKeys(addressline2);
			Thread.sleep(500);
			logger.info("Entered address line 2");
		}
		
		public void setCity(String city) throws InterruptedException {
			textCity.sendKeys(Keys.CONTROL, "a"); // Select all text
			Thread.sleep(300);
			textCity.sendKeys(Keys.DELETE);	 // Delete all text
			Thread.sleep(300);
			textCity.sendKeys(city);
			Thread.sleep(500);
			logger.info("Entered city");
		}
		
		public void setState(String state) throws InterruptedException {
			textState.sendKeys(Keys.CONTROL, "a"); // Select all text
			Thread.sleep(300);
			textState.sendKeys(Keys.DELETE);	 // Delete all text
			Thread.sleep(300);
			textState.sendKeys(state);
			Thread.sleep(500);
			logger.info("Entered state");
		}
		
		public void setCountry(String country) throws InterruptedException {
			textCountry.sendKeys(Keys.CONTROL, "a"); // Select all text
			Thread.sleep(300);
			textCountry.sendKeys(Keys.DELETE);	 // Delete all text
			Thread.sleep(300);
			textCountry.sendKeys(country);
			Thread.sleep(500);
			logger.info("Entered country");
		}
		
		public void setPostalCode(String postalCode) throws InterruptedException {
			textPostalCode.sendKeys(Keys.CONTROL, "a"); // Select all text
			Thread.sleep(300);
			textPostalCode.sendKeys(Keys.DELETE);	 // Delete all text
			Thread.sleep(300);
			textPostalCode.sendKeys(postalCode);
			Thread.sleep(500);
			logger.info("Entered postal code");
		}
		
		
		//TO FOR THE USER ADDRESS(WITH RETURN TYPE PO_HomePage)
		public PO_HomePage fillUsersAddressDetails(String address1, String address2, String city, String state, String country, String postalCode, String buttonNextOrGoToHome) throws InterruptedException
		{
			setAddressLine1(address1);
			setAddressLine2(address2);
			setCity(city);
			setState(state);
			setCountry(country);
			setPostalCode(postalCode);
			
			if(buttonNextOrGoToHome.equals("saveAndGoToHome")){
				clickOnBtnSaveAndGoToHome_2_RU();
			} else if(buttonNextOrGoToHome.equals("next")){
				clickOnBtnNext_2_RU();
			}
			
			return new PO_HomePage(driver);
		}
		
		
		//TO FOR THE USER ADDRESS(WITH RETURN TYPE PO_UserProfilePage_OtherDetails)
		public PO_UserProfilePage_OtherDetails fillUsersAddressDetails_ReturnType_OtherDetails(String address1, String address2, String city, String state, String country, String postalCode, String buttonNextOrGoToHome) throws InterruptedException
		{
			setAddressLine1(address1);
			setAddressLine2(address2);
			setCity(city);
			setState(state);
			setCountry(country);
			setPostalCode(postalCode);
			
			if(buttonNextOrGoToHome.equals("saveAndGoToHome")){
				clickOnBtnSaveAndGoToHome_2_RU();
			} else if(buttonNextOrGoToHome.equals("next")){
				clickOnBtnNext_2_RU();
			}
			
			return new PO_UserProfilePage_OtherDetails(driver);
		}
		
		
		
		//=====END====Address Action Methods============//

}
