package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LeavePage;
import com.hrms.pageObject.PO_LoginPage;

public class TC_Leave extends BaseClass{
	
	//CREATES SUPER CONSTRUCTOR,INHERITETS(BASE CLASS)
	public TC_Leave() {
		super();
	}
	
	//CONSTRUCTOR AND OTHER VARIABLE DECLARATOINS/INITIALIZATIONS
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_LeavePage lp;
	public Faker faker = new Faker();
	
	
	//VARIABLE DECLARATIONS AND ITS INITIALIZATIONS
	String leaveTypeName = "Sick Leave"; // SELECT WHICH IS PRESENT IN THE DROPDOWN ONLY
	String leaveDuration = "First half"; 	// OR "Second half", "Full day"
	String leaveStartDate = "18 August 2023"; //APPLY ONLY THIS GIVEN FORMATE
	String leaveEndDate = "30 August 2023"; //APPLY ONLY THIS GIVEN FORMATE
	String reason = faker.lorem().paragraph(1);
			
			
	//TO PERFORM THE LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException {
		lgn = new PO_LoginPage(driver);
		hp = lgn.login(userName, password);
		Thread.sleep(3000);
	}
	
	//TO APPLY LEAVE
	@Test(priority =2 , dependsOnMethods = {"test_Login"})
	public void test_ApplyLeave() throws InterruptedException {
		lp = callMeBeforePerformAnyAction();
		hp = lp.applyLeave(leaveTypeName, leaveDuration, leaveStartDate, leaveEndDate, reason);
		logger.info("Leave applied");		
	}
	
	//TO PERFORM THE LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(5000);
		// TO LOGOUT
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_LeavePage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		
		//TO ACCESS LEAVE TAB
		hp.clickOntabLeave();
		Thread.sleep(2000);
		
		//TO ACCESS LEAVE PAGE OBJECTS
		return new PO_LeavePage(driver);	
	}
}
