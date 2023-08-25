package com.hrms.testCases;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pageObject.PO_LoginPage;
import com.hrms.dataBase.DatabaseConnectionAndQuery_GenericMethods;
//DON'T REMOVE THIS BECAUSE WHILE CALLIN DATA FROM THE COFIGURATIONS FILE IT IS REQUIRED 
import com.hrms.dataProviders.from_readDataFromExcelFile.DataProviders; 

//TO TEST THE LOGIN FUNCTIONALITY
public class TC_Login extends BaseClass {
	
	//CONSTRUCTOR
	public TC_Login(){
		super();
	}
	
	//LOIGN CONSTRUCTOR DECLARATION
	public PO_LoginPage lgn;
	
	
	
	//TO LOGIN BY USING DATA PROVIDER METHODS
	//@Test(priority = 1 , dataProvider = fileNameOnly )
	public void test_Login(String userName , String password ) throws InterruptedException
	{
		lgn = new PO_LoginPage(driver);
		lgn.Login(userName, password);
	}
	

	//TO LOGIN BY USING DATA FROM THE BASE CLASS AND IT TAKING FROM THE CONFIGURATIONS FILES
	@Test(priority = 1)
	public void test_Login() throws InterruptedException, SQLException
	{
		lgn = new PO_LoginPage(driver);
		lgn.Login(userName, password);
		
		//For DataBase Testing
		ResultSet resultset = DatabaseConnectionAndQuery_GenericMethods.dataBaseCollectionAndQuerry("select * from public.users");
		while(resultset.next())
		{
			System.out.println(resultset.getString("user_name"));
		}
		
	}
	
	//======START=====DATA READING FORM THE EXCEL FILE======IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME=====//
	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
	public final String fileNameOnly = "TC_Loign";
	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHOD
	public DataProviders dp =  new DataProviders();
	//DATA PROVIDER
	@DataProvider(name = fileNameOnly)
	public String[][] dataProvider() throws IOException {
		String loginData[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly);
		return loginData;
	}
	//======END=====DATA READING FORM THE EXCEL FILE=====IT IS GENERIC METHOD TO USE THIS ONLY PASS THE EXCEL FILE NAME======//
			
	
}