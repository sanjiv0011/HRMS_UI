package my_support;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Action_Delete {
	
public static final Logger logger = LogManager.getLogger(Action_Restore.class);
	
	public static void delete(String searchKey, WebElement searchBox, WebElement btnAction,WebElement btnDelete, WebElement btnYes, String confirmMessage ) throws InterruptedException
	{
		searchBox.sendKeys(searchKey,Keys.ENTER);
		logger.info("searchKey searched");
    	Thread.sleep(8000);
    	
    	try{
			logger.info("Try block");
		
			btnAction.click();
    		logger.info("Click on the btnAction");
        	Thread.sleep(1000);
        	
        	btnDelete.click();
        	logger.info("Click on the btnDelete");
        	Thread.sleep(1000);
        	
        	btnYes.click();
        	logger.info("Click on the btnYes");
    	    Thread.sleep(100);

    	}catch(Exception e) {
    		logger.info("Catch block");
    		if(e.getMessage() != null){
    			logger.info(e.getMessage());
    		}
    	}
	}
}
