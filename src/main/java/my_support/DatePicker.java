package my_support;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker{
	
	public static final Logger logger = LogManager.getLogger(DatePicker.class);
	
	//======================= this is used when month and year are in the grid format==================//
	public static void DatePicker_GenericMethod_WithoutDropDown(WebElement path_YearDateToggelBtn, WebElement selectMonth ,WebElement iconNextMonth, WebElement iconPreviousMonth, List <WebElement> path_dateGrid, List <WebElement> path_yearGrid, String yourDate ) throws InterruptedException
	{	logger.info("Enter inside date picker methods");
			
	    // my date setting
        String myDate[] = yourDate.split(" ");
        String year = myDate[2];
        logger.info("Input year: " + year);
        String month = myDate[1];
        logger.info("Input month: " + month);
        String date = myDate[0];
        logger.info("Input date: " + date);

        // to click on the toggle button for year and date selection
        Thread.sleep(1000);
        path_YearDateToggelBtn.click();
        logger.info("Clicked on the toggle button for date and year selection");
        Thread.sleep(500);

        // to match and pick year
        List<WebElement> yearGrid = path_yearGrid;
        boolean flag = false;
        for (WebElement yearElement : yearGrid) {
            String yr = yearElement.getText();
            if (yr.equals(year)) {
                Thread.sleep(500);
                yearElement.click();
                Thread.sleep(500);
                flag = true;
                logger.info("Selected year: " + yr);
                break;
            }
        }
        if (flag == true) {
            logger.info("Year selected");
        } else {
            logger.info("Year not selected");
        }

        // to match month find already present month "path_currentMonthYearDisplayed"
        Thread.sleep(500);
        String monthyear = selectMonth.getText();
        logger.info(monthyear);
        String arr[] = monthyear.split(" ");
        String mon = arr[0];
        logger.info("Displayed month name: " + mon);
        String monthArray[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        int displayedMonth = 0;
        int inputMonth = 0;
        for (int i = 1; i < monthArray.length; i++) {
            if (mon.equalsIgnoreCase(monthArray[i])) {
                displayedMonth = i;
            }
            if (month.equalsIgnoreCase(monthArray[i])) {
                inputMonth = i;
            }
        }
        while (displayedMonth > inputMonth) {
            Thread.sleep(500);
            iconPreviousMonth.click();
            displayedMonth = displayedMonth - 1;
        }
        while (displayedMonth < inputMonth) {
            Thread.sleep(500);
            iconNextMonth.click();
            displayedMonth = displayedMonth + 1;
        }
        if (displayedMonth == inputMonth) {
            logger.info("Month is selected and name is: " + monthArray[inputMonth]);
        } else {
            logger.info("Month not selected");
        }

        // Date picker "path_date"
        List<WebElement> allDates = path_dateGrid;
        Thread.sleep(500);
        boolean flag2 = false;
        for (WebElement dateElement : allDates) {
            String dt = dateElement.getText();
            if (dt.equals(date)) {
                Thread.sleep(500);
                dateElement.click();
                Thread.sleep(500);
                flag2 = true;
                logger.info("Selected date: " + dt);
                break;
            }
        }
        if (flag2 == true) {
            logger.info("Date selected");
        } else {
            logger.info("Date not selected");
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
