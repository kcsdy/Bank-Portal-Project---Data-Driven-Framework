package testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import utilities.TestUtil;

import base.TestBase;

public class customerLoginTest extends TestBase {
	@Test
	public void NavigateToHomeScreenTest() throws InterruptedException {
		if (!TestUtil.isTestRunnable("NavigateToHomeScreenTest", excel)) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		driver.findElement(By.cssSelector(ObjectReference.getProperty("homeBtn"))).click();
		Assert.assertTrue(
				driver.findElement(By.xpath(ObjectReference.getProperty("BankName"))).getText().equals("XYZ Bank"));
		
	}

	@Test(dataProviderClass = TestUtil.class, dataProvider="dp")
	public void custLoginTest(Hashtable<String,String> data) throws InterruptedException {
		if (!TestUtil.isTestRunnable("custLoginTest", excel)) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		driver.findElement(By.xpath(ObjectReference.getProperty("customerLoginBtn"))).click();
		Select yourNameDropdown = new Select(
				driver.findElement(By.xpath(ObjectReference.getProperty("yourNameDropdown"))));
		yourNameDropdown.selectByVisibleText(data.get("firstname") + " " + data.get("lastname"));
		driver.findElement(By.xpath(ObjectReference.getProperty("loginBtn"))).click();
		Thread.sleep(3000);
	}

	@Test(dataProviderClass = TestUtil.class, dataProvider="dp")
	public void successfulCustomerLoginTest(Hashtable<String,String> data) throws InterruptedException {
		if (!TestUtil.isTestRunnable("successfulCustomerLoginTest", excel)) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		Assert.assertTrue(driver.findElement(By.xpath(ObjectReference.getProperty("welcomeMsg"))).getText()
				.equals(data.get("firstname") + " " + data.get("lastname")));
		Thread.sleep(3000);
	}

	

}
