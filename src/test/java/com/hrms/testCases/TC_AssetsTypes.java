package com.hrms.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders;
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
	@Test(priority =2 , dependsOnMethods = "test_Login", dataProvider = fileNameOnly)
	public void test_CreateAssetsTypes(String assetTypeName, String assetTypeCode, String assetTypeDescription) throws InterruptedException
	{	// to create new organization
		acat = callMeBeforePerformAnyAction();
		hp = acat.createAssetType(assetTypeName, assetTypeCode, assetTypeDescription);
		logger.info("Create assets types methods call done");	
		Thread.sleep(2000);
	}
	
	//ARCHIVE ASSESTS TYPES
	//@Test(priority = 3 , dependsOnMethods = "test_Login")
	public void test_ArchiveAssetsTypes()throws InterruptedException
	{
		acat = callMeBeforePerformAnyAction();
		hp = acat.archiveAssetType(assetTypeName);
		logger.info("Archive job titles call done");
		Thread.sleep(2000);
	}
	
	//RESTORE ASSESTS TYPES
	//@Test(priority = 4, dependsOnMethods = "test_Login")
	public void test_RestoreAssetsTypes()throws InterruptedException
	{
		acat = callMeBeforePerformAnyAction();
		hp = acat.restoreAssetType(assetTypeName);
		logger.info("Restore job titles call done");
		Thread.sleep(2000);
	}
		
	
	//EDIT ASSESTS TYPES
	//@Test(priority = 5 , dependsOnMethods = "test_Login")
	public void test_EditAssetsTypes()throws InterruptedException
	{
		acat = callMeBeforePerformAnyAction();
		hp = acat.editAssetType(assetTypeSearchKey,newAssetTypeDescription, newAssetTypeName,newAssetTypeCode);
		Thread.sleep(2000);
	}
	
	//TO PERFORM THE LOGOUT
	@Test(priority = 10, dependsOnMethods = "test_Login")
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

	//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
  	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
  	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
  	public final String fileNameOnly = "TC_AssetsTypes";
  	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
  	public DataProviders dp =  new DataProviders();
  	//DATA PROVIDER
  	@DataProvider(name = fileNameOnly)
  	public String[][] dataProvider() throws IOException {
  		String loginData[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly);
  		return loginData;
  	}
  	//======END=====DATA READING FORM THE EXCEL FILE=====IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME======//
  	
}
