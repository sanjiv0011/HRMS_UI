package com.hrms.readExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// It is used to read data from the excel files
public class ReadDataFromExcelFile {

	public String filePath;// = "./"+"//ExcelData//Excel_Data_For_Test.xlsx";
	
	public ReadDataFromExcelFile(String filePath)
	{
		this.filePath = filePath;
	}
	
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	
	
	public int getRowCount(String sheetName) throws IOException
	{
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException
	{
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		
		int cellCount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;
	}
	
	
	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException
	{
		File src = new File(filePath);
		
		if(!src.exists())
		{
			workbook = new XSSFWorkbook();
			fos = new FileOutputStream(filePath);
			workbook.write(fos);
		}
		
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		
		if(workbook.getSheetIndex(sheetName)== -1)// if sheet not exists then create new sheet
		{
			workbook.createSheet(sheetName);
		}
		
		sheet = workbook.getSheet(sheetName);
		
		if(sheet.getRow(rownum)== null) // if row not exists then create new row
		{
			sheet.createRow(rownum);
		}
		
		row = sheet.getRow(rownum);
		
		cell = row.createCell(colnum);
		
		cell.setCellValue(data);
		
		fos = new FileOutputStream(filePath);
		
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
	

	public String getCellData(String sheetName, int rownum, int colnum) throws IOException
	{
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		
		try {
			data  = formatter.formatCellValue(cell);
			//return the formatted value of the cell as string regardless of its types
		}
		catch(Exception e)
		{
			data = "";
			System.out.println(e.getCause());
		}
		workbook.close();
		fis.close();
		return data;
				
		
	}
	

	
}


