package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utility.Base;

public class Cart extends Productpage{
	
	private static By cartbutton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");

	  public static void CartpageActions() 
	  {
	    	try { 
	    		driver.findElement(cartbutton).click();
	    		
	    	 		       
	    		      
	    		       
	    		       
	    		    
	    	}
	    	catch (Exception e)
	    	{
	    		System.err.println("Cartbutton is not working. Error: " + e.getMessage());
	           
	    	}
	

	  }
}
