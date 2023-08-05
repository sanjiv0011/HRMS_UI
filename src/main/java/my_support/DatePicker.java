package my_support;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {
	
	
	
	//======================= this is used when there is no dropdown for the month and year ==================//
	public static void DatePicker_GenericMethod_WithoutDropDown(String path_dateIconSelector, String path_currentDateYear ,String path_up_down_arrowBtn , String path_date )
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		String year = "2023";
		String month = "July";
		String date = "13";
		
		driver.findElement(By.xpath(path_dateIconSelector)).click(); // date picker path"path_dateIconSelector"
		
		while(true) // this loop decide month and year
		{
			// to match month year find already present month year"path_currentDateYear"
			String monthyear = driver.findElement(By.xpath(path_currentDateYear)).getText(); 
			
			String arr[] = monthyear.split(" "); // it spit month and year
			String mon  =arr[0];
			String yr = arr[1];
			
			if(mon.equalsIgnoreCase(month)&& yr.equalsIgnoreCase(year))
			{
				break; // come out from the loop
			}
			else
			{
				// it will click on the array mark to jump on next month"path_up_down_arrowBtn"
				driver.findElement(By.xpath(path_up_down_arrowBtn)).click();
			}
			
		}
		
		// Date picker  "path_date"
		List<WebElement> allDates = driver.findElements(By.xpath(path_date));
		for(WebElement dateElement : allDates)
		{
			String dt = dateElement.getText();
			if(dt.equals(date))
			{
				dateElement.click();
				break;
			}
		}
	}
	
	
	//======================= used when drop down present for month and year==================//
	
	public static void DatePicker_GenericMethod_WithDropDown()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// path for date picker "path_DatePicker"
		driver.findElement(By.xpath("")).click();
		
		// use it  if drop come under select tab"path_monthDropDown"
		Select month_drp = new Select(driver.findElement(By.xpath("")));
		month_drp.selectByVisibleText("July");
		
		// use it  if drop come under select tab"path_yearDropDown"
		Select year_drp = new Select(driver.findElement(By.xpath("")));
		year_drp.selectByVisibleText("2023");
		
		
		
	}
}
