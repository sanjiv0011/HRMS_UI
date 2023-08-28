package com.hrms.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_ProjectPage;

public class TC_Projects extends BaseClass{
	//CONSTRUCTOR CREATION WHICH IS INHERITACTES THE BASECLASS BY SUPER KEY WORDS
	public TC_Projects() {
		super();
	}
	
	//OBJECT/PARAMETER DECLARATION
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_ProjectPage pp;
	
	//VARIABLE DECLARATION AND INITIALAZATION
	String projectName = "MetaVerse"; //faker.job().title();
	String projectDescription = faker.address().fullAddress();
	String domainName = "Cloud computing"; // SELECT IT FORM THE ALREADY PRESENT LIST
	String clientName ="AMR ReseachAMR"; // SELECT IT FORM THE ALREADY PRESENT LIST
	String technologyName ="NextJs"; // SELECT IT FORM THE ALREADY PRESENT LIST
	String projectStartDate ="15 August 2023"; // PROVIDE ONLY GIVEN FORMAT "15 August 2023"
	String projectEndDate ="30 August 2023"; // PROVIDE ONLY GIVEN FORMAT "30 August 2023"
	
	String projectSearchKey = projectName;
	String newProjecDescription = projectDescription;
	String newProjecName = projectName;
	String newDomainName = "Cloud computing"; // SELECT IT FORM THE ALREADY PRESENT LIST
	String newTechnologyName ="NextJs"; // SELECT IT FORM THE ALREADY PRESENT LIST
	String newProjectStartDate ="15 August 2023"; // PROVIDE ONLY GIVEN FORMAT "15 August 2023"
	String newProjectEndDate ="30 August 2023"; // PROVIDE ONLY GIVEN FORMAT "30 August 2023"
	
	String userNameToAssignProject = "Sarah Anderson"; //PROVIDE THE USER NAME AS PER LIST(USER APPLICABLE FOR PROJECT ASSIGNMENT)
	String assignProjectStartDate = "20 August 2023"; //PROJECT ASSIGN START DATE(PROVIDE IN THE GIVEN FORMAT ONLY) 
	String assignProjectEndDate = "30 August 2023"; 	//PROJECT ASSIGN START DATE(PROVIDE IN THE GIVEN FORMAT ONLY) 
	
	
	//TO PERFORM THE LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
	}
	
	//TO CREATE THE  PROJECT 
	//@Test(priority =2 , dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly)
	public void test_CreateProject(String projectName, String projectDescription, String domainName, String clientName, String technologyName, String projectStartDate, String projectEndDate) throws InterruptedException {
		pp = callMeBeforePerformAnyAction();
		hp = pp.createProject(projectName, projectDescription, domainName, clientName, technologyName, projectStartDate, projectEndDate);
	}
	
	//ARCHIVE PROJECT
	//@Test(priority = 3 , dependsOnMethods = {"test_Login"})
	public void test_ArchiveProject()throws InterruptedException {
		pp = callMeBeforePerformAnyAction();
		hp = pp.archiveProject(projectName);
	}
	
	//RESTORE PROJECT
	//@Test(priority = 4, dependsOnMethods = {"test_Login"})
	public void test_RestoreProject()throws InterruptedException {
		pp = callMeBeforePerformAnyAction();
		hp = pp.restoreProject(projectName);
	}
		
	
	//EDIT PROJECT
	//@Test(priority = 5 , dependsOnMethods = {"test_Login"})
	public void test_EditProject()throws InterruptedException {
		pp = callMeBeforePerformAnyAction();
		hp = pp.editProject(projectSearchKey, newProjecName, newProjecDescription, newDomainName, newTechnologyName, newProjectStartDate, newProjectEndDate );
	}
	
	//ASSIGN PROJECT TO THE USERS
	@Test(priority = 6 , dependsOnMethods = {"test_Login"})
	public void test_AssignProject()throws InterruptedException {
		pp = callMeBeforePerformAnyAction();
		hp = pp.assignProjectToUser(projectSearchKey, userNameToAssignProject, assignProjectStartDate, assignProjectEndDate);
		Thread.sleep(2000);
	}
	
	
	//TO PERFORM THE LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_ProjectPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		
		//TO ACCESS PROJECT TAB
		hp.clickOntabProjects();
		Thread.sleep(2000);
		
		//TO ACCESS PROJECT PAGE OBJECTS
		return new PO_ProjectPage(driver);	
	}
	
	//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
  	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
  	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
  	public final String fileNameOnly = "TC_Projects";
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
