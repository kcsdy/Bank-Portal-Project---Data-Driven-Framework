package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;

public class LogoutTest extends TestBase{

	@Test
	public void logoutTest() {
		driver.findElement(By.xpath(ObjectReference.getProperty("logoutBtn"))).click();
	}
}
