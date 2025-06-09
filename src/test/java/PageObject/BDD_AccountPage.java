package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.ElementUtils;

public class BDD_AccountPage extends BDD_BasePage1 {
     public BDD_AccountPage(WebDriver driver) {
    	 super(driver);
     }
     @FindBy(xpath="//li[@class='customer-welcome active' ]//li[contains(.,'My Account')]") WebElement btn_Myaccount;
   
     @FindBy(xpath="//span[text()='My Account']") WebElement verf_myaccount;
     @FindBy(xpath="//div[text()='Thank you for registering with Main Website Store.']")
	public WebElement verf_confmessage;
     @FindBy(xpath="//div[@id='block-collapsible-nav']//li[2]") WebElement btn_Myorder;
     @FindBy(xpath="//div[@class='page-title-wrapper' and contains(.,'My Orders')]") WebElement verf_Myorders;
     @FindBy(xpath="//table[@id='my-orders-table']/tbody/tr[1]/td[6]/a[1]") WebElement btn_vieworder;
     @FindBy(xpath="//div[@class='page-title-wrapper' and contains(.,'Order # ')]") WebElement verf_OrderNum;
     @FindBy(xpath="//table[@id='my-orders-table']/tbody/tr[1]/td[6]/a[2]") WebElement btn_reorder;
    
     public void btn_MyAccount() {
    	 btn_Myaccount.click();
     }
     public String verf_MyAccount() {
    	 return ElementUtils.TryCatchBlock(verf_myaccount);
     }
     public String confmsg() {
    	 return ElementUtils.TryCatchBlock(verf_confmessage);
     }
     public void btn_myorder() {
    	 btn_Myorder.click();
     }
     public String verf_myorders() {
    	 return ElementUtils.TryCatchBlock(verf_Myorders);
     }
     public void btn_vieworder() {
    	 btn_vieworder.click();
     }
     public String verf_ordernum() {
    	 return ElementUtils.TryCatchBlock(verf_OrderNum);
     }
     public void btn_reOrder() {
    	 btn_reorder.click();
     }
}
