package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.ElementUtils;


public class BDD_ShoppingCart extends BDD_BasePage1 {
   public BDD_ShoppingCart(WebDriver driver) {
	   super(driver);
   }
   @FindBy(xpath="//div[@class='page-title-wrapper' and contains(.,'Shopping Cart')]") WebElement verf_ShpCart;
 
   @FindBy(xpath="(//span[normalize-space()='View and Edit Cart'])[1]\r\n") WebElement btn_viewEditCart;
   @FindBy(id="cart-808446-qty") WebElement box_itemqty;
   @FindBy(xpath="(//a[@title='Edit item parameters'])[1]") WebElement btn_editcart;
   @FindBy(xpath="//a[@class='action action-delete']") WebElement btn_delcart;
   @FindBy(xpath="//button[@title='Update Shopping Cart']") WebElement btn_updatecart;
   @FindBy(xpath="//span[normalize-space()='Move to Wishlist']") WebElement link_wishlist;
 
 
   //@FindBy(xpath="//div[@class='cart-empty']/p[1]") WebElement verf_emptycartmsg;
   //@FindBy(xpath="//div[@class='cart-empty']/p[2]/a") WebElement link_continueshp;

public String verf_Shpcart() {
	 return ElementUtils.TryCatchBlock(verf_ShpCart);
}
}