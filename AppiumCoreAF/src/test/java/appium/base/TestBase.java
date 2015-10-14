package appium.base;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import appium.util.ScreenshotCapture;

/**
 * This is the base of all the tests. All tests are required to extend this
 * class.
 * 
 * @author aswinis
 *
 */
public class TestBase {

	private AppiumServer service = null;
	protected AndroidDriver<WebElement> driver = null;
	private DriverManager sManager = null;
	private DesiredCapabilities capabilities = null;

	private String apkFile = "WordPress.apk";
	private String appPackage = "org.wordpress.android";
	private String appActivity = "org.wordpress.android.ui.accounts.SignInActivity";

	@BeforeSuite
	public void setUp() throws MalformedURLException {

		service = new AppiumServer();
		service.startAppiumServer();

		File classPathRoot = new File(System.getProperty("user.dir"));
		File app = new File(new File(classPathRoot, "/app"), apkFile);

		capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability("platformName", "Android");
		// capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("deviceName", "Nexus7");

		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("appWaitActivity", appActivity);
		// hide soft keyboard
		capabilities.setCapability("unicodeKeyboard", "true");
		// Doesn’t stop the process of the app under test, before starting the
		// app using adb.
		capabilities.setCapability("dontStopAppOnReset", "true");

		sManager = new DriverManager();
		sManager.setCapabilities(capabilities);

		driver = sManager.getDriver();

	}

	@BeforeMethod
	public void doBeforeMethod() throws MalformedURLException {

		if (driver == null) {
			sManager.setCapabilities(capabilities);
			driver = sManager.getDriver();
		}
		driver.startActivity(appPackage, appActivity);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public void doAfterMethod(ITestResult result) {

		if (driver != null) {
			ScreenshotCapture.takeScreenshot(driver, result.getMethod().getMethodName());
			driver.resetApp();
		}
	}

	@AfterSuite(alwaysRun = true)
	public void teardown() {
		if (driver != null) {
			driver.closeApp();
			// driver.removeApp(appPackage);
		}
		service.stopAppiumServer();
	}
}
