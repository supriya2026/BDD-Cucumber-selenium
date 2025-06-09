package StepDefinitions;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;
import DriverFactory.DriverFactory;
import POJO.Guest;
//import POJO.Guest1;
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
import utility.ElementUtils;

public class AddtoCartStep{
	
	private WebDriver driver = DriverFactory.getDriver();
	private Logger log;
    BaseStep BS = new BaseStep();
	BDD_ItemSelectionPage ISP = new BDD_ItemSelectionPage(driver);
	BDD_GuestPageRegistration GR = new BDD_GuestPageRegistration(driver);
	BDD_LoginPage LP = new BDD_LoginPage(driver);
	BDD_AddCart AC = new BDD_AddCart(driver);
	
   
   @DataTableType
   public Guest convertGuest(Map<String, String> row) {
       Guest guest = new Guest();
       guest.setEmail(row.get("email"));
       guest.setFirstname(row.get("firstname"));
       guest.setLastname(row.get("lastname"));
       guest.setAddress(row.get("address"));
       guest.setCity(row.get("city"));
       guest.setState(row.get("state"));
       guest.setZipcode(row.get("zipcode"));
       guest.setPhone(row.get("phone"));
       return guest;
   }
    //Product add to cart as guest
   
	@Given("User on homepage")
	public void user_on_homepage() {
		log = LogManager.getLogger(this.getClass().getName());
		ISP.Drpdwn_women();
        
	}
	
	@When("AddtoCart")
	public void add_to_cart() {
		//ElementUtils.WaitForElement(driver, ISP.addTocart(), 5);
		String msg = ISP.verf_addcartmsg();
		assertTrue(msg.contains("You added"));
		AC.tab_addtocart();
        AC.btn_proceedcheckout();
        
	}
	@When("User fills shipping details")
	public void user_fills_shipping_details(io.cucumber.datatable.DataTable dataTable) {
	    List<Guest> user = dataTable.asList(Guest.class);
	    System.out.println("gu"+user);
	    Guest guest = user.get(0);
		//System.out.println("Raw table asLists: " + dataTable.asLists());
	  // Guest guest = user.get(0);
	   System.out.println("guest"+guest);
	   String email = guest.getEmail();
	   //System.out.println(email);
	   String firstname = guest.getFirstname();
       String lastname = guest.getLastname();
      // Guest country = user.get(3);
       String Address = guest.getAddress();
       String city = guest.getCity();
       String state = guest.getState();
       String zipcode = guest.getZipcode();
       String phone = guest.getPhone();
       GR.SetEmail(email);
       GR.SetFirstName(firstname);
       GR.SetLastName(lastname);
       GR.Country();
       GR.SetAddress(Address);
       GR.SetCity(city);
       GR.State(state);
       GR.SetZipCode(zipcode);
       GR.SetPhone(phone);
       
       // shipping method
       AC.ShippingType();
       AC.btn_Next();
       log.info("User entered details");
     }
	@When("User does the payment")
	public void user_does_the_payment() {
		 AC.btn_addresscheck();
         AC.btn_placeOrder();
	}
	//Add to cart
	 @Then("User checks {string} message in navigation tab")
     public void user_checks_message_in_navigation_tab(String text) {
       BS.user_verfies_on_navigation_bar(text);
        
     }
     //remove item from cart
     @When("User deletes the item in the cart")
     public void user_deletes_the_item_in_the_cart() {
    	 LP.verf_logininMsg();
    	 AC.tab_addtocart();
    	 //AC.msg_cartt();
         AC.btn_Remove();
         AC.alert_delconfMsg();
         
     }
     @Then("if empty then {string} should be displayed")
     public void if_empty_then_should_be_displayed(String text) {
        String msg = AC.verf_msgEmptyCart();
        assertEquals(text,msg);
        
     }
   /*  @When("User clicks the continue shooping link")
     public void user_clicks_the_continue_shooping_link() {
    	 AC.btn_conshp();
     }*/
    


}
