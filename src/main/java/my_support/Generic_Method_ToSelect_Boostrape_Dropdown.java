package my_support;

import java.util.List;

import org.openqa.selenium.WebElement;

public class Generic_Method_ToSelect_Boostrape_Dropdown 
{
    public static void selectOptionFromDropdown(List<WebElement> options, String value)
    {
    	for(WebElement element : options)
    	{
    		if(element.getText().equals(value))
    		{
    			element.click();
    			break;
    		}
    	}
    }
}
