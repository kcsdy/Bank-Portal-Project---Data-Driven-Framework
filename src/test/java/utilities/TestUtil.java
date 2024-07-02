package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import base.TestBase;

public class TestUtil extends TestBase{
	
	public static String screenshotPath;
	public static String screenshotName;
	
	public static void caturingScreenshots() throws IOException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		System.out.println(screenshotName);
		
		//screenshotPath = "C:\\Users\\ASUS\\eclipse-workspace\\DataDrivenFrameWork\\target\\surefire-reports\\html\\"+screenshotName;
		
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotName));
	}
	
	@DataProvider
	public Object[][] dp(Method m) {
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table =null;

		// System.out.println(rows);
		// System.out.println(cols);

		// rows=2 //cols=3
		for (int i = 2; i <= rows; i++) {
			table = new Hashtable<String,String>();
			for (int j = 0; j < cols; j++) {
				table.put(excel.getCellData(sheetName, j, 1), excel.getCellData(sheetName, j, i));
				data[i - 2][0] = table;
			}
		}

		return data;
	}
	
	public static boolean isTestRunnable(String testName,ExcelReader excel)
	{
		String sheetName = "test_suite";
		int rows = excel.getRowCount(sheetName);
		
		for(int rNum=2;rNum<=rows;rNum++) {
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName))
			{
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
		}
		return false;
		}

}
