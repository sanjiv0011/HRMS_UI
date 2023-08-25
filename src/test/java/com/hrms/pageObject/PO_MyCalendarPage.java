package com.hrms.pageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;
import com.hrms.projectUtility.MyCalendarPicker;

public class PO_MyCalendarPage extends ReUseAbleElement{
	
	//CONSTRUCTOR AND OTHRE VARIABLE DECLARATIOIN
	public WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public Logger logger = LogManager.getLogger(getClass());
	public WebDriverWait wait;
	public Actions action;
	public PO_HomePage hp;

	//APPLY PAGE FACTORY CONCEPT THRUGH INHERITANCE(RE USE ABLE ELEMENT CLASS)
	public PO_MyCalendarPage(WebDriver driver){	
		super(driver);
		this.driver = driver;
		jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		action = new Actions(driver);
		hp = new PO_HomePage(driver);
	}
	
	//=====START====MY CALLENDAR PAGE OBJECTS============//
	//MONTH ADDRESS
	@FindBy(xpath = "//button[normalize-space()='Month']")
	@CacheLookup
	public WebElement btnMonth;
	
	//WEEK ADDRESS
	@FindBy(xpath = "//button[normalize-space()='Week']")
	@CacheLookup
	public WebElement btnWeek;
	
	//DAY ADDRESS
	@FindBy(xpath = "//button[normalize-space()='Day']")
	@CacheLookup
	public WebElement btnDay;
	
	//TODAY ADDRESS
	@FindBy(xpath = "//button[normalize-space()='Today']")
	@CacheLookup
	public WebElement btnToday;
	
	//BACK ADDRESS
	@FindBy(xpath = "//button[normalize-space()='Back']")
	@CacheLookup
	public WebElement btnMonthBack;
	
	//NEXT ADDRESS
	@FindBy(xpath = "//button[normalize-space()='Next']")
	@CacheLookup
	public WebElement btnMonthNext;
	
	//MONTH YEAR TEXT ADDRESS
	@FindBy(xpath = "//span[@class='rbc-toolbar-label']")
	@CacheLookup
	public WebElement elementTextCurrentMonthYearDisplayed;
	
	//CALENDAR DATE LIST ADDRESS
	@FindBy(xpath = "//div[@class='rbc-date-cell']//button")
	@CacheLookup
	public List <WebElement> path_listCallendarDate;
	
	//CALENDAR DATE CONTENT ADDRESS
	@FindBy(xpath = "//div[@class='rbc-event-content']")
	@CacheLookup
	public List <WebElement> path_listContentDate;
	
	//SHOW MORE(PLUS) BUTTON  ADDRESS
	@FindBy(xpath = "//button[contains(@class,'rbc-button-link rbc-show-more')]")
	@CacheLookup
	public WebElement path_btnShowMorePlusSign;
	
	//SHOW MORE(PLUS) CONTENT LIST  ADDRESS
	@FindBy(xpath = "//div[@class='rbc-overlay']//div//div")
	@CacheLookup
	public List <WebElement> path_listShowMoreContent;
	
	//CURRENT DAY MONTH DATE ADDRESS
	@FindBy(xpath = "//span[@class='rbc-toolbar-label']")
	@CacheLookup
	public WebElement elementDisplayedDayMonthDate;
	
	
	//=====END====MY CALENDAR PAGE OBJECTS============//
	
	
	//=====START====MY CALENDAR PAGE OBJECTS ACTIONS METHODS============//
	//CLICK ON MONTH BUTTON
    public void clickOnBtnMonth() throws InterruptedException {
        btnMonth.click();
        logger.info("Clicked on Month button");
        Thread.sleep(1000);
        jsExecutor.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(1000);
        jsExecutor.executeScript("window.scrollBy(0, -300);");
        Thread.sleep(1000);
    }
    
    //CLICK ON WEEK BUTTON
    public void clickOnBtnWeek() throws InterruptedException {
        btnWeek.click();
        jsExecutor.executeScript("window.scrollBy(0, 300);");
        logger.info("Clicked on Week button");
        Thread.sleep(1000);
        jsExecutor.executeScript("window.scrollBy(0, -300);");
        Thread.sleep(1000);
    }
    
    //CLICK ON DAYS BUTTON
    public void clickOnBtnDay() throws InterruptedException {
        btnDay.click();
        Thread.sleep(1000);
        logger.info("Clicked on Days button");
        jsExecutor.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(1000);
        jsExecutor.executeScript("window.scrollBy(0, -300);");
        Thread.sleep(1000);
    }
    
