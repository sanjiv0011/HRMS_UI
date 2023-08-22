package com.hrms.pageObject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;

public class PO_UserPermissions extends ReUseAbleElement{
	
	 // Constructor to initialize the page and its elements
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;


    public PO_UserPermissions(WebDriver driver) {
        super(driver);
        this.driver = driver;
        jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
    }
    
  //=========START==========CHECK BOX FOR THE PERMISSION PAGE OBJECTS========//
    
		//assetAdminCheckbox 
	 	@FindBy(xpath = "//span[normalize-space()='Asset Admin']")
	    @CacheLookup
	    public WebElement assetAdminCheckbox;
	 	public void clickOnAssetAdminCheckbox() throws InterruptedException{
	 		assetAdminCheckbox.click();
	 		logger.info("Clicked on the: assetAdminCheckbox");
	 		Thread.sleep(500);
	 	}

	 	//assetCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Asset Create']")
	    @CacheLookup
	    public WebElement assetCreateCheckbox;
	    public void clickOnassetCreateCheckbox() throws InterruptedException{
	    	assetCreateCheckbox.click();
	 		logger.info("Clicked on the: assetCreateCheckbox");
	 		Thread.sleep(500);
	 	}
	    
	    //assetEditCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Asset Edit']")
	    @CacheLookup
	    public WebElement assetEditCheckbox;
	    public void clickOnassetEditCheckbox() throws InterruptedException{
	    	assetEditCheckbox.click();
	 		logger.info("Clicked on the: assetEditCheckbox ");
	 		Thread.sleep(500);
	 	}

	    //assetReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Asset Read']")
	    @CacheLookup
	    public WebElement assetReadCheckbox;
	    public void clickOnassetReadCheckbox() throws InterruptedException{
	    	assetReadCheckbox.click();
	 		logger.info("Clicked on the: assetReadCheckbox");
	 		Thread.sleep(500);
	 	}
	    
	    //assetTypeAdminCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Asset Type Admin']")
	    @CacheLookup
	    public WebElement assetTypeAdminCheckbox;
	    public void clickOnAssetTypeAdminCheckbox() throws InterruptedException{
	    	assetTypeAdminCheckbox.click();
	 		logger.info("Clicked on the: assetTypeAdminCheckbox");
	 		Thread.sleep(500);
	 	}

	    //assetTypeCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Asset Type Create']")
	    @CacheLookup
	    public WebElement assetTypeCreateCheckbox;
	    public void clickOnassetTypeCreateCheckbox() throws InterruptedException{
	    	assetTypeCreateCheckbox.click();
	 		logger.info("Clicked on the: assetTypeCreateCheckbox ");
	 		Thread.sleep(500);
	 	}

	    //assetTypeEditCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Asset Type Edit']")
	    @CacheLookup
	    public WebElement assetTypeEditCheckbox;
	    public void clickOnassetTypeEditCheckbox() throws InterruptedException{
	    	assetTypeEditCheckbox.click();
	 		logger.info("Clicked on the: assetTypeEditCheckbox ");
	 		Thread.sleep(500);
	 	}

	    //assetTypeReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Asset Type Read']")
	    @CacheLookup
	    public WebElement assetTypeReadCheckbox;
	    public void clickOnassetTypeReadCheckbox() throws InterruptedException{
	    	assetTypeReadCheckbox.click();
	 		logger.info("Clicked on the: assetTypeReadCheckbox" );
	 		Thread.sleep(500);
	 	}
	    
	    //clientsAdminCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Clients Admin']")
	    @CacheLookup
	    public WebElement clientsAdminCheckbox;
	    public void clickOnClientsAdminCheckbox() throws InterruptedException{
	    	clientsAdminCheckbox.click();
	 		logger.info("Clicked on the: clientsAdminCheckbox");
	 		Thread.sleep(500);
	 	}

	    //clientsCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Clients Create']")
	    @CacheLookup
	    public WebElement clientsCreateCheckbox;
	    public void clickOnclientsCreateCheckbox() throws InterruptedException{
	    	clientsCreateCheckbox.click();
	 		logger.info("Clicked on the: clientsCreateCheckbox");
	 		Thread.sleep(500);
	 	}
	    
