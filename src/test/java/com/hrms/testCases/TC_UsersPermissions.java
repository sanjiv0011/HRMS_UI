package com.hrms.testCases;

import org.testng.annotations.Test;

import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_UserPermissions;
import com.hrms.pageObject.PO_UsersPage;

public class TC_UsersPermissions extends BaseClass {
		//CREATES SUPER CONSTRUCTOR,INHERITETS(BASE CLASS)
		public TC_UsersPermissions() {
			super();
		}
		
		//CONSTRUCTOR AND OTHER VARIABLE DECLARATOINS/INITIALIZATIONS
		public PO_LoginPage lgn;
		public PO_HomePage hp;
		public PO_UsersPage up;
		public PO_UserPermissions userPermissions;
		
		//TO PERFORM THE LOGIN
		@Test(priority = 1)
		public void test_Login() throws InterruptedException {
			lgn = new PO_LoginPage(driver);
			hp = lgn.Login(userName, password);
		}
		
		//TO CHECK USER PERMISSION ASSIGNMENT DROPDOWNS 
		@Test(priority = 2 , dependsOnMethods = {"test_Login"})
		public void test_UserPermissionAssignmentDropdown() throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			up.clickOnBtnCreateUser(); 
			userPermissions = up.clickOnTabPermissions_ReturnTypePermissionPage();
			hp = userPermissions.userPermissionsDropdown();	
		}
		
		
		//TO CHECK USER PERMISSION ADMIN CHECKBOX SELECTION
		@Test(priority = 3 , dependsOnMethods = {"test_Login"})
		public void test_UserPermissionAdminCheckBoxSelection() throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			up.clickOnBtnCreateUser(); 
			userPermissions = up.clickOnTabPermissions_ReturnTypePermissionPage();
			hp = userPermissions.userPermissionsAdminCheckbox();	
		}
		
		//TO CHECK USER PERMISSION ALL THE CHECKBOX FROM BOTTOM TO TOP SELECTION
		@Test(priority = 4 , dependsOnMethods = {"test_Login"})
		public void test_UserPermissionAllCheckBoxSelectionFromBottomToTop() throws InterruptedException {
			up = callMeBeforePerformAnyAction();
			up.clickOnBtnCreateUser(); 
			userPermissions = up.clickOnTabPermissions_ReturnTypePermissionPage();
			hp = userPermissions.userPermissionsCheckboxSelectionBottomToTop();	
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
			//TO ACCESS USERS PERMISSION PAGE OBJECTS
			return new PO_UsersPage(driver);	
		}
}
