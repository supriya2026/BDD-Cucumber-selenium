package AppHooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class ScreenshotHooks {
	public Logger logger;
	WebDriver driver = DriverFactory.getDriver();
	public ScreenshotHooks(WebDriver driver) {
        this.driver = driver;
    }
	public String captureScreenshot(String scenarioName) {
        
        TakesScreenshot ts = (TakesScreenshot) driver;
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
/*
    // After hook to take screenshot when a scenario fails
    @After
    public void takeScreenshot(Scenario scenario) {
	if (scenario.isFailed()) {
		 /*try {
 		   String imgPath = captureScreen(scenario.getName());
 		   
 		   scenario.attach(targetFilePath, imgPath, scenario.getName());
 		   }
 	   catch(IOException e1) {
 		    e1.printStackTrace();
 	   }
	
	            // Take screenshot and store it as a byte array
	            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
	            // Attach the screenshot to the report (this is an example for Allure, you can change the reporting tool accordingly)
	            scenario.attach(screenshot, "image/png", scenario.getName());
	           // scenario.attach(screenshot, null, null);
	            logger.error("Scenario failed: {}", scenario.getName());
    } else {
        logger.info("Scenario passed: {}", scenario.getName());
    }
    }*/
}
