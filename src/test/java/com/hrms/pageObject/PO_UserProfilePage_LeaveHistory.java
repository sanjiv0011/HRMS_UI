package com.hrms.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PO_UserProfilePage_LeaveHistory {

	public WebDriver driver = null;
	
	public PO_UserProfilePage_LeaveHistory(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
}
