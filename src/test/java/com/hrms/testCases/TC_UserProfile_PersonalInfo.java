package com.hrms.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_UserProfilePage;
import com.hrms.pageObject.PO_UserProfilePage_PersonalInfo;

public class TC_UserProfile_PersonalInfo extends BaseClass {

	public TC_UserProfile_PersonalInfo()
	{
		super();
	}
	
	//CONSTRUCTOR DECLARATION AND INITIALIZATION
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_UserProfilePage upp;
	public PO_UserProfilePage_PersonalInfo uppi;
	public Faker faker= new Faker();
	
//	//VARIABLES DECLARATIONS AND INITIALIZATIONS(WHILE USING THIS COMMENT THE DATAPROVIDER METHODS)
//	  public String phoneNumber = "+91 "+"1234567890";
//    public String dateOfBirth = "20 July 2021";
//    public String gender = "Male";
//    public String marri = "Married";
//    public String bio = "xysdfshnsdfj";
//     public String  buttonNextOrGoToHome = "saveAndGoToHome"; //OR "next" OR "saveAndGoToHome"
	

	//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
	public final String fileNameOnly = "TC_UserProfile_PersonalInfo";
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
	public void test_Login() throws InterruptedException {
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
	}
		
	//TO FILL THE USER PERSONAL DETAILS ONLY
	@Test(priority = 2, dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly)
	public void test_UsersProfile_PersonalInfo(String phoneNumber,String dateOfBirth,String gender,String marri,String bio,String buttonNextOrGoToHome) throws InterruptedException, IOException {
		uppi = callMeBeforePerformAnyAction();
		System.out.println("uppi: "+uppi);
		hp = uppi.personalInfoDetails(phoneNumber,dateOfBirth,gender, marri,bio,buttonNextOrGoToHome);	
	}
	
	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_UserProfilePage_PersonalInfo callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		//TO ACCESS THE SYSTEM MANAGER BUTTON
		hp.clickOnbtnSystemManager();
		//TO ACCESS USER PROFILE TAB
		upp = hp.clickOndropdownMyProfile();
		//System.out.println("upp: "+upp);
		upp.clickOntabPersonalInfo();
		Thread.sleep(2000);
		
		//TO ACCESS USERS PAGE OBJECTS
		return new PO_UserProfilePage_PersonalInfo(driver);
	}
}
