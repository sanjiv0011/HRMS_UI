package com.hrms.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pageObject.PO_HomePage;

public class TC_LoginAndLogout extends TC_Login{
	/* 
	 This class applicable for login and logout both and 
	 We can use this class any where, where we have to perform the login first then some other activity 
	 and at the end to perform logout functionality
	
	*/
	
	public TC_LoginAndLogout()
	{
		super();
	}
	
	PO_HomePage hp;
	
	@Test(priority = 1)	// here zero ensures least priority, so that this call happens at the last.
	public void test_Logout() throws InterruptedException
	{	// It perform the logout activity
		
		hp = new PO_HomePage(driver);
		
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
