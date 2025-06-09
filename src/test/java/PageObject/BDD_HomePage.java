package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

public class BDD_HomePage extends BDD_BasePage1{
	public BDD_HomePage(WebDriver driver) {
		   super(driver);
	   }
	   @FindBy(xpath="//ul[@class='header links']//li[2]") WebElement btn_signin;
	   @FindBy(xpath="//ul[@class='header links']//li[3]") WebElement btn_create_account;
	   
	     
	   
	   public void signin() {
		   btn_signin.click();
	   }
	   public void create_account() {
		   btn_create_account.click();
	   }
}
