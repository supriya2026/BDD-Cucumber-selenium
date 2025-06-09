package StepDefinitions;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import PageObject.BDD_ItemSelectionPage;
import PageObject.BDD_Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStep {
	private WebDriver driver = DriverFactory.getDriver();
	private Logger log;
	BaseStep BS = new BaseStep();
	BDD_Product prod = new BDD_Product(driver);
	BDD_ItemSelectionPage ISP = new BDD_ItemSelectionPage(driver);
	@Given("User enters {string} in search bar")
    public void user_enters_in_search_bar(String string) {
	    log = LogManager.getLogger(this.getClass().getName());
	    prod.btn_Search();
	    
	}
	@Given("User selects the item category from dropdown menu")
	public void user_selects_the_item_category_from_dropdown_menu() {
	    prod.drpdown_womenshirt();
	}
	@When("User selects the product")
	public void user_selects_the_product() {
		    ISP.item_selection();
	        ISP.select_size();
	        ISP.select_color();
	        
	        //log.info("item selected and added to cart");
	}
	//Product to WishList
	@When("User clicks Add to WishList link")
	public void user_clicks_add_to_wish_list_link() {
	    prod.btn_addWishList();
	    log.info("product added to wish list");
	  //  prod.btn_delfromWishList();
	}
	@Then("User checks {string}")
	public void user_checks(String message) {
	   String text= prod.verf_wishList();
	   assertEquals(message,text);
	   
	    
	}
	//product to compare List
	@When("User clicks Add to compare link")
	public void user_clicks_add_to_compare_link() {
	    prod.btn_addToCompare();
	    log.info("product added to compare List ");
	    //String text= prod.verfAddCompareMsg();
		//   assertEquals("added product",text);
		prod.link_CompareList();
		
		
	}
	@Then("User verifies {string}")
	public void user_verifies(String message) {
		  String text =  prod.verfCompProdsMsg();
		   assertEquals(message,text);
		log.info("product added to compare list");
	    
	}



}
