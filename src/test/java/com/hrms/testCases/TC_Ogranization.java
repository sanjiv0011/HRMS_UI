package com.hrms.testCases;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.dataBase.DatabaseConnectionAndQuery_GenericMethods;
import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders;
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
	
	//VARIABLES DECLARATIONS AND INITIALIZATIONS(WHILE USING THIS COMMENT THE DATAPROVIDER METHODS)
	//VARIABLE DECLARATIONS AND ITS INITIALIZATIONS
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
	
	String orgName = "SFCSolutions"; // PASS THE VALUE YOU WANT TO ARCHIVE/RESTORE/ACTIVATE/DEACTIVATE

  	
	//TO LOGIN
	@Test(priority =1)
	public void test_Login() throws InterruptedException {
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
	}
	
	//TO CREATE ORGANIZATION
	@Test(priority = 2, dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly)
	public void test_CreateOrganization(String orgName, String orgCode, String orgEmail, String orgPhoneNumber, String orgAddress, String orgArea, String orgCity, String orgState, String orgPostalCode, String orgCountry, String orgTimeZone) throws InterruptedException, SQLException
	{	op = callMeBeforePerformAnyAction();
		hp = op.createOragnization(orgName, orgCode, orgEmail, orgPhoneNumber, orgAddress, orgArea, orgCity, orgState, orgPostalCode, orgCountry, orgTimeZone);
	}
	
	
	//ARCHIVE ORGANIZATION
	@Test(priority = 3 , dependsOnMethods = {"test_Login"})
	public void test_ArchiveOrganization()throws InterruptedException, SQLException {
		op = callMeBeforePerformAnyAction();
		hp = op.archiveOrganization(orgName);
	}
	
	//RESTORE ORGANIZATION
	@Test(priority = 4, dependsOnMethods = {"test_Login"})
	public void test_RestoreOrganization()throws InterruptedException, SQLException {
		op = callMeBeforePerformAnyAction();
		hp = op.restoreOrganization(orgName);
		logger.info("Restore user call done");
	}
	
	//DEACTIVATE ORGANIZATION
	@Test(priority = 5)
	public void test_DeActivateOrganization()throws InterruptedException, SQLException {
		op = callMeBeforePerformAnyAction();
		hp = op.deactivateOrganization(orgName);
	}
	
	//ACTIVATE ORGANIZATION
	@Test(priority = 6)
	public void test_ActivateOrganization()throws InterruptedException, SQLException {
		op = callMeBeforePerformAnyAction();
		hp = op.activateOrganization(orgName);
	}
		
	
	//EDIT ORGANIZATION
	@Test(priority = 7, dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly)
	public void test_EditOrganization(String orgName, String orgCode, String orgEmail, String orgPhoneNumber, String orgAddress, String orgArea, String orgCity, String orgState, String orgPostalCode, String orgCountry, String orgTimeZone)throws InterruptedException, SQLException {
		op = callMeBeforePerformAnyAction();
		hp = op.editOragnization(orgName, orgCode, orgEmail, orgPhoneNumber, orgAddress, orgArea, orgCity, orgState, orgPostalCode, orgCountry, orgTimeZone );
	}
			
	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
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
	

	//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
  	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
  	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
  	public final String fileNameOnly = "TC_Ogranization";
  	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
  	public DataProviders dp =  new DataProviders();
  	//DATA PROVIDER
  	@DataProvider(name = fileNameOnly)
  	public String[][] dataProvider() throws IOException {
  		String loginData[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly);
  		return loginData;
  	}
  	//======END=====DATA READING FORM THE EXCEL FILE=====IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME======//
  	

}
