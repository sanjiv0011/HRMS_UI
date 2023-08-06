package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_Asserts_CreateAssetsTypes;
import com.hrms.pageObject.PO_Assets_CreateAssert;
import com.hrms.pageObject.PO_ClientPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_OragnizationPage;

public class TC_Assets_CreateAssets extends BaseClass {
	public TC_Assets_CreateAssets() {
		super();
	}
	
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_Assets_CreateAssert aca;
	
	String companyName = "Endurance";
	String assetType = "LatheMachine";
	String serialNumber = "132456";
	String modelNumber = "465312";
	String usedBy = "Jokhan";
	String supportPerson = "Jenex";
	String warrantyExpiry = "06/25/2025";
	String warranty = "3";
	String manufacturerDate1 = "06/25/2022";
	String purchaseDate1 = "06/25/2023";
	String invoiceNumber = "6542130" ;
	String invoiceURL = "https://ete.com";
	String status = "new";
	String condition = "new";
	String replacementStatus = "null";
	
	@Test(priority =1)
	public void test_CreateCleint() throws InterruptedException
	{
		//to perform login 
		lgn = new PO_LoginPage(driver);
		hp = lgn.login(userName, password);
		
		// to access assets tab
		hp.clickOntabAssets();
		
		//to access assets page
		aca = new PO_Assets_CreateAssert(driver);
		logger.info("started assest page constructor");
		
		// to create new organization
		hp = aca.createAssets(companyName, assetType, serialNumber, modelNumber, usedBy, supportPerson, warrantyExpiry, warranty, manufacturerDate1, purchaseDate1, invoiceNumber, invoiceURL, status, condition, replacementStatus);
		logger.info("Client created");
		
		// to logout
		hp.Logout();
		
		
	}


}
