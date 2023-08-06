package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_ClientPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_OragnizationPage;

public class TC_CreateCleint extends BaseClass {
	public TC_CreateCleint() {
		super();
	}
	
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_ClientPage cp;
	
	String cleintName = faker.name().firstName();
	String clientDescription = faker.company().profession();
	
	@Test(priority =1)
	public void test_CreateCleint() throws InterruptedException
	{
		//to perform login 
		lgn = new PO_LoginPage(driver);
		hp = lgn.login(userName, password);
		logger.info("Login Done");
		
		// to access client tab
		hp.clickOntabClients();
		
		//to access cleint page
		cp = new PO_ClientPage(driver);
		logger.info("started client page constructor");
		
		// to create new organization
		hp = cp.createClient(cleintName, clientDescription);
		logger.info("Client created");
		
		// to logout
		hp.Logout();
		
		
	}


}
