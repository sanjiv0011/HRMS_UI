package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_Asserts_CreateAssetsTypes;
import com.hrms.pageObject.PO_AssetsPage;
import com.hrms.pageObject.PO_ClientPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_OragnizationPage;

public class TC_Assets extends BaseClass {
	public TC_Assets() {
		super();
	}
	
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_AssetsPage aca;
	
	String companyName = "Endurance";
	String assetType = "Fans";
	String serialNumber = "132456";
	String modelNumber = "465312";
	String usedBy = "Jokhan";
	String supportPerson = "Jenex";
	String warrantyExpiry = "6 July 2025";
	String warranty = "3";
	String manufacturerDate1 = "25 June 2022";
	String purchaseDate1 = "20 March 2023";
	String invoiceNumber = "6542130" ;
	String invoiceURL = "https://ete.com";
	String status = "active";
	String condition = "new";
	String replacementStatus = "none";
	
	
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException{
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		logger.info("Login Done");
	}
		
	//TO CREATE ASSETS
	@Test(priority = 2)
	public void test_CreateAssets() throws InterruptedException
	{	// to create new organization
		aca = callMeBeforePerformAnyAction();
		hp = aca.createAssets(companyName, assetType, serialNumber, modelNumber, usedBy, supportPerson, warranty, warrantyExpiry, manufacturerDate1, purchaseDate1, invoiceNumber, invoiceURL, status, condition, replacementStatus);
		logger.info("Assets created");
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
	public PO_AssetsPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		
		//TO ACCESS ASSETS TAB
		hp.clickOntabAssets();
		Thread.sleep(2000);
		
		//TO ACCESS USERS PAGE OBJECTS
		return new PO_AssetsPage(driver);
	}


}
