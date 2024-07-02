package testcases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class CustomerDepositTest extends TestBase {

	String depositSubmitTime;

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void addDepositTest(Hashtable<String,String> data) {
		if (!TestUtil.isTestRunnable("addDepositTest", excel)) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		driver.findElement(By.xpath(ObjectReference.getProperty("depositBtn"))).click();

		Assert.assertTrue(driver.findElement(By.xpath(ObjectReference.getProperty("inputField"))).isDisplayed());

		Assert.assertTrue(driver.findElement(By.xpath(ObjectReference.getProperty("inputField"))).isEnabled());

		driver.findElement(By.xpath(ObjectReference.getProperty("inputField"))).sendKeys(data.get("depositAmount"));

		driver.findElement(By.xpath(ObjectReference.getProperty("submitBtn"))).submit();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy h:mm:ss a");
		depositSubmitTime = now.format(format);

		String textColor = driver.findElement(By.xpath(ObjectReference.getProperty("depositConfirmationMsg")))
				.getCssValue("color");

		Assert.assertTrue(textColor.equals("rgba(255, 0, 0, 1)"));
	}

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void depositVisibleInTransTest(Hashtable<String,String> data) throws ParseException {
		if (!TestUtil.isTestRunnable("depositVisibleInTransTest", excel)) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		driver.findElement(By.xpath(ObjectReference.getProperty("transactionsBtn"))).click();

		String latestDepositTime = driver.findElement(By.xpath(ObjectReference.getProperty("latestTransactionDate")))
				.getText().replace(",", "");

		System.out.println(latestDepositTime);

		System.out.println(depositSubmitTime);
		Assert.assertTrue(latestDepositTime.equals(depositSubmitTime));

		String depositAmountUI = driver.findElement(By.xpath(ObjectReference.getProperty("latestTransactionAmount")))
				.getText();
		System.out.println(depositAmountUI);
		System.out.println(data.get("depositAmount"));

		Assert.assertTrue(depositAmountUI.equalsIgnoreCase(data.get("depositAmount").replace(".0", "")));

		String depositTypeUI = driver.findElement(By.xpath(ObjectReference.getProperty("latestTransactionType")))
				.getText();
		System.out.println(depositTypeUI);
		Assert.assertTrue(depositTypeUI.equals(data.get("Type")));
	}

}
