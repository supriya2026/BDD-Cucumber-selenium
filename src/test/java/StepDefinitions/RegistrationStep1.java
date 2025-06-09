package StepDefinitions;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import DriverFactory.DriverFactory;
import PageObject.BDD_AccountPage;
import PageObject.BDD_HomePage;
import PageObject.BDD_RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utility.ElementUtils;


import org.junit.Assert;


public class RegistrationStep1 { 
	 private WebDriver driver = DriverFactory.getDriver();
	 private Logger log;
	 BDD_AccountPage AP =  new BDD_AccountPage(driver);
	@Given("user goto create an account tab")
	public void user_goto_create_an_account_tab() {
		log = LogManager.getLogger(this.getClass().getName());
	    BDD_HomePage HP = new BDD_HomePage(driver);
	    HP.create_account();
	    	}

	@When("user entered First_Name {string} Last_Name {string} Email {string} Password {string} confirm_password {string}")
	public void user_entered_first_name_last_name_email_password_confirm_password(String firstname, String lastname, String email, String pswd, String confpswd) {
		BDD_RegistrationPage RP = new BDD_RegistrationPage(driver);
		RP.setFirstName(firstname);
		RP.setLastName(lastname);
		RP.setEmail(email);
		RP.setpassword(pswd);
		RP.setconfpswd(confpswd);
		RP.createAccount();
	    
	}

	@Then("user should register successfully")
	public void user_should_register_successfully() {
		
		WebElement msg = AP.verf_confmessage;
		ElementUtils.WaitForElement(driver,msg,5);
		String text = AP.confmsg();
		String message = AP.verf_MyAccount();
		Assert.assertEquals("Thank you for registering with Main Website Store.",text);
		log.info("registeration success message verified");
	    //String title=driver.getTitle();
	    //Assert.assertEquals("My Account",title);
	    
	   // throw new io.cucumber.java.PendingException();
	    
	}
	@Then("Redirected to My Account page")
	public void redirected_to_my_account_page() {
		String message =  AP.verf_MyAccount();
        assertEquals("My Account",message);//My account page
	}




	
}
