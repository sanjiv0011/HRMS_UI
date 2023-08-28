package com.hrms.testCases;

import org.testng.annotations.Test;


import com.hrms.pageObject.PO_HomePage;

public class TC_LoginAndLogout extends TC_Login{
	/* 
	 This class applicable for login and logout both and 
	 We can use this class any where, where we have to perform the login first then some other activity 
	 and at the end to perform logout functionality
	
	*/
	
	public TC_LoginAndLogout(){
		super();
	}
	
	public PO_HomePage hp;
	
	@Test(priority = 10)	// here zero or ten ensures least priority, so that this call happens at the last.
	public void test_Logout() throws InterruptedException {	
		hp = new PO_HomePage(driver);
		hp.Logout();
	}

}
