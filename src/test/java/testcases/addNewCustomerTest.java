package testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class addNewCustomerTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void AddNewCustomerTest(Hashtable<String,String> data)
			throws InterruptedException {

		if (!TestUtil.isTestRunnable("AddNewCustomerTest", excel)) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		if(!data.get("Runmode").equals("Y"))
		{
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		log.debug("Inside Add New Customer Test");

		driver.findElement(By.xpath(ObjectReference.getProperty("addCustBtn"))).click();
		driver.findElement(By.xpath(ObjectReference.getProperty("firstNameTextBox"))).sendKeys(data.get("firstname"));
		driver.findElement(By.xpath(ObjectReference.getProperty("lastNameTextBox"))).sendKeys(data.get("lastname"));
		driver.findElement(By.xpath(ObjectReference.getProperty("postCodeTextBox"))).sendKeys(data.get("postcode"));
		driver.findElement(By.xpath(ObjectReference.getProperty("addBtn"))).click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		alert.accept();
	}

}
