package com.hrms.dataProviders.from_readDataFromExcelFile;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.hrms.utilities.ReadDataFromExcelFile;



// IT IS USED TO PROVIDE DATA TO THE TEST CASES CLASS	 by using java files "ReadDataFromExcelFile.java"
public class DataProviders {
	
	@DataProvider(name = "Data")
	public String[][] getDataFromExcelFile() throws IOException
	{
		String filePath = "./"+"//ExcelData//Excel_Data_For_Test.xlsx";
		ReadDataFromExcelFile xls = new ReadDataFromExcelFile(filePath);
		
		int rownum = xls.getRowCount("Sheet1");
		int colcount = xls.getCellCount("Sheet1", 1);
		
		String UserData[][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0; j<colcount ;j++)
			{
				UserData[i-1][j] = xls.	getCellData("Sheet1",i,j);
			}
		}
		
		return UserData;
	}

}
