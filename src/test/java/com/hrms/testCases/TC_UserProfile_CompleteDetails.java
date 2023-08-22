package com.hrms.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_UserProfilePage;
import com.hrms.pageObject.PO_UserProfilePage_AddressDetails;
import com.hrms.pageObject.PO_UserProfilePage_BankDetails;
import com.hrms.pageObject.PO_UserProfilePage_OtherDetails;
import com.hrms.pageObject.PO_UserProfilePage_PersonalInfo;
import com.hrms.pageObject.PO_UserProfilePage_ResetPassword;

public class TC_UserProfile_CompleteDetails extends BaseClass{
	//CONSTRUCTOR TO INHERITENCE BASE CLASS PARAMETERS
	public TC_UserProfile_CompleteDetails() {
		super();
	}
	
	//CONSTRUCTOR INITIALIZATIONS AND DECLARATIONS
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_UserProfilePage upp;
	public PO_UserProfilePage_PersonalInfo uppi;
	public PO_UserProfilePage_AddressDetails upad;
	public PO_UserProfilePage_BankDetails upbd;
	public PO_UserProfilePage_OtherDetails upod;
	public PO_UserProfilePage_ResetPassword uprp;
	public Faker faker= new Faker();
	public DataProviders dp =  new DataProviders();

////VARIABLES DECLARATIONS AND INITIALIZATIONS(WHILE USING THIS COMMENT THE DATAPROVIDER METHODS)
//	//VARIABLES FOR PERSONAL DETAILS
//	public String phoneNumber = "+91 "+"1234567890";
//    public String dateOfBirth = "20 July 2021";
//    public String gender = "Male";
//    public String marri = "Married";
//    public String bio = "xysdfshnsdfj";
//    
//	//VARIABLE FOR ADDRESS DETAILS
//	public String addressLine1 = faker.address().buildingNumber();
//	public String addressLine2 = faker.address().fullAddress();
//	public String city = faker.address().cityName();
//	public String state = faker.address().state();
//	public String country = "India";
//	public String postalCode = "123456";
//	  
//	//VARIABLES FOR OTHERES DETAILS
//	public String emergencyContactName = faker.name().fullName();
//    public String emergencyContactNumber = "+91 "+"1234567890";
//    public String socialSecuritynumber = "123456789";
//    
//    //VARIABLES FOR BANK DETAILS
//  	public String bankName = "Bank of baroda";
//    public String bankNumber = "123546789987420";
//    public String accountName = "My name bank name";
//    public String isfcCode = "COSB0000001";
//    
//    //VARIABLES FOR RESET PASSWORD
//  	public String oldPassword = "Qwer4321!";
//    public String newPassword = "Qwer4321!";
//    public String  buttonNextOrGoToHome = "next"; //or "next" , "saveAndGoToHome"
    
  
	//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
  	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
  	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
	
	//PERSONAL INFO
  	public final String fileNameOnly_PersonlInfo = "UserProfile_CompleteDetails//"+"TC_UserProfile_PersonalInfo";
  	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
  	//DATA PROVIDER
  	@DataProvider(name = fileNameOnly_PersonlInfo)
  	public String[][] dataProvider_PersonlInfo() throws IOException {
  		String loginData[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly_PersonlInfo);
  		return loginData;
  	}
  	
  	//ADDRESS DETAILS
  	public final String fileNameOnly_Address = "UserProfile_CompleteDetails//"+"TC_UsersProfile_AddressDetails";
  	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
  	//DATA PROVIDER
  	@DataProvider(name = fileNameOnly_Address)
  	public String[][] dataProvider_Address() throws IOException {
  		String loginData[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly_Address);
  		return loginData;
  	}
  	
  	//BANK DETAILS
  	public final String fileNameOnly_Bank = "UserProfile_CompleteDetails//"+"TC_UsersProfile_BankDetails";
  	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
  	//DATA PROVIDER
  	@DataProvider(name = fileNameOnly_Bank)
  	public String[][] dataProvider_Bank() throws IOException {
  		String loginData[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly_Bank);
  		return loginData;
  	}
  	
  	//OTHERS DETAILS
  	public final String fileNameOnly_Others = "UserProfile_CompleteDetails//"+"TC_UsersProfile_OthersDetails";
  	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
  	//DATA PROVIDER
  	@DataProvider(name = fileNameOnly_Others)
  	public String[][] dataProvider_OthereDetails() throws IOException {
  		String loginData[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly_Others);
  		return loginData;
  	}
  	