	    //clientsEditCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Clients Edit']")
	    @CacheLookup
	    public WebElement clientsEditCheckbox;
	    public void clickOnclientsEditCheckbox() throws InterruptedException{
	    	clientsEditCheckbox.click();
	 		logger.info("Clicked on the: clientsEditCheckbox");
	 		Thread.sleep(500);
	 	}

	    //clientsReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Clients Read']")
	    @CacheLookup
	    public WebElement clientsReadCheckbox;
	    public void clickOnClientsReadCheckbox() throws InterruptedException{
	    	clientsReadCheckbox.click();
	 		logger.info("Clicked on the: clientsReadCheckbox");
	 		Thread.sleep(500);
	 	}
	    
	    //dailyUpdateCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Daily Update Create']")
	    @CacheLookup
	    public WebElement dailyUpdateCreateCheckbox;
	    public void clickOnDailyUpdateCreateCheckbox() throws InterruptedException{
	    	dailyUpdateCreateCheckbox.click();
	 		logger.info("Clicked on the: dailyUpdateCreateCheckbox");
	 		Thread.sleep(500);
	 	}

	    
	    //dailyUpdateReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Daily Update Read']")
	    @CacheLookup
	    public WebElement dailyUpdateReadCheckbox;
	    public void clickOndailyUpdateReadCheckbox() throws InterruptedException{
	    	dailyUpdateReadCheckbox.click();
	 		logger.info("Clicked on the: dailyUpdateReadCheckbox");
	 		Thread.sleep(500);
	 	}

	    
	    //jobTitleAdminCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Job Title Admin']")
	    @CacheLookup
	    public WebElement jobTitleAdminCheckbox;
	    public void clickOnJobTitleAdminCheckbox() throws InterruptedException{
	    	jobTitleAdminCheckbox.click();
	 		logger.info("Clicked on the: jobTitleAdminCheckbox");
	 		Thread.sleep(500);
	 	}

	    //jobTitleCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Job Title Create']")
	    @CacheLookup
	    public WebElement jobTitleCreateCheckbox;
	    public void clickOnjobTitleCreateCheckbox() throws InterruptedException{
	    	jobTitleCreateCheckbox.click();
	 		logger.info("Clicked on the: jobTitleCreateCheckbox");
	 		Thread.sleep(500);
	 	}

	    
	    //jobTitleEditCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Job Title Edit']")
	    @CacheLookup
	    public WebElement jobTitleEditCheckbox;
	    public void clickOnjobTitleEditCheckbox() throws InterruptedException{
	    	jobTitleEditCheckbox.click();
	 		logger.info("Clicked on the: jobTitleEditCheckbox");
	 		Thread.sleep(500);
	 	}

	    //jobTitleReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Job Title Read']")
	    @CacheLookup
	    public WebElement jobTitleReadCheckbox;
	    public void clickOnjobTitleReadCheckbox() throws InterruptedException{
	    	jobTitleReadCheckbox.click();
	 		logger.info("Clicked on the: jobTitleReadCheckbox ");
	 		Thread.sleep(500);
	 	}
	    
	    //leaveBalanceAdminCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Leave Balance Admin']")
	    @CacheLookup
	    public WebElement leaveBalanceAdminCheckbox;
	    public void clickOnLeaveBalanceAdminCheckbox() throws InterruptedException{
	    	leaveBalanceAdminCheckbox.click();
	 		logger.info("Clicked on the: leaveBalanceAdminCheckbox");
	 		Thread.sleep(500);
	 	}

	    //leaveBalanceCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Leave Balance Create']")
	    @CacheLookup
	    public WebElement leaveBalanceCreateCheckbox;
	    public void clickOnleaveBalanceCreateCheckbox() throws InterruptedException{
	    	leaveBalanceCreateCheckbox.click();
	 		logger.info("Clicked on the: leaveBalanceCreateCheckbox");
	 		Thread.sleep(500);
	 	}

	    //leaveBalanceEditCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Leave Balance Edit']")
	    @CacheLookup
	    public WebElement leaveBalanceEditCheckbox;
	    public void clickOnleaveBalanceEditCheckbox() throws InterruptedException{
	    	leaveBalanceEditCheckbox.click();
	 		logger.info("Clicked on the: leaveBalanceEditCheckbox");
	 		Thread.sleep(500);
	 	}

