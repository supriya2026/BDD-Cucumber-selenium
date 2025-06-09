package DriverFactory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
       public static WebDriver driver;
       public Properties p;
       public static ThreadLocal<WebDriver> TLDriver = new ThreadLocal<>();
       public void init_driver(String browser) throws IOException {
    	   FileReader file = new FileReader("./src//test//resources/config.properties");
   		   p = new Properties();
   		   p.load(file);
          //if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
   			     
   			     if(browser.equalsIgnoreCase("chrome")) {
   			    	//System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
   			    	 WebDriver d = new ChromeDriver();
   			    	 TLDriver.set(d);
   			     }
   			     else if(browser.equalsIgnoreCase("firefox")) {
   			    	System.setProperty("webdriver.firefox.driver", "path/to/firefoxdriver");
   			    	 TLDriver.set(new FirefoxDriver());
   			     }
   			     else if(browser.equalsIgnoreCase("edge")) {
   			    	//System.setProperty("webdriver.edge.driver", "path/to/edgedriver");
   			    	 TLDriver.set(new EdgeDriver());
   			     }
   			     else {
   			    	 System.out.println("Please give correct browser" + browser);
   			     }
   			     
   			//}
            // getDriver().manage().deleteAllCookies();
		    // getDriver().manage().window().maximize();
		     //return getDriver();
		     
       }
     //this method gets the driver with threadlocal (sync if more threads r there)
   			public static  WebDriver getDriver() {
   			      System.out.println(TLDriver.get());
   			      return (TLDriver.get());
       }
}
