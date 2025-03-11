package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	private ExtentReports extent;
	
	public ExtentReports getInstance() {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\ASUS\\git\\Bank-Portal-Project---Data-Driven-Framework\\src\\test\\resources\\reports\\ExtentReports.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		return extent;
	}
}