	    //leaveBalanceReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Leave Balance Read']")
	    @CacheLookup
	    public WebElement leaveBalanceReadCheckbox;
	    public void clickOnleaveBalanceReadCheckbox() throws InterruptedException{
	    	leaveBalanceReadCheckbox.click();
	 		logger.info("Clicked on the: leaveBalanceReadCheckbox ");
	 		Thread.sleep(500);
	 	}

	    
	    //leaveRequestAdminCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Leave Request Admin']")
	    @CacheLookup
	    public WebElement leaveRequestAdminCheckbox;
	    public void clickOnLeaveRequestAdminCheckbox() throws InterruptedException{
	    	leaveRequestAdminCheckbox.click();
	 		logger.info("Clicked on the: leaveRequestAdminCheckbox");
	 		Thread.sleep(500);
	 	}

	    //leaveRequestCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Leave Request Create']")
	    @CacheLookup
	    public WebElement leaveRequestCreateCheckbox;
	    public void clickOnleaveRequestCreateCheckbox() throws InterruptedException{
	    	leaveRequestCreateCheckbox.click();
	 		logger.info("Clicked on the: leaveRequestCreateCheckbox");
	 		Thread.sleep(500);
	 	}

	    //leaveRequestEditCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Leave Request Edit']")
	    @CacheLookup
	    public WebElement leaveRequestEditCheckbox;
	    public void clickOnleaveRequestEditCheckbox() throws InterruptedException{
	    	leaveRequestEditCheckbox.click();
	 		logger.info("Clicked on the: leaveRequestEditCheckbox");
	 		Thread.sleep(500);
	 	}

	    //leaveRequestReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Leave Request Read']")
	    @CacheLookup
	    public WebElement leaveRequestReadCheckbox;
	    public void clickOnleaveRequestReadCheckbox() throws InterruptedException{
	    	leaveRequestReadCheckbox.click();
	 		logger.info("Clicked on the: leaveRequestReadCheckbox");
	 		Thread.sleep(500);
	 	}

	    //leaveTypeAdminCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Leave Type Admin']")
	    @CacheLookup
	    public WebElement leaveTypeAdminCheckbox;
	    public void clickOnLeaveTypeAdminCheckbox() throws InterruptedException{
	    	leaveTypeAdminCheckbox.click();
	 		logger.info("Clicked on the: leaveTypeAdminCheckbox");
	 		Thread.sleep(500);
	 	}

	    //leaveTypeCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Leave Type Create']")
	    @CacheLookup
	    public WebElement leaveTypeCreateCheckbox;
	    public void clickOnleaveTypeCreateCheckbox() throws InterruptedException{
	    	leaveTypeCreateCheckbox.click();
	 		logger.info("Clicked on the: leaveTypeCreateCheckbox");
	 		Thread.sleep(500);
	 	}

	    //leaveTypeEditCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Leave Type Edit']")
	    @CacheLookup
	    public WebElement leaveTypeEditCheckbox;
	    public void clickOnleaveTypeEditCheckbox() throws InterruptedException{
	    	leaveTypeEditCheckbox.click();
	 		logger.info("Clicked on the: leaveTypeEditCheckbox");
	 		Thread.sleep(500);
	 	}

	    //leaveTypeReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Leave Type Read']")
	    @CacheLookup
	    public WebElement leaveTypeReadCheckbox;
	    public void clickOnleaveTypeReadCheckbox() throws InterruptedException{
	    	leaveTypeReadCheckbox.click();
	 		logger.info("Clicked on the: leaveTypeReadCheckbox ");
	 		Thread.sleep(500);
	 	}

	   
	    //organizationsAdminCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Organizations Admin']")
	    @CacheLookup
	    public WebElement organizationsAdminCheckbox;
	    public void clickOnOrganizationsAdminCheckbox() throws InterruptedException{
	    	organizationsAdminCheckbox.click();
	 		logger.info("Clicked on the: organizationsAdminCheckbox");
	 		Thread.sleep(500);
	 	}

	    //organizationsCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Organizations Create']")
	    @CacheLookup
	    public WebElement organizationsCreateCheckbox;
	    public void clickOnorganizationsCreateCheckbox() throws InterruptedException{
	    	organizationsCreateCheckbox.click();
	 		logger.info("Clicked on the: organizationsCreateCheckbox");
	 		Thread.sleep(500);
	 	}

