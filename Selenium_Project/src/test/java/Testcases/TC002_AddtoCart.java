package Testcases;

import org.testng.annotations.Test;

import Pages.Cart;
import Pages.Homepage;
import Pages.Productpage;
import Utility.Base;

public class TC002_AddtoCart extends Base

{
  @Test
  public static void AddtocartProduct()throws Exception
  {
	    Homepage.ClickProduct();
	    Productpage product = new Productpage();
	    product.isAllProductsPageVisible();
	    product.searchForProduct("TShirt");
	    product.Addtocart();
	    product.VerifyPriceAndName();
  }
}
