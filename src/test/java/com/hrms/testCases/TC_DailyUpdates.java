package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_DailyUpdates;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;

import org.openqa.selenium.interactions.Action;


public class TC_DailyUpdates extends BaseClass{
	
	//CREATES SUPER CONSTRUCTOR,INHERITETS(BASE CLASS)
	public TC_DailyUpdates() {
		super();
	}
	
	//CONSTRUCTOR AND OTHER VARIABLE DECLARATOINS/INITIALIZATIONS
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_DailyUpdates du;
	
	
	String dailyUpdateDate = "17 August 2023";
	String hoursStart = "5";
	String mintuesStart = "55";
	String AMPMStart = "PM";
	String hoursEnd = "9";
	String mintuesEnd = "20";
	String AMPMEnd = "AM";
	String projectName = "YourDreamHouse";
	String description = faker.lorem().paragraph();
	
	
	//TO LOGIN
	@Test(priority =1)
	public void test_Login() throws InterruptedException{
		lgn = new PO_LoginPage(driver);
		hp = lgn.login(userName, password);
	}
	
	//TO CREATE DAILY UPDATES
	@Test(priority = 2, dependsOnMethods = {"test_Login"})
	public void test_CreateDailyUpdates() throws InterruptedException
	{	du = callMeBeforePerformAnyAction();
		hp = du.createDailyUpdates(driver, dailyUpdateDate, hoursStart, mintuesStart, AMPMStart, hoursEnd, mintuesEnd, AMPMEnd, projectName, description);
	}
	
	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		Thread.sleep(2000);
		hp.clickOniconHomeImage();
		Thread.sleep(4000);
		// TO LOGOUT
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_DailyUpdates callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		
		//TO ACCESS DAILY UPADTES TAB
		hp.clickOntabDailyUpdates();
		Thread.sleep(2000);
		
		//TO ACCESS DAILY UPDATES PAGE OBJECTS
		return new PO_DailyUpdates(driver);	
	}

}
