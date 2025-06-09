package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BDD_RegistrationPage extends BDD_BasePage1 {
	public BDD_RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
   @FindBy(xpath="//input[@id='firstname']") WebElement txt_firstname;
   @FindBy(xpath="//input[@id='lastname']") WebElement txt_lastname;
   @FindBy(xpath="//input[@id='email_address']") WebElement txt_email;
   @FindBy(xpath="//input[@id='password']") WebElement txt_password;
   @FindBy(xpath="//input[@id='password-confirmation']") WebElement txt_confpassword;
   @FindBy(xpath="//button[.='Create an Account']") WebElement btn_createAccount;
   
   public void setFirstName(String firstname) {
	   txt_firstname.sendKeys(firstname);
	   
   }
   public String  getFirstName() {
	   return (txt_firstname.getText());
	   
   }
   public void setLastName(String lastname) {
	   txt_lastname.sendKeys(lastname);
	   
   }
   public void setEmail(String email) {
	   txt_email.sendKeys(email);
	   
   }
   public void setpassword(String password) {
	   txt_password.sendKeys(password);
	   
   }
   public void setconfpswd(String pswd) {
	   txt_confpassword.sendKeys(pswd);
	   
   }
   public void createAccount() {
	   btn_createAccount.click();
	   
   }
}
