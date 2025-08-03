package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Homepage;
import Pages.Productpage;
import Utility.Base;

public class TC001_Searchproduct extends Base

{
	
         @Test
    	 public void searchForProduct() {
    	    Homepage.ClickProduct();
    	    Productpage product = new Productpage();
    	    product.isAllProductsPageVisible();
    	    product.searchForProduct("TShirt");
    	  
    	    product.getAllProductNames();
    	    product.isProductInSearchResults("TShirt");
    	  
    	    
    	}
}
