package com.hrms.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;

public class TC_HomePage extends BaseClass {
	
	public TC_HomePage()
	{
		super();
	}
	
	
	// By extending TC_Login class it will perform the login activity
	@Test(priority = 1)
	public void test_HomePage() throws InterruptedException
	{
		// To start the login activity
		PO_LoginPage lgn = new PO_LoginPage(driver);
		
		PO_HomePage hp = lgn.login(userName, password);// takes values from the base class
		logger.info("Done login");
		
		// To perform the home page testing activity
		hp.HomePageTesting();
		logger.info("Home Page testing done");
		
		// To perform logout activity
		hp.Logout();
		if(driver.getTitle().equals("Login to HRMS"))
		{
			Assert.assertTrue(true);
			logger.info("Logout successful...");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Logout failed!!!");
		}
	
	}
	

}
