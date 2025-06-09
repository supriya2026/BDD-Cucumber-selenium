package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BDD_ForgotPasswordPage extends BDD_BasePage1 {
   public BDD_ForgotPasswordPage(WebDriver driver) {
	   super(driver);
   }
   @FindBy(id="email_address") WebElement txt_email;
   @FindBy(xpath="//span[normalize-space()='Reset My Password']") WebElement btn_ResetPassword;
   @FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']") WebElement verf_msg;
   @FindBy(xpath="(//span[@class='base'])[1]") WebElement verf_customerloginpage;
 
   public void SetEmail(String email) {
	   txt_email.sendKeys(email);
   }
   public void btn_resetpswd() {
	   btn_ResetPassword.click();
   }
   public String verf_linkmsg() {
	   try {
		   return (verf_msg.getText());
	   }catch(Exception e) {
		   return e.getMessage();
	   }
   }
   public String Verf_loginpage() {
	   try {
		   return (verf_customerloginpage.getText());
	   } catch(Exception e) {
		   return e.getMessage();
	   }
   }
 
   
}
