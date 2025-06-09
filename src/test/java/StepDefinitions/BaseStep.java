package StepDefinitions;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import POJO.User;
import PageObject.BDD_AddCart;
import PageObject.BDD_GuestPageRegistration;
import PageObject.BDD_HomePage;
import PageObject.BDD_ItemSelectionPage;
import PageObject.BDD_LoginPage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BaseStep {
	private WebDriver driver = DriverFactory.getDriver();
	private final Logger log = LogManager.getLogger(this.getClass().getName()); 
   protected  BDD_ItemSelectionPage ISP = new BDD_ItemSelectionPage(driver);
   protected BDD_GuestPageRegistration GR = new BDD_GuestPageRegistration(driver);
   protected  BDD_LoginPage LP = new BDD_LoginPage(driver);
   protected BDD_AddCart AC = new BDD_AddCart(driver);
    @DataTableType
    public User convertToUser(Map<String, String> row) {
        return new User(row.get("Email"), row.get("Password"));
    }
    //valid credentials
    @Given("User on hompage and navigates to sign in tab")
    public void user_on_hompage_and_navigates_to_sign_in_tab() {
    	 
    	 BDD_HomePage HP = new BDD_HomePage(driver);
         HP.signin();
     }
     @When("User enters user details")
     public void user_enters_user_details(io.cucumber.datatable.DataTable dataTable) {
    	 List<User> users = dataTable.asList(User.class);
         User email = users.getFirst();
         User password = users.getLast();
         LP.SetEmail(email);
         LP.SetPassword(password);
         LP.btn_signin();
      }
     @Then("User verfies {string} on navigation bar")
     public void user_verfies_on_navigation_bar(String message) {
    	 
    	 String msg = LP.verf_logininMsg();
         assertTrue(msg.contains(message));//welcome
     }
     //item selection
     @When("User selects the item")
 	public void user_selects_the_item() {
 		 ISP.Drpdwn_women();
         ISP.CategorySelection();
         ISP.Style_filter();
         ISP.style_select();
         ISP.item_selection();
         ISP.select_size();
         ISP.select_color();
        // ISP.addTocart();
         log.info("item selected and added to cart");
 	}
     
     //Add to cart
     @Then("User checks {string} message")
 	public void user_checks_message(String message) {
 		String text = AC.Verf_confmsg();
 		assertEquals(message,text);//"thank you for ur purchase msg"
 		
 	}
     @When("AddtoCart and do the payment")
     public void addto_cart_and_do_the_payment() {
   	     ISP.addTocart();
    	 String msg = ISP.verf_addcartmsg();
 		 assertTrue(msg.contains("You added"));
    	 AC.tab_addtocart();
         AC.btn_proceedcheckout();
         AC.ShippingType();
         AC.btn_Next();
         AC.btn_addresscheck();
         AC.btn_placeOrder();
        // log.info("sucessfully order got placed");
     }
 	@When("User presses Continue shopping")
 	public void user_presses_continue_shopping() {
 		AC.btn_conshp();
 	}
 	@Then("HomePage should be visible")
     public void home_page_should_be_visible() {
 		String text = AC.verf_homepage();
 		assertEquals("Home Page",text);
    	log.info("Home Page Verified");
    	 
     }
 	
 	
     
      
    
}