	    //organizationsEditCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Organizations Edit']")
	    @CacheLookup
	    public WebElement organizationsEditCheckbox;
	    public void clickOnorganizationsEditCheckbox() throws InterruptedException{
	    	organizationsEditCheckbox.click();
	 		logger.info("Clicked on the: organizationsEditCheckbox");
	 		Thread.sleep(500);
	 	}

	    //organizationsReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Organizations Read']")
	    @CacheLookup
	    public WebElement organizationsReadCheckbox;
	    public void clickOnorganizationsReadCheckbox() throws InterruptedException{
	    	organizationsReadCheckbox.click();
	 		logger.info("Clicked on the: organizationsReadCheckbox");
	 		Thread.sleep(500);
	 	}

	    //permissionAdminCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Permission Admin']")
	    @CacheLookup
	    public WebElement permissionAdminCheckbox;
	    public void clickOnPermissionAdminCheckbox() throws InterruptedException{
	    	permissionAdminCheckbox.click();
	 		logger.info("Clicked on the: permissionAdminCheckbox");
	 		Thread.sleep(500);
	 	}

	    //permissionCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Permission Create']")
	    @CacheLookup
	    public WebElement permissionCreateCheckbox;
	    public void clickOnpermissionCreateCheckbox() throws InterruptedException{
	    	permissionCreateCheckbox.click();
	 		logger.info("Clicked on the: permissionCreateCheckbox");
	 		Thread.sleep(500);
	 	}

	    //permissionEditCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Permission Edit']")
	    @CacheLookup
	    public WebElement permissionEditCheckbox;
	    public void clickOnpermissionEditCheckbox() throws InterruptedException{
	    	permissionEditCheckbox.click();
	 		logger.info("Clicked on the: permissionEditCheckbox");
	 		Thread.sleep(500);
	 	}

	    //permissionReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Permission Read']")
	    @CacheLookup
	    public WebElement permissionReadCheckbox;
	    public void clickOnpermissionReadCheckbox() throws InterruptedException{
	    	permissionReadCheckbox.click();
	 		logger.info("Clicked on the: permissionReadCheckbox");
	 		Thread.sleep(500);
	 	}

	    //projectAssignmentAdminCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Project Assignment Admin']")
	    @CacheLookup
	    public WebElement projectAssignmentAdminCheckbox;
	    public void clickOnProjectAssignmentAdminCheckbox() throws InterruptedException{
	    	projectAssignmentAdminCheckbox.click();
	 		logger.info("Clicked on the: projectAssignmentAdminCheckbox");
	 		Thread.sleep(500);
	 	}

	    //projectAssignmentCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Project Assignment Create']")
	    @CacheLookup
	    public WebElement projectAssignmentCreateCheckbox;
	    public void clickOnprojectAssignmentCreateCheckbox() throws InterruptedException{
	    	projectAssignmentCreateCheckbox.click();
	 		logger.info("Clicked on the: projectAssignmentCreateCheckbox");
	 		Thread.sleep(500);
	 	}

	    //projectAssignmentReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Project Assignment Read']")
	    @CacheLookup
	    public WebElement projectAssignmentReadCheckbox;
	    public void clickOnprojectAssignmentReadCheckbox() throws InterruptedException{
	    	projectAssignmentReadCheckbox.click();
	 		logger.info("Clicked on the: projectAssignmentReadCheckbox");
	 		Thread.sleep(500);
	 	}

	    //projectAdminCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Project Admin']")
	    @CacheLookup
	    public WebElement projectAdminCheckbox;
	    public void clickOnProjectAdminCheckbox() throws InterruptedException{
	    	projectAdminCheckbox.click();
	 		logger.info("Clicked on the: projectAdminCheckbox");
	 		Thread.sleep(500);
	 	}

	    //projectCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Project Create']")
	    @CacheLookup
	    public WebElement projectCreateCheckbox;
	    public void clickOnprojectCreateCheckbox() throws InterruptedException{
	    	projectCreateCheckbox.click();
	 		logger.info("Clicked on the: projectCreateCheckbox");
	 		Thread.sleep(500);
	 	}

	    //projectEditCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Project Edit']")
	    @CacheLookup
	    public WebElement projectEditCheckbox;
	    public void clickOnprojectEditCheckbox() throws InterruptedException{
	    	projectEditCheckbox.click();
	 		logger.info("Clicked on the: projectEditCheckbox");
	 		Thread.sleep(500);
	 	}

