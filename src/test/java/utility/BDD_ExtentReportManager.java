package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BDD_ExtentReportManager {
	private static final ThreadLocal<ExtentReports> extent = ThreadLocal.withInitial(() -> new ExtentReports());
    //private static final ExtentReports extent = new ExtentReports();
    private static final ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");

    
    public static ExtentReports getExtentReports() {
    	spark.config().setReportName("Cucumber Test Report");
    	spark.config().setDocumentTitle("Automation Report");
    	
    	extent.get().attachReporter(spark);
        return extent.get();
    }
}
