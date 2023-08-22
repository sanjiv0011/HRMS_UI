package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_UserProfilePage;

public class TC_UserProfilePage extends BaseClass {
	public TC_UserProfilePage()
	{
		super();
	}
	
	//CONSTRUCTOR DECLARATIONS
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_UserProfilePage upp;
	public Faker faker= new Faker();
	
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
	}
	
	//USER PROFILE PAGE TESTING
	@Test(priority = 2 , dependsOnMethods = {"test_Login"})
	public void test_UserProfilePage() throws InterruptedException {
		upp = callMeBeforePerformAnyAction();
		hp = upp.UserProfilePageTesting();
	}
	
	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_UserProfilePage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		//TO ACCESS THE SYSTEM MANAGER BUTTON
		hp.clickOnbtnSystemManager();
		//TO ACCESS USER PROFILE TAB
		hp.clickOndropdownMyProfile();
		Thread.sleep(2000);
		
		//TO ACCESS USERS PAGE OBJECTS
		return new PO_UserProfilePage(driver);
	}

		
}
