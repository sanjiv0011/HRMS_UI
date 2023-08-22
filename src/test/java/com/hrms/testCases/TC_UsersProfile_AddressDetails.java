package com.hrms.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_AssetsPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_UserProfilePage;
import com.hrms.pageObject.PO_UserProfilePage_AddressDetails;
import com.hrms.pageObject.PO_UserProfilePage_PersonalInfo;

public class TC_UsersProfile_AddressDetails extends BaseClass{
	public TC_UsersProfile_AddressDetails()
	{
		super();
	}
	
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_UserProfilePage upp;
	public PO_UserProfilePage_AddressDetails upad;
	public Faker faker= new Faker();
	
	//VARIABLES
	public String addressLine1 = faker.address().buildingNumber();
    public String addressLine2 = faker.address().fullAddress();
    public String city = faker.address().cityName();
    public String state = faker.address().state();
    public String country = faker.address().country();
    public String postalCode = "123456";
    
    public String  buttonNextOrGoToHome = "saveAndGoToHome"; //or "next"
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException{
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		logger.info("Login Done");
	}
	
	//TO FILL ADDRESS DETAILS
	@Test(priority = 2)
	public void test_UsersProfile_AddressDetails() throws InterruptedException
	{
		upad = callMeBeforePerformAnyAction();
		hp = upad.fillUsersAddressDetails(addressLine1,addressLine2,city, state,country,  postalCode,buttonNextOrGoToHome);	
	}
	
	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_UserProfilePage_AddressDetails callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		//TO ACCESS THE SYSTEM MANAGER BUTTON
		hp.clickOnbtnSystemManager();
		//TO ACCESS USER PROFILE TAB
		upp = hp.clickOndropdownMyProfile();
		upp.clickOntabAddress();
		Thread.sleep(2000);
		
		//TO ACCESS USERS PAGE OBJECTS
		return new PO_UserProfilePage_AddressDetails(driver);
	}

}
