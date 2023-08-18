package my_support;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;

public class TimePicker {
	
	//VARIABLE AND CONSTRUCTER DECLARATIONS
	public static final Logger logger = LogManager.getLogger(TimePicker.class);
	public static WebDriverWait wait = null;
	static Actions action;

    //ACTION METHODS TO SELECT THE TIME FROM
    public static void selectTime(WebDriver driver, String ValueHours, String ValueMinutes, String AMPM, WebElement path_AM, WebElement path_PM, List <WebElement> path_hours, List <WebElement> path_minutes ) throws InterruptedException
    {  	
    	action = new Actions(driver);
    	wait = new WebDriverWait (driver, Duration.ofSeconds(10));
    	 
    	if (AMPM.equals("AM")) {
    		wait.until(ExpectedConditions.elementToBeClickable(path_AM));
    		Thread.sleep(300);
            action.moveToElement(path_AM).doubleClick().build().perform();
           
            logger.info("Clicked on the AM button: " + path_AM.getText());
        } else if (AMPM.equals("PM")) {
        	wait.until(ExpectedConditions.elementToBeClickable(path_PM));
        	Thread.sleep(300);
            action.moveToElement(path_PM).doubleClick().build().perform();
            
            logger.info("Clicked on the PM button: " + path_PM.getText());
        } else {
            logger.info("Invalid AMPM format");
        }
  
    	//TO SELECT HOURS
    	TimePicker.selectTimeHoursOrMinutes(path_hours,ValueHours);
    	Thread.sleep(2000);
    	
    	//TO SELECT MINUTES
    	TimePicker.selectTimeHoursOrMinutes(path_minutes,ValueMinutes);
    	Thread.sleep(2000);
    	
    }

	//SELECTING DATA FROM THE LIST
    public static void selectTimeHoursOrMinutes(List<WebElement> options, String value) throws InterruptedException
    {	logger.info("Entered inside methods selectTimeHoursOrMinutes");
    	String vr = null;
    	boolean flag = false;
    	
    	try {
			for(WebElement element : options) {	
    			//logger.info(element.getText());
        		if(element.getText().equals(value)) {
        			wait.until(ExpectedConditions.elementToBeClickable(element));
        			Thread.sleep(3000);
        			vr = element.getText();
        			action.moveToElement(element).click().build().perform();
        			Thread.sleep(1000);
        			flag = true;
        			break;
        		}
			}
    	}
    	catch(Exception e) {
    			logger.info("Message from the selectTimeHoursOrMinutes methods: "+e.getCause());
    		}
    
    	if(!flag) {
    		logger.info("Option is not selected: "+vr);
    	}else {
    		logger.info("Option is selected: "+vr);
    	}
    	
    }
}
