package testcases;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class MultiAccountTest extends TestBase{

	String accountNumberPound;
	String accountNumberRupee;
	String accountNumberDollar;
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void creatingMultiAcctTest (Hashtable<String,String> data) {
		driver.findElement(By.cssSelector(ObjectReference.getProperty("homeBtn"))).click();
		driver.findElement(By.xpath(ObjectReference.getProperty("bmlBtn"))).click();
		driver.findElement(By.xpath(ObjectReference.getProperty("openAcctBtn"))).click();
		Select userSelect = new Select(driver.findElement(By.xpath(ObjectReference.getProperty("userSelect"))));
		userSelect.selectByVisibleText(data.get("fullName"));
		Select currencySelect = new Select(driver.findElement(By.xpath(ObjectReference.getProperty("currencySelect"))));
		currencySelect.selectByVisibleText(data.get("Currency"));
		driver.findElement(By.xpath(ObjectReference.getProperty("processBtn"))).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		if(data.get("Currency").equals("Pound"))
			{
			accountNumberPound = alert.getText().substring(alert.getText().indexOf(":")+1);
			System.out.println(accountNumberPound);
			}
		else if(data.get("Currency").equals("Rupee"))
		{
			accountNumberRupee = alert.getText().substring(alert.getText().indexOf(":")+1);
			System.out.println(accountNumberRupee);
		}
		else if(data.get("Currency").equals("Dollar"))
		{
			accountNumberDollar = alert.getText().substring(alert.getText().indexOf(":")+1);
			System.out.println(accountNumberDollar);
		}
		alert.accept();
	}
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void correctMultiAccIdGenTest(Hashtable<String,String> data) throws InterruptedException {
		driver.findElement(By.cssSelector(ObjectReference.getProperty("homeBtn"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ObjectReference.getProperty("customerLoginBtn"))).click();
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.xpath(ObjectReference.getProperty("yourNameDropdown"))));
		select.selectByVisibleText(data.get("fullName"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(ObjectReference.getProperty("loginBtn"))).click();
		Thread.sleep(3000);
		Select accNoDropdown = new Select(driver.findElement(By.xpath(ObjectReference.getProperty("accountNum"))));
		List<WebElement> accountSelect = accNoDropdown.getOptions();
		Thread.sleep(3000);
		System.out.println(accountSelect.size());
		//System.out.println(accountSelect.get(0).getText().equals(accountNumberPound));
		//System.out.println(accountSelect.get(1).toString().equals(accountNumberRupee));
		//System.out.println(accountSelect.get(2).toString().equals(accountNumberDollar));
	}
}
