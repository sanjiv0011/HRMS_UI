package com.hrms.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pageObject.PO_LoginPage;

public class TC_Login extends BaseClass {
	// This Class applicable only for the login functionality
	
	public TC_Login()
	{
		super();
	}
	
	PO_LoginPage lgn;
	
	
	@Test(priority = 1)// One ensures the highest priority just after the base class
	public void test_Login() throws InterruptedException, IOException
	{
		lgn = new PO_LoginPage(driver);
		lgn.Login(userName, password);
	}
	
}