  	//RESET PASSWORD
  	public final String fileNameOnly_Reset = "UserProfile_CompleteDetails//"+"TC_UsersProfile_ResetPassword";
  	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
  	//DATA PROVIDER
  	@DataProvider(name = fileNameOnly_Reset)
  	public String[][] dataProvider() throws IOException {
  		String loginData[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly_Reset);
  		return loginData;
  	}
  	//======END=====DATA READING FORM THE EXCEL FILE=====IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME======//
  	
  	
    
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException{
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		logger.info("Login Done");
	}
	
	//TO FILL UP PERSONAL DETAILS
	@Test(priority = 2 , dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly_PersonlInfo)
	public void test_UsersProfile_PersonalInfo(String phoneNumber, String dateOfBirth, String gender, String marri, String bio, String buttonNextOrGoToHome) throws InterruptedException {
		uppi = setUpToAccessPersonalUserProfilePage();
		upad = uppi.personalInfoDetails_ReturnTypeAddressDetails(phoneNumber,dateOfBirth,gender, marri,bio,buttonNextOrGoToHome);	// line 1
		//System.out.println("Return type: "+upad);
	}
	
	//TO FILL UP ADDRESS DETAILS
	@Test(priority = 3, dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly_Address)
	public void test_UsersProfile_AddressDetails(String addressLine1, String addressLine2, String city,String state, String country , String postalCode,String buttonNextOrGoToHome) throws InterruptedException {		
		upod = upad.fillUsersAddressDetails_ReturnType_OtherDetails(addressLine1,addressLine2,city, state,country,  postalCode,buttonNextOrGoToHome);	// line 1	
		System.out.println("Return type: "+upod);
	}
	
	//TO FILL OTHERS DETAILS
	@Test(priority = 4 , dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly_Others)
	public void test_UsersProfile_OthresDetails(String emergencyContactName, String emergencyContactNumber, String socialSecuritynumber, String buttonNextOrGoToHome) throws InterruptedException {
		hp = upod.fillOthersDetails(emergencyContactName,emergencyContactNumber,socialSecuritynumber,buttonNextOrGoToHome);	
		System.out.println("Return type: "+hp);
	}
	
	//TO FILL UP BANK DETAILS
	@Test(priority = 5 , dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly_Bank)
	public void test_UsersProfile_BankDetails(String bankName, String bankNumber, String accountName, String isfcCode) throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		//TO ACCESS THE SYSTEM MANAGER BUTTON
		hp.clickOnbtnSystemManager();
		//TO ACCESS USER PROFILE TAB
		upp = hp.clickOndropdownMyProfile();
		//System.out.println("upp: "+upp);
		upbd = upp.clickOntabBankDetails_ReturnBankDeailsPage();
		Thread.sleep(2000);
		hp = upbd.fillBankDetails(bankName,bankNumber,accountName,isfcCode);	
		System.out.println("Return type: "+hp);
	}
		
	//TO TEST RESET PASSWORD
	@Test(priority = 6 , dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly_Reset)
	public void test_UsersProfile_ResetPassword(String oldPassword, String newPassword) throws InterruptedException
	{
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		//TO ACCESS THE SYSTEM MANAGER BUTTON
		hp.clickOnbtnSystemManager();
		//TO ACCESS USER PROFILE TAB
		upp = hp.clickOndropdownMyProfile();
		//System.out.println("upp: "+upp);
		uprp = upp.clickOntabResetPassword_ReturnResetPasswordPage();
		Thread.sleep(2000);
		hp = uprp.resetPassword(oldPassword,newPassword);	
	}
	
	
	//TO LOGOUT
	@Test(priority = 10, dependsOnMethods = {"test_Login"})
	public void test_Logout() throws InterruptedException {
		hp.Logout();
	}
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_UserProfilePage_PersonalInfo setUpToAccessPersonalUserProfilePage() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
		hp.clickOniconHomeImage();
		Thread.sleep(3000);
		//TO ACCESS THE SYSTEM MANAGER BUTTON
		hp.clickOnbtnSystemManager();
		//TO ACCESS USER PROFILE TAB
		upp = hp.clickOndropdownMyProfile();
		//System.out.println("upp: "+upp);
		upp.clickOntabPersonalInfo();
		Thread.sleep(2000);
		
		//TO ACCESS USERS PAGE OBJECTS
		return new PO_UserProfilePage_PersonalInfo(driver);
	}
			
}
