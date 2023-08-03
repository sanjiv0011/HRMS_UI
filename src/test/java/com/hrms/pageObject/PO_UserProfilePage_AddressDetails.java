package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_UserProfilePage_AddressDetails {
	
	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());

	public PO_UserProfilePage_AddressDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//=====START====Address info Page objects============//
		@FindBy(xpath = "//input[@id=':rv:']")
		@CacheLookup
		WebElement textAddressLine1;

		@FindBy(xpath = "//input[@id=':r11:']")
		@CacheLookup
		WebElement textAddressLine2;

		@FindBy(xpath = "//input[@id=':r13:']")
		@CacheLookup
		WebElement textCity;

		@FindBy(xpath = "//input[@id=':r15:']")
		@CacheLookup
		WebElement textState;

		@FindBy(xpath = "//input[@id=':r17:']")
		@CacheLookup
		WebElement textCountry;

		@FindBy(xpath = "//input[@id=':r19:']")
		@CacheLookup
		WebElement textPostalCode;
						
		@FindBy(xpath = "//div[@class='account-tabs-content MuiBox-root css-0']//div[2]//button[1]//p[1]")
		@CacheLookup
		WebElement btnAddressSaveandGoToHome;

		@FindBy(xpath = "//body/div[@id='__next']/div[@class='MuiBox-root css-1k9dio6']/div[@class='miniSidebarWrapper appMainFixedHeader MuiBox-root css-1f8gm9f']/div[@class='mainContent MuiBox-root css-0']/form[@action='#']/div[@class='MuiBox-root css-1c5ij41']/div[@class='MuiBox-root css-1n83im1']/div[@class='MuiBox-root css-hcwjkm']/div[@class='MuiBox-root css-deejpe']/div[@class='account-tabs-content MuiBox-root css-0']/div[1]/button[1]")
		@CacheLookup
		WebElement btnAddressNext;
		//=====END====Address info Page objects============//
	
	//=====START====Address Action Methods============//
		public void setAddressLine1(String addressline1)
		{
			textAddressLine1.sendKeys(addressline1);
			logger.info("Entered address line 1");
		}
		
		public void setAddressLine2(String addressline2)
		{
			textAddressLine2.sendKeys(addressline2);
			logger.info("Entered address line 2");
		}
		
		public void setCity(String city)
		{
			textCity.sendKeys(city);
			logger.info("Entered city");
		}
		
		public void setState(String state)
		{
			textState.sendKeys(state);
			logger.info("Entered state");
		}
		
		public void setCountry(String country)
		{
			textCountry.sendKeys(country);
			logger.info("Entered country");
		}
		
		public void setPostalCode(String postalCode)
		{
			textPostalCode.sendKeys(postalCode);
			logger.info("Entered postal code");
		}
		
		public void clickOnBtnAddressSaveAndGoToHome()
		{
			btnAddressSaveandGoToHome.click();
			logger.info("Clicked on the address btn save and go to home");
		}
		
		public void clickOnBtnAddressNext()
		{
			btnAddressNext.click();
			logger.info("Clicked on the address btn next");
		}
		
		public PO_UserProfilePage fillAddressDetails(String address1, String address2, String city, String state, String country, String postalCode, String choice) throws InterruptedException
		{
			textAddressLine1.sendKeys(address1);
			logger.info("Entered address line 1");
			Thread.sleep(500);
			
			textAddressLine2.sendKeys(address2);
			logger.info("Entered address line 1");
			Thread.sleep(500);
			
			textCity.sendKeys(city);
			logger.info("Entered city");
			Thread.sleep(500);
			
			textState.sendKeys(state);
			logger.info("Entered state");
			Thread.sleep(500);
			
			textCountry.sendKeys(country);
			logger.info("Entered country");
			Thread.sleep(500);
			
			textPostalCode.sendKeys(postalCode);
			logger.info("Entered postal code");
			Thread.sleep(500);
			
			if(choice == "saveAndHome")
			{
				btnAddressSaveandGoToHome.click();
				logger.info("Clicked on the address btn save and go to home");
				Thread.sleep(500);
			}
			else if(choice == "next")
			{
				btnAddressNext.click();
				logger.info("Clicked on the address btn next");
				Thread.sleep(500);
			}
			
			return new PO_UserProfilePage(driver);
		}
		
		//=====END====Address Action Methods============//

}
