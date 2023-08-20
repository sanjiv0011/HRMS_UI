package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_UserProfilePage;
import com.hrms.pageObject.PO_UserProfilePage_PersonalInfo;

public class TC_UserProfile_PersonalInfo extends BaseClass {

	public TC_UserProfile_PersonalInfo()
	{
		super();
	}
	
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_UserProfilePage upp;
	public PO_UserProfilePage_PersonalInfo uppi;
	public Faker faker= new Faker();
	
	//VARIABLES
	public String phoneNumber = "+91"+"1234567890";
    public String dateOfBirth = "20 July 2021";
    public String gender = "Male";
    public String marri = "Married";
    public String bio = "xysdfshnsdfj";
    
    public String  buttonNextOrGoToHome = "saveAndGoToHome"; //or "next"
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException{
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		logger.info("Login Done");
	}
		
	@Test(priority = 2)
	public void test_UsersProfile_PersonalInfo() throws InterruptedException
	{
		uppi = callMeBeforePerformAnyAction();
		System.out.println("uppi: "+uppi);
		uppi.personalInfoDetails(phoneNumber,dateOfBirth,gender, marri,bio,buttonNextOrGoToHome);	
	}
	
	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_UserProfilePage_PersonalInfo callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		//TO ACCESS THE SYSTEM MANAGER BUTTON
		hp.clickOnbtnSystemManager();
		//TO ACCESS USER PROFILE TAB
		upp = hp.clickOndropdownMyProfile();
		//System.out.println("upp: "+upp);
		upp.clickOntabPersonalInfo();
		Thread.sleep(2000);
		
		//TO ACCESS USERS PAGE OBJECTS
		return new PO_UserProfilePage_PersonalInfo(driver);
	}
}
