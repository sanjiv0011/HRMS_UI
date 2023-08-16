package my_support;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;


public class Generic_Method_ToSelect_Boostrape_Dropdown 
{
	public static final Logger logger = LogManager.getLogger(Generic_Method_ToSelect_Boostrape_Dropdown.class);
	
    public static void selectOptionFromDropdown(List<WebElement> options, String value)
    {
    	
    	boolean flag = false;
    	for(WebElement element : options)
    	{	
    		if(element.getText().equals(value))
    		{
    			element.click();
    			flag = true;
    			break;
    		}
    		
    	}
    
    	if(flag == true) {
    		logger.info("Option is selected");
    	}else {
    		logger.info("Option is not selected");
    	}
    	
    }
}

