package testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class openAccountTest extends TestBase {
	

	@Test(dataProviderClass = TestUtil.class, dataProvider="dp")
	public void OpenAccountTest(Hashtable<String,String> data) {
		
		if (!TestUtil.isTestRunnable("OpenAccountTest", excel)) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		driver.findElement(By.xpath(ObjectReference.getProperty("openAcctBtn"))).click();
		Select cust = new Select(driver.findElement(By.xpath(ObjectReference.getProperty("userSelect"))));
		//String custfirstName= data.get("firstname");
		//String custlastName = data.get("lastname");
		//String custName = custfirstName +" "+custlastName;
		String custName = data.get("firstname")+" "+data.get("lastname");
		//System.out.println(custfirstName);
		//System.out.println(custlastName);
		System.out.println(custName);
		cust.selectByVisibleText(custName);
		Select currency = new Select(driver.findElement(By.xpath(ObjectReference.getProperty("currencySelect"))));
		currency.selectByVisibleText("Pound");
		driver.findElement(By.xpath(ObjectReference.getProperty("processBtn"))).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains("Account created successfully"));
		alert.accept();
		
	}
	
	
	
}
