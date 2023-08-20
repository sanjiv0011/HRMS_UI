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

public class TC_UsersProfile_BankDetails extends BaseClass{
	public TC_UsersProfile_BankDetails()
	{
		super();
	}
	
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_UserProfilePage upp;
	public PO_UserProfilePage_BankDetails upbd;
	public Faker faker= new Faker();
	
	//VARIABLES
	public String bankName = "Bank of baroda";
    public String bankNumber = "123546789987420";
    public String accountName = "My name bank name";
    public String isfcCode = "KLJD54612";

	
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
		upbd = callMeBeforePerformAnyAction();
		upbd.fillBankDetails(bankName,bankNumber,accountName,isfcCode);	
	}

	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_UserProfilePage_BankDetails callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		//TO ACCESS THE SYSTEM MANAGER BUTTON
		hp.clickOnbtnSystemManager();
		//TO ACCESS PO_UserProfilePage_OtherDetails TAB
		upp = hp.clickOndropdownMyProfile();
		upp.clickOntabBankDetails();
		Thread.sleep(2000);
		
		//TO ACCESS USER PROFILE BANK DETAILS OBJECTS
		return new PO_UserProfilePage_BankDetails(driver);
	}

}
