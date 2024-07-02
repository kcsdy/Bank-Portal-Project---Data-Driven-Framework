package testcases;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class ValidateCustomerEntryTest extends TestBase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider="dp")
	public void customerEnteredExistanceTest(Hashtable<String,String> data) throws InterruptedException
	{
		if (!TestUtil.isTestRunnable("customerEnteredExistanceTest", excel)) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		driver.findElement(By.xpath(ObjectReference.getProperty("customerBtn"))).click();
		
		List<WebElement> firstnamecolumn = driver.findElements(By.xpath(ObjectReference.getProperty("firstNameColumn")));
		List<WebElement> lastNameColumn = driver.findElements(By.xpath(ObjectReference.getProperty("lastNameColumn")));
		List<WebElement> postcodeColumn = driver.findElements(By.xpath(ObjectReference.getProperty("postcodeColumn")));
		
		int firstnameIndex = 0;
		int lastnameIndex = 0;
		int postcodeIndex = 0;
		for(int i=0;i<firstnamecolumn.size();i++)
		{
			if(firstnamecolumn.get(i).getText().equals(data.get("firstname")))
			{
				Assert.assertTrue(firstnamecolumn.get(i).getText().equals(data.get("firstname")));
				firstnameIndex = i;
			}
			
		}
		
		for(int i=0;i<lastNameColumn.size();i++)
		{
			if(lastNameColumn.get(i).getText().equals(data.get("lastname")))
			{
				Assert.assertTrue(lastNameColumn.get(i).getText().equals(data.get("lastname")));
				lastnameIndex = i;
			}
			
		}
		
		for(int i=0;i<postcodeColumn.size();i++)
		{
			if(postcodeColumn.get(i).getText().equals(data.get("postcode")))
			{
				Assert.assertTrue(postcodeColumn.get(i).getText().equals(data.get("postcode")));
				postcodeIndex = i;
			}
			
		}
		
		Assert.assertTrue(firstnameIndex==lastnameIndex && lastnameIndex==postcodeIndex && postcodeIndex==firstnameIndex);
		
	}
	
	
	@Test(dataProviderClass = TestUtil.class, dataProvider="dp")
	public void searchBoxWorkingTest(Hashtable<String,String> data) throws InterruptedException
	{
		if (!TestUtil.isTestRunnable("searchBoxWorkingTest", excel)) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		driver.findElement(By.xpath(ObjectReference.getProperty("searchBox"))).sendKeys(data.get("firstname"));
	
		List<WebElement> firstnamecolumn = driver.findElements(By.xpath(ObjectReference.getProperty("firstNameColumn")));
		
		for(int i=0;i<firstnamecolumn.size();i++)
		{
			if(firstnamecolumn.get(i).getText().equals(data.get("firstname")))
			{
				Assert.assertTrue(true);
			}
		}
		
	}
	

}
