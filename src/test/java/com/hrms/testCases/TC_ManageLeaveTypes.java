package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_ClientPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_JobTitles;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_ManageLeaveTypes;
import com.hrms.pageObject.PO_OragnizationPage;

public class TC_ManageLeaveTypes extends BaseClass {
	public TC_ManageLeaveTypes() {
		super();
	}
	
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_ManageLeaveTypes mlt;
	
	String leaveTypeName = faker.name().firstName();
	String leaveTypeDescription = faker.company().profession();
	
	@Test(priority =1)
	public void test_CreateCleint() throws InterruptedException
	{
		//to perform login 
		lgn = new PO_LoginPage(driver);
		hp = lgn.login(userName, password);
		
		// to access manage leave types tab
		hp.clickOntabManageLeaveTypes();
		
		//to access manage leave type page
		mlt = new PO_ManageLeaveTypes(driver);
		
		// to create new organization
		hp = mlt.createLeaveType(leaveTypeName, leaveTypeDescription);
		logger.info("JobTitle created");
		
		// to logout
		hp.Logout();
		
		
	}


}
