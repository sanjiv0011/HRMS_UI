package com.hrms.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LeavePage;
import com.hrms.pageObject.PO_LoginPage;

public class TC_Leave extends BaseClass{
	
	//CREATES SUPER CONSTRUCTOR,INHERITETS(BASE CLASS)
	public TC_Leave() {
		super();
	}
	
	//CONSTRUCTOR AND OTHER VARIABLE DECLARATOINS/INITIALIZATIONS
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_LeavePage lp;
	public Faker faker = new Faker();

	
//  //VARIABLES DECLARATIONS AND INITIALIZATIONS(WHILE USING THIS COMMENT THE DATAPROVIDER METHODS)
//	//VARIABLE DECLARATIONS AND ITS INITIALIZATIONS
//	String leaveTypeName = "Sick Leave"; // SELECT WHICH IS PRESENT IN THE DROPDOWN ONLY
//	String leaveDuration = "Full day"; 	// OR "Second half", "Full day"
//	String leaveStartDate = "18 August 2023"; //APPLY ONLY THIS GIVEN FORMATE
//	String leaveEndDate = "30 August 2023"; //APPLY ONLY THIS GIVEN FORMATE
//	String reason = faker.lorem().paragraph(1);
			
			
	//TO PERFORM THE LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		Thread.sleep(3000);
	}
	
	//TO APPLY LEAVE
	@Test(priority =2 , dependsOnMethods = {"test_Login"} , dataProvider = fileNameOnly)
	public void test_ApplyLeave(String leaveTypeName, String leaveDuration, String leaveStartDate, String leaveEndDate, String reason) throws InterruptedException {
		lp = callMeBeforePerformAnyAction();
		hp = lp.applyLeave(leaveTypeName, leaveDuration, leaveStartDate, leaveEndDate, reason);
		logger.info("Leave applied");		
	}
	
	//TO PERFORM THE LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(5000);
		// TO LOGOUT
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_LeavePage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		
		//TO ACCESS LEAVE TAB
		hp.clickOntabLeave();
		Thread.sleep(2000);
		
		//TO ACCESS LEAVE PAGE OBJECTS
		return new PO_LeavePage(driver);	
	}
	
	//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
  	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
  	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
  	public final String fileNameOnly = "TC_Leave";
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
