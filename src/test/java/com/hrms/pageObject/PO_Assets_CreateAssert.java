package com.hrms.pageObject;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_Assets_CreateAssert {
	    // Constructor to initialize the page and its elements
		public WebDriver driver = null;
		public Logger logger = LogManager.getLogger(getClass());
	
	    public PO_Assets_CreateAssert(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Enter Asset Company Name
	    @FindBy(xpath = "//xpath/for/enterAssetCompanyName")
	    @CacheLookup
	    private WebElement enterAssetCompanyName;

	    // Select Asset Type
	    @FindBy(xpath = "//xpath/for/selectAssetType")
	    @CacheLookup
	    private WebElement selectAssetType;


	    // Enter Serial Number
	    @FindBy(xpath = "//xpath/for/enterSerialNumber")
	    @CacheLookup
	    private WebElement enterSerialNumber;

	    // Enter Model Number
	    @FindBy(xpath = "//xpath/for/enterModelNumber")
	    @CacheLookup
	    private WebElement enterModelNumber;


	    // Enter Used By
	    @FindBy(xpath = "//xpath/for/enterUsedBy")
	    @CacheLookup
	    private WebElement enterUsedBy;


	    // Enter Support Person
	    @FindBy(xpath = "//xpath/for/enterSupportPerson")
	    @CacheLookup
	    private WebElement enterSupportPerson;


	    // Enter Warranty
	    @FindBy(xpath = "//xpath/for/enterWarranty")
	    @CacheLookup
	    private WebElement enterWarranty;

	    // Warranty Expiry Date (MM/DD/YYYY)
	    @FindBy(xpath = "//xpath/for/warrantyExpiryDate")
	    @CacheLookup
	    private WebElement warrantyExpiryDate;

	    // Manufacturer Date (MM/DD/YYYY)
	    @FindBy(xpath = "//xpath/for/manufacturerDate")
	    @CacheLookup
	    private WebElement manufacturerDate;

	    // Purchase Date (MM/DD/YYYY)
	    @FindBy(xpath = "//xpath/for/purchaseDate")
	    @CacheLookup
	    private WebElement purchaseDate;

	    // Enter Invoice Number
	    @FindBy(xpath = "//xpath/for/enterInvoiceNumber")
	    @CacheLookup
	    private WebElement enterInvoiceNumber;


	    // Enter Invoice URL
	    @FindBy(xpath = "//xpath/for/enterInvoiceURL")
	    @CacheLookup
	    private WebElement enterInvoiceURL;

	    // Select Status
	    @FindBy(xpath = "//xpath/for/selectStatus")
	    @CacheLookup
	    private WebElement selectStatus;

	    // Select Condition
	    @FindBy(xpath = "//xpath/for/selectCondition")
	    @CacheLookup
	    private WebElement selectCondition;

	    // Select Replacement Status
	    @FindBy(xpath = "//xpath/for/selectReplacementStatus")
	    @CacheLookup
	    private WebElement selectReplacementStatus;
	    
	    

	    // Method to enter Asset Company Name
	    public void enterAssetCompanyName(String companyName) {
	        enterAssetCompanyName.sendKeys(companyName);
	        logger.info("Entered Asset Company Name: " + companyName);
	    }

	    // Method to select Asset Type
	    public void selectAssetType(String assetType) {
	        selectAssetType.sendKeys(assetType);
	        logger.info("Selected Asset Type: " + assetType);
	    }

	    // Method to enter Serial Number
	    public void enterSerialNumber(String serialNumber) {
	        enterSerialNumber.sendKeys(serialNumber);
	        logger.info("Entered Serial Number: " + serialNumber);
	    }

	    // Method to enter Model Number
	    public void enterModelNumber(String modelNumber) {
	        enterModelNumber.sendKeys(modelNumber);
	        logger.info("Entered Model Number: " + modelNumber);
	    }

	    // Method to enter Used By
	    public void enterUsedBy(String usedBy) {
	        enterUsedBy.sendKeys(usedBy);
	        logger.info("Entered Used By: " + usedBy);
	    }

	    // Method to enter Support Person
	    public void enterSupportPerson(String supportPerson) {
	        enterSupportPerson.sendKeys(supportPerson);
	        logger.info("Entered Support Person: " + supportPerson);
	    }

	    // Method to enter Warranty
	    public void enterWarranty(String warranty) {
	        enterWarranty.sendKeys(warranty);
	        logger.info("Entered Warranty: " + warranty);
	    }

	    // Method to enter Warranty Expiry Date (MM/DD/YYYY)
	    public void enterWarrantyExpiryDate(String warrantyExpiry) {
	        warrantyExpiryDate.sendKeys(warrantyExpiry);
	        logger.info("Entered Warranty Expiry Date: " + warrantyExpiry);
	    }

	    // Method to enter Manufacturer Date (MM/DD/YYYY)
	    public void enterManufacturerDate(String manufacturerDate1) {
	        manufacturerDate.sendKeys(manufacturerDate1);
	        logger.info("Entered Manufacturer Date: " + manufacturerDate1);
	    }

	    // Method to enter Purchase Date (MM/DD/YYYY)
	    public void enterPurchaseDate(String purchaseDate1) {
	        purchaseDate.sendKeys(purchaseDate1);
	        logger.info("Entered Purchase Date: " + purchaseDate1);
	    }

	    // Method to enter Invoice Number
	    public void enterInvoiceNumber(String invoiceNumber) {
	        enterInvoiceNumber.sendKeys(invoiceNumber);
	        logger.info("Entered Invoice Number: " + invoiceNumber);
	    }

	    // Method to enter Invoice URL
	    public void enterInvoiceURL(String invoiceURL) {
	        enterInvoiceURL.sendKeys(invoiceURL);
	        logger.info("Entered Invoice URL: " + invoiceURL);
	    }

	    // Method to select Status
	    public void selectStatus(String status) {
	        selectStatus.sendKeys(status);
	        logger.info("Selected Status: " + status);
	    }

	    // Method to select Condition
	    public void selectCondition(String condition) {
	        selectCondition.sendKeys(condition);
	        logger.info("Selected Condition: " + condition);
	    }

	    // Method to select Replacement Status
	    public void selectReplacementStatus(String replacementStatus) {
	        selectReplacementStatus.sendKeys(replacementStatus);
	        logger.info("Selected Replacement Status: " + replacementStatus);
	    }
	    
	    
	    // all in one
	    public PO_HomePage createAssets(String companyName, String assetType,String serialNumber,String modelNumber,
	    String usedBy,	String supportPerson, String warranty, String warrantyExpiry, String manufacturerDate1, String purchaseDate1, String invoiceNumber, String invoiceURL, String status, String condition, String replacementStatus) throws InterruptedException{
	    	 enterAssetCompanyName.sendKeys(companyName);
		        logger.info("Entered Asset Company Name: " + companyName);
		        Thread.sleep(1000);
		        
		        
		        selectAssetType.sendKeys(assetType);
		        logger.info("Selected Asset Type: " + assetType);
		        Thread.sleep(1000);
		        
		        enterSerialNumber.sendKeys(serialNumber);
		        logger.info("Entered Serial Number: " + serialNumber);
		        Thread.sleep(1000);
		        
		        
		        enterModelNumber.sendKeys(modelNumber);
		        logger.info("Entered Model Number: " + modelNumber);
		        Thread.sleep(1000);
		        
		        enterUsedBy.sendKeys(usedBy);
		        logger.info("Entered Used By: " + usedBy);
		        Thread.sleep(1000);
		        
		        enterSupportPerson.sendKeys(supportPerson);
		        logger.info("Entered Support Person: " + supportPerson);
		        Thread.sleep(1000);
		        
		        enterWarranty.sendKeys(warranty);
		        logger.info("Entered Warranty: " + warranty);
		        Thread.sleep(1000);
		        
		        warrantyExpiryDate.sendKeys(warrantyExpiry);
		        logger.info("Entered Warranty Expiry Date: " + warrantyExpiry);
		        Thread.sleep(1000);
		        
		        
		        manufacturerDate.sendKeys(manufacturerDate1);
		        logger.info("Entered Manufacturer Date: " + manufacturerDate1);
		        Thread.sleep(1000);
		        
		        purchaseDate.sendKeys(purchaseDate1);
		        logger.info("Entered Purchase Date: " + purchaseDate1);
		        Thread.sleep(1000);
		        
		        enterInvoiceNumber.sendKeys(invoiceNumber);
		        logger.info("Entered Invoice Number: " + invoiceNumber);
		        Thread.sleep(1000);
		        
		        enterInvoiceURL.sendKeys(invoiceURL);
		        logger.info("Entered Invoice URL: " + invoiceURL);
		        Thread.sleep(1000);
		        
		        selectStatus.sendKeys(status);
		        logger.info("Selected Status: " + status);
		        Thread.sleep(1000);
		        
		        selectCondition.sendKeys(condition);
		        logger.info("Selected Condition: " + condition);
		        Thread.sleep(1000);
		        
		        
		        selectReplacementStatus.sendKeys(replacementStatus);
		        logger.info("Selected Replacement Status: " + replacementStatus);
		        Thread.sleep(1000);
		        
		        return new PO_HomePage(driver);
	    }
}

