package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.DriverFactory;

public class ElementUtils {
	//Waittime method
	public static void WaitForElement(WebDriver driver,WebElement element, int timeoutSecs ) {
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeoutSecs));
	   wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void ActionForElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
		
	}
	public static void SelectDropDown(WebElement element, String Text) {
		Select sc = new Select(element);
		sc.selectByVisibleText(Text);
	}
	
	public static String TryCatchBlock(WebElement element) {
		try {
			return (element.getText());
		} catch(Exception e) {
			return e.getMessage();
		}
	}
}
