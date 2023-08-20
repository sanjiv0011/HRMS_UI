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

public class PO_UserProfilePage_ResetPassword extends ReUseAbleElement {

	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	
	public PO_UserProfilePage_ResetPassword(WebDriver driver)
	{
		super(driver);
        this.driver = driver;
        jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	}
	
	//=====START====Other details Page objects============//
	@FindBy(xpath = "//input[@name='oldPassword']")
	@CacheLookup
	WebElement textOldPassword;

	@FindBy(xpath = "//input[@name='newPassword']")
	@CacheLookup
	WebElement textNewPassword;

	@FindBy(xpath = "//input[@name='confirmNewPassword']")
	@CacheLookup
	WebElement textReTypeNewPassword;


	//=====END====Others Details Page objects============//
	
	public void setOldPassword(String oldpwd) throws InterruptedException {
		textOldPassword.sendKeys(oldpwd);
		Thread.sleep(1000);
		logger.info("Enterd Old password");
		ruae.clickOnEyeIconPasswordView_1_RU();
	}
	
	public void setNewPassword(String newpwd) throws InterruptedException {
		textNewPassword.sendKeys(newpwd);
		Thread.sleep(1000);
		logger.info("Enterd new password");
		ruae.clickOnEyeIconPasswordView_2_RU();
	}
	
	public void setRetypeNewPassword(String renewpwd) throws InterruptedException {
		textReTypeNewPassword.sendKeys(renewpwd);
		Thread.sleep(1000);
		logger.info("Enterd retype new password");
		ruae.clickOnEyeIconPasswordView_3_RU();
	}
	
	
	//TO RESET PASSWORD
	public PO_HomePage resetPassword(String oldpwd, String newPwd) throws InterruptedException 
	{
		setOldPassword(oldpwd);
		setNewPassword(newPwd);
		setRetypeNewPassword(newPwd);
		ruae.clickOnBtnSaveChanges_RU();
		return new PO_HomePage(driver);
	}
	
	
}
