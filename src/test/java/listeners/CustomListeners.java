package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.TestBase;
import utilities.TestUtil;

public class CustomListeners implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		takeScreenshot(result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

		System.setProperty("org.uncommons.reportng.escape-output", "false");

		try {
			TestUtil.caturingScreenshots();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Screenshot Evidence");
		Reporter.log("<br>");
		Reporter.log("<a href=" + TestUtil.screenshotName + "  target=\"_blank\" >Screenshot</a>");

	}

	public void takeScreenshot(String testcase) {
		
		try {
		File screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				"C:\\Users\\ASUS\\git\\Bank-Portal-Project---Data-Driven-Framework\\src\\test\\resources\\screenshots\\"
						+ testcase + ".png");
		
		FileUtils.copyFile(screenshot, destFile);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}
}
