package testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class CustomerWithdrawlTest extends TestBase{

	@Test(dataProviderClass = TestUtil.class , dataProvider = "dp" )
	public void withdrawlAmtLessThanBalTest(Hashtable<String,String> Data) {
		
		
		driver.findElement(By.xpath(ObjectReference.getProperty("transBackBtn"))).click();
		driver.findElement(By.xpath(ObjectReference.getProperty("withdrawlBtn"))).click();
		driver.findElement(By.xpath(ObjectReference.getProperty("inputField"))).sendKeys(Data.get("withdrawlAmount"));
		driver.findElement(By.xpath(ObjectReference.getProperty("submitBtn"))).submit();
		
	}
}
