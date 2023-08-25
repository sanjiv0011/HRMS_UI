package com.hrms.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.hrms.pageObject.PO_HomePage;

import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_ManageLeaveTypes;


public class TC_ManageLeaveTypes extends BaseClass {
	public TC_ManageLeaveTypes() {
		super();
	}
	
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_ManageLeaveTypes mlt;
	
	 
	String leaveTypeName = "Emergency Leave";
	String leaveTypeDescription = faker.company().profession();

	
	
	//TO PERFORM THE LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		Thread.sleep(5000);
	}
			
	//TO CREATE LEAVE TYPES
	@Test(priority =2, dependsOnMethods = {"test_Login"} , dataProvider = fileNameOnly)
	public void test_CreateLeaveType(String leaveTypeName, String leaveTypeDescription) throws InterruptedException {
		mlt = callMeBeforePerformAnyAction();
		hp = mlt.createLeaveType(leaveTypeName, leaveTypeDescription);
		logger.info("Leave types created");
	}
	
	
	//ACTIVATE LEAVE TYPES
	@Test(priority = 4)
	public void test_ActivateLeaveTypes()throws InterruptedException {
		mlt = callMeBeforePerformAnyAction();
		hp = mlt.activateLeaveTypes(leaveTypeName);
	}
	
	//DEACTIVATE LEAVE TYPES
	@Test(priority = 3)
	public void test_DeActivateLeaveTypes()throws InterruptedException {
		mlt = callMeBeforePerformAnyAction();
		hp = mlt.deactivateLeaveTypes(leaveTypeName);
	}
			
			
	//EDIT LEAVE TYPES
	@Test(priority = 5)
	public void test_EditLeaveTypes()throws InterruptedException {
		mlt = callMeBeforePerformAnyAction();
		hp = mlt.editLeaveType(leaveTypeName,leaveTypeDescription,leaveTypeName);
	}
	
	//DELETE LEAVE TYPES
	@Test(priority = 6)
	public void test_DeleteLeaveTypes()throws InterruptedException {
		mlt = callMeBeforePerformAnyAction();
		hp = mlt.deleteLeaveTypes(leaveTypeName);
	}
	
	//TO PERFORM THE LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		Thread.sleep(5000);
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		// to logout
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_ManageLeaveTypes callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		// to access manage leave types tab
		hp.clickOntabManageLeaveTypes();
		Thread.sleep(2000);
		//to access manage leave type page
		return new PO_ManageLeaveTypes(driver);	
	}

	//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
  	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
  	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
  	public final String fileNameOnly = "TC_ManageLeaveTypes";
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
