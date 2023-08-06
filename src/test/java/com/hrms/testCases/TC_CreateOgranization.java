package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_OragnizationPage;

public class TC_CreateOgranization extends BaseClass{
	public TC_CreateOgranization() {
		super();
	}
	
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_OragnizationPage op;
	
	String orgName = faker.company().name();
	String orgCode = faker.random().hex(4);
	String orgEmail = faker.internet().emailAddress();
	String orgPhoneNumber = "+91"+"1234567890";
	String orgAddress = faker.address().buildingNumber();
	String orgArea = faker.address().secondaryAddress();
	String orgCity = faker.address().city();
	String orgState = faker.address().state();
	String orgPostalCode = "123456";
	String orgCountry = faker.address().country();
	String orgTimeZone = "(UTC +05:30) Asia/Kolkata";
	
	@Test(priority =1)
	public void test_CreateOrganization() throws InterruptedException
	{
		//to perform login 
		lgn = new PO_LoginPage(driver);
		hp = lgn.login(userName, password);
		logger.info("Login Done");
		
		// to access organization tab
		hp.clickOntabOrganizations();
		
		//to access organization tab
		op = new PO_OragnizationPage(driver);
		
		// to create new organization
		hp = op.createOragnization(orgName, orgCode, orgEmail, orgPhoneNumber, orgAddress, orgArea, orgCity, orgState, orgPostalCode, orgCountry, orgTimeZone);
		logger.info("Organization created");
		
		// to logout
		hp.Logout();
		
		
	}
}
