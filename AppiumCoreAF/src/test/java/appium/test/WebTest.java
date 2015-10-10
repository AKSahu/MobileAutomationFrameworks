package appium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appium.base.TestUtility;

public class WebTest {

	WebDriver driver = null;

	@BeforeMethod
	public void doBeforeMethod() {
		driver = new FirefoxDriver();
	}

	@Test
	public void searchGoogle() {
		driver.get("http://www.google.in");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("q")).sendKeys("A.K.Sahu's Blog");
	}

	@AfterMethod(alwaysRun = true)
	public void doAfterMethod(ITestResult result) {

		if (driver != null) {
			TestUtility.takeScreenshot(driver, result.getMethod().getMethodName());
			driver.close();
			driver.quit();
		}
	}
}
