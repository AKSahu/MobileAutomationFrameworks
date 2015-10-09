package appium.base;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.ErrorHandler;
import org.openqa.selenium.remote.ExecuteMethod;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.internal.JsonToWebElementConverter;

import com.google.gson.JsonObject;

import appium.report.CommandList;
import io.appium.java_client.AppiumSetting;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.TouchableElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * This class implements all the methods associated with
 * {@link io.appium.java_client.android.AndroidDriver}
 * 
 * @author A. K. Sahu
 *
 * @param <RequiredElementType>
 *            means the required type from the list of allowed types below that
 *            implement {@link WebElement} Instances of the defined type will be
 *            returned via findElement* and findElements*. Warning (!!!).
 *            Allowed types:<br/>
 *            {@link WebElement}<br/>
 *            {@link TouchableElement}<br/>
 *            {@link RemoteWebElement}<br/>
 *            {@link MobileElement} {@link AndroidElement}
 */
public class AndroidDriver<RequiredElementType extends WebElement>
		extends io.appium.java_client.android.AndroidDriver<RequiredElementType> {

	/**
	 * 
	 * @param remoteAddress
	 * @param desiredCapabilities
	 */
	public AndroidDriver(URL remoteAddress, Capabilities desiredCapabilities) {
		super(remoteAddress, desiredCapabilities);
	}

	/**
	 * 
	 * @param service
	 * @param desiredCapabilities
	 */
	public AndroidDriver(AppiumDriverLocalService service, Capabilities desiredCapabilities) {
		super(service, desiredCapabilities);
	}

	/**
	 * 
	 * @param builder
	 * @param desiredCapabilities
	 */
	public AndroidDriver(AppiumServiceBuilder builder, Capabilities desiredCapabilities) {
		super(builder, desiredCapabilities);
	}

	/**
	 * 
	 * @param desiredCapabilities
	 */
	public AndroidDriver(Capabilities desiredCapabilities) {
		super(desiredCapabilities);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.android.AndroidDriver#scrollTo(java.lang.String)
	 */
	@Override
	public RequiredElementType scrollTo(String text) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + text + "'");
		return super.scrollTo(text);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#scrollToExact(java.lang.
	 * String)
	 */
	@Override
	public RequiredElementType scrollToExact(String text) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + text + "'");
		return super.scrollToExact(text);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#pressKeyCode(int)
	 */
	@Override
	public void pressKeyCode(int key) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + key + "'");
		super.pressKeyCode(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#pressKeyCode(int,
	 * java.lang.Integer)
	 */
	@Override
	public void pressKeyCode(int key, Integer metastate) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + key + "' and '" + metastate + "'");
		super.pressKeyCode(key, metastate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#longPressKeyCode(int)
	 */
	@Override
	public void longPressKeyCode(int key) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + key + "'");
		super.longPressKeyCode(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#longPressKeyCode(int,
	 * java.lang.Integer)
	 */
	@Override
	public void longPressKeyCode(int key, Integer metastate) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + key + "' and '" + metastate + "'");
		super.longPressKeyCode(key, metastate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#getNetworkConnection()
	 */
	@Override
	public NetworkConnectionSetting getNetworkConnection() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getNetworkConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#setNetworkConnection(io.
	 * appium.java_client.NetworkConnectionSetting)
	 */
	@Override
	public void setNetworkConnection(NetworkConnectionSetting connection) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + connection + "'");
		super.setNetworkConnection(connection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.android.AndroidDriver#pushFile(java.lang.String,
	 * byte[])
	 */
	@Override
	public void pushFile(String remotePath, byte[] base64Data) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + remotePath + "' and '" + base64Data + "'");
		super.pushFile(remotePath, base64Data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#startActivity(java.lang.
	 * String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void startActivity(String appPackage, String appActivity, String appWaitPackage, String appWaitActivity)
			throws IllegalArgumentException {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
						+ "' with input parameter(s) '" + appPackage + "' , '" + appActivity + "' , '" + appWaitPackage
						+ "' and '" + appWaitActivity + "'");
		super.startActivity(appPackage, appActivity, appWaitPackage, appWaitActivity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#startActivity(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void startActivity(String appPackage, String appActivity) throws IllegalArgumentException {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + appPackage + "' and '" + appActivity + "'");
		super.startActivity(appPackage, appActivity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.android.AndroidDriver#endTestCoverage(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void endTestCoverage(String intent, String path) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + intent + "' and '" + path + "'");
		super.endTestCoverage(intent, path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#currentActivity()
	 */
	@Override
	public String currentActivity() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName());
		return super.currentActivity();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#openNotifications()
	 */
	@Override
	public void openNotifications() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		super.openNotifications();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#isLocked()
	 */
	@Override
	public boolean isLocked() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.isLocked();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#toggleLocationServices()
	 */
	@Override
	public void toggleLocationServices() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		super.toggleLocationServices();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.android.AndroidDriver#ignoreUnimportantViews(java.
	 * lang.Boolean)
	 */
	@Override
	public void ignoreUnimportantViews(Boolean compress) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + compress + "'");
		super.ignoreUnimportantViews(compress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#
	 * findElementByAndroidUIAutomator(java.lang.String)
	 */
	@Override
	public RequiredElementType findElementByAndroidUIAutomator(String using) throws WebDriverException {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementByAndroidUIAutomator(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.android.AndroidDriver#
	 * findElementsByAndroidUIAutomator(java.lang.String)
	 */
	@Override
	public List<RequiredElementType> findElementsByAndroidUIAutomator(String using) throws WebDriverException {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementsByAndroidUIAutomator(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.AppiumDriver#findElements(org.openqa.selenium.By)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findElements(By by) {
		// CommandList.getInstance().reportSuccess("Invoking '" +
		// Thread.currentThread().getStackTrace()[1].getMethodName()
		// + "' with input parameter(s) '" + by + "'");
		return super.findElements(by);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.AppiumDriver#findElementsById(java.lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findElementsById(String id) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + id + "'");
		return super.findElementsById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#findElementsByLinkText(java.lang.
	 * String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findElementsByLinkText(String using) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementsByLinkText(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.AppiumDriver#findElementsByPartialLinkText(java.
	 * lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findElementsByPartialLinkText(String using) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementsByPartialLinkText(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#findElementsByTagName(java.lang.
	 * String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findElementsByTagName(String using) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementsByTagName(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.AppiumDriver#findElementsByName(java.lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findElementsByName(String using) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementsByName(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.AppiumDriver#findElementsByClassName(java.lang.
	 * String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findElementsByClassName(String using) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementsByClassName(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.AppiumDriver#findElementsByCssSelector(java.lang.
	 * String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findElementsByCssSelector(String using) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementsByCssSelector(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.AppiumDriver#findElementsByXPath(java.lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findElementsByXPath(String using) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementsByXPath(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.AppiumDriver#findElementsByAccessibilityId(java.
	 * lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findElementsByAccessibilityId(String using) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementsByAccessibilityId(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#execute(java.lang.String)
	 */
	@Override
	protected Response execute(String command) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + command + "'");
		return super.execute(command);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#getExecuteMethod()
	 */
	@Override
	public ExecuteMethod getExecuteMethod() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getExecuteMethod();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#resetApp()
	 */
	@Override
	public void resetApp() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		super.resetApp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#isAppInstalled(java.lang.String)
	 */
	@Override
	public boolean isAppInstalled(String bundleId) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + bundleId + "'");
		return super.isAppInstalled(bundleId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#installApp(java.lang.String)
	 */
	@Override
	public void installApp(String appPath) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + appPath + "'");
		super.installApp(appPath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#removeApp(java.lang.String)
	 */
	@Override
	public void removeApp(String bundleId) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + bundleId + "'");
		super.removeApp(bundleId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#launchApp()
	 */
	@Override
	public void launchApp() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		super.launchApp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#closeApp()
	 */
	@Override
	public void closeApp() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		super.closeApp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#runAppInBackground(int)
	 */
	@Override
	public void runAppInBackground(int seconds) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + seconds + "'");
		super.runAppInBackground(seconds);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#hideKeyboard()
	 */
	@Override
	public void hideKeyboard() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		super.hideKeyboard();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#pullFile(java.lang.String)
	 */
	@Override
	public byte[] pullFile(String remotePath) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + remotePath + "'");
		return super.pullFile(remotePath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#pullFolder(java.lang.String)
	 */
	@Override
	public byte[] pullFolder(String remotePath) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + remotePath + "'");
		return super.pullFolder(remotePath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#performTouchAction(io.appium.
	 * java_client.TouchAction)
	 */
	@Override
	public TouchAction performTouchAction(TouchAction touchAction) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + touchAction + "'");
		return super.performTouchAction(touchAction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.AppiumDriver#performMultiTouchAction(io.appium.
	 * java_client.MultiTouchAction)
	 */
	@Override
	public void performMultiTouchAction(MultiTouchAction multiAction) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + multiAction + "'");
		super.performMultiTouchAction(multiAction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#tap(int,
	 * org.openqa.selenium.WebElement, int)
	 */
	@Override
	public void tap(int fingers, WebElement element, int duration) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + fingers + "' , '" + element + "' and '" + duration + "'");
		super.tap(fingers, element, duration);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#tap(int, int, int, int)
	 */
	@Override
	public void tap(int fingers, int x, int y, int duration) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + fingers + "' , '" + x + "' , '" + y + "' and '" + duration + "'");
		super.tap(fingers, x, y, duration);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#swipe(int, int, int, int, int)
	 */
	@Override
	public void swipe(int startx, int starty, int endx, int endy, int duration) {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
						+ "' with input parameter(s) '" + startx + "', '" + starty + "', '" + endx + "', '" + endy
						+ "', '" + duration + "'");
		super.swipe(startx, starty, endx, endy, duration);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.AppiumDriver#pinch(org.openqa.selenium.WebElement)
	 */
	@Override
	public void pinch(WebElement el) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + el + "'");
		super.pinch(el);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#pinch(int, int)
	 */
	@Override
	public void pinch(int x, int y) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + x + "' and '" + y + "'");
		super.pinch(x, y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.AppiumDriver#zoom(org.openqa.selenium.WebElement)
	 */
	@Override
	public void zoom(WebElement el) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + el + "'");
		super.zoom(el);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#zoom(int, int)
	 */
	@Override
	public void zoom(int x, int y) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + x + "' and '" + y + "'");
		super.zoom(x, y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#getSettings()
	 */
	@Override
	public JsonObject getSettings() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getSettings();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#setSetting(io.appium.java_client.
	 * AppiumSetting, java.lang.Object)
	 */
	@Override
	protected void setSetting(AppiumSetting setting, Object value) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + setting + "' and '" + value + "'");
		super.setSetting(setting, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#lockScreen(int)
	 */
	@Override
	public void lockScreen(int seconds) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + seconds + "'");
		super.lockScreen(seconds);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#context(java.lang.String)
	 */
	@Override
	public WebDriver context(String name) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + name + "'");
		return super.context(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#getContextHandles()
	 */
	@Override
	public Set<String> getContextHandles() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getContextHandles();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#getContext()
	 */
	@Override
	public String getContext() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getContext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#rotate(org.openqa.selenium.
	 * ScreenOrientation)
	 */
	@Override
	public void rotate(ScreenOrientation orientation) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + orientation + "'");
		super.rotate(orientation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#getOrientation()
	 */
	@Override
	public ScreenOrientation getOrientation() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getOrientation();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#location()
	 */
	@Override
	public Location location() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.location();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.AppiumDriver#setLocation(org.openqa.selenium.html5.
	 * Location)
	 */
	@Override
	public void setLocation(Location location) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + location + "'");
		super.setLocation(location);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#getAppStrings()
	 */
	@Override
	public String getAppStrings() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getAppStrings();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#getAppStrings(java.lang.String)
	 */
	@Override
	public String getAppStrings(String language) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + language + "'");
		return super.getAppStrings(language);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.AppiumDriver#getRemoteAddress()
	 */
	@Override
	public URL getRemoteAddress() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getRemoteAddress();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.DefaultGenericMobileDriver#execute(java.lang.
	 * String, java.util.Map)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Response execute(String driverCommand, Map<String, ?> parameters) {
		List mapValues = null;
		if (parameters != null) {
			mapValues = new ArrayList(parameters.values());
		}
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' for driver command '" + driverCommand + "' with input parameter(s) '" + mapValues + "'");
		return super.execute(driverCommand, parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.DefaultGenericMobileDriver#findElement(org.openqa.
	 * selenium.By)
	 */
	@Override
	public RequiredElementType findElement(By by) {
		// CommandList.getInstance().reportSuccess("Invoking '" +
		// Thread.currentThread().getStackTrace()[1].getMethodName()
		// + "' with input parameter(s) '" + by + "'");
		return super.findElement(by);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.DefaultGenericMobileDriver#findElementById(java.
	 * lang.String)
	 */
	@Override
	public RequiredElementType findElementById(String id) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + id + "'");
		return super.findElementById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.DefaultGenericMobileDriver#findElementByLinkText(
	 * java.lang.String)
	 */
	@Override
	public RequiredElementType findElementByLinkText(String using) throws WebDriverException {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementByLinkText(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.DefaultGenericMobileDriver#
	 * findElementByPartialLinkText(java.lang.String)
	 */
	@Override
	public RequiredElementType findElementByPartialLinkText(String using) throws WebDriverException {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementByPartialLinkText(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.DefaultGenericMobileDriver#findElementByTagName(
	 * java.lang.String)
	 */
	@Override
	public RequiredElementType findElementByTagName(String using) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementByTagName(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.DefaultGenericMobileDriver#findElementByName(java.
	 * lang.String)
	 */
	@Override
	public RequiredElementType findElementByName(String using) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementByName(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.DefaultGenericMobileDriver#findElementByClassName(
	 * java.lang.String)
	 */
	@Override
	public RequiredElementType findElementByClassName(String using) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementByClassName(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.DefaultGenericMobileDriver#findElementByCssSelector
	 * (java.lang.String)
	 */
	@Override
	public RequiredElementType findElementByCssSelector(String using) throws WebDriverException {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementByCssSelector(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.appium.java_client.DefaultGenericMobileDriver#findElementByXPath(java.
	 * lang.String)
	 */
	@Override
	public RequiredElementType findElementByXPath(String using) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementByXPath(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.DefaultGenericMobileDriver#
	 * findElementByAccessibilityId(java.lang.String)
	 */
	@Override
	public RequiredElementType findElementByAccessibilityId(String using) throws WebDriverException {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + using + "'");
		return super.findElementByAccessibilityId(using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.appium.java_client.DefaultGenericMobileDriver#getMouse()
	 */
	@Deprecated
	@Override
	public Mouse getMouse() {
		// CommandList.getInstance().reportSuccess("Invoking '" +
		// Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getMouse();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.remote.RemoteWebDriver#setFileDetector(org.openqa.
	 * selenium.remote.FileDetector)
	 */
	@Override
	public void setFileDetector(FileDetector detector) {
		// CommandList.getInstance().reportSuccess("Invoking '" +
		// Thread.currentThread().getStackTrace()[1].getMethodName()
		// + "' with input parameter(s) '" + detector + "'");
		super.setFileDetector(detector);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#getSessionId()
	 */
	@Override
	public SessionId getSessionId() {
		// CommandList.getInstance().reportSuccess("Invoking '" +
		// Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getSessionId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.remote.RemoteWebDriver#setSessionId(java.lang.String)
	 */
	@Override
	protected void setSessionId(String opaqueKey) {
		// CommandList.getInstance().reportSuccess("Invoking '" +
		// Thread.currentThread().getStackTrace()[1].getMethodName()
		// + "' with input parameter(s) '" + opaqueKey + "'");
		super.setSessionId(opaqueKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#startSession(org.openqa.
	 * selenium.Capabilities)
	 */
	@Override
	protected void startSession(Capabilities desiredCapabilities) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + desiredCapabilities + "'");
		super.startSession(desiredCapabilities);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#startSession(org.openqa.
	 * selenium.Capabilities, org.openqa.selenium.Capabilities)
	 */
	@Override
	protected void startSession(Capabilities desiredCapabilities, Capabilities requiredCapabilities) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + desiredCapabilities + "' and '" + requiredCapabilities + "'");
		super.startSession(desiredCapabilities, requiredCapabilities);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#startClient()
	 */
	@Override
	protected void startClient() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		super.startClient();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#stopClient()
	 */
	@Override
	protected void stopClient() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		super.stopClient();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#getErrorHandler()
	 */
	@Override
	public ErrorHandler getErrorHandler() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getErrorHandler();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.remote.RemoteWebDriver#setErrorHandler(org.openqa.
	 * selenium.remote.ErrorHandler)
	 */
	@Override
	public void setErrorHandler(ErrorHandler handler) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + handler + "'");
		super.setErrorHandler(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#getCommandExecutor()
	 */
	@Override
	public CommandExecutor getCommandExecutor() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getCommandExecutor();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.remote.RemoteWebDriver#setCommandExecutor(org.openqa.
	 * selenium.remote.CommandExecutor)
	 */
	@Override
	protected void setCommandExecutor(CommandExecutor executor) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + executor + "'");
		super.setCommandExecutor(executor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#getCapabilities()
	 */
	@Override
	public Capabilities getCapabilities() {
		// CommandList.getInstance().reportSuccess("Invoking '" +
		// Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getCapabilities();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#get(java.lang.String)
	 */
	@Override
	public void get(String url) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + url + "'");
		super.get(url);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#getTitle()
	 */
	@Override
	public String getTitle() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getTitle();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#getCurrentUrl()
	 */
	@Override
	public String getCurrentUrl() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getCurrentUrl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.remote.RemoteWebDriver#getScreenshotAs(org.openqa.
	 * selenium.OutputType)
	 */
	@Override
	public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + outputType + "'");
		return super.getScreenshotAs(outputType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.remote.RemoteWebDriver#findElement(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	protected WebElement findElement(String by, String using) {
		// CommandList.getInstance().reportSuccess("Invoking '" +
		// Thread.currentThread().getStackTrace()[1].getMethodName()
		// + "' with input parameter(s) '" + by + "' and '" + using + "'");
		return super.findElement(by, using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.remote.RemoteWebDriver#setFoundBy(org.openqa.selenium
	 * .SearchContext, org.openqa.selenium.WebElement, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	protected void setFoundBy(SearchContext context, WebElement element, String by, String using) {
		// CommandList.getInstance().reportSuccess("Invoking '" +
		// Thread.currentThread().getStackTrace()[1].getMethodName()
		// + "' with input parameter(s) '" + context + "', '" + element + "', '"
		// + by + "', and '" + using + "'");
		super.setFoundBy(context, element, by, using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.remote.RemoteWebDriver#findElements(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	protected List<WebElement> findElements(String by, String using) {
		// CommandList.getInstance().reportSuccess("Invoking '" +
		// Thread.currentThread().getStackTrace()[1].getMethodName()
		// + "' with input parameter(s) '" + by + "' and '" + using + "'");
		return super.findElements(by, using);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#getPageSource()
	 */
	@Override
	public String getPageSource() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getPageSource();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#close()
	 */
	@Override
	public void close() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		super.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#quit()
	 */
	@Override
	public void quit() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		super.quit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#getWindowHandles()
	 */
	@Override
	public Set<String> getWindowHandles() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getWindowHandles();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#getWindowHandle()
	 */
	@Override
	public String getWindowHandle() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getWindowHandle();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#executeScript(java.lang.
	 * String, java.lang.Object[])
	 */
	@Override
	public Object executeScript(String script, Object... args) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + script + "' and '" + args + "'");
		return super.executeScript(script, args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.remote.RemoteWebDriver#executeAsyncScript(java.lang.
	 * String, java.lang.Object[])
	 */
	@Override
	public Object executeAsyncScript(String script, Object... args) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + script + "' and '" + args + "'");
		return super.executeAsyncScript(script, args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#switchTo()
	 */
	@Override
	public TargetLocator switchTo() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.switchTo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#navigate()
	 */
	@Override
	public Navigation navigate() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.navigate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#manage()
	 */
	@Override
	public Options manage() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.manage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.remote.RemoteWebDriver#setElementConverter(org.openqa
	 * .selenium.remote.internal.JsonToWebElementConverter)
	 */
	@Override
	protected void setElementConverter(JsonToWebElementConverter converter) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + converter + "'");
		super.setElementConverter(converter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#getElementConverter()
	 */
	@Override
	protected JsonToWebElementConverter getElementConverter() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getElementConverter();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.remote.RemoteWebDriver#setLogLevel(java.util.logging.
	 * Level)
	 */
	@Override
	public void setLogLevel(Level level) {
		CommandList.getInstance().reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "' with input parameter(s) '" + level + "'");
		super.setLogLevel(level);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#getKeyboard()
	 */
	@Override
	public Keyboard getKeyboard() {
		CommandList.getInstance()
				.reportSuccess("Invoking '" + Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getKeyboard();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openqa.selenium.remote.RemoteWebDriver#log(org.openqa.selenium.remote
	 * .SessionId, java.lang.String, java.lang.Object,
	 * org.openqa.selenium.remote.RemoteWebDriver.When)
	 */
	@Override
	protected void log(SessionId sessionId, String commandName, Object toLog, When when) {
		// CommandList.getInstance().reportSuccess(
		// "Invoking '" +
		// Thread.currentThread().getStackTrace()[1].getMethodName() + "' with
		// input parameter(s) '"
		// + sessionId + "', '" + commandName + "', '" + toLog + "' and '" +
		// when + "'");
		super.log(sessionId, commandName, toLog, when);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#getFileDetector()
	 */
	@Override
	public FileDetector getFileDetector() {
		// CommandList.getInstance().reportSuccess("Invoking '" +
		// Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.getFileDetector();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.remote.RemoteWebDriver#toString()
	 */
	@Override
	public String toString() {
		// CommandList.getInstance().reportSuccess("Invoking '" +
		// Thread.currentThread().getStackTrace()[1].getMethodName() + "'");
		return super.toString();
	}
}
