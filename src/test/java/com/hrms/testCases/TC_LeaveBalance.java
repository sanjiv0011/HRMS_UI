package com.hrms.testCases;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.hrms.dataBase.DatabaseConnectionAndQuery_GenericMethods;
import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.hrms.pageObject.PO_AssetsPage;
import com.hrms.pageObject.PO_HomePage;
import com.hrms.pageObject.PO_LeaveBalance;
import com.hrms.pageObject.PO_LoginPage;

public class TC_LeaveBalance extends BaseClass {
	public TC_LeaveBalance() {
		super();
	}
	
	//TO INITIATE FAKER LIBRARY CONSTRUCTER
	public Faker faker = new Faker();
	//TO INITIATE LONGIN CONSTRUCTER
	public PO_LoginPage lgn;
	//TO INITIATE HOME PAGE CONSTRUCTER
	public PO_HomePage hp;
	//TO INITIATE LEAVE BALANCE PAGE CONSTRUCTER
	public PO_LeaveBalance lb;
	
	//INPUT VALUES
	String leaveBalanceStartDate = "01 August 2023";
	String leaveBalanceEndDate = "31 August 2023";
	String leaveTypeName = "Casual Leave";
	String leaveBalance =  "25";
	String leaveTypeNameForSearch = "Casual"; //BEACUSE IT NOT ABLE TO SEARCH TWO WORD KEY
	
		//TO PERFORM THE LOGIN
		@Test(priority = 1)
		public void test_Login() throws InterruptedException{
			lgn = new PO_LoginPage(driver);
			hp = lgn.Login(userName, password);
			Thread.sleep(3000);
		}
		
		//TO CREATE LEAVE BALANCE
		//@Test(priority =2 , dependsOnMethods = {"test_Login"}, dataProvider = fileNameOnly)
		public void test_CreateLeaveBalance(String leaveBalanceStartDate, String leaveBalanceEndDate, String leaveTypeName, String  leaveBalance) throws InterruptedException, SQLException
		{
			lb = callMeBeforePerformAnyAction();

//			String  ui_leaveBalanceStartDate =  leaveBalanceStartDate;
//			String  ui_leaveBalanceEndDate =  leaveBalanceEndDate;
//			String  ui_leaveTypeName =  leaveTypeName;
//			String  ui_leaveBalance = leaveBalance;
		
			hp = lb.createLeaveBalance(leaveBalanceStartDate, leaveBalanceEndDate, leaveTypeName, leaveBalance);

			
//			//For DataBase Testing
//			if(lb.isLeaveBalanceCreatedMessageDisplayed()) {
//				//TO SELECT THE LEAVE TYPES
//				ResultSet resultsetLeaveTypes = DatabaseConnectionAndQuery_GenericMethods.dataBaseCollectionAndQuerry("select id,name from public.leave_types");
//				String leaveTypeId = null;
//				while(resultsetLeaveTypes.next()){
//					System.out.println("Leave types: "+resultsetLeaveTypes.getString("name")+" "+resultsetLeaveTypes.getString("id"));
//					if(ui_leaveTypeName.equals(resultsetLeaveTypes.getString("name"))) {
//						leaveTypeId = resultsetLeaveTypes.getString("id");
//					}
//				}
//				
//				//TO SELECT LEAVE BALANCE BY LEAVE TYPES ID
//				ResultSet resultsetLeaveBalance = DatabaseConnectionAndQuery_GenericMethods.dataBaseCollectionAndQuerry("select * from public.leave_balances ORDER BY updated_at");
//				while(resultsetLeaveBalance.next())
//				{	System.out.println(resultsetLeaveBalance);
//					//System.out.println("Leave balance: "+resultsetLeaveTypes.getString("start_date")+" "+resultsetLeaveTypes.getString("end_date")+" "+resultsetLeaveTypes.getString("balance"));
//					if(leaveTypeId.equals(resultsetLeaveBalance.getString("leave_type_id")))
//					{
//						//DATA FROM THE DATABASE
//						//String db_ogName = resultset.getString("name");
//						String db_leaveBalanceStartDate = resultsetLeaveBalance.getString("start_date");
//						String db_leaveBalanceEndDate = resultsetLeaveBalance.getString("end_date");
//						String db_leaveBalance = resultsetLeaveBalance.getString("balance");
//					
//						//CROSS VERIFICATIONS(IT WILL MATCH USER INPUT DATA WITH DATABASE ENTRY)
//						Assert.assertEquals(ui_leaveBalanceStartDate, db_leaveBalanceStartDate, "To match start_date");
//						Assert.assertEquals(ui_leaveBalanceEndDate, db_leaveBalanceEndDate, "To match end_date");
//						Assert.assertEquals(ui_leaveBalance, db_leaveBalance, "To match balance");
//						break;
//					}
//				}
//			}
		}
		
	
		//@Test(priority = 3, dependsOnMethods = {"test_Login"} )//TO ARCHIVE THE LEAVE BALANCE
		public void test_ArchiveLeaveBalance() throws InterruptedException {
			lb = callMeBeforePerformAnyAction();
			hp = lb.archiveLeaveBalance(leaveTypeNameForSearch);
		}
	
	
	
		//@Test(priority = 4, dependsOnMethods = {"test_Login"} )//TO RESTORE THE LEAVE BALANCE
		public void test_RestoreLeaveBalance() throws InterruptedException {
			lb = callMeBeforePerformAnyAction();
			hp = lb.restoreLeaveBalance(leaveTypeNameForSearch);
		}
		
		@Test(priority = 5 , dependsOnMethods = {"test_Login"} )//TO EDIT THE LEAVE BALANCE
		public void test_EditLeaveBalance() throws InterruptedException {
			lb = callMeBeforePerformAnyAction();
			hp = lb.editLeaveBalance(leaveBalanceStartDate, leaveBalanceEndDate, leaveTypeNameForSearch, leaveBalance);
		}
		
		//TO LOGOUT
		@Test(priority = 10, dependsOnMethods = {"test_Login"})
		public void test_Logout() throws InterruptedException {
			hp.Logout();
		}
		
		//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
		public PO_LeaveBalance callMeBeforePerformAnyAction() throws InterruptedException {
			//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE
			hp.clickOniconHomeImage();
			Thread.sleep(3000);
			//TO ACCESS ASSETS TAB
			hp.clickOntabLeaveBalances();
			Thread.sleep(2000);
			//TO ACCESS LEAVE BALANCE PAGE OBJECTS
			return new PO_LeaveBalance(driver);
		}

		
		//=========DATA PROVIDER CONCEPT========WHILE USING THIS PROVIDES THE EXCEL FIEL VARIABLE AS AN AGRUMENT IN THE TEST_METHODS======//
	  	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
	  	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
	  	public final String fileNameOnly = "TC_LeaveBalance";
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
