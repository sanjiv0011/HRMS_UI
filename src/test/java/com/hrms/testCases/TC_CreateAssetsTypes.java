package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_Asserts_CreateAssetsTypes;
import com.hrms.pageObject.PO_ClientPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_OragnizationPage;

public class TC_CreateAssetsTypes extends BaseClass {
	public TC_CreateAssetsTypes() {
		super();
	}
	
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_Asserts_CreateAssetsTypes acat;
	
	String assetTypeName = faker.name().firstName();
	String assetTypeCode = "ADFY";
	String assetTypeDescription = faker.company().profession();
	
	@Test(priority =1)
	public void test_CreateCleint() throws InterruptedException
	{
		//to perform login 
		lgn = new PO_LoginPage(driver);
		hp = lgn.login(userName, password);
		
		// to access assets tab
		hp.clickOntabAssets();
		
		//to access assets page
		acat = new PO_Asserts_CreateAssetsTypes(driver);
		logger.info("started assest page constructor");
		
		// to create new organization
		hp = acat.createAssetType(assetTypeName, assetTypeCode, assetTypeDescription);
		logger.info("Client created");
		
		// to logout
		hp.Logout();
		
		
	}


}
