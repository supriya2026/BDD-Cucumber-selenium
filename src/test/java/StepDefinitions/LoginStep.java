package StepDefinitions;

import static org.junit.Assert.assertEquals;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import POJO.Guest;
import POJO.Guest1;
import POJO.User;
import PageObject.BDD_AccountPage;
import PageObject.BDD_AddCart;
import PageObject.BDD_ForgotPasswordPage;
import PageObject.BDD_GuestPageRegistration;
import PageObject.BDD_HomePage;
import PageObject.BDD_ItemSelectionPage;
import PageObject.BDD_LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStep {
	
	private WebDriver driver = DriverFactory.getDriver();
	private BaseStep BS = new BaseStep();
	private final Logger log = LogManager.getLogger(this.getClass().getName());
	BDD_ItemSelectionPage ISP = new BDD_ItemSelectionPage(driver);
	BDD_AddCart AC = new BDD_AddCart(driver);
	BDD_LoginPage LP = new BDD_LoginPage(driver);
	BDD_AccountPage AP = new BDD_AccountPage(driver);
    BDD_GuestPageRegistration GR = new BDD_GuestPageRegistration(driver);
	@DataTableType
	   public Guest1 convertGuest(Map<String, String> row) {
	       Guest1 guest = new Guest1();
	       guest.setAddress(row.get("address"));
	       guest.setCity(row.get("city"));
	       guest.setState(row.get("state"));
	       guest.setZipcode(row.get("zipcode"));
	       guest.setPhone(row.get("phone"));
	       return guest;
	   }
	//valid credentials
     /*@Then("User verfies {string} on navigation bar")
     public void user_verfies_on_navigation_bar(String message) {
    	 
    	 String msg = LP.verf_logininMsg();
         assertTrue(msg.contains(message));//welcome
     }*/
     @When("User presses signout button using {string} on navigation bar")
     public void user_presses_signout_button_using_on_navigation_bar(String link_txt) {
         LP.drp_accountmenu();
         LP.btn_signout();
     }
     @Then("{string} message should be displayed")
     public void message_should_be_displayed(String message) {
    	 String msg = LP.verf_SignoutMsg();
         assertEquals("You are signed out",msg);//logout message
         log.info("Logout message verified");
     }
     @Then("Redirected to HomePage")
     public void redirected_to_home_page() {
    	 AC.verf_homepage();
         System.out.println("HomePage Verified");
     }
     //invalid credentials
     @When("User enters invalid user details")
     public void user_enters_invalid_user_details(io.cucumber.datatable.DataTable dataTable) {
    	 List<User> users = dataTable.asList(User.class);
         User email = users.getFirst();
         User password = users.getLast();
        	 
         BDD_LoginPage LP = new BDD_LoginPage(driver);
         LP.SetEmail(email);
         LP.SetPassword(password);
         LP.btn_signin();
     }
     @Then("Error message showing {string} should display")
     public void error_message_showing_should_display(String text) {
         String msg = LP.verf_invalidmessage();
         assertTrue(msg.contains(text));//error message
     }
     @Then("LoginPage should be visible")
     public void login_page_should_be_visible() {
    	 BDD_ForgotPasswordPage FP = new BDD_ForgotPasswordPage(driver);
    	 String text = FP.Verf_loginpage();
         assertEquals("Customer Login",text);
     
     }
     //login and add to cart first time after registration
     @When("User selects item")
     public void user_selects_item() {
    	 ISP.Drpdwn_women();
    	 BS.user_selects_the_item();
     }
    /* @Then("User verifies {string} page")
     public void user_verifies_page(String text) {
         String message =  AP.verf_MyAccount();
         assertEquals(text,message);//My account page
     }*/
     @When("User fills in shipping details")
     public void user_fills_in_shipping_details(io.cucumber.datatable.DataTable dataTable) {
         List<Guest1> user = dataTable.asList(Guest1.class);
         Guest1 guest = user.get(0);
         String address = guest.getAddress();
         String city = guest.getCity();
         String state = guest.getState();
         String zipcode = guest.getZipcode();
         String phone = guest.getPhone();
         GR.Country();
         GR.SetAddress(address);
         GR.SetCity(city);
         GR.State(state);
         GR.SetZipCode(zipcode);
         GR.SetPhone(phone);
         log.info("User entered details");
         // shipping method
         AC.ShippingType();
         AC.btn_Next();
         
       }
  



    





}