	    //projectReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Project Read']")
	    @CacheLookup
	    public WebElement projectReadCheckbox;
	    public void clickOnprojectReadCheckbox() throws InterruptedException{
	    	projectReadCheckbox.click();
	 		logger.info("Clicked on the: projectReadCheckbox");
	 		Thread.sleep(500);
	 	}

	    //usersAdminCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Users Admin']")
	    @CacheLookup
	    public WebElement usersAdminCheckbox;
	    public void clickOnUsersAdminCheckbox() throws InterruptedException{
	    	usersAdminCheckbox.click();
	 		logger.info("Clicked on the: usersAdminCheckbox");
	 		Thread.sleep(500);
	 	}

	    //usersCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Users Create']")
	    @CacheLookup
	    public WebElement usersCreateCheckbox;
	    public void clickOnusersCreateCheckbox() throws InterruptedException{
	    	usersCreateCheckbox.click();
	 		logger.info("Clicked on the: usersCreateCheckbox");
	 		Thread.sleep(500);
	 	}

	    //usersEditCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Users Edit']")
	    @CacheLookup
	    public WebElement usersEditCheckbox;
	    public void clickOnusersEditCheckbox() throws InterruptedException{
	    	usersEditCheckbox.click();
	 		logger.info("Clicked on the: usersEditCheckbox  ");
	 		Thread.sleep(500);
	 	}

	    //usersReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='Users Read']")
	    @CacheLookup
	    public WebElement usersReadCheckbox;
	    public void clickOnusersReadCheckbox() throws InterruptedException{
	    	usersReadCheckbox.click();
	 		logger.info("Clicked on the: usersReadCheckbox");
	 		Thread.sleep(500);
	 	}

	    //userProfilesAdminCheckbox
	    @FindBy(xpath = "//span[normalize-space()='User Profiles Admin']")
	    @CacheLookup
	    public WebElement userProfilesAdminCheckbox;
	    public void clickOnUserProfilesAdminCheckbox() throws InterruptedException{
	    	userProfilesAdminCheckbox.click();
	 		logger.info("Clicked on the: userProfilesAdminCheckbox");
	 		Thread.sleep(500);
	 	}

	    //userProfilesCreateCheckbox
	    @FindBy(xpath = "//span[normalize-space()='User Profiles Create']")
	    @CacheLookup
	    public WebElement userProfilesCreateCheckbox;
	    public void clickOnuserProfilesCreateCheckbox() throws InterruptedException{
	    	userProfilesCreateCheckbox.click();
	 		logger.info("Clicked on the: userProfilesCreateCheckbox");
	 		Thread.sleep(500);
	 	}

	    //userProfilesEditCheckbox
	    @FindBy(xpath = "//span[normalize-space()='User Profiles Edit']")
	    @CacheLookup
	    public WebElement userProfilesEditCheckbox;
	    public void clickOnuserProfilesEditCheckbox() throws InterruptedException{
	    	userProfilesEditCheckbox.click();
	 		logger.info("Clicked on the: userProfilesEditCheckbox");
	 		Thread.sleep(500);
	 	}

	    //userProfilesReadCheckbox
	    @FindBy(xpath = "//span[normalize-space()='User Profiles Read']")
	    @CacheLookup
	    public WebElement userProfilesReadCheckbox;
	    public void clickOnuserProfilesReadCheckbox() throws InterruptedException{
	    	userProfilesReadCheckbox.click();
	 		logger.info("Clicked on the: userProfilesReadCheckbox");
	 		Thread.sleep(500);
	 	}
	    //=========END========CHECK BOX FOR THE PERMISSION PAGE OBJECTS========//
	    
	    
	    
	  //==========START==========DROPDOWN FOR THE PERMISSION PAGE OBJESTS=========//
	    //Asset Management
	    @FindBy(xpath = "//p[normalize-space()='Asset Management']")
	    @CacheLookup
	    public WebElement dropDownAssetManagement ;
	    public void clickOnAssetManagement()  throws InterruptedException {
	    	dropDownAssetManagement.click();
	    	logger.info("Clicked on the Asset Management ");
	    	Thread.sleep(500);
	    }
	    
