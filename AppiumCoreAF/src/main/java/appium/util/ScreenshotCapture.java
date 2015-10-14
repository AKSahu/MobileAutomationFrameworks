package appium.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * This class gives functionality to capture screenshot of the mulator/device or
 * entire screen
 * 
 * @author A. K. Sahu
 * 
 */
public class ScreenshotCapture {

	private static String imgLoc = null;

	private static Logger log = Logger.getLogger(ScreenshotCapture.class);

	static {
		try {
			imgLoc = new File(".").getCanonicalPath() + File.separator + ConfigUtil.getScreenshotDirectory()
					+ File.separator;
			log.info("Screenshot location is set to '" + imgLoc + "'");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the location(complete path) of screenshot directory
	 * 
	 * @return
	 */
	public static String getScreenshotDirectory() {
		return imgLoc;
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
			File destFile = new File(new File(classPathRoot, "/screenshot"), aName + ".png");
			FileUtils.copyFile(scrFile, destFile);
			log.info("Screenshot has been captured at:" + destFile.getAbsolutePath());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

}