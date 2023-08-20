package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_AssetsPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LeaveBalance;
import com.hrms.pageObject.PO_LoginPage;

public class TC_LeaveBalance extends BaseClass {
	public TC_LeaveBalance() {
		super();
	}
	
	//TO INITIATE FAKER LIBRARY CONSTRUCTER
	public Faker faker = new Faker();
	
	//TO INITIATE LONGIN CONSTRUCTER
	public PO_LoginPage lgn;
	
	//TO INITIATE HOME PAGE CONSTRUCTER
	public PO_HomePage hp;
	
	//TO INITIATE LEAVE BALANCE PAGE CONSTRUCTER
	public PO_LeaveBalance lb;
	
	//INPUT VALUES
	String leaveBalanceStartDate = "1 August 2023";
	String leaveBalanceEndDate = "31 July 2028";
	String leaveTypeName = "Emergency Leave";
	String leaveBalance =  "20";
	String leaveTypeNameForSearch = "Emergency"; //BEACUSE IT NOT ABLE TO SEARCH TWO WORD KEY
	
		//TO PERFORM THE LOGIN
		@Test(priority = 1)
		public void test_Login() throws InterruptedException
		{
			//to perform login 
			lgn = new PO_LoginPage(driver);
			hp = lgn.Login(userName, password);
			Thread.sleep(3000);
		}
		
		//TO CREATE LEAVE BALANCE
		@Test(priority =2 /*, dependsOnMethods = {"test_Login"} */)
		public void test_CreateLeaveBalance() throws InterruptedException
		{
			lb = callMeBeforePerformAnyAction();
			hp = lb.createLeaveBalance(leaveBalanceStartDate, leaveBalanceEndDate, leaveTypeName, leaveBalance);
			logger.info("Leave Balance created");
		}
		
	
		//@Test(priority = 3, dependsOnMethods = {"test_Login"} )//TO ARCHIVE THE LEAVE BALANCE
		public void test_ArchiveLeaveBalance() throws InterruptedException
		{
			lb = callMeBeforePerformAnyAction();
			hp = lb.archiveLeaveBalance(leaveTypeNameForSearch);
			Thread.sleep(2000);
		}
	
	
	
		//@Test(priority = 4, dependsOnMethods = {"test_Login"} )//TO RESTORE THE LEAVE BALANCE
		public void test_RestoreLeaveBalance() throws InterruptedException
		{
			lb = callMeBeforePerformAnyAction();
			hp = lb.restoreLeaveBalance(leaveTypeNameForSearch);
			Thread.sleep(2000);
		}
		
		//@Test(priority = 5 , dependsOnMethods = {"test_Login"} )//TO EDIT THE LEAVE BALANCE
		public void test_EditLeaveBalance() throws InterruptedException
		{
			lb = callMeBeforePerformAnyAction();
			hp = lb.editLeaveBalance(leaveBalanceStartDate, leaveBalanceEndDate, leaveTypeNameForSearch, leaveBalance);
			Thread.sleep(2000);
		}
		
		//TO LOGOUT
		@Test(priority = 10, dependsOnMethods = {"test_Login"})
		public void test_Logout() throws InterruptedException {
			//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
			Thread.sleep(2000);
			hp.clickOniconHomeImage();
			Thread.sleep(5000);
			// TO LOGOUT
			hp.Logout();
		}
		
		//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
		public PO_LeaveBalance callMeBeforePerformAnyAction() throws InterruptedException {
			//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
			hp.clickOniconHomeImage();
			Thread.sleep(3000);
			
			//TO ACCESS ASSETS TAB
			hp.clickOntabLeaveBalances();
			Thread.sleep(2000);
			
			//TO ACCESS USERS PAGE OBJECTS
			return new PO_LeaveBalance(driver);
		}

}
