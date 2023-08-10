package my_support;

import java.util.List;
import org.openqa.selenium.WebElement;

public class DatePicker {
	
	
	//======================= this is used when month and year are in the grid format==================//
		public static void DatePicker_GenericMethod_WithoutDropDown(WebElement path_dateIcon, WebElement path_YearDateToggelBtn, WebElement selectDateOfBirthMonth ,WebElement iconDateOfBirthNextMonth, WebElement iconDateOfBirthPreviousMonth, List <WebElement> path_dateGrid, List <WebElement> path_yearGrid, String yourDate ) throws InterruptedException
		{
			
			Thread.sleep(1000);
			// my date setting 
			String myDate[] = yourDate.split(" ");
			String year = myDate[2];
			System.out.println("Input year: "+year);
			String month = myDate[1];
			System.out.println("Input month: "+month);
			String date = myDate[0];
			System.out.println("Input date: "+date);
			
			// to click on the date icon , date picker path"path_dateIconSelector"
			path_dateIcon.click();
			System.out.println("Clicked on the date picker icon");
			Thread.sleep(1000);
			
			// to click on the toggel button for year and date selection
			path_YearDateToggelBtn.click();
			System.out.println("Clicked on the toggel button for date and year slection");
			Thread.sleep(1000);
			
			// to match and pick year
			List<WebElement> yearGrid = path_yearGrid;
			//System.out.println(yearGrid);
			boolean flag = false;
			Thread.sleep(1000);
			for(WebElement yearElement : yearGrid)
			{
				String yr = yearElement.getText();
				if(yr.equals(year))
				{	Thread.sleep(1000);
					yearElement.click();
					Thread.sleep(1000);
					flag = true;
					System.out.println("Selected year : "+yr);
					break;
				}
			}
			if(flag == true) {
				System.out.println("Year selected");
			}else {
				System.out.println("Year not selected");
			}
				
				//System.out.println();
				// to match month find already present month "path_currentMonthYear"
				String monthyear = selectDateOfBirthMonth.getText(); 
				Thread.sleep(1000);
				System.out.println(monthyear);
				String arr[] = monthyear.split(" "); // it spit month and year
				String mon  =arr[0];
				System.out.println("Displayed month name: "+mon);
				String monthAarry[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
			
				int displayedMonth =0;int inputmonth=0;
				for(int i= 1; i< monthAarry.length;i++)
				{
					if(mon.equalsIgnoreCase(monthAarry[i])){
						displayedMonth=i;
					}
					if(month.equalsIgnoreCase(monthAarry[i])){
						inputmonth=i;
					}
				}
				while(displayedMonth>inputmonth)
				{
					Thread.sleep(1000);
					iconDateOfBirthPreviousMonth.click();
					displayedMonth = displayedMonth -1;
					Thread.sleep(1000);
				}
				while(displayedMonth<inputmonth)
				{
					Thread.sleep(1000);
					iconDateOfBirthNextMonth.click();
					displayedMonth = displayedMonth +1;
					Thread.sleep(1000);
				}
				if(displayedMonth == inputmonth){
					System.out.println("Month is selected and name is: "+inputmonth);
				} else{
					System.out.println("Month not selected");
				}
				
				
				
			
			// Date picker  "path_date"
			List<WebElement> allDates = path_dateGrid;
			Thread.sleep(1000);
			boolean flag2 = false;
			for(WebElement dateElement : allDates)
			{
				String dt = dateElement.getText();
				if(dt.equals(date))
				{	Thread.sleep(1000);
					dateElement.click();
					flag2 = true;
					Thread.sleep(1000);
					System.out.println("Selected date: "+dt);
					break;
				}
			}
			if(flag2 == true) {
				System.out.println("Date selected");
			}else {
				System.out.println("Date not selected");
			}
			Thread.sleep(1000);
			
		}
	
	
//	//======================= this is used when there is no dropdown for the month and year ==================//
//	public static void DatePicker_GenericMethod_WithoutDropDown(String path_dateIconSelector, String path_currentDateYear ,String path_up_down_arrowBtn , String path_date )
//	{
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver= new ChromeDriver();
//		
//		String year = "2023";
//		String month = "July";
//		String date = "13";
//		
//		driver.findElement(By.xpath(path_dateIconSelector)).click(); // date picker path"path_dateIconSelector"
//		
//		while(true) // this loop decide month and year
//		{
//			// to match month year find already present month year"path_currentDateYear"
//			String monthyear = driver.findElement(By.xpath(path_currentDateYear)).getText(); 
//			
//			String arr[] = monthyear.split(" "); // it spit month and year
//			String mon  =arr[0];
//			String yr = arr[1];
//			
//			if(mon.equalsIgnoreCase(month)&& yr.equalsIgnoreCase(year))
//			{
//				break; // come out from the loop
//			}
//			else
//			{
//				// it will click on the array mark to jump on next month"path_up_down_arrowBtn"
//				driver.findElement(By.xpath(path_up_down_arrowBtn)).click();
//			}
//			
//		}
//		
//		// Date picker  "path_date"
//		List<WebElement> allDates = driver.findElements(By.xpath(path_date));
//		for(WebElement dateElement : allDates)
//		{
//			String dt = dateElement.getText();
//			if(dt.equals(date))
//			{
//				dateElement.click();
//				break;
//			}
//		}
//	}
	
	
	
	
//	//======================= used when drop down present for month and year==================//
//	
//	public static void DatePicker_GenericMethod_WithDropDown()
//	{
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver= new ChromeDriver();
//		
//		// path for date picker "path_DatePicker"
//		driver.findElement(By.xpath("")).click();
//		
//		// use it  if drop come under select tab"path_monthDropDown"
//		Select month_drp = new Select(driver.findElement(By.xpath("")));
//		month_drp.selectByVisibleText("July");
//		
//		// use it  if drop come under select tab"path_yearDropDown"
//		Select year_drp = new Select(driver.findElement(By.xpath("")));
//		year_drp.selectByVisibleText("2023");
//		
//		
//		
//	}
	
	
}
