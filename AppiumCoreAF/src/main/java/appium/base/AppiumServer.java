package appium.base;

import java.io.File;

import org.apache.log4j.Logger;

import appium.util.ConfigUtil;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * This page models Appium server
 * 
 * @author A. K. Sahu
 *
 */
public class AppiumServer {

	String appiumInstallationDir = ConfigUtil.getProperty("APPIUM_INSTALLATION_DIRECTORY");
	AppiumDriverLocalService service = null;
	private static Logger log = Logger.getLogger(AppiumServer.class);

	public AppiumServer() {
		File classPathRoot = new File(System.getProperty("user.dir"));

		service = AppiumDriverLocalService
				.buildService(
						new AppiumServiceBuilder()
								.usingDriverExecutable(new File(appiumInstallationDir + File.separator + "Appium"
										+ File.separator + "node.exe"))
				.withAppiumJS(
						new File(appiumInstallationDir + File.separator + "Appium" + File.separator + "node_modules"
								+ File.separator + "appium" + File.separator + "bin" + File.separator + "appium.js"))
				.withLogFile(new File(new File(classPathRoot, File.separator + "log"), "androidLog.txt")));
		log.info("Appium server is initialized.");
	}

	/**
	 * Starts appium server
	 */
	public void startAppiumServer() {
		service.start();
		log.info("Appium server has started successfully!");
	}

	/**
	 * Starts appium server
	 */
	public void stopAppiumServer() {
		service.stop();
		log.info("Appium server has stopped successfully!");
	}
}
