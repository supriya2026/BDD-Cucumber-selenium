package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.ElementUtils;

public class BDD_Product extends BDD_BasePage1{
      public BDD_Product(WebDriver driver) {
    	  super(driver);
      }
      //search
      @FindBy(xpath="//input[@id='search']") WebElement btn_search;
      @FindBy(xpath="//div[@id='search_autocomplete']//li[5]") WebElement drpdown_wmntshirt;
      @FindBy(xpath="(//a[@title='Edit item parameters'])[1]") WebElement btn_editcart;
      @FindBy(xpath="(//span[contains(text(),'Add to Wish List')])[1]") WebElement btn_addtoWishList;
      @FindBy(xpath="//div[@class='page-title-wrapper' and contains(.,'My Wish List')]") WebElement verf_wishlist;
      @FindBy(xpath="//div[@class='products-grid wishlist']//li[2]//a[@title='Remove Item']") WebElement btn_removefrmWisshList;
      @FindBy(xpath="//div[@class='page messages' and contains(.,'removed from your Wish List')]") WebElement verf_delfromwishlist;
      
      @FindBy(xpath="//div[@class='product-addto-links']/a[2]") WebElement btn_addtoCompare;
      @FindBy(xpath="//div[@class='page messages' and contains(.,'added product')]") WebElement verf_addcomparemsg;
      @FindBy(xpath="//div[@class='page messages' ]//a") WebElement link_compList;
      @FindBy(xpath="//div[@class='page-title-wrapper' and contains(.,'Compare')]") WebElement verf_CompareProducts;
    
    
      public void btn_Search() {
    	  btn_search.sendKeys("Women");
      }
      public void drpdown_womenshirt() {
    	  drpdown_wmntshirt.click();
      }
      public void btn_addWishList() {
    	  btn_addtoWishList.click();
      }
      public String verf_wishList() {
    	  return ElementUtils.TryCatchBlock(verf_wishlist);
      }
      public void btn_delfromWishList() {
    	  btn_removefrmWisshList.click();
      }
      public String verf_delfromWishList() {
    	  return ElementUtils.TryCatchBlock(verf_delfromwishlist);
      }
      public void btn_addToCompare() {
    	  btn_addtoCompare.click();
      }
      public String verfAddCompareMsg() {
    	  return ElementUtils.TryCatchBlock(verf_addcomparemsg);
      }
      public void link_CompareList() {
    	  link_compList.click();
      }
      public String verfCompProdsMsg() {
    	  return ElementUtils.TryCatchBlock(verf_CompareProducts);
      }
}
