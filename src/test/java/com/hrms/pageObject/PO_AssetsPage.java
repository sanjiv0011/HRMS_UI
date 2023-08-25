package com.hrms.pageObject;


import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.ReUseAble.PageObject.ReUseAbleElement;
import com.hrms.projectUtility.DatePicker;
import com.hrms.projectUtility.Generic_Method_ToSelect_Boostrape_Dropdown;

public class PO_AssetsPage extends ReUseAbleElement {
	
	    //OBJECT DECLARATIONS
		public WebDriver driver;
		public Logger logger = LogManager.getLogger(getClass());
		public JavascriptExecutor jsExecutor;
		public ReUseAbleElement ruae;
		public WebDriverWait wait;
		public Actions action;
	

		//CONSTRUCTOR
	    public PO_AssetsPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(10));
			action = new Actions(driver);
	    }
	    
	    //CRETAE ASSETS BUTTON AT ASSETS PAGE
	    @FindBy(xpath = "(//p[text()='Create Asset'])[1]")
	    @CacheLookup
	    public WebElement btnCreateAssetAtAssetsPage;
	    
	    // Enter Serial Number
	    @FindBy(xpath = "//input[@placeholder='Enter Asset Company Name']")
	    @CacheLookup
	    public WebElement enterCompanyName;

	    // Select Asset Type from the list
	    @FindBy(xpath = "//ul[@id='asset-listbox']//li")
	    @CacheLookup
	    public List <WebElement> listAssetType;


	    // Enter Serial Number
	    @FindBy(xpath = "//input[@name='serialNumber']")
	    @CacheLookup
	    public WebElement enterSerialNumber;

	    // Enter Model Number
	    @FindBy(xpath = "//input[@name='modelNo']")
	    @CacheLookup
	    public WebElement enterModleNumber;

	    // Enter Used By
	    @FindBy(xpath = "//input[@name='usedBy']")
	    @CacheLookup
	    public WebElement enterUsedBy;


	    // Enter Support Person
	    @FindBy(xpath = "//input[@name='supportPerson']")
	    @CacheLookup
	    public WebElement enterSupportPerson;


	    // Enter Warranty
	    @FindBy(xpath = "//input[@name='warranty']")
	    @CacheLookup
	    public WebElement enterWarranty;

	    //FOR THE WARRANTY EXPIRAY , PURCHASE AND MANUFACTURING DATE ICON CLICK ACTION USE THE RE USE ABLE COMPONENT(1, 2 ,3)
	    //AND
	    //FOR THE ASSETS TYPES , CONDITION AND STATUS DROPDOWN ICON CLICK ACTION USE THE RE USE ABLE COMPONENT(1, 2, 3, 4)

	    // Enter Invoice Number
	    @FindBy(xpath = "//input[@name='invoiceNumber']")
	    @CacheLookup
	    public WebElement enterInvoiceNumber;


	    // Enter Invoice URL
	    @FindBy(xpath = "//input[@name='invoiceUrl']")
	    @CacheLookup
	    public WebElement enterInvoiceURL;

	    // Select Status from the list
	    @FindBy(xpath = "//ul[@id='status-listbox']//li")
	    @CacheLookup
	    public  List <WebElement> listStatus;

	    // Select Condition
	    @FindBy(xpath = "//ul[@id='condition-listbox']//li")
	    @CacheLookup
	    public List <WebElement> listCondition;

	    // Select Replacement Status
	    @FindBy(xpath = "//ul[@id='replacementStatus-listbox']//li")
	    @CacheLookup
	    public List <WebElement> listReplacementStatus;
	    
	    //BUTTON CREATE ASSETS AT CREATE ASSETS PAGE
	    @FindBy(xpath = "(//p[text()='Create Asset'])[2]")
	    @CacheLookup
	    public WebElement btnCreateAssetsAtCreateAssetsPage;
	    
	    //CLICK ON BUTTON CREATE ASSETS AT ASSETS PAGE
	    public void clickOnBtnCreateAssetsAtAssetaPage() throws InterruptedException {
	    	btnCreateAssetAtAssetsPage.click();
	        logger.info("Clicked on the button");
	        Thread.sleep(1000);
	    }
	    
	    // Method to enter Asset Company Name
	    public void selectAssetCompanyName(String companyName) throws InterruptedException {
	    	enterCompanyName.sendKeys(companyName);
	    	Thread.sleep(500);
		     logger.info("Entered company name");
	    }

	    // Method to select Asset Type
	    public void selectAssetType(String assetType) throws InterruptedException {
	    	clickOnDropdown_1_RU();
	    	Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listAssetType,assetType );
	    	Thread.sleep(500);
	    }

	    // Method to enter Serial Number
	    public void enterSerialNumber(String serialNumber) throws InterruptedException {
	    	enterSerialNumber.sendKeys(serialNumber);
	    	Thread.sleep(500);
	        logger.info("Entered Serial Numbe");
	    }

	    // Method to enter Model Number
	    public void enterModelNumber(String modelNumber) throws InterruptedException {
	    	enterModleNumber.sendKeys(modelNumber);
	    	Thread.sleep(500);
	        logger.info("Entered Model Number: ");
	    }

	    // Method to enter Used By
	    public void enterUsedBy(String usedBy) throws InterruptedException {
	        enterUsedBy.sendKeys(usedBy);
	        Thread.sleep(500);
	        logger.info("Entered Used By");
	    }

	    // Method to enter Support Person
	    public void enterSupportPerson(String supportPerson) throws InterruptedException {
	        enterSupportPerson.sendKeys(supportPerson);
	        Thread.sleep(500);
	        logger.info("Entered Support Person");
	    }

	    // Method to enter Warranty
	    public void enterWarranty(String warranty) throws InterruptedException {
	    	enterWarranty.sendKeys(warranty);
	        Thread.sleep(500);
	        logger.info("Entered Warranty");
	    }
	    
	    // Method to enter Warranty Expiry Date (MM/DD/YYYY)
	    public void enterWarrantyExpiryDate(String warrantyExpiry, int x) throws InterruptedException {
	    	DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver,warrantyExpiry, x);
			Thread.sleep(1000);
	    }

	    // Method to enter Manufacturer Date (MM/DD/YYYY)
	    public void enterManufacturerDate(String manufacturerDate1, int x) throws InterruptedException {
	    	DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver,manufacturerDate1, x);
			Thread.sleep(1000);
	    }
	    
	    // Method to enter Purchase Date (MM/DD/YYYY)
	    public void enterPurchaseDate(String purchaseDate1, int x) throws InterruptedException {
	    	DatePicker.DatePicker_GenericMethod_WithoutDropDown(driver, purchaseDate1, x);
			Thread.sleep(1000);
	    }

	    // Method to enter Invoice Number
	    public void enterInvoiceNumber(String invoiceNumber) throws InterruptedException {
	        enterInvoiceNumber.sendKeys(invoiceNumber);
	        Thread.sleep(500);
	        logger.info("Entered Invoice Number: " + invoiceNumber);
	    }

	    // Method to enter Invoice URL
	    public void enterInvoiceURL(String invoiceURL) throws InterruptedException {
	        enterInvoiceURL.sendKeys(invoiceURL);
	        Thread.sleep(500);
	        logger.info("Entered Invoice URL: " + invoiceURL);
	    }

	    // Method to select Status
	    public void selectStatus(String status) throws InterruptedException {
	    	clickOnDropdown_2_RU();
	    	Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listStatus,status );
	    	Thread.sleep(500);
	    }

	    // Method to select Condition
	    public void selectCondition(String condition) throws InterruptedException {
	    	clickOnDropdown_3_RU();
	    	Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listCondition,condition );
	    	Thread.sleep(500);
	    }

	    // Method to select Replacement Status
	    public void selectReplacementStatus(String replacementStatus) throws InterruptedException {
	    	clickOnDropdown_4_RU();
	    	Generic_Method_ToSelect_Boostrape_Dropdown.selectOptionFromDropdown(listReplacementStatus,replacementStatus );
	    	Thread.sleep(500);
	    }
	    
	    // Method to click on create assets button at create assests page
	    public void clickOnBtnCreateAssetsAtCreateAssetsPage() throws InterruptedException {
	    	btnCreateAssetsAtCreateAssetsPage.click();
	    	Thread.sleep(300);
	        logger.info("Clicked on the create assets button at create assets page");
	    }
	    
	    //TO CREATE ASSETS
	    public PO_HomePage createAssets(String companyName, String assetType,String serialNumber,String modelNumber, String usedBy,	String supportPerson, String warranty, String warrantyExpiry, String manufacturerDate1, String purchaseDate1, String invoiceNumber, String invoiceURL, String status, String condition, String replacementStatus) throws InterruptedException
	    {
	    	clickOnBtnCreateAssetsAtAssetaPage();
	    	enterPurchaseDate(purchaseDate1,3);
	    	enterManufacturerDate(manufacturerDate1,2);
	    	enterWarrantyExpiryDate(warrantyExpiry,1);
	    	selectAssetCompanyName(companyName);
	    	selectAssetType(assetType);
	    	enterSerialNumber(serialNumber);
	    	enterModelNumber(modelNumber);
	    	enterUsedBy(usedBy);
	    	enterSupportPerson(supportPerson);
	    	enterWarranty(warranty);
	    	enterInvoiceNumber(invoiceNumber);
	    	enterInvoiceURL(invoiceURL);
	    	selectStatus(status);
	    	selectCondition(condition);
	    	selectReplacementStatus(replacementStatus);
	    	clickOnBtnCreateAssetsAtCreateAssetsPage();
	    	
		    return new PO_HomePage(driver);
	    }
}

