package com.hrms.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.hrms.pageObject.PO_AssetsPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_UserProfilePage;
import com.hrms.pageObject.PO_UserProfilePage_AddressDetails;
import com.hrms.pageObject.PO_UserProfilePage_PersonalInfo;

public class TC_UsersProfile_AddressDetails extends BaseClass{
	public TC_UsersProfile_AddressDetails(){
		super();
	}
	
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_UserProfilePage upp;
	public PO_UserProfilePage_AddressDetails upad;
	public Faker faker= new Faker();
	
//	//VARIABLES DECLARATIONS AND INITIALIZATIONS(WHILE USING THIS COMMENT THE DATAPROVIDER METHODS)
//	public String addressLine1 = faker.address().buildingNumber();
//    public String addressLine2 = faker.address().fullAddress();
//    public String city = faker.address().cityName();
//    public String state = faker.address().state();
//    public String country = faker.address().country();
//    public String postalCode = "123456";
//    public String  buttonNextOrGoToHome = "saveAndGoToHome"; //or "next"
	
	
	//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
	public final String fileNameOnly = "TC_UsersProfile_AddressDetails";
	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHOD
	public DataProviders dp =  new DataProviders();
	//DATA PROVIDER
	@DataProvider(name = fileNameOnly)
	public String[][] dataProvider() throws IOException {
		String loginData[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly);
		return loginData;
	}
	//======END=====DATA READING FORM THE EXCEL FILE=====IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME======//
	
		
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException{
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
	}
	
	//TO FILL ADDRESS DETAILS
	@Test(priority = 2,  dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly)
	public void test_UsersProfile_AddressDetails(String addressLine1, String addressLine2, String city, String state, String country, String postalCode, String buttonNextOrGoToHome) throws InterruptedException
	{
		upad = callMeBeforePerformAnyAction();
		hp = upad.fillUsersAddressDetails(addressLine1,addressLine2,city, state,country,  postalCode,buttonNextOrGoToHome);	
	}
	
	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_UserProfilePage_AddressDetails callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		//TO ACCESS THE SYSTEM MANAGER BUTTON
		hp.clickOnbtnSystemManager();
		//TO ACCESS USER PROFILE TAB
		upp = hp.clickOndropdownMyProfile();
		upp.clickOntabAddress();
		Thread.sleep(2000);
		
		//TO ACCESS USERS PAGE OBJECTS
		return new PO_UserProfilePage_AddressDetails(driver);
	}

}
