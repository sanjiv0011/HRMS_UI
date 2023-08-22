package com.hrms.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_AssetsPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_UserProfilePage;
import com.hrms.pageObject.PO_UserProfilePage_AddressDetails;
import com.hrms.pageObject.PO_UserProfilePage_OtherDetails;
import com.hrms.pageObject.PO_UserProfilePage_PersonalInfo;

public class TC_UsersProfile_OthersDetails extends BaseClass{
	public TC_UsersProfile_OthersDetails()
	{
		super();
	}
	
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_UserProfilePage upp;
	public PO_UserProfilePage_OtherDetails upod;
	public Faker faker= new Faker();
	
	//VARIABLES
	public String emergencyContactName = faker.name().fullName();
    public String emergencyContactNumber = "+91 "+"1234567890";
    public String socialSecuritynumber = "123456789";
    
    public String  buttonNextOrGoToHome = "saveAndGoToHome"; //or "next"
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException{
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		logger.info("Login Done");
	}
	
	//TO FILL OTHERS DETAILS
	@Test(priority = 2)
	public void test_UsersProfile_OthresDetails() throws InterruptedException
	{
		upod = callMeBeforePerformAnyAction();
		hp = upod.fillOthersDetails(emergencyContactName,emergencyContactNumber,socialSecuritynumber,buttonNextOrGoToHome);	
	}

	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_UserProfilePage_OtherDetails callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		//TO ACCESS THE SYSTEM MANAGER BUTTON
		hp.clickOnbtnSystemManager();
		//TO ACCESS PO_UserProfilePage_OtherDetails TAB
		upp = hp.clickOndropdownMyProfile();
		upp.clickOntabOtherInformation();
		Thread.sleep(2000);
		
		//TO ACCESS PO_UserProfilePage_OtherDetails OBJECTS
		return new PO_UserProfilePage_OtherDetails(driver);
	}

}
