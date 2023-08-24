package com.hrms.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.hrms.pageObject.PO_ClientPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_JobTitles;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_OragnizationPage;

public class TC_Cleint extends BaseClass {
	public TC_Cleint() {
		super();
	}
	
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_ClientPage cp;

  //VARIABLES DECLARATIONS AND INITIALIZATIONS(WHILE USING THIS COMMENT THE DATAPROVIDER METHODS)
	String cleintName = "AMR Reseach";
	String clientDescription = faker.company().profession();
	String clientSearchKey = cleintName;
	String newClientDescription = faker.company().profession();
	String newCleintName = "AMR";
	
	
	//TO PERFORM THE LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException
	{	//to perform login
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		Thread.sleep(5000);
	}
	
	//TO CREATE CLIENT
	@Test(priority =2 , dependsOnMethods = {"test_Login"} , dataProvider = fileNameOnly)
	public void test_CreateCleint(String cleintName, String clientDescriptions ) throws InterruptedException
	{	cp = callMeBeforePerformAnyAction();
		hp = cp.createClient(cleintName, clientDescriptions);
		logger.info("Client created");
	
	}
	
	//ARCHIVE CLINET
	@Test(priority = 3 , dependsOnMethods = {"test_Login"})
	public void test_ArchiveClient()throws InterruptedException
	{
		cp = callMeBeforePerformAnyAction();
		hp = cp.archiveClient(cleintName);
		logger.info("Archive client call done");	
	}
	
	//RESTORE CLINET
	@Test(priority = 4, dependsOnMethods = {"test_Login"})
	public void test_RestoreClient()throws InterruptedException
	{
		cp = callMeBeforePerformAnyAction();
		hp = cp.restoreClient(cleintName);
		logger.info("Restore client call done");
	}
		
	
	//EDIT CLINET
	@Test(priority = 5 , dependsOnMethods = {"test_Login"})
	public void test_EditClient()throws InterruptedException
	{
		cp = callMeBeforePerformAnyAction();
		hp = cp.editClient(cleintName,clientDescription, cleintName);
		logger.info("Edit client call done");
	}
	
	//TO PERFORM THE LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException
	{	//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		// to logout
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_ClientPage callMeBeforePerformAnyAction() throws InterruptedException
	{	//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		
		//TO ACCESS JOB TITLES TAB
		hp.clickOntabClients();
		Thread.sleep(2000);
		
		//TO ACCESS JOB TITLES PAGE OBJECTS
		return new PO_ClientPage(driver);	
	}
	
	//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
  	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
  	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
  	public final String fileNameOnly = "TC_Cleint";
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
