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
		String  ui_orgName =  orgName;
		String  ui_orgCode =  orgCode;
		String  ui_orgEmail =  orgEmail;
		String  ui_orgPhoneNumber = orgPhoneNumber;
		String  ui_orgAddress = orgAddress;
		String  ui_orgArea = orgArea;
		String  ui_orgCity =  orgCity;
		String  ui_orgState = orgState;
		String  ui_orgPostalCode = orgPostalCode;
		String  ui_orgCountry =  orgCountry;
		String  ui_orgTimeZone[] =  orgTimeZone.split(" ");
		//System.out.println(ui_orgTimeZone[1]);
		hp = op.createOragnization(orgName, orgCode, orgEmail, orgPhoneNumber, orgAddress, orgArea, orgCity, orgState, orgPostalCode, orgCountry, orgTimeZone);
		logger.info("Organization created");
		
//		if(op.isOrganizationCreateSuccessMessageDisplayed())
//		{
//			//For DataBase Testing
//			ResultSet resultset = DatabaseConnectionAndQuery_GenericMethods.dataBaseCollectionAndQuerry("select * from public.organizations");
//			while(resultset.next())
//			{
//				if(ui_orgName.equals(resultset.getString("name")))
//				{
//					//DATA FROM THE DATABASE
//					//String db_ogName = resultset.getString("name");
//					String db_orgCode = resultset.getString("code");
//					String db_orgEmail = resultset.getString("email_address");
//					String db_orgPhoneNumber = resultset.getString("phone_number");
//					String db_orgTimeZone = resultset.getString("timeZone");
//					
//					
//					String db_Address = resultset.getString("address");
//	                // Parse the address JSON BACAUSE ADDRESS IN DATA BASE PRESENT IN THE JSON FORMAT
//	                JSONObject addressJSON = new JSONObject(db_Address);
//
//	                // Extract fields from the JSON
//	                String addressLine1 = addressJSON.getString("addressLine1");
//	                String addressLine2 = addressJSON.getString("addressLine2");
//	                String city = addressJSON.getString("city");
//	                String state = addressJSON.getString("state");
//	                String country = addressJSON.getString("country");
//	                String postalCode = addressJSON.getString("postalCode");
//	    
//					
//					//CROSS VERIFICATIONS(IT WILL MATCH USER INPUT DATA WITH DATABASE ENTRY)
//					Assert.assertEquals(ui_orgCode, db_orgCode, "To match orgCode");
//					Assert.assertEquals(ui_orgEmail, db_orgEmail, "To match orgEmail");
//					Assert.assertEquals(ui_orgPhoneNumber, db_orgPhoneNumber, "To match orgPhoneNumber");
//					Assert.assertEquals(ui_orgAddress, addressLine1, "To match orgAddressLine1");
//					Assert.assertEquals(ui_orgArea, addressLine2, "To match orgAddressLine2");
//					Assert.assertEquals(ui_orgCity, city, "To match orgCity");
//					Assert.assertEquals(ui_orgState, state, "To match orgState");
//					Assert.assertEquals(ui_orgPostalCode, postalCode, "To match orgPostalCode");
//					Assert.assertEquals(ui_orgCountry, country, "To match orgCountry");
//					Assert.assertEquals(ui_orgTimeZone[2], db_orgTimeZone, "To match orgTimeZone");
//					
//					break;
//				}
//				
//			}
//		}
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
	@Test(priority = 7, dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly)
	public void test_EditOrganization(String orgName, String orgCode, String orgEmail, String orgPhoneNumber, String orgAddress, String orgArea, String orgCity, String orgState, String orgPostalCode, String orgCountry, String orgTimeZone)throws InterruptedException {
		op = callMeBeforePerformAnyAction();
		hp = op.editOragnization(orgName, orgCode, orgEmail, orgPhoneNumber, orgAddress, orgArea, orgCity, orgState, orgPostalCode, orgCountry, orgTimeZone );
		logger.info("Edit organization call done");	
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
