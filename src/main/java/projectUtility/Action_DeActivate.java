package projectUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Action_DeActivate {
	
	public static final Logger logger = LogManager.getLogger(Action_Restore.class);
	
	public static void deactivate(String searchKey, WebElement searchBox, WebElement label, WebElement btnAction, WebElement actionDeactivate, WebElement btnYes, String confirmMessage ) throws InterruptedException
	{
		searchBox.sendKeys(searchKey,Keys.ENTER);
		logger.info("searchKey searched");
    	Thread.sleep(8000);
    	
    	try{
    		logger.info("Try block");
    		if(label.getText().equals("ACTIVE")) {
    			btnAction.click();
        		logger.info("Click on the btnAction");
            	Thread.sleep(1000);
            	
            	actionDeactivate.click();
            	logger.info("Click on the actionDeactivate");
            	Thread.sleep(1000);
            	
            	btnYes.click();
            	logger.info("Click on the btnYes");
        	    Thread.sleep(100);
    		}
    	}catch(Exception e) {
    		logger.info("Catch block");
    		if(e.getMessage() != null){
    			logger.info(e.getMessage());
    			logger.info("Already Deactivated");
    		}
    	}
	}

}
