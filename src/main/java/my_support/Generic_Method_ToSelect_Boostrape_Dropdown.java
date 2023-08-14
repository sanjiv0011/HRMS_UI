package my_support;

import java.util.List;

import org.openqa.selenium.WebElement;


public class Generic_Method_ToSelect_Boostrape_Dropdown 
{
	
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
    		System.out.println("Option is selected");
    	}else {
    		System.out.println("Option is not selected");
    	}
    	
    }
}

