package PageObject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementUtils;

public class BDD_AddCart extends BDD_BasePage1{
     public BDD_AddCart(WebDriver driver) {
    	 super(driver);
     }
     
     @FindBy(xpath="//a[contains(.,'My Cart')]") WebElement tab_cart;
     @FindBy(xpath="(//strong[@class='subtitle empty'])[1]") WebElement msg_cart;
  
    // @FindBy(xpath="//span[@class='counter qty empty']/span[1]") WebElement verf_emptyornotcart;
     @FindBy(id="top-cart-btn-checkout") WebElement btn_prcdtocheckout;
     @FindBy(xpath="//input[@name='ko_unique_1']") WebElement btn_shpmthd;
     @FindBy(xpath="//button[contains(.,'Next')]") WebElement btn_next;
     //@FindBy(id="discount-code") WebElement txt_promo;
     //@FindBy(xpath="//button[contains(.,'Apply Discount')]") WebElement btn_applyDiscount;
     @FindBy(xpath="//input[@id='billing-address-same-as-shipping-checkmo']") WebElement btn_Addresscheck;
     @FindBy(xpath="//button[@title='Place Order']") WebElement btn_placeorder;
     @FindBy(xpath="//span[text()='Thank you for your purchase!']") WebElement verf_msg;
     @FindBy(xpath="//span[text()='Continue Shopping']") WebElement btn_continueshp;
     @FindBy(xpath="//h1[contains(.,'Home Page')]") WebElement verf_homepage;
     //empty cart
     @FindBy(xpath="(//a[@title='Remove item'])[1]") WebElement btn_remove;
     @FindBy(xpath="//button[@class='action-primary action-accept']") WebElement alert_delconf;
     @FindBy(xpath="(//strong[@class='subtitle empty'])[1]") WebElement verf_emptycartmsg;
     //view and edit btn
     
   
   public void tab_addtocart() {
	   ElementUtils.WaitForElement(driver,tab_cart,7);
	   tab_cart.click();
   }
  
   public void msg_cartt() {
	   if(msg_cart.getText().equals("You have no items in your shopping cart.")) {
		   ElementUtils.WaitForElement(driver,tab_cart,5);
		   tab_cart.click();
		   System.out.println("hi");
	   }
	   else {
		   
		   System.out.println("hello");
		   tab_cart.click();
	   }
	  
   }
   public void btn_proceedcheckout() {
	   btn_prcdtocheckout.click();
   }
   public void ShippingType() {
  	 btn_shpmthd.click();
   }
   public void btn_Next() {
  	 btn_next.click();
   }
   public void btn_addresscheck() {
	    // ElementUtils.WaitForElement(driver, btn_Addresscheck, 3);
	  	 if(btn_Addresscheck.isSelected() == false) {
	  		btn_Addresscheck.click();
	  	 }
	  	 
	   }
   public void btn_placeOrder() {
	 ElementUtils.WaitForElement(driver, btn_placeorder, 5);
  	 btn_placeorder.click();
   }
   public String Verf_confmsg() {
  	 return ElementUtils.TryCatchBlock(verf_msg);
   }
   //to continue shopping
   public void btn_conshp() {
  	 btn_continueshp.click();
   }
 //homepage verification 
   public String verf_homepage() {
  	 return ElementUtils.TryCatchBlock(verf_homepage);
   }
   //Remove item
   public void btn_Remove() {
	   ElementUtils.WaitForElement(driver, btn_remove, 5);
	   btn_remove.click();
   }
   public void alert_delconfMsg() {
	  // WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	 //  Alert myalert=wait.until(ExpectedConditions.alertIsPresent());
	 //  myalert.accept();
	   ElementUtils.WaitForElement(driver,alert_delconf, 5);
	   alert_delconf.click();
	   
   }
   public String verf_msgEmptyCart() {
	  	 return ElementUtils.TryCatchBlock(verf_emptycartmsg);
	   }
 /*  public void link_CtnShp() {
		// ElementUtils.WaitForElement(driver, btn_placeorder, 5);
	   link_continueshp.click();
	   }*/
}
