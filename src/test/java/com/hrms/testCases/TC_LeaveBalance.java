package com.hrms.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.pageObject.PO_ClientPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_JobTitles;
import com.hrms.pageObject.PO_LeaveBalance;
import com.hrms.pageObject.PO_LoginPage;
import com.hrms.pageObject.PO_ManageLeaveTypes;
import com.hrms.pageObject.PO_OragnizationPage;

public class TC_LeaveBalance extends BaseClass {
	public TC_LeaveBalance() {
		super();
	}
	
	public Faker faker = new Faker();
	public PO_LoginPage lgn;
	public PO_HomePage hp;
	public PO_LeaveBalance lb;
	
	String startDate = "25/08/2023";
	String endDate = "25/08/2023";
	String leaveName = "First Half Leave";
	String leaveBalance =  "123456";
	
	@Test(priority =1)
	public void test_CreateCleint() throws InterruptedException
	{
		//to perform login 
		lgn = new PO_LoginPage(driver);
		hp = lgn.login(userName, password);
		
		// to access manage leave types tab
		hp.clickOntabLeaveBalances();
		
		//to access manage leave type page
		lb = new PO_LeaveBalance(driver);
		
		// to create new organization
		hp = lb.createLeaveBalance(startDate, endDate, leaveName, leaveBalance);
		logger.info("Leave Balance created");
		
		// to logout
		hp.Logout();
		
		
	}


}
