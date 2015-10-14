package appium.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * This page models android/appium driver
 * 
 * @author A. K. Sahu
 *
 */
public class DriverManager {

	AndroidDriver<WebElement> driver;
	private static Logger log = Logger.getLogger(DriverManager.class);

	/**
	 * Gets the driver instance
	 * 
	 * @return
	 */
	public AndroidDriver<WebElement> getDriver() {
		log.info("Getting the android driver instance...");
		return driver;
	}

	/**
	 * Create RemoteWebDriver instance and connect to the Appium server. It will
	 * launch the App in Android Device using the configurations specified in
	 * Desired Capabilities
	 * 
	 * @param capabilities
	 * @throws MalformedURLException
	 */
	public void setCapabilities(DesiredCapabilities capabilities) throws MalformedURLException {
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		log.info("The capabilities are set and driver is instanciated.");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
}
