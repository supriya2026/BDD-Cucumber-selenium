package StepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import PageObject.BDD_AccountPage;
import PageObject.BDD_LoginPage;
import PageObject.BDD_ShoppingCart;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountStep {
	private WebDriver driver = DriverFactory.getDriver();
	private Logger log;
	BaseStep BS = new BaseStep();
	BDD_AccountPage AP = new BDD_AccountPage(driver);
	BDD_LoginPage LP = new BDD_LoginPage(driver);
	BDD_ShoppingCart SC = new BDD_ShoppingCart(driver);
	
	@When("User logins and navigates to My Account in  profile dropdown menu")
	public void user_logins_and_navigates_to_my_account_in_profile_dropdown_menu() {
		log = LogManager.getLogger(this.getClass().getName());
	    LP.drp_accountmenu();
		AP.btn_MyAccount();
	    
	}
	//My Account Page
	@Then("User verifies {string} title")
	public void user_verifies_title(String msg) {
	    String text = AP.verf_MyAccount();
	    assertEquals(msg,text);
	    log.info("My account Page verified");
	}
	//My order page
	@When("User Clicks My order tab")
	public void user_clicks_my_order_tab() {
	    AP.btn_myorder();
	    
	   
	}
	@Then("User verifies {string} myorders title")
	public void user_verifies_myorders_title(String msg) {
		String text = AP.verf_myorders();
	    assertEquals(msg,text);
	    log.info("My order Page verified");
	}
	//view order
	@When("User Clicks view order link")
	public void user_clicks_view_order_link() {
	    AP.btn_vieworder();
	}
	@Then("User verifies  order page")
	public void user_verifies_order_page() {
		String text = AP.verf_ordernum();
		assertEquals("Order ",text);
	   // assertTrue(text.contains("Order #"));
	    log.info("view order is verified");
	}
	//reorder
	@When("User Clicks reorder link")
	public void user_clicks_reorder_link() {
	    AP.btn_reOrder();
	}
	@Then("redirected to Shopping Cart page")
	public void redirected_to_shopping_cart_page() {
		String text = SC.verf_Shpcart();
	    assertEquals("Shopping Cart",text);
	    log.info("Reorder is verified");
	}







}
