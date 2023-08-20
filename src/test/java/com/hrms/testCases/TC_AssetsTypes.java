package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_Asserts_CreateAssetsTypes;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;

public class TC_AssetsTypes extends BaseClass {
	public TC_AssetsTypes() {
		super();
	}
	
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_Asserts_CreateAssetsTypes acat;
	
	String assetTypeName = "WaterBottels";
	String assetTypeCode = "WTBL";
	String assetTypeDescription = faker.address().fullAddress();
	String assetTypeSearchKey = assetTypeName;
	String newAssetTypeDescription = assetTypeDescription;
	String newAssetTypeName = "WaterBtl";
	String newAssetTypeCode = assetTypeCode;
	
	
	//TO PERFORM THE LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException
	{	//to perform login
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		Thread.sleep(5000);
	}
		
	//TO CREATE ASSESTS TYPES	
	@Test(priority =2 , dependsOnMethods = {"test_Login"})
	public void test_CreateAssetsTypes() throws InterruptedException
	{	// to create new organization
		acat = callMeBeforePerformAnyAction();
		hp = acat.createAssetType(assetTypeName, assetTypeCode, assetTypeDescription);
		logger.info("Create assets types methods call done");	
		Thread.sleep(2000);
	}
	
	//ARCHIVE JOB TITLES
	@Test(priority = 3 , dependsOnMethods = {"test_Login"})
	public void test_ArchiveAssetsTypes()throws InterruptedException
	{
		acat = callMeBeforePerformAnyAction();
		hp = acat.archiveAssetType(assetTypeName);
		logger.info("Archive job titles call done");
		Thread.sleep(2000);
	}
	
	//RESTORE JOB TITLES
	@Test(priority = 4, dependsOnMethods = {"test_Login"})
	public void test_RestoreAssetsTypes()throws InterruptedException
	{
		acat = callMeBeforePerformAnyAction();
		hp = acat.restoreAssetType(assetTypeName);
		logger.info("Restore job titles call done");
		Thread.sleep(2000);
	}
		
	
	//EDITJOB TITLES
	@Test(priority = 5 , dependsOnMethods = {"test_Login"})
	public void test_EditAssetsTypes()throws InterruptedException
	{
		acat = callMeBeforePerformAnyAction();
		hp = acat.editAssetType(assetTypeSearchKey,newAssetTypeDescription, newAssetTypeName,newAssetTypeCode);
		Thread.sleep(2000);
	}
	
	//TO PERFORM THE LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException
	{	//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		hp.Logout();// to logout
	}
		
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Asserts_CreateAssetsTypes callMeBeforePerformAnyAction() throws InterruptedException
	{	//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		
		//TO ACCESS ASSETS TAB
		hp.clickOntabAssets();
		Thread.sleep(2000);
		
		//TO ACCESS ASSETS TYPES PAGE OBJECTS
		return new PO_Asserts_CreateAssetsTypes(driver);	
	}

}