	    //Asset Type Management 
	    @FindBy(xpath = "//p[normalize-space()='Asset Type Management']")
	    @CacheLookup
	    public WebElement dropDownAssetTypeManagement ;
	    public void clickOndropDownAssetTypeManagement()  throws InterruptedException {
	    	dropDownAssetTypeManagement.click();
	    	logger.info("Clicked on the Asset Type Management ");
	    	Thread.sleep(500);
	    }
	    
	    
	    //Client Management
	    @FindBy(xpath = "//p[normalize-space()='Client Management']")
	    @CacheLookup
	    public WebElement dropDownClientManagement ;
	    public void clickOnClientManagement()  throws InterruptedException {
	    	dropDownClientManagement.click();
	    	logger.info(" Clicked on the Client Management");
	    	Thread.sleep(500);
	    }
	    
	    //Daily Update Management
	    @FindBy(xpath = "//p[normalize-space()='Daily Update Management']")
	    @CacheLookup
	    public WebElement dropDownDailyUpdateManagement ;
	    public void clickOndropDownDailyUpdateManagement()  throws InterruptedException {
	    	dropDownDailyUpdateManagement.click();
	    	logger.info("Clicked on the Daily Update Management ");
	    	Thread.sleep(500);
	    }
	    
	    
	    //Job Title Management
	    @FindBy(xpath = "//p[normalize-space()='Job Title Management']")
	    @CacheLookup
	    public WebElement dropDownJobTitleManagement ;
	    public void clickOnJobTitleManagement()  throws InterruptedException {
	    	dropDownJobTitleManagement.click();
	    	logger.info(" Clicked on the Job Title Management ");
	    	Thread.sleep(500);
	    }
	    
	    
	    //Leave Balance Management
	    @FindBy(xpath = "//p[normalize-space()='Leave Balance Management']")
	    @CacheLookup
	    public WebElement dropDownLeaveBalanceManagement ;
	    public void clickOnLeaveBalanceManagement()  throws InterruptedException {
	    	dropDownLeaveBalanceManagement.click();
	    	logger.info("Clicked on the Leave Balance Management ");
	    	Thread.sleep(500);
	    }
	    
	    
	    //
	    @FindBy(xpath = "//p[normalize-space()='Leave Request Management']")
	    @CacheLookup
	    public WebElement dropDownLeaveRequestManagement ;
	    public void clickOnLeaveRequestManagement()  throws InterruptedException {
	    	dropDownLeaveRequestManagement.click();
	    	logger.info("Clicked on the Leave Request Management ");
	    	Thread.sleep(500);
	    }
	    
	    //
	    @FindBy(xpath = "//p[normalize-space()='Leave Type Management']")
	    @CacheLookup
	    public WebElement dropDownLeaveTypeManagement ;
	    public void clickOnLeaveTypeManagement()  throws InterruptedException {
	    	dropDownLeaveTypeManagement.click();
	    	logger.info("Clicked on the Leave Type Management  ");
	    	Thread.sleep(500);
	    }
	    
	    //Organizations Management
	    @FindBy(xpath = "//p[normalize-space()='Organizations Management']")
	    @CacheLookup
	    public WebElement dropDownOrganizationsManagement ;
	    public void clickOnOrganizationsManagement()  throws InterruptedException {
	    	dropDownOrganizationsManagement.click();
	    	logger.info(" Clicked on the Organizations Management");
	    	Thread.sleep(500);
	    }
	    
	    //Permission Management
	    @FindBy(xpath = "//p[normalize-space()='Permission Management']")
	    @CacheLookup
	    public WebElement dropDownPermissionManagement;
	    public void clickOnPermissionManagement()  throws InterruptedException {
	    	dropDownPermissionManagement.click();
	    	logger.info(" Clicked on the Permission Management");
	    	Thread.sleep(500);
	    }
	    
	    //Project Assignment Management
	    @FindBy(xpath = "//p[normalize-space()='Project Assignment Management']")
	    @CacheLookup
	    public WebElement dropDownProjectAssignmentManagement ;
	    public void clickOnProjectAssignmentManagement()  throws InterruptedException {
	    	dropDownProjectAssignmentManagement.click();
	    	logger.info("Clicked on the Project Assignment Management ");
	    	Thread.sleep(500);
	    }
	    
