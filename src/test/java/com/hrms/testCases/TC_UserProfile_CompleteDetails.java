package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
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
	
	//VARIABLES FOR PERSONAL DETAILS
	public String phoneNumber = "+91 "+"1234567890";
    public String dateOfBirth = "20 July 2021";
    public String gender = "Male";
    public String marri = "Married";
    public String bio = "xysdfshnsdfj";
    
	//VARIABLE FOR ADDRESS DETAILS
	public String addressLine1 = faker.address().buildingNumber();
	public String addressLine2 = faker.address().fullAddress();
	public String city = faker.address().cityName();
	public String state = faker.address().state();
	public String country = "India";
	public String postalCode = "123456";
	  
	//VARIABLES FOR OTHERES DETAILS
	public String emergencyContactName = faker.name().fullName();
    public String emergencyContactNumber = "+91 "+"1234567890";
    public String socialSecuritynumber = "123456789";
    
    //VARIABLES FOR BANK DETAILS
  	public String bankName = "Bank of baroda";
    public String bankNumber = "123546789987420";
    public String accountName = "My name bank name";
    public String isfcCode = "COSB0000001";
    
    //VARIABLES FOR RESET PASSWORD
  	public String oldPassword = "Qwer4321!";
    public String newPassword = "Qwer4321!";
    
    public String  buttonNextOrGoToHome = "next"; //or "next" , "saveAndGoToHome"
    
    
    
	//TO LOGIN
	@Test(priority = 1)
	public void test_Login() throws InterruptedException{
		lgn = new PO_LoginPage(driver);
		hp = lgn.Login(userName, password);
		logger.info("Login Done");
	}
	
	//TO FILL UP PERSONAL DETAILS
	@Test(priority = 2)
	public void test_UsersProfile_PersonalInfo() throws InterruptedException {
		uppi = setUpToAccessPersonalUserProfilePage();
		upad = uppi.personalInfoDetails_ReturnTypeAddressDetails(phoneNumber,dateOfBirth,gender, marri,bio,buttonNextOrGoToHome);	// line 1
		//System.out.println("Return type: "+upad);
	}
	
	//TO FILL UP ADDRESS DETAILS
	@Test(priority = 3)
	public void test_UsersProfile_AddressDetails() throws InterruptedException {		
		upod = upad.fillUsersAddressDetails_ReturnType_OtherDetails(addressLine1,addressLine2,city, state,country,  postalCode,buttonNextOrGoToHome);	// line 1	
		System.out.println("Return type: "+upod);
	}
	
	//TO FILL OTHERS DETAILS
	@Test(priority = 4)
	public void test_UsersProfile_OthresDetails() throws InterruptedException {
		hp = upod.fillOthersDetails(emergencyContactName,emergencyContactNumber,socialSecuritynumber,buttonNextOrGoToHome);	
		System.out.println("Return type: "+hp);
	}
	
	//TO FILL UP BANK DETAILS
	@Test(priority = 5)
	public void test_UsersProfile_BankDetails() throws InterruptedException {
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
		
	@Test(priority = 6)
	public void test_UsersProfile_ResetPassword() throws InterruptedException
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
