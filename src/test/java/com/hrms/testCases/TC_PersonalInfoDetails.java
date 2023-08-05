package com.hrms.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_UserProfilePage;
import com.hrms.pageObject.PO_UserProfilePage_PersonalInfo;

public class TC_PersonalInfoDetails extends BaseClass{
	public TC_PersonalInfoDetails()
	{
		super();
	}
	
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_UserProfilePage upp;
	public PO_UserProfilePage_PersonalInfo upppi;
	public Faker faker= new Faker();
	
	@Test(priority = 1)
	public void test_fillPersonalInfoDetails() throws InterruptedException
	{
		// To start the login activity
		lgn = new PO_LoginPage(driver);
		
		hp = lgn.login(userName, password);// takes values from the base class
		logger.info("Done login");
		
		//to click on system manager 
		hp.clickOnbtnSystemManager();
		Thread.sleep(2000);
		
		// to click on my profile drop down
		hp.clickOndropdownMyProfile();
		Thread.sleep(2000);
		
		// to click on personal details tab
		upp = new PO_UserProfilePage(driver);
		upp.clickOntabPersonalInfo();
		Thread.sleep(5000);
		
		// to access user profile page personal info page
		upppi = new PO_UserProfilePage_PersonalInfo(driver);
		upppi.PersonalInfoDetails("+911234567890", "01/25/2000", "Male", "Married", "Full Time", "Dev", "Bio", "07/25/2023", "HR", "saveAndHome");
		
		
		
	}

}
