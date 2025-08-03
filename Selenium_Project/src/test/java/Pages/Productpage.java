// src/main/java/Pages/ProductsPage.java
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import Utility.Base;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;


public class Productpage extends Base {

   
	private static By cartbutton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    private By allProductsHeader = By.cssSelector("div.features_items h2.title");
    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");	  
    private By productname = By.cssSelector("div.productinfo p");
    private By Addtocart = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a");
    private By Countinueshopping = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[1]/div/div/div[3]/button");
   protected String Productname;
   protected String productprice;
    public boolean isAllProductsPageVisible() {
        try {
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsHeader));
            return header.isDisplayed() && header.getText().equals("ALL PRODUCTS");
        } catch (Exception e) {
            System.err.println("Products page is not visible or header text is incorrect. Error: " + e.getMessage());
            return false;
        }
    }

    public void searchForProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(productName);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
    
    public boolean isSearchedProductsHeaderVisible() {
        try {
            
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsHeader));
            return header.isDisplayed() && header.getText().equals("SEARCHED PRODUCTS");
        } catch (Exception e) {
            System.err.println("Searched results page header is not correct. Error: " + e.getMessage());
            return false;
        }
    }

    public List<String> getAllProductNames() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productname));
        List<WebElement> productElements = driver.findElements(productname);
        return productElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    
    public boolean isProductInSearchResults(String name) {
        List<String> productNames = getAllProductNames();
        String lowercaseSearchTerm = name.toLowerCase();

        for (String productName : productNames) {
            if (productName.toLowerCase().contains(lowercaseSearchTerm)) {
                System.out.println("Match found! Product name: '" + productName + "' contains search term: '" + name + "'");
                return true;
            }
        }
        System.out.println("No product name contains the search term: '" + name + "'");
        return false;
    }
    public void Addtocart()throws Exception
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0, 500)");
    	Thread.sleep(2000);
    	try {
    	
    		driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")).click();
    	    Productname =	driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")).getText();
    	    productprice =driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span")).getText();
    	    driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")).click();
    	    driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button")).click();
    	    driver.findElement(cartbutton).click();
    	   
    	}
    	catch (Exception e)
    	{
    		System.err.println(e);
    	}
    	
    }
    public  void VerifyPriceAndName()
	{
    	Assert.assertEquals(Productname, driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[2]/h4/a")).getText());
	    Assert.assertEquals(productprice, driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[3]/p")).getText());
	    Assert.assertEquals(productprice, driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[5]/p")).getText());
	    
	}
   
    	
    	
    	
    
}
