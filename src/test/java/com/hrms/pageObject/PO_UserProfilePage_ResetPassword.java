package com.hrms.pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_UserProfilePage_ResetPassword {

	public WebDriver driver = null;
	public Logger logger = LogManager.getLogger(getClass());
	
	public PO_UserProfilePage_ResetPassword(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//=====START====Other details Page objects============//
	@FindBy(xpath = "//input[@id=':r11:']]")
	@CacheLookup
	WebElement textOldPassword;

	@FindBy(xpath = "//body/div[@id='__next']/div[@class='MuiBox-root css-1k9dio6']/div[@class='miniSidebarWrapper appMainFixedHeader MuiBox-root css-1f8gm9f']/div[@class='mainContent MuiBox-root css-0']/form[@action='#']/div[@class='MuiBox-root css-1c5ij41']/div[@class='MuiBox-root css-1i5nutl']/div[@class='MuiBox-root css-hcwjkm']/div[@class='MuiBox-root css-deejpe']/div[@class='account-tabs-content MuiBox-root css-0']/div/div[@class='MuiBox-root css-1a3nf9b']/form[@action='#']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-4 css-isbt42']/div[4]/div[1]")
	@CacheLookup
	WebElement textNewPassword;

	@FindBy(xpath = "//label[normalize-space()='Retype New Password']")
	@CacheLookup
	WebElement textReTypeNewPassword;
	
	@FindBy(xpath = "//button[@type='submit'][normalize-space()='Reset Password']")
	@CacheLookup
	WebElement btnResetPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	@CacheLookup
	WebElement btnCancel;
	
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1nhkohy']//*[name()='svg']")
	@CacheLookup
	WebElement eyeIconOldPasword;
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-1a3nf9b']//div[3]//div[1]//div[1]//div[1]//div[1]//button[1]//*[name()='svg']")
	@CacheLookup
	WebElement eyeIconNewPasword;
	
	
	@FindBy(xpath = "//div[@class='account-tabs-content MuiBox-root css-0']//div//div[4]//div[1]//div[1]//div[1]//div[1]//button[1]//*[name()='svg']//*[name()='path' and contains(@d,'M12 4.5C7 ')]")
	@CacheLookup
	WebElement eyeIconReTypeNewPasword;


	//=====END====Others Details Page objects============//
	
	public void setOldPassword(String oldpwd) 
	{
		textOldPassword.sendKeys(oldpwd);
		logger.info("Enterd Old password");
	}
	
	public void setNewPassword(String newpwd) 
	{
		textNewPassword.sendKeys(newpwd);
		logger.info("Enterd new password");
	}
	
	public void setRetypeNewPassword(String renewpwd) 
	{
		textReTypeNewPassword.sendKeys(renewpwd);
		logger.info("Enterd retype new password");
	}
	
	public void clickOnEyeIconOldPassword() 
	{
		eyeIconOldPasword.click();
		logger.info("Clicked on eye icon old password");
	}

	public void clickOnEyeIconNewPassword() 
	{
		eyeIconNewPasword.click();
		logger.info("Clicked on eye icon new password");
	}
	
	public void clickOnEyeIconRetyopeNewPassword() 
	{
		eyeIconReTypeNewPasword.click();
		logger.info("Clicked on eye icon tepe new password");
	}

	public void clickOnBtnResetPassword() 
	{
		btnResetPassword.click();
		logger.info("Clicked on btnResetPassword");
	}
	
	public void clickOnBtnCanle() 
	{
		btnCancel.click();
		logger.info("Clicked on btnCancel");
	}
	
	// all in one
	public PO_UserProfilePage resetPassword(String oldpwd, String newPwd) throws InterruptedException 
	{
		textOldPassword.sendKeys(oldpwd);
		logger.info("Enterd Old password");
		Thread.sleep(500);
		
		textNewPassword.sendKeys(newPwd);
		logger.info("Enterd new password");
		Thread.sleep(500);
		
		textReTypeNewPassword.sendKeys(newPwd);
		logger.info("Enterd retype new password");
		Thread.sleep(500);
		
		eyeIconOldPasword.click();
		logger.info("Clicked on eye icon old password");
		Thread.sleep(500);
		
		eyeIconNewPasword.click();
		logger.info("Clicked on eye icon new password");
		Thread.sleep(500);
		
		eyeIconReTypeNewPasword.click();
		logger.info("Clicked on eye icon tepe new password");
		Thread.sleep(500);
		
		btnResetPassword.click();
		logger.info("Clicked on btnResetPassword");
		Thread.sleep(500);
		
		return new PO_UserProfilePage(driver);
	}
	
	
}
