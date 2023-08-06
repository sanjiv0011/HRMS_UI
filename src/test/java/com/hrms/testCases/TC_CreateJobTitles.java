package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_ClientPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_JobTitles;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_OragnizationPage;

public class TC_CreateJobTitles extends BaseClass {
	public TC_CreateJobTitles() {
		super();
	}
	
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_JobTitles jt;
	
	String cleintName = faker.name().firstName();
	String clientDescription = faker.company().profession();
	
	@Test(priority =1)
	public void test_CreateCleint() throws InterruptedException
	{
		//to perform login 
		lgn = new PO_LoginPage(driver);
		hp = lgn.login(userName, password);
		
		// to access client tab
		hp.clickOntabJobTitle();
		
		//to access cleint page
		jt = new PO_JobTitles(driver);
		logger.info("started JobTitle page constructor");
		
		// to create new organization
		hp = jt.createJobTitle(cleintName, clientDescription);
		logger.info("JobTitle created");
		
		// to logout
		hp.Logout();
		
		
	}


}