    //CLICK ON TODAY BUTTON
    public void clickOnBtnToday() throws InterruptedException {
        btnToday.click();
        Thread.sleep(1000);
        logger.info("Clicked on Todays button");
        jsExecutor.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(1000);
        jsExecutor.executeScript("window.scrollBy(0, -300);");
        Thread.sleep(1000);
    }

    
    //CLICK ON BACK  BUTTON
    public void clickOnBtnMonthBack() throws InterruptedException {
        btnMonthBack.click();
        Thread.sleep(1000);
        logger.info("Clicked on back Month button");
        jsExecutor.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(1000);
        jsExecutor.executeScript("window.scrollBy(0, -300);");
        Thread.sleep(1000);
    }

    
   //CLICK ON NEXT BUTTON
    public void clickOnBtnMonthNext() throws InterruptedException {
        btnMonthNext.click();
        Thread.sleep(1000);
        logger.info("Clicked on next Month button");
        jsExecutor.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(1000);
        jsExecutor.executeScript("window.scrollBy(0, -300);");
        Thread.sleep(1000);
    }
    
    //CLICK ON SHOW MORE PLUS BUTTON
    public void clickOnBtnShowMorePlusSign() throws InterruptedException {
    	path_btnShowMorePlusSign.click();
        logger.info("Clicked on the show more plus button");
        Thread.sleep(1000);
    }
    
    //TO VIEW AND CLICK ON SHOW MORE CONTENT UNDER SHOW MORE BUTTON
    public void clickOnShowMoreContentAndView(String dateContent) throws InterruptedException {
    	hp.clickOntabMyCalendar();
    	clickOnBtnShowMorePlusSign();
    	for(WebElement ele : path_listShowMoreContent) {
    		if(ele.getText().equals(dateContent))
    		{	Thread.sleep(1000);
    			action.moveToElement(ele).click().build().perform();
    			logger.info("Clicked on the show more content");
    			Thread.sleep(1000);
    			driver.navigate().refresh();
    			Thread.sleep(3000);
    			break;
    		}
    	}
    	
    }
  //=====END====MY CALENDAR PAGE OBJECTS ACTIONS METHODS============//
    
    
    //CLICK ON AND VIEW MY CALENDAR ELEMENT FROMT THE MONTH TAB
    public PO_HomePage clickAndViewMyCalendarElementMonthView(WebDriver driver,String dateValue,String dateContent) throws InterruptedException
    {	logger.info("Entered inside clickAndViewMyCalendarElement method");
    	clickOnBtnMonth();
    	clickOnBtnMonthBack();
    	clickOnBtnMonthNext();
    	clickOnBtnWeek();
    	clickOnBtnMonthBack();
    	clickOnBtnMonthNext();
    	clickOnBtnDay();
    	clickOnBtnMonthBack();
    	clickOnBtnMonthNext();
    	clickOnBtnToday();
    	clickOnBtnMonthBack();
    	clickOnBtnMonthNext();
    	clickOnBtnMonth();
    	//TO MOVE CORRECT DATE AND CLICK ON THE CORRECT CONTENT(DAILY UPDATES) WITHOUT EXPANDING SHOW MORE PLUS BUTTON
    	MyCalendarPicker.moveToCorrectDateInCalendarAndClickOnContentMonthView(driver, dateValue,dateContent, path_listCallendarDate, path_listContentDate,path_btnShowMorePlusSign, path_listShowMoreContent);
    	//TO CHECK HIDES CONTENT FIRST CLICK ON THE SHOW MORE PLUS BUTTON
    	logger.info("Return back from the MyCalendar Picker");
    	driver.navigate().refresh();
    	logger.info("Page refreshed");
    	Thread.sleep(3000);
    	clickOnShowMoreContentAndView(dateContent);
    	return new PO_HomePage(driver);
    }
    
    //CLICK AND VIEW ELEMENT FROMT DAY TAB
    public PO_HomePage clickAndViewMyCalendarElementDayView(WebDriver driver,String dateValue,String dateContent) throws InterruptedException
    {	logger.info("Entered inside clickAndViewMyCalendarElementDayView method");
    	clickOnBtnDay();
    	
    	//TO MOVE CORRECT DATE AND CLICK ON THE CORRECT CONTENT(DAILY UPDATES) WITHOUT EXPANDING SHOW MORE PLUS BUTTON
    	MyCalendarPicker.moveToCorrectDateInCalendarAndClickOnContentMonthView(driver, dateValue,dateContent, path_listCallendarDate, path_listContentDate,path_btnShowMorePlusSign, path_listShowMoreContent);
    	//TO CHECK HIDES CONTENT FIRST CLICK ON THE SHOW MORE PLUS BUTTON
    	logger.info("Return back from the MyCalendar Picker");
    	
    	return new PO_HomePage(driver);
    }


}
