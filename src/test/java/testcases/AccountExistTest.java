package testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class AccountExistTest extends TestBase{

	@Test(dataProviderClass = TestUtil.class , dataProvider = "dp")
	public void accountExistTest(Hashtable<String,String> data) throws InterruptedException {
		Select select = new Select(driver.findElement(By.xpath(ObjectReference.getProperty("yourNameDropdown"))));
		select.selectByVisibleText(data.get("fullName"));
		driver.findElement(By.xpath(ObjectReference.getProperty("loginBtn"))).click();
		String noAccountText = driver.findElement(By.xpath(ObjectReference.getProperty("noAccountText"))).getText();
		Assert.assertTrue(noAccountText.equals(data.get("noAccountText")));
		driver.findElement(By.xpath(ObjectReference.getProperty("logoutBtn"))).click();
		
	}
}
