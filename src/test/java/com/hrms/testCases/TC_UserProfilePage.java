package com.hrms.testCases;

import org.testng.annotations.Test;

import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_UserProfilePage;

public class TC_UserProfilePage extends BaseClass {
	public TC_UserProfilePage()
	{
		super();
	}
	
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_UserProfilePage upp;
	
	@Test(priority = 1)
	public void test_UserProfilePage() throws InterruptedException {
		// To start the login activity
		lgn = new PO_LoginPage(driver);
		
		hp = lgn.login(userName, password);// takes values from the base class
		logger.info("Done login");
		
		//to click on the system manager 
		hp.clickOnbtnSystemManager();
		Thread.sleep(500);
		
		//to click on the my profile page
		hp.clickOndropdownMyProfile();
		Thread.sleep(2000);
		
		// to start user profile activity tab
		upp = new PO_UserProfilePage(driver);
		hp = upp.UserProfilePageTesting();
		logger.info("User profile testing done");
		
		// To perform logout activity
		hp.Logout();
	}
}
