package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_MyCalendarPage;

public class TC_MyCalendar extends BaseClass{
	
	//CREATES SUPER CONSTRUCTOR,INHERITETS(BASE CLASS)
	public TC_MyCalendar() {
		super();
	}
	
	//CONSTRUCTOR AND OTHER VARIABLE DECLARATOINS/INITIALIZATIONS
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_MyCalendarPage mcp;

	
	//VARIABLE DECLARATION AND INITIALIZATIONS
	String dateValue = "17";
	String dateContent = "MetaVerseMetaVerse";
	
	
	//TO LOGIN
	@Test(priority =1)
	public void test_Login() throws InterruptedException{
		lgn = new PO_LoginPage(driver);
		hp = lgn.login(userName, password);
	}
	
	//TO VISIT AND CHECK MY CALLENDAR MONTH VIEW
	@Test(priority = 2, dependsOnMethods = {"test_Login"})
	public void test_VisitMyCalendarContentMonthWiseView() throws InterruptedException
	{	mcp = callMeBeforePerformAnyAction();
		hp = mcp.clickAndViewMyCalendarElementMonthView(driver, dateValue, dateContent);
		logger.info("test_VisitMyCalendarContent call done");
	}
	
//	//TO VISIT AND CHECK MY CALLENDAR MONTH VIEW
//	@Test(priority = 2, dependsOnMethods = {"test_Login"})
//	public void test_VisitMyCalendarContentDayWiseView() throws InterruptedException
//	{	mcp = callMeBeforePerformAnyAction();
//		hp = mcp.clickAndViewMyCalendarElementDayWiseView(driver, dateValue, dateContent);
//		logger.info("test_VisitMyCalendarContentDayWiseView call done");
//	}
	
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
	public PO_MyCalendarPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		
		//TO ACCESS DAILY UPADTES TAB
		hp.clickOntabMyCalendar();
		Thread.sleep(2000);
		
		//TO ACCESS DAILY UPDATES PAGE OBJECTS
		return new PO_MyCalendarPage(driver);	
	}
}
