package com.hrms.testCases;


/*import java.text.SimpleDateFormat;
import java.util.Date;
*/

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.github.javafaker.Faker;
import com.hrms.utilities.ReadConfigFiles;


public class BaseClass {
	
	public static WebDriver driver;
	
	// logger to log the messages
	public Logger logger = LogManager.getLogger(this.getClass());
	
	
	// to read the file from utilities.ReadConfigFiles
	ReadConfigFiles rcf = new ReadConfigFiles();
	public String baseUrl = rcf.getApplicationUrl();
	public String userName = rcf.getUserName();
	public String password = rcf.getPassword();
	
	
	// to generate random data
	public Faker faker = new Faker();
	
	// to select the driver
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{
		logger.info("Base class started...");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chromedriver",rcf.getChromePath());
			
			// for headless browsing
			ChromeOptions option = new ChromeOptions();
	        option.addArguments("--incognito");	//TO OPEN CHROME DIRVER INCOGNITO MODE
			//option.addArguments("--headless=chrome");
			//option.setExperimentalOption("debuggerAddress", "http://localhost:8888");
			driver = new ChromeDriver(option);
			
			logger.info("Chrome driver selected");
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.geckodriver",rcf.getFireFoxPath());
			driver = new FirefoxDriver();
			logger.info("Fire fox driver selected");
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.msedgedriver",rcf.getMsEdgePath());
			driver = new EdgeDriver();
			logger.info("Edge driver selected");
		}
		driver.get(baseUrl);
		Thread.sleep(5000);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}
	
	
	
	// to stop the driver
	@AfterClass
	public void teardown()
	{
		driver.quit();
		logger.info("Driver shutdown");
	}
	
	
	// to generate random string 
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(6);
		return generatedstring;
	}
	
	
	// to generate random String number with specfic digit length
	public String randomStringNumber(int max, int min)
	{
		String rdmStringNumber = RandomStringUtils.randomNumeric(min, max);
		return rdmStringNumber;
	}
	
}
