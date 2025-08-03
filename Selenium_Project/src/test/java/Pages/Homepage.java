package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.Assert;
import Utility.Base;

public class Homepage extends Base{
	
	private static By pageTitleLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
    private static By productsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
  
    public static void ClickProduct() {
    	try { 
    		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitleLocator)).isDisplayed();
            Assert.assertEquals(driver.getTitle(),"Automation Exercise" );
           driver.findElement(productsButton).click(); 
    	}
    	catch (Exception e)
    	{
    		System.err.println("Homepage is not visible. Error: " + e.getMessage());
           
    	}
    	
     
    }
    
}

