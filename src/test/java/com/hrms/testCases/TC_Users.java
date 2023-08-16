package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
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
		public Faker faker = new Faker();
		
		//VARIABLE DECLARATIONS AND ITS INITIALIZATIONS
		String uname = "jhondove";
		String passwordToCreate = faker.internet().password(8, 10, true, true, true);
		String organizationName = faker.company().name();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String emailAddress= faker.internet().emailAddress();
		String userRole= "org-admin"; // OR "user" IT CONTAINS ONLY THIS TWO VALUES
		
		//TO PERFORM THE LOGIN
		@Test(priority = 1)
		public void test_Login() throws InterruptedException {
			lgn = new PO_LoginPage(driver);
			hp = lgn.login(userName, password);
			Thread.sleep(3000);
		}
		
		//TO CREATE USER
		//@Test(priority =2 , dependsOnMethods = {"test_Login"})
		public void test_CreateUser() throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			hp = up.createUser(uname, passwordToCreate, organizationName, firstName, lastName, emailAddress, userRole);
			logger.info("User created");		
		}
			
		//ARCHIVE USER
		//@Test(priority = 3 , dependsOnMethods = {"test_Login"})
		public void test_ArchiveUser()throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			hp = up.archiveUser(uname);
			logger.info("Archive User call done");	
		}
		
		//RESTORE USER
		//@Test(priority = 4, dependsOnMethods = {"test_Login"})
		public void test_RestoreUser()throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			hp = up.restoreUser(uname);
			logger.info("Restore user call done");
		}
		
		//ACTIVATE USER
		@Test(priority = 5)
		public void test_ActivateUser()throws InterruptedException
		{
			up = callMeBeforePerformAnyAction();
			hp = up.activateUser(uname);
			logger.info("Activate user call done");	
		}
		
		//DEACTIVATE USER
		@Test(priority = 6)
		public void test_DeActivateUser()throws InterruptedException
		{
			up = callMeBeforePerformAnyAction();
			hp = up.deactivateUser(uname);
			logger.info("DeActivate user call done");
		}
				
			
	//		//EDIT PROJECT
	//		//@Test(priority = 5 , dependsOnMethods = {"test_Login"})
	//		public void test_EditProject()throws InterruptedException {
	//			pp = callMeBeforePerformAnyAction();
	//			hp = pp.editProject(projectSearchKey, newProjecName, newProjecDescription, newDomainName, newTechnologyName, newProjectStartDate, newProjectEndDate );
	//			Thread.sleep(2000);
	//		}
			
	//		//ASSIGN PROJECT TO THE USERS
	//		@Test(priority = 6 , dependsOnMethods = {"test_Login"})
	//		public void test_AssignProject()throws InterruptedException {
	//			pp = callMeBeforePerformAnyAction();
	//			hp = pp.assignProjectToUser(projectSearchKey, userNameToAssignProject, assignProjectStartDate, assignProjectEndDate);
	//			Thread.sleep(2000);
	//		}
			
			
			//TO PERFORM THE LOGOUT
			@Test(priority = 10, dependsOnMethods = {"test_Login"})
			public void test_Logout() throws InterruptedException {
				//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
				hp.clickOniconHomeImage();
				Thread.sleep(3000);
				// TO LOGOUT
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

}
