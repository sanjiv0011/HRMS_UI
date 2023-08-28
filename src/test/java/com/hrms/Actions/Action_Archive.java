package com.hrms.Actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

public class Action_Archive {
	
	public static final Logger logger = LogManager.getLogger(Action_Archive.class);
	public ReUseAbleElement ruae;
	
	public void archive(String searchKey,WebDriver driver, String message) throws InterruptedException
	{
		ruae = new ReUseAbleElement(driver);
		ruae.searchBox_RU(searchKey);
    	if(!ruae.isSearchKeysNotFound_RU()){
    		if(!ruae.isAlreadyArchivedDisplayed_RU()) {
    			ruae.clickOnActionButton_RU();
    			ruae.clickOnArchiveAction_RU();
    			ruae.clickOnYesButton_RU();
    	    	//CHECK THE ARCHIVED CONFIRMATIONS MESSAGES
    	    	String alretMsg = ruae.snakeAlertMessagesDisplayedContent_RU();
    	    	if(alretMsg.equals(message)) {
    	    		Assert.assertEquals(message, alretMsg,"ARCHIVED successfully");
    	    		logger.info("===>>> "+message);
    	    	}else {
    	    		logger.info("Alert message content: "+alretMsg);
    	    	}
    		}
    	}
	}
	
}
