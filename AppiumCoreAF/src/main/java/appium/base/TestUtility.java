package appium.base;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * This page models all the utilities required for the framework
 * 
 * @author A. K. Sahu
 *
 */
public class TestUtility {

	/**
	 * Gets a string with current date and time in
	 * <code>dd-MM-yyyy_hh.mm.ss_a</code> format for the system time
	 * 
	 * @return
	 */
	public static String getTimeStamp() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy_hh.mm.ss_a");
		return df.format(new Date());
	}
	
	/**
	 * Gets a string with current date and time in
	 * <code>dd-MM-yyyy_hh.mm.ss_a</code> format for the specified
	 * <code>timeZone</code>
	 * 
	 * @param timeZone
	 *            a time zone e.g. PST, IST
	 * @return
	 */
	public static String getTimeStamp(String timeZone) {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy_hh.mm.ss_a");
		df.setTimeZone(TimeZone.getTimeZone(timeZone));
		return df.format(new Date());
	}

	/**
	 * Gets the current system time as hex-decimal string
	 * 
	 * @return
	 */
	public static String getTimeStampLong() {
		return Long.toHexString(System.currentTimeMillis());
	}
	
	/**
	 * Gets only the time form the time stamp 
	 * @return a hh:mm:ss value
	 */
	public static String getTimeStampOnlyTime() {
		return (new SimpleDateFormat("hh:mm:ss")).format(new Date());
	}

	/**
	 * Takes the application screenshot
	 * 
	 * @param driver
	 * @param aName
	 */
	public static void takeScreenshot(WebDriver driver, String aName) {
		try {
			File classPathRoot = new File(System.getProperty("user.dir"));
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(new File(classPathRoot, "/screenshot"), aName + ".png"));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public static String getScreenshotDirectory() {
		File classPathRoot = new File(System.getProperty("user.dir"));
		File screenshot = new File(classPathRoot, "/screenshot");
		return screenshot.getAbsolutePath();
	}

	public static String getReportsDirectory() {
		File classPathRoot = new File(System.getProperty("user.dir"));
		File screenshot = new File(classPathRoot, "/report");
		return screenshot.getAbsolutePath();
	}
}
