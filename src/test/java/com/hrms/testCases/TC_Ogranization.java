package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_OragnizationPage;
import com.hrms.pageObject.PO_UsersPage;

public class TC_Ogranization extends BaseClass{
	
	//CREATES SUPER CONSTRUCTOR,INHERITETS(BASE CLASS)
	public TC_Ogranization() {
		super();
	}
	
	//CONSTRUCTOR AND OTHER VARIABLE DECLARATOINS/INITIALIZATIONS
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_OragnizationPage op;
	
	//VARIABLE DECLARATIONS AND ITS INITIALIZATIONS
	String orgName = faker.company().name(); //"Willms-Mann";
	String orgCode = faker.random().hex(4);
	String orgEmail = faker.internet().emailAddress();
	String orgPhoneNumber = "+91"+"1234567890";
	String orgAddress = faker.address().buildingNumber();
	String orgArea = faker.address().secondaryAddress();
	String orgCity = faker.address().city();
	String orgState = faker.address().state();
	String orgPostalCode = "123456";
	String orgCountry = "India"; //faker.address().country();
	String orgTimeZone = "(UTC +05:30) Asia/Kolkata";
	
	String newOrgCode = faker.random().hex(4);
	String newOrgEmail = faker.internet().emailAddress();
	String newOrgPhoneNumber = "+91"+"1234567890";
	String newOrgAddress = faker.address().buildingNumber();
	String newOrgArea = faker.address().secondaryAddress();
	String newOrgCity = faker.address().city();
	String newOrgState = faker.address().state();
	String newOrgPostalCode = "123456";
	String newOrgCountry = "India";
	String newOrgTimeZone = "(UTC +05:30) Asia/Kolkata";
	
	//TO LOGIN
	@Test(priority =1)
	public void test_Login() throws InterruptedException{
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		logger.info("Login Done");
	}
	
	//TO CREATE ORGANIZATION
	@Test(priority = 2, dependsOnMethods = {"test_Login"})
	public void test_CreateOrganization() throws InterruptedException
	{	op = callMeBeforePerformAnyAction();
		hp = op.createOragnization(orgName, orgCode, orgEmail, orgPhoneNumber, orgAddress, orgArea, orgCity, orgState, orgPostalCode, orgCountry, orgTimeZone);
		logger.info("Organization created");
		
	}
	
	
	//ARCHIVE ORGANIZATION
	@Test(priority = 3 , dependsOnMethods = {"test_Login"})
	public void test_ArchiveOrganization()throws InterruptedException {
		op = callMeBeforePerformAnyAction();
		hp = op.archiveOrganization(orgName);
		logger.info("Archive User call done");	
	}
	
	//RESTORE ORGANIZATION
	@Test(priority = 4, dependsOnMethods = {"test_Login"})
	public void test_RestoreOrganization()throws InterruptedException {
		op = callMeBeforePerformAnyAction();
		hp = op.restoreOrganization(orgName);
		logger.info("Restore user call done");
	}
	
	//DEACTIVATE ORGANIZATION
	@Test(priority = 5)
	public void test_DeActivateOrganization()throws InterruptedException {
		op = callMeBeforePerformAnyAction();
		hp = op.deactivateOrganization(orgName);
		logger.info("DeActivate user call done");
	}
	
	//ACTIVATE ORGANIZATION
	@Test(priority = 6)
	public void test_ActivateOrganization()throws InterruptedException {
		op = callMeBeforePerformAnyAction();
		hp = op.activateOrganization(orgName);
		logger.info("Activate user call done");	
	}
		
	
	//EDIT ORGANIZATION
	@Test(priority = 7, dependsOnMethods = {"test_Login"})
	public void test_EditOrganization()throws InterruptedException {
		op = callMeBeforePerformAnyAction();
		hp = op.editOragnization(orgName, newOrgCode, newOrgEmail, newOrgPhoneNumber, newOrgAddress, newOrgArea, newOrgCity, newOrgState, newOrgPostalCode, newOrgCountry, newOrgTimeZone );
		logger.info("Edit organization call done");	
	}
			
	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		Thread.sleep(2000);
		hp.clickOniconHomeImage();
		Thread.sleep(5000);
		// TO LOGOUT
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_OragnizationPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		
		//TO ACCESS USERS TAB
		hp.clickOntabOrganizations();
		Thread.sleep(2000);
		
		//TO ACCESS USERS PAGE OBJECTS
		return new PO_OragnizationPage(driver);	
	}

}
