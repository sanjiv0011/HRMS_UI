package my_support;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker{
	
	
	
	
	//======================= this is used when month and year are in the grid format==================//
		public static void DatePicker_GenericMethod_WithoutDropDown(WebElement path_YearDateToggelBtn, WebElement selectMonth ,WebElement iconNextMonth, WebElement iconPreviousMonth, List <WebElement> path_dateGrid, List <WebElement> path_yearGrid, String yourDate ) throws InterruptedException
		{
			
			// my date setting 
			String myDate[] = yourDate.split(" ");
			String year = myDate[2];
			System.out.println("Input year: "+year);
			String month = myDate[1];
			System.out.println("Input month: "+month);
			String date = myDate[0];
			System.out.println("Input date: "+date);
				
			// to click on the toggel button for year and date selection
			//Thread.sleep(50);
			path_YearDateToggelBtn.click();
			System.out.println("Clicked on the toggel button for date and year slection");
			Thread.sleep(500);
			
			// to match and pick year
			List<WebElement> yearGrid = path_yearGrid;
			//System.out.println(yearGrid);
			boolean flag = false;
			for(WebElement yearElement : yearGrid)
			{
				String yr = yearElement.getText();
				if(yr.equals(year))
				{	Thread.sleep(500);
					yearElement.click();
					Thread.sleep(500);
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
				Thread.sleep(500);
				String monthyear = selectMonth.getText(); 
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
					Thread.sleep(500);
					iconPreviousMonth.click();
					displayedMonth = displayedMonth -1;
				}
				while(displayedMonth<inputmonth)
				{
					Thread.sleep(500);
					iconNextMonth.click();
					displayedMonth = displayedMonth +1;
				}
				if(displayedMonth == inputmonth){
					System.out.println("Month is selected and name is: "+monthAarry[inputmonth]);
				} else{
					System.out.println("Month not selected");
				}
				
				
				
			
			// Date picker  "path_date"
			List<WebElement> allDates = path_dateGrid;
			Thread.sleep(500);
			boolean flag2 = false;
			for(WebElement dateElement : allDates)
			{
				String dt = dateElement.getText();
				if(dt.equals(date))
				{	Thread.sleep(500);
					dateElement.click();
					Thread.sleep(500);
					flag2 = true;
					System.out.println("Selected date: "+dt);
					break;
				}
			}
			if(flag2 == true) {
				System.out.println("Date selected");
			}else {
				System.out.println("Date not selected");
			}
			
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
