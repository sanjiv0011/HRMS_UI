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
import com.hrms.pageObject.PO_UserProfilePage_OtherDetails;
import com.hrms.pageObject.PO_UserProfilePage_PersonalInfo;

public class TC_UsersProfile_OthersDetails extends BaseClass{
	public TC_UsersProfile_OthersDetails()
	{
		super();
	}
	
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_UserProfilePage upp;
	public PO_UserProfilePage_OtherDetails upod;
	public Faker faker= new Faker();
	
//	//VARIABLES DECLARATIONS AND INITIALIZATIONS(WHILE USING THIS COMMENT THE DATAPROVIDER METHODS)
//	  public String emergencyContactName = faker.name().fullName();
//    public String emergencyContactNumber = "+91 "+"1234567890";
//    public String socialSecuritynumber = "123456789";
//    public String  buttonNextOrGoToHome = "saveAndGoToHome"; //or "next"
	
	
    //=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
  	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
  	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
  	public final String fileNameOnly = "TC_UsersProfile_OthersDetails";
  	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
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
	
	//TO FILL OTHERS DETAILS
	@Test(priority = 2, dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly)
	public void test_UsersProfile_OthresDetails(String emergencyContactName, String emergencyContactNumber, String socialSecuritynumber, String buttonNextOrGoToHome  ) throws InterruptedException
	{
		upod = callMeBeforePerformAnyAction();
		hp = upod.fillOthersDetails(emergencyContactName,emergencyContactNumber,socialSecuritynumber,buttonNextOrGoToHome);	
	}

	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_UserProfilePage_OtherDetails callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		//TO ACCESS THE SYSTEM MANAGER BUTTON
		hp.clickOnbtnSystemManager();
		//TO ACCESS PO_UserProfilePage_OtherDetails TAB
		upp = hp.clickOndropdownMyProfile();
		upp.clickOntabOtherInformation();
		Thread.sleep(2000);
		
		//TO ACCESS PO_UserProfilePage_OtherDetails OBJECTS
		return new PO_UserProfilePage_OtherDetails(driver);
	}

}
