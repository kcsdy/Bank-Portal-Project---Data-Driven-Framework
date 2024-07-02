package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws InterruptedException {

		if (!TestUtil.isTestRunnable("loginAsBankManager", excel)) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		log.debug("Inside Login Test");
		driver.findElement(By.xpath(ObjectReference.getProperty("bmlBtn"))).click();

		Assert.assertTrue(isElementExists(By.xpath(ObjectReference.getProperty("addCustBtn"))),
				"Bank Manager Login is successful");
		log.debug("Login Successfully Executed");
		
	}

}
