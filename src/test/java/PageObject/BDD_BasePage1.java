package PageObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import DriverFactory.DriverFactory;

public class BDD_BasePage1 {
	WebDriver driver = DriverFactory.getDriver();
    public BDD_BasePage1(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver,this);
    }
	
	 
	
}
