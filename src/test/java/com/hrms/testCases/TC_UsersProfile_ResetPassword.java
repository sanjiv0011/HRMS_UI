package com.hrms.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_AssetsPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_UserProfilePage;
import com.hrms.pageObject.PO_UserProfilePage_AddressDetails;
import com.hrms.pageObject.PO_UserProfilePage_BankDetails;
import com.hrms.pageObject.PO_UserProfilePage_OtherDetails;
import com.hrms.pageObject.PO_UserProfilePage_PersonalInfo;
import com.hrms.pageObject.PO_UserProfilePage_ResetPassword;

public class TC_UsersProfile_ResetPassword extends BaseClass{
	public TC_UsersProfile_ResetPassword()
	{
		super();
	}
	
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_UserProfilePage upp;
	public PO_UserProfilePage_ResetPassword uprp;
	public Faker faker= new Faker();
	
	//VARIABLES
	public String oldPassword = "Qwer4321!";
    public String newPassword = "Qwer4321!";

	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException{
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		logger.info("Login Done");
	}
		
	@Test(priority = 2)
	public void test_UsersProfile_AddressDetails() throws InterruptedException
	{
		uprp = callMeBeforePerformAnyAction();
		uprp.resetPassword(oldPassword,newPassword);	
	}

	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_UserProfilePage_ResetPassword callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		//TO ACCESS THE SYSTEM MANAGER BUTTON
		hp.clickOnbtnSystemManager();
		//TO ACCESS PO_UserProfilePage_ResetPassword TAB
		upp = hp.clickOndropdownMyProfile();
		upp.clickOntabResetPassword();
		Thread.sleep(2000);
		
		//TO ACCESS USER PROFILE RESET PASSWORD OBJECTS
		return new PO_UserProfilePage_ResetPassword(driver);
	}

}
