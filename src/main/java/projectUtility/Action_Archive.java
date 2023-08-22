package projectUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Action_Archive {
	
	public static final Logger logger = LogManager.getLogger(Action_Restore.class);
	
	public static void archive(String searchKey, WebElement searchBox, WebElement archivedLabel, WebElement btnAction, WebElement actionArchive, WebElement btnYes, String confirmMessage ) throws InterruptedException
	{
		searchBox.sendKeys(searchKey,Keys.ENTER);
		logger.info("searchKey searched");
    	Thread.sleep(8000);
    	try{
    		if(archivedLabel.isDisplayed()) {
        		logger.info("Already archived");
    		}
    	}catch(Exception e) {
    		if(e.getMessage() != null){
    			logger.info(e.getMessage());
    			
    			btnAction.click();
        		logger.info("Click on the btnAction");
            	Thread.sleep(1000);
            	
            	actionArchive.click();
            	logger.info("Click on the actionArchive");
            	Thread.sleep(1000);
            	
            	btnYes.click();
            	logger.info("Click on the btnYes");
        	    Thread.sleep(100);
    		}
    	}
    	
//   	 String msg = getArchivedMessage();
//   	 try {
//   		 wait.until(ExpectedConditions.invisibilityOf(msgCreated));
//   		 if(msg.contains("Leave Balance Archived Successfully")) {
//	    		 Assert.assertTrue(true);
//	    		 logger.info("Leave balance archived passed...");
//	    	 }else {
//	    		 Assert.assertTrue(false);
//	    		 logger.info("Leave balance archived failed!!!");
//	    	 }
//   	 }catch(Exception e)
//   	 {
//   		 e.getCause();
//   	 }
	}

}
