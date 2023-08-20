package com.hrms.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_UserProfilePage;
import com.hrms.pageObject.PO_UserProfilePage_PersonalInfo;

public class TC_HomePage extends BaseClass {
	
	public TC_HomePage()
	{
		super();
	}
	
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public Faker faker= new Faker();
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException{
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		logger.info("Login Done");
	}
	
	
	//TO TEST HOME PAGE 
	//@Test(priority = 2)
	public void test_HomePage() throws InterruptedException
	{	// To perform the home page testing activity
		hp.HomePageTesting();
		logger.info("Home Page testing done");
	}
	
	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		hp.Logout();
	}

}
