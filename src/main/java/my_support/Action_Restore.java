package my_support;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class Action_Restore {
	
	public static final Logger logger = LogManager.getLogger(Action_Restore.class);

	public static void restore(String searchKey, WebElement searchBox, WebElement archivedLabel,  WebElement btnAction, WebElement actionRestore, WebElement btnYes, String confirmMessage) throws InterruptedException {
		searchBox.sendKeys(searchKey, Keys.ENTER);
		logger.info("searchKey searched");
    	Thread.sleep(8000);
    	try {
    		if(archivedLabel.isDisplayed()) {
    			logger.info(archivedLabel.isDisplayed());
    			btnAction.click();
        		logger.info("Click on the btnAction");
            	Thread.sleep(2000);
            	
            	logger.info("Before actionRestore.click line");
            	actionRestore.click();
            	logger.info("Click on the actionRestore");
            	Thread.sleep(1000);
            	
            	btnYes.click();
            	logger.info("Click on the btnYes");
            	Thread.sleep(200);
    		}
    			
    	} catch(Exception e) {
    			if(e.getMessage() != null){
    				logger.info("Already Restored");
    			}
    	}
	}
}
