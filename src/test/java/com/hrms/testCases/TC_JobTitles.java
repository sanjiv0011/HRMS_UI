package com.hrms.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_JobTitles;
import com.hrms.pageObject.PO_LoginPage;

public class TC_JobTitles extends BaseClass {
	public TC_JobTitles() {
		super();
	}
	
	//CONSTRUCTOR DECLARATIOSN
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_JobTitles jt;
	
	//VARIABLES
	String jobTitle = "OfficeBoy"; //faker.job().title();
	String jobDescription = faker.job().position();
	String jobTitlesSearchKey = jobTitle;
	String newJobDescription = jobDescription;
	String newJobTitles = jobTitle;
	
	
	//TO PERFORM THE LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
	}
	
	//TO CREATE THE  JOB TITLES 
	@Test(priority =2 , dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly)
	public void test_CreateCleint(String jobTitle, String jobDescription) throws InterruptedException {		
		jt = callMeBeforePerformAnyAction();
		hp = jt.createJobTitle(jobTitle, jobDescription);
	}
	
	//ARCHIVE JOB TITLES
	@Test(priority = 3 , dependsOnMethods = {"test_Login"})
	public void test_ArchiveJobTitles()throws InterruptedException {
		jt = callMeBeforePerformAnyAction();
		hp = jt.archiveJobTitles(jobTitle);	
	}
	
	//RESTORE JOB TITLES
	@Test(priority = 4, dependsOnMethods = {"test_Login"})
	public void test_RestoreJobTitles()throws InterruptedException	{
		jt = callMeBeforePerformAnyAction();
		hp = jt.restoreJobTitles(jobTitle);
	}
		
	
	//EDITJOB TITLES
	@Test(priority = 5 , dependsOnMethods = {"test_Login"})
	public void test_EditJobTitles()throws InterruptedException {
		jt = callMeBeforePerformAnyAction();
		hp = jt.editJobTitles(jobTitlesSearchKey,newJobDescription, newJobTitles);
	}
	
	
	//TO PERFORM THE LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {	
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_JobTitles callMeBeforePerformAnyAction() throws InterruptedException
	{	//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		//TO ACCESS JOB TITLES TAB
		hp.clickOntabJobTitle();
		Thread.sleep(2000);
		//TO ACCESS JOB TITLES PAGE OBJECTS
		return new PO_JobTitles(driver);	
	}

	//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
  	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
  	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
  	public final String fileNameOnly = "TC_JobTitles";
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
