package appium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import appium.base.TestBase;
import appium.page.SignInPage;

/**
 * An example class for testing WordPress application using the appium framework
 * 
 * @author A. K. Sahu
 *
 */
public class WordPressTest extends TestBase {

	@Test(enabled = true)
	public void testSignInScreen() {

		WebElement forgetPwd = driver.findElement(SignInPage.FORGET_PASSWORD_BUTTON);
		Assert.assertEquals(forgetPwd.getText(), "Lost your password?");

		WebElement selfHosted = driver.findElement(SignInPage.SELF_HOSTED_BUTTON);
		Assert.assertEquals(selfHosted.getText(), "Add self-hosted site");

		WebElement signInBtn = driver.findElement(SignInPage.SIGN_IN_BUTTON);
		Assert.assertFalse(signInBtn.isEnabled(), "The button should not be enabled!");

		Assert.assertFalse(true, "Failing the test to check report :)");

	}

	@Test(enabled = true)
	public void testSignInButtonEnableDisable() {

		WebElement signInBtn = driver.findElement(SignInPage.SIGN_IN_BUTTON);
		Assert.assertFalse(signInBtn.isEnabled(), "The button should not be enabled!");

		driver.findElement(SignInPage.USERNAME_INPUT).sendKeys("aksahu");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(SignInPage.PASSWORD_INPUT).sendKeys("aksahu123");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Assert.assertTrue(signInBtn.isEnabled(), "The button is not enabled!");

	}

	@Test(enabled = true)
	public void testInvalidCredentials() {

		driver.findElement(SignInPage.USERNAME_INPUT).sendKeys("aksahu");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(SignInPage.PASSWORD_INPUT).sendKeys("aksahu123");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(SignInPage.SIGN_IN_BUTTON).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		WebElement wrongSignInMsg = driver.findElement(SignInPage.SIGN_IN_ALERT_TEXT);
		Assert.assertEquals(wrongSignInMsg.getText(), "We can't log you in");

		driver.findElement(SignInPage.CANCEL_BUTTON).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		WebElement forgetPwd = driver.findElement(SignInPage.FORGET_PASSWORD_BUTTON);
		Assert.assertEquals(forgetPwd.getText(), "Lost your password?");
	}
}
