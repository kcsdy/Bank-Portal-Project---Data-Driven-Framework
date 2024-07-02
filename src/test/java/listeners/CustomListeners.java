package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

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

    		
    public void onTestFailure(ITestResult arg0) {					
        // TODO Auto-generated method stub		
    	
        		
    }		

    		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    		
    public void onTestStart(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

	
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub		
    	
    	System.setProperty("org.uncommons.reportng.escape-output","false");
    
    	try {
			TestUtil.caturingScreenshots();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Reporter.log("Screenshot Evidence");
    	Reporter.log("<br>");
    	Reporter.log("<a href="+TestUtil.screenshotName +"  target=\"_blank\" >Screenshot</a>");
        		
    }		
}
