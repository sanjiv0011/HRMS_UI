package com.hrms.Alerts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Alert_ManageLeaveTypes {

	public  Logger logger = LogManager.getLogger(getClass());
	public  WebDriver driver;
	public  JavascriptExecutor jsExecutor;
	public  WebDriverWait wait;
	public  Actions action;
	
	//ALERT MANAGE LEAVE TYPES MESSAGES
	String alertRestored_lt = "Leave Type Activated Successfully.";
	String alertArchived_lt = "Leave Type Deactivated Successfully.";
	String alertCreated_lt = "Leave Type Created Successfully.";
	String alertUpdated_lt = "Leave Type Updated Successfully.";
	String alertAleradyExist_lt = "Leave Type already exists.";

}
