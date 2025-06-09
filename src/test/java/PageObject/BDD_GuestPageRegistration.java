package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import POJO.Guest1;
import utility.ElementUtils;

public class BDD_GuestPageRegistration extends BDD_BasePage1{
     public BDD_GuestPageRegistration(WebDriver driver) {
    	 super(driver);
     }
     @FindBy(id="customer-email") WebElement tx_email;
     @FindBy(xpath="//input[@name='firstname']") WebElement txt_Firstname;
     @FindBy(xpath="//input[@name='lastname']") WebElement txt_Lastname;
     @FindBy(xpath="//input[@name='street[0]']") WebElement txt_Address;
     @FindBy(xpath="//input[@name='city']") WebElement txt_city;
     @FindBy(xpath="//select[@name='country_id']") WebElement Dropdown_Country_US;
     @FindBy(xpath="//select[@name='region_id']") WebElement Drpdwn_state;
     @FindBy(xpath="//input[@name='postcode']") WebElement txt_zipcode;
     @FindBy(xpath="//input[@name='telephone']") WebElement txt_phone;
     
     @FindBy(xpath="//a[@class='action primary']//span[contains(text(),'Create an Account')") WebElement btn_createAccount;
     
     
     public void SetEmail(String email) {
    	 ElementUtils.WaitForElement(driver, tx_email,5);
    	 tx_email.sendKeys(email);
     }
     public void SetFirstName(String Firstname) {
    	 txt_Firstname.sendKeys(Firstname);
     }
     public void SetLastName(String Lastname) {
    	 txt_Lastname.sendKeys(Lastname);
     }
     public void Country() {
    	 ElementUtils.SelectDropDown(Dropdown_Country_US,"United States");
     }
     public void SetAddress(String Address) {
    	 txt_Address.sendKeys(Address);
     }
     public void SetCity(String city) {
    	 txt_city.sendKeys(city);
     }
     
     public void State(String state) {
    	 ElementUtils.WaitForElement(driver, Drpdwn_state,5);
    	 ElementUtils.SelectDropDown(Drpdwn_state,state);
     }
     public void SetZipCode(String zipcode) {
    	 txt_zipcode.sendKeys(zipcode);
     }
     public void SetPhone(String Phone) {
    	 txt_phone.sendKeys(Phone);
     }
     //shipping type
     
     //or to create account
     public void btn_createAccount() {
    	 btn_createAccount.click();
     }
     
   
   
     
}
