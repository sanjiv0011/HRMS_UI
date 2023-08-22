package com.hrms.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.hrms.pageObject.PO_DailyUpdates;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;

import java.io.IOException;

import org.openqa.selenium.interactions.Action;


public class TC_DailyUpdates extends BaseClass{
	
	//CREATES SUPER CONSTRUCTOR,INHERITETS(BASE CLASS)
	public TC_DailyUpdates() {
		super();
	}
	
	//CONSTRUCTOR AND OTHER VARIABLE DECLARATOINS/INITIALIZATIONS
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_DailyUpdates du;
	
//  //VARIABLES DECLARATIONS AND INITIALIZATIONS(WHILE USING THIS COMMENT THE DATAPROVIDER METHODS)
//	String dailyUpdateDate = "17 August 2023";
//	String hoursStart = "5";
//	String mintuesStart = "55";
//	String AMPMStart = "PM";
//	String hoursEnd = "9";
//	String mintuesEnd = "20";
//	String AMPMEnd = "AM";
//	String projectName = "YourDreamHouse";
//	String description = faker.lorem().paragraph();
	
	//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
  	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
  	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
  	public final String fileNameOnly = "TC_DailyUpdates";
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
	@Test(priority =1)
	public void test_Login() throws InterruptedException{
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
	}
	
	//TO CREATE DAILY UPDATES
	@Test(priority = 2, dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly)
	public void test_CreateDailyUpdates(String dailyUpdateDate, String hoursStart, String mintuesStart, String AMPMStart, String hoursEnd, String mintuesEnd, String AMPMEnd, String projectName, String description) throws InterruptedException
	{	du = callMeBeforePerformAnyAction();
		hp = du.createDailyUpdates(driver, dailyUpdateDate, hoursStart, mintuesStart, AMPMStart, hoursEnd, mintuesEnd, AMPMEnd, projectName, description);
	}
	
	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		Thread.sleep(2000);
		hp.clickOniconHomeImage();
		Thread.sleep(4000);
		// TO LOGOUT
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_DailyUpdates callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		
		//TO ACCESS DAILY UPADTES TAB
		hp.clickOntabDailyUpdates();
		Thread.sleep(2000);
		
		//TO ACCESS DAILY UPDATES PAGE OBJECTS
		return new PO_DailyUpdates(driver);	
	}

}
