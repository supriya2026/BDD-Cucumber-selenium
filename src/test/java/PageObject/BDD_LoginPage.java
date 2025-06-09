package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import POJO.User;
import utility.ElementUtils;

public class BDD_LoginPage extends BDD_BasePage1 {
    public BDD_LoginPage(WebDriver driver) {
    	super(driver);
    }
    @FindBy(xpath="//input[@id='email']") WebElement txt_email;
    @FindBy(xpath="//input[@name='login[password]']") WebElement txt_password;
    @FindBy(xpath="//button[.='Sign In']") WebElement btn_signin;
    @FindBy(xpath="//a[@class='action remind']//span[text()='Forgot Your Password?']") WebElement btn_forgotpswd;
    @FindBy(xpath="//a[@class='action create primary']//span[text()='Create an Account']") WebElement btn_createAccount;
    @FindBy(xpath="//div[@class='messages' and contains(.,'account sign-in was incorrect')]") WebElement verf_invalidmsg;
    @FindBy(xpath="//div[@class='panel header']//span[@class='logged-in' and contains(.,'Welcome')]") WebElement verf_loginmsg;
    @FindBy(xpath="//div[@class='panel header']//button") WebElement drpdown_account;
    @FindBy(xpath="//li[@class='customer-welcome active' ]//li[@class='authorization-link' and contains(.,'Sign Out')]") WebElement btn_signout;
    @FindBy(xpath="//h1[contains(.,'You are signed out')]") WebElement verf_Signoutmsg;
  
    public void SetEmail(User user) {
    	txt_email.sendKeys(user.getEmail());
    }
    public void SetPassword(User user) {
    	txt_password.sendKeys(user.getPassword());
    }
    public void btn_signin() {
    	btn_signin.click();
    }
    public void btn_forgorpassword() {
    	btn_forgotpswd.click();
    }
    
    public void btn_createaccount() {
    	btn_createAccount.click();
    }
    public String verf_invalidmessage() {
    	return ElementUtils.TryCatchBlock(verf_invalidmsg);
    	
    }
    public String verf_logininMsg() {
    	return ElementUtils.TryCatchBlock(verf_loginmsg);
    }
    public void drp_accountmenu() {
    	drpdown_account.click();
    }
    public void btn_signout() {
    	btn_signout.click();
    }
    
    public String verf_SignoutMsg() {
    	ElementUtils.WaitForElement(driver,verf_Signoutmsg, 6);
    	return ElementUtils.TryCatchBlock(verf_Signoutmsg);
    }
    
  
}