	    //Project Management
	    @FindBy(xpath = "//p[normalize-space()='Project Management']")
	    @CacheLookup
	    public WebElement dropDownProjectManagement ;
	    public void clickOnProjectManagement()  throws InterruptedException {
	    	dropDownProjectManagement.click();
	    	logger.info("Clicked on the Project Management ");
	    	Thread.sleep(500);
	    }
	    
	    
	    //User Management
	    @FindBy(xpath = "//p[normalize-space()='User Management']")
	    @CacheLookup
	    public WebElement dropDownUserManagement ;
	    public void clickOnUserManagement()  throws InterruptedException {
	    	dropDownUserManagement.click();
	    	logger.info("Clicked on the User Management ");
	    	Thread.sleep(500);
	    }
	    
	    //User Profile Management
	    @FindBy(xpath = "//p[normalize-space()='User Profile Management']")
	    @CacheLookup
	    public WebElement dropDownUserProfileManagement ;
	    public void clickOnUserProfileManagement()  throws InterruptedException {
	    	dropDownUserProfileManagement.click();
	    	logger.info("Clicked on the User Profile Management");
	    	Thread.sleep(500);
	    }
	  //==========END=======DROPDOWN FOR THE PERMISSION PAGE OBJESTS=========//
	    
	    //TO CHECK PERMISSION DROPDOWN WORKING
	    public PO_HomePage userPermissionsDropdown() throws InterruptedException
	    {
	    	for(int i=0;i<2;i++) {
	    		clickOnAssetManagement();
		    	clickOndropDownAssetTypeManagement();
		    	clickOnClientManagement();
		    	clickOndropDownDailyUpdateManagement();
		    	clickOnJobTitleManagement();
		    	clickOnLeaveBalanceManagement();
		    	clickOnLeaveRequestManagement();
		    	if(i==1) {
		    		jsExecutor.executeScript("window.scrollBy(0,300);");
		    	}
		    	clickOnLeaveTypeManagement();
		    	clickOnOrganizationsManagement();
		    	clickOnPermissionManagement();
		    	clickOnProjectAssignmentManagement();
		    	clickOnProjectManagement();
		    	clickOnUserManagement();
		    	clickOnUserProfileManagement();
	    	}
	    	
	    	return new PO_HomePage(driver);
	    }
	    
	    
	  //TO CHECK USER PERMISSIONS ADMIN CHECKBOX
	    public PO_HomePage userPermissionsAdminCheckbox() throws InterruptedException
	    {
	    	for(int i=0;i<1;i++) {
	    		clickOnAssetAdminCheckbox();
	    		clickOnAssetTypeAdminCheckbox();
	    		clickOnClientsAdminCheckbox();
	    		//DAILY UPDATES CHECKBOX
	    		clickOnClientsReadCheckbox();
	    		clickOnDailyUpdateCreateCheckbox();
	    		
	    		clickOnJobTitleAdminCheckbox();
	    		jsExecutor.executeScript("window.scrollBy(0, 300);");
	    		Thread.sleep(1000);
	    		clickOnLeaveBalanceAdminCheckbox();
	    		clickOnLeaveRequestAdminCheckbox();
	    		clickOnLeaveTypeAdminCheckbox();
	    		clickOnOrganizationsAdminCheckbox();
	    		jsExecutor.executeScript("window.scrollBy(0, 300);");
	    		Thread.sleep(1000);
	    		clickOnPermissionAdminCheckbox();
	    		clickOnProjectAssignmentAdminCheckbox();
	    		clickOnProjectAdminCheckbox();
	    		clickOnUsersAdminCheckbox();
	    		clickOnUserProfilesAdminCheckbox();	
	    		jsExecutor.executeScript("window.scrollBy(0, -600);");
	    		Thread.sleep(1000);
	    		
	    		ruae.clickOnBtnSaveAndGoToHome_2_RU();
	    		Thread.sleep(300);
	    		logger.info("Permissions assigned to the creted users with admin all");
	    		
	    	}
	    	
	    	return new PO_HomePage(driver);
	    }
	    
	    
	    //TO CHECK USER PERMISSIONS ALL THE CHECKBOX SELECTIO FORM THE BOTTOM TO TOP
	    public PO_HomePage userPermissionsCheckboxSelectionBottomToTop() throws InterruptedException
	    {
	    	for(int i=0;i<2;i++) {
	    		//ASSETS CHECKBOX
	    		clickOnassetReadCheckbox();
	    		clickOnassetEditCheckbox();
	    		clickOnassetCreateCheckbox();
	    		clickOnAssetAdminCheckbox();
	    		
	    		//ASSETS TYPES CHECK BOX
	    		clickOnassetTypeReadCheckbox();
	    		clickOnassetTypeEditCheckbox();
	    		clickOnassetTypeCreateCheckbox();
	    		clickOnAssetTypeAdminCheckbox();
	    		
	    		//CLIENT CHECKBOX
	    		clickOnClientsReadCheckbox();
	    		clickOnclientsEditCheckbox();
	    		clickOnclientsCreateCheckbox();
	    		clickOnClientsAdminCheckbox();
	    		jsExecutor.executeScript("window.scrollBy(0, 200);");
	    		Thread.sleep(1000);
	    		
	    		//DAILY UPDATES CHECKBOX
	    		clickOndailyUpdateReadCheckbox();
	    		clickOnDailyUpdateCreateCheckbox();
	    		
	    		
	    		//JOB TITLE CHECKBOX
	    		clickOnjobTitleReadCheckbox();
	    		clickOnjobTitleEditCheckbox();
	    		clickOnjobTitleCreateCheckbox();
	    		clickOnJobTitleAdminCheckbox();
	    		
	    		//LEAVE BALANCE CHECKBOX
	    		clickOnleaveBalanceReadCheckbox();
	    		clickOnleaveBalanceEditCheckbox();
	    		clickOnleaveBalanceCreateCheckbox();
	    		clickOnLeaveBalanceAdminCheckbox();
	    		jsExecutor.executeScript("window.scrollBy(0, 200);");
	    		Thread.sleep(1000);
	    		
	    		//LEAVE REQUEST CHECKBOX
	    		clickOnleaveRequestReadCheckbox();
	    		clickOnleaveRequestEditCheckbox();
	    		clickOnleaveRequestCreateCheckbox();
	    		clickOnLeaveRequestAdminCheckbox();
	    		
	    		//LEAVE TYPES CHECKBOX
	    		clickOnleaveTypeReadCheckbox();
	    		clickOnleaveTypeEditCheckbox();
	    		clickOnleaveTypeCreateCheckbox();
	    		clickOnLeaveTypeAdminCheckbox();
	    		
	    		//ORGANIZATION CHECKBOX
	    		clickOnorganizationsReadCheckbox();
	    		clickOnorganizationsEditCheckbox();
	    		clickOnorganizationsCreateCheckbox();
	    		clickOnOrganizationsAdminCheckbox();
	    		jsExecutor.executeScript("window.scrollBy(0, 200);");
	    		Thread.sleep(1000);
	    		
	    		//PERMISSIONS CHECKBOX
	    		clickOnpermissionReadCheckbox();
	    		clickOnpermissionEditCheckbox();
	    		clickOnpermissionCreateCheckbox();
	    		clickOnPermissionAdminCheckbox();
	    		
	    		//PROJECT ASSIGNMENT CHECKBOX
	    		clickOnprojectAssignmentReadCheckbox();
	    		clickOnprojectAssignmentCreateCheckbox();
	    		clickOnProjectAssignmentAdminCheckbox();
	    		
	    		//PROJECT CHECKBOX
	    		clickOnprojectReadCheckbox();
	    		clickOnprojectEditCheckbox();
	    		clickOnprojectCreateCheckbox();
	    		clickOnProjectAdminCheckbox();
	    		jsExecutor.executeScript("window.scrollBy(0, -200);");
	    		Thread.sleep(1000);
	    		
	    		//USERS CHECKBOX
	    		clickOnusersReadCheckbox();
	    		clickOnusersEditCheckbox();
	    		clickOnusersCreateCheckbox();
	    		clickOnUsersAdminCheckbox();
	    		
	    		//USERS PROFILE CHECKBOX
	    		clickOnuserProfilesReadCheckbox();
	    		clickOnuserProfilesEditCheckbox();
	    		clickOnuserProfilesCreateCheckbox();
	    		clickOnUserProfilesAdminCheckbox();
	    		jsExecutor.executeScript("window.scrollBy(0, -800);");
	    		Thread.sleep(1000);
	    		
	    		ruae.clickOnBtnSaveAndGoToHome_2_RU();
	    	}
	    	
	    	return new PO_HomePage(driver);
	    }
	    
	  
}
