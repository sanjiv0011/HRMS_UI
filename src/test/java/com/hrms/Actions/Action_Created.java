package com.hrms.Actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;
import com.hrms.pageObject.PO_ManageLeaveTypes;


public class Action_Created {
	
	public static final Logger logger = LogManager.getLogger(Action_Created.class);
	public ReUseAbleElement ruae;

	public void created(WebDriver driver, String messageCreated, String messageAlreadyExist) throws InterruptedException
	{
		ruae = new ReUseAbleElement(driver);
		
		//CHECK THE CREATE CONFIRMATIONS MESSAGES
    	if(!ruae.isRequiredMessageDisplayed_RU()){
    		String alretMsg = ruae.snakeAlertMessagesDisplayedContent_RU();
    		if(alretMsg.equals(messageCreated)) {
        		Assert.assertEquals(alretMsg, messageCreated, "CREATED successfully");
        		logger.info("==> "+messageCreated);
        	}else if(alretMsg.equals(messageAlreadyExist)){
        		Assert.assertEquals(alretMsg,messageAlreadyExist,"Already Exist");
        		logger.info("===>>> "+messageAlreadyExist);
        		ruae.clickOnCancelButton_RU();
        	}else if(alretMsg.contains("error")){
        		Assert.assertTrue(alretMsg.contains("error"),"Error");
        		logger.info("===>>> "+"Error");
        		ruae.clickOnCancelButton_RU();
        	}else {
        		logger.info("Alert message content: "+alretMsg);
        	}
    	}else {
    		ruae.clickOnCancelButton_RU();
    	}
	}
	
}
