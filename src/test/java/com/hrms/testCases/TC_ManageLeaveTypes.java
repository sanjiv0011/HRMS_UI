package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
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
	
	 
	String leaveTypeName = "Casual Leave";
	String leaveTypeDescription = faker.company().profession();
	String newLeaveTypes = "Paid Leave";
	
	
	//TO PERFORM THE LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException
	{
		//to perform login 
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		Thread.sleep(5000);
	}
			
	@Test(priority =2)
	public void test_CreateLeaveType() throws InterruptedException
	{
		mlt = callMeBeforePerformAnyAction();
		hp = mlt.createLeaveType(leaveTypeName, leaveTypeDescription);
		logger.info("Leave types created");
	}
	
	
	//ACTIVATE LEAVE TYPES
	@Test(priority = 3)
	public void test_ActivateLeaveTypes()throws InterruptedException
	{
		mlt = callMeBeforePerformAnyAction();
		hp = mlt.activateLeaveTypes(leaveTypeName);
		logger.info("Activate Leave Type call done");	
	}
	
	//DEACTIVATE LEAVE TYPES
	@Test(priority = 4)
	public void test_DeActivateLeaveTypes()throws InterruptedException
	{
		mlt = callMeBeforePerformAnyAction();
		hp = mlt.deactivateLeaveTypes(leaveTypeName);
		logger.info("DeActivate Leave Type call done");
	}
	
	//EDIT LEAVE TYPES
	@Test(priority = 4)
	public void test_EditLeaveTypes()throws InterruptedException
	{
		mlt = callMeBeforePerformAnyAction();
		hp = mlt.editLeaveType(leaveTypeName,leaveTypeDescription,newLeaveTypes);
		Thread.sleep(2000);
	}
	
	//DELETE LEAVE TYPES
	@Test(priority = 5)
	public void test_DeleteLeaveTypes()throws InterruptedException
	{
		mlt = callMeBeforePerformAnyAction();
		hp = mlt.deleteLeaveTypes(leaveTypeName);
		Thread.sleep(2000);
		logger.info("Delete Leave Type call done");
	}
	
	//TO PERFORM THE LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException
	{
		Thread.sleep(10000);
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		
		// to logout
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_ManageLeaveTypes callMeBeforePerformAnyAction() throws InterruptedException
	{
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		
		// to access manage leave types tab
		hp.clickOntabManageLeaveTypes();
		Thread.sleep(2000);
		
		//to access manage leave type page
		return new PO_ManageLeaveTypes(driver);	
	}


}
