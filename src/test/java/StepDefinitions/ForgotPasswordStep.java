package StepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
//import POJO.User;
import PageObject.BDD_ForgotPasswordPage;
import PageObject.BDD_HomePage;
import PageObject.BDD_LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordStep {
    private WebDriver driver = DriverFactory.getDriver();
   
    BDD_ForgotPasswordPage FP = new BDD_ForgotPasswordPage(driver);
    
    @Given("User clicks forgot password link on login page")
    public void user_clicks_forgot_password_link_on_login_page() {
    	BDD_HomePage HP = new BDD_HomePage(driver);
        BDD_LoginPage LP = new BDD_LoginPage(driver);
        HP.signin();
        LP.btn_forgorpassword();
    }
   
    @When("User navigates to forgot password page enters {string} and clicks reset password button")
    public void user_navigates_to_forgot_password_page_enters_and_clicks_reset_password_button(String email) {
          FP.SetEmail(email);
          FP.btn_resetpswd();
    }
    @Then("Login Page should be visible")
    public void login_page_should_be_visible() {
        String text = FP.Verf_loginpage();
        assertEquals("Customer Login",text);
    }
    @Then("A confirmation mail should be displayed on login page with the {string} address")
    public void a_confirmation_mail_should_be_displayed_on_login_page_with_the_address(String email) {
        String msg = FP.verf_linkmsg();
        assertTrue(msg.contains(email),"Email not found in Confirmation message");
    }


}
