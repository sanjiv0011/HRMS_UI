package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_ClientPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_JobTitles;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_OragnizationPage;

public class TC_Cleint extends BaseClass {
	public TC_Cleint() {
		super();
	}
	
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_ClientPage cp;
	
	String cleintName = "AMR Reseach";
	String clientDescription = faker.company().profession();
	String clientSearchKey = cleintName;
	String newClientDescription = faker.company().profession();
	String newCleintName = "AMR";
	
	
	//TO PERFORM THE LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException
	{	//to perform login
		lgn = new PO_LoginPage(driver);
		hp = lgn.login(userName, password);
		Thread.sleep(5000);
	}
	
	//TO CREATE CLIENT
	@Test(priority =2 , dependsOnMethods = {"test_Login"})
	public void test_CreateCleint() throws InterruptedException
	{	cp = callMeBeforePerformAnyAction();
		hp = cp.createClient(cleintName, clientDescription);
		logger.info("Client created");
	
	}
	
	//ARCHIVE CLINET
	@Test(priority = 3 , dependsOnMethods = {"test_Login"})
	public void test_ArchiveClient()throws InterruptedException
	{
		cp = callMeBeforePerformAnyAction();
		hp = cp.archiveClient(cleintName);
		logger.info("Archive client call done");	
	}
	
	//RESTORE CLINET
	@Test(priority = 4, dependsOnMethods = {"test_Login"})
	public void test_RestoreClient()throws InterruptedException
	{
		cp = callMeBeforePerformAnyAction();
		hp = cp.restoreClient(cleintName);
		logger.info("Restore client call done");
	}
		
	
	//EDIT CLINET
	@Test(priority = 5 , dependsOnMethods = {"test_Login"})
	public void test_EditClient()throws InterruptedException
	{
		cp = callMeBeforePerformAnyAction();
		hp = cp.editClient(clientSearchKey,newClientDescription, newCleintName);
		logger.info("Edit client call done");
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
	public PO_ClientPage callMeBeforePerformAnyAction() throws InterruptedException
	{	//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		
		//TO ACCESS JOB TITLES TAB
		hp.clickOntabClients();
		Thread.sleep(2000);
		
		//TO ACCESS JOB TITLES PAGE OBJECTS
		return new PO_ClientPage(driver);	
	}


}
