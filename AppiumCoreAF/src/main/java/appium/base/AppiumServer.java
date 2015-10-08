package appium.base;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * This page models Appium server
 * 
 * @author A. K. Sahu
 *
 */
public class AppiumServer {

	String appiumInstallationDir = "C:/Program Files (x86)";
	AppiumDriverLocalService service = null;

	public AppiumServer() {
		File classPathRoot = new File(System.getProperty("user.dir"));

		service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File(appiumInstallationDir + "/Appium/node.exe"))
						.withAppiumJS(new File(appiumInstallationDir + "/Appium/node_modules/appium/bin/appium.js"))
						.withLogFile(new File(new File(classPathRoot, "/log"), "androidlog.txt")));
	}

	/**
	 * Starts appium server
	 */
	public void startAppiumServer() {
		service.start();
	}

	/**
	 * Starts appium server
	 */
	public void stopAppiumServer() {
		service.stop();
	}
}
