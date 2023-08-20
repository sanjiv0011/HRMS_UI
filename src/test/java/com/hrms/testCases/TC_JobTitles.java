package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_JobTitles;
import com.hrms.pageObject.PO_LoginPage;

public class TC_JobTitles extends BaseClass {
	public TC_JobTitles() {
		super();
	}
	
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_JobTitles jt;
	
	String jobTitle = "Senior Retail Executive"; //faker.job().title();
	String jobDescription = faker.job().position();
	String jobTitlesSearchKey = jobTitle;
	String newJobDescription = jobDescription;
	String newJobTitles = jobTitle;
	
	
	//TO PERFORM THE LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException
	{
		//to perform login
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		Thread.sleep(5000);
	}
	
	//TO CREATE THE  JOB TITLES 
	@Test(priority =2 , dependsOnMethods = {"test_Login"})
	public void test_CreateCleint() throws InterruptedException
	{		
		jt = callMeBeforePerformAnyAction();
		hp = jt.createJobTitle(jobTitle, jobDescription);
		logger.info("JobTitle created");		
	}
	
	//ARCHIVE JOB TITLES
	@Test(priority = 3 , dependsOnMethods = {"test_Login"})
	public void test_ArchiveJobTitles()throws InterruptedException
	{
		jt = callMeBeforePerformAnyAction();
		hp = jt.archiveJobTitles(jobTitle);
		logger.info("Archive job titles call done");	
	}
	
	//RESTORE JOB TITLES
	@Test(priority = 4, dependsOnMethods = {"test_Login"})
	public void test_RestoreJobTitles()throws InterruptedException
	{
		jt = callMeBeforePerformAnyAction();
		hp = jt.restoreJobTitles(jobTitle);
		logger.info("Restore job titles call done");
	}
		
	
	//EDITJOB TITLES
	@Test(priority = 5 , dependsOnMethods = {"test_Login"})
	public void test_EditJobTitles()throws InterruptedException
	{
		jt = callMeBeforePerformAnyAction();
		hp = jt.editJobTitles(jobTitlesSearchKey,newJobDescription, newJobTitles);
		Thread.sleep(2000);
	}
	
	
	//TO PERFORM THE LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException
	{	//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		// to logout
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


}
