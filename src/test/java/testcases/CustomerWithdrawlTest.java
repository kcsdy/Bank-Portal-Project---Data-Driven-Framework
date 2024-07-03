package testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class CustomerWithdrawlTest extends TestBase{

	@Test(dataProviderClass = TestUtil.class , dataProvider = "dp" )
	public void withdrawlAmountLessThanBalanceTest(Hashtable<String,String> Data) {
		
		driver.findElement(By.xpath(ObjectReference.getProperty(""))).click();
	}
}
