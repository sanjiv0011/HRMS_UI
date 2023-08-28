package com.hrms.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_UserPermissions;
import com.hrms.pageObject.PO_UsersPage;

public class TC_Users extends BaseClass{
	
		//CREATES SUPER CONSTRUCTOR,INHERITETS(BASE CLASS)
		public TC_Users() {
			super();
		}
		
		//CONSTRUCTOR AND OTHER VARIABLE DECLARATOINS/INITIALIZATIONS
		public PO_LoginPage lgn;
		public PO_HomePage hp;
		public PO_UsersPage up;
		public PO_UserPermissions userPermissions;
		public Faker faker = new Faker();

		//VARIABLES DECLARATIONS AND INITIALIZATIONS(WHILE USING THIS COMMENT THE DATAPROVIDER METHODS)
		//VARIABLE DECLARATIONS AND ITS INITIALIZATIONS
		String uname = "mariasoma";
		String passwordToCreate = faker.internet().password(8, 10, true, true, true);
		String organizationName = "Westwood";
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String emailAddress= faker.internet().emailAddress();
		String userRole= "org-admin"; // OR "user" IT CONTAINS ONLY THIS TWO VALUES
		
		
		String newUName = "jhondove";
		String newOrganizationName = faker.company().name();
		String NewFirstName = faker.company().name();
		String newLastName = faker.name().firstName();
		String newEmailAddress = faker.name().lastName();
		String newUserRole= userRole;
		
		String projectName = "MetaVerseMetaVerse";
		String userSearchKey = uname;
		String assignProjectStartDate = "18 August 2023" ;
		String assignProjectEndDate = "30 August 2023";
	
		
		//TO PERFORM THE LOGIN
		@Test(priority = 1)
		public void test_Login() throws InterruptedException {
			lgn = new PO_LoginPage(driver);
			hp = lgn.Login(userName, password);
		}
		
		//TO CREATE USER
		//@Test(priority =2 , dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly)
		public void test_CreateUser(String uname, String passwordToCreate, String organizationName, String firstName, String lastName, String emailAddress, String userRole) throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			hp = up.createUser(uname, passwordToCreate, organizationName, firstName, lastName, emailAddress, userRole);	
		}
			
		//ARCHIVE USER
		//@Test(priority = 3 , dependsOnMethods = {"test_Login"})
		public void test_ArchiveUser()throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			hp = up.archiveUser(uname);
		}
		
		//RESTORE USER
		//@Test(priority = 4, dependsOnMethods = {"test_Login"})
		public void test_RestoreUser()throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			hp = up.restoreUser(uname);
		}
		
		//ACTIVATE USER
		//@Test(priority = 5)
		public void test_ActivateUser()throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			hp = up.activateUser(uname);
		}
		
		//DEACTIVATE USER
		//@Test(priority = 6)
		public void test_DeActivateUser()throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			hp = up.deactivateUser(uname);
		}
				
			
		//EDIT USER
		//@Test(priority = 7, dependsOnMethods = {"test_Login"})
		public void test_EditUser()throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			hp = up.editUser(uname, newUName, newOrganizationName, NewFirstName, newLastName, newEmailAddress, newUserRole );
		}
			
		//ASSIGN PROJECT TO THE USERSNewFirstName
		//@Test(priority = 8, dependsOnMethods = {"test_Login"})
		public void test_AssignUserToProject()throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			hp = up.assignUserToProject(userSearchKey, projectName, assignProjectStartDate, assignProjectEndDate);
		}
			
		
		//TO CREATE USER WITH PERMISSIONS
		@Test(priority = 9 , dependsOnMethods = {"test_Login"})
		public void test_CreateUserWithUserPermissions() throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			userPermissions = up.createUser_ReturnType_PO_UserPermissions(uname, passwordToCreate, organizationName, firstName, lastName, emailAddress, userRole);
		}
		
				
		//TO PERFORM THE LOGOUT
		@Test(priority = 10, dependsOnMethods = {"test_Login"})
		public void test_Logout() throws InterruptedException {
			hp.Logout();
		}
		
		//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
		public PO_UsersPage callMeBeforePerformAnyAction() throws InterruptedException {
			//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
			hp.clickOniconHomeImage();
			Thread.sleep(3000);
			//TO ACCESS USERS TAB
			hp.clickOntabUsers();
			Thread.sleep(2000);
			//TO ACCESS USERS PAGE OBJECTS
			return new PO_UsersPage(driver);	
		}
		
		//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
	  	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
	  	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
	  	public final String fileNameOnly = "TC_Users";
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
