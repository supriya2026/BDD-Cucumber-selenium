package AppHooks;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mortbay.log.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import DriverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
//import testCases.BasePageTest;
import utility.BDD_ExtentReportManager;

public class Hooks {
     
	public Logger logger;
	public static ExtentReports extent = BDD_ExtentReportManager.getExtentReports();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	//private WebDriver driver = ;
     @Before(order=1)
     public void setup() throws IOException {
    	 logger=LogManager.getLogger(this.getClass());
    	 DriverFactory df =  new DriverFactory();
    	 String browser = System.getProperty("browser","chrome");
    	 df.init_driver(browser);
    	DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/");
    	 //driver.get("https://parabank.parasoft.com/parabank/index.htm");
    	DriverFactory.getDriver().manage().window().maximize();
    	DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	
	}
     @Before(order=2)
     public void BeforeScenario(Scenario scenario) {
    	 test.set(extent.createTest(scenario.getName()));
    	 logger.info("Scenario test started: {}", scenario.getName());
     }
    
     @After(order=2)
      public void AfterScenario(Scenario scenario) throws IOException{
    	 if (scenario.isFailed()) {
    		 String screenshotPath = captureScreenshot(scenario.getName());
             test.get().fail("Scenario failed. Screenshot attached.")
			         .addScreenCaptureFromPath(screenshotPath);
             logger.error("Scenario failed: {}", scenario.getName());
         } else {
             logger.info("Scenario passed: {}", scenario.getName());
         }
    	 extent.flush();}
     @After(order=1)
     public void TearDown(Scenario scenario) {
    	 DriverFactory.getDriver().quit();
    	 logger.info("Driver closed");}
    

     public String captureScreenshot(String scenarioName) {
         
             TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
             File source = ts.getScreenshotAs(OutputType.FILE);
             String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
             String fileName = System.getProperty("user.dir") + "\\screenshots\\"+ scenarioName + "_" + timestamp + ".png";
             File destination = new File(fileName);
             try {
             FileUtils.copyFile(source, destination);
             System.out.println("Screenshot saved to: " + fileName);
            
         } catch (IOException e) {
             e.printStackTrace();
         }
         return fileName;
     }
}
