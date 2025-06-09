package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.ElementUtils;

public class BDD_ItemSelectionPage extends BDD_BasePage1 {
     public BDD_ItemSelectionPage(WebDriver driver) {
    	 super(driver);
     }
     @FindBy(xpath="//span[contains(.,'Women')]") WebElement Dropdown_Women;
    // @FindBy(xpath="//a[text()='Tops']") WebElement Dropdown_Tops;
    // @FindBy(xpath="//a[.='Hoodies & Sweatshirts']") WebElement catselection_Hoodies;
     @FindBy(xpath="//div[@class='categories-menu']//li[contains(.,'Hoodies & Sweatshirts')]") WebElement catselection_Hoodies;
   
     @FindBy(xpath="//div[.='Style']") WebElement dropdown_style;
     @FindBy(xpath="//div[@class='filter-options-content']//li[contains(.,'Pullover')]") WebElement filter_style;
     @FindBy(xpath="//select[@id=\"sorter\"]") WebElement drpdwn_sortby;
     @FindBy(xpath="//ol[@class='products list items product-items']/li[2]") WebElement item_selection;
     @FindBy(xpath="//div[@option-id='167']") WebElement size_selection;
     @FindBy(xpath="(//div[@class='swatch-option color'])[1]") WebElement  color_selection;
     //@FindBy(xpath="//div[@option-id='53']") WebElement  color_selection;
     @FindBy(id="product-addtocart-button") WebElement  btn_addCart;
     @FindBy(xpath="//div[@class='messages' and contains(.,'You added')]") WebElement  verf_addCart;
   
     
     public void Drpdwn_women() {
    	 ElementUtils.ActionForElement(driver, Dropdown_Women);
     }
    /* public void Drpdwn_Tops() {
    	 ElementUtils.ActionForElement(driver, Dropdown_Tops);
     }*/
     public void CategorySelection() {
    	 catselection_Hoodies.click();
     }
     public void Style_filter() {
    	 dropdown_style.click();
     }
     public void style_select() {
    	 filter_style.click();
     }
     public void sortBy_price() {
    	 ElementUtils.SelectDropDown(drpdwn_sortby,"Price");
     }
     public void item_selection() {
    	 item_selection.click();
     }
     public void select_size() {
    	 size_selection.click();
     }
     public void select_color() {
    	 color_selection.click();
     }
     public void addTocart() {
    	ElementUtils.WaitForElement(driver, btn_addCart, 5);
    	 btn_addCart.click();
     }
     public String verf_addcartmsg() {
    	 //ElementUtils.TryCatchBlock(verf_addCart);
    	 try {
    		 return verf_addCart.getText();
    	 }catch(Exception e) {
    		 return e.getMessage();
    	 }
    }
     
     
}
