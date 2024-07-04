package testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
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
	
	@Test(dataProviderClass = TestUtil.class , dataProvider = "dp")
	public void withdrawlAmtMoreThanBalTest(Hashtable<String,String> data) throws InterruptedException
	{
		driver.findElement(By.xpath(ObjectReference.getProperty("inputField"))).sendKeys(data.get("withdrawlAmount"));
		driver.findElement(By.xpath(ObjectReference.getProperty("submitBtn"))).submit();
		String errorMsgInPortal = driver.findElement(By.xpath(ObjectReference.getProperty("withdrawlAmtMoreThanBalText"))).getText();
		Assert.assertTrue(errorMsgInPortal.equals(data.get("errorMsg")));
	}
	
	/*@Test
	public void withdrawlAmtEqualToBalTest() {
		String accBal = driver.findElement(By.xpath(ObjectReference.getProperty("balanceValue"))).getText();
		System.out.println(accBal);
		driver.findElement(By.xpath(ObjectReference.getProperty("inputField"))).sendKeys(accBal);
		driver.findElement(By.xpath(ObjectReference.getProperty("submitBtn"))).submit();
		String successMsg = driver.findElement(By.xpath(ObjectReference.getProperty("withdrawlAmtMoreThanBalText"))).getText();
		Assert.assertTrue(successMsg.equals("Transaction successful"));
	}
	*/
}
