package appium.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * This class models the Genymotion emulator - android faster emulator Note: We
 * need to have a licence to use these commands
 * 
 * @author A. K. Sahu
 *
 */
public class GenymotionManager {

	private static String genemotionPath = "/Applications/Genymotion.app/Contents/MacOS/gmtool";

	/**
	 * Starts the given genymotion emulator
	 * 
	 * @param nameOfAVD
	 */
	public static void startGenymotionEmulator(String nameOfAVD) {
		System.out.println("Starting emulator...");
		String[] aCommand = new String[] { genemotionPath, "admin", "start", nameOfAVD };
		try {
			Process process = new ProcessBuilder(aCommand).start();
			process.waitFor(60, TimeUnit.SECONDS);

			BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String line = null;
			boolean anyError = false;
			while ((line = inputStream.readLine()) != null) {
				System.out.println(line);
				anyError = true;
			}
			if (!anyError)
				System.out.println("Emulator started successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stops the given genymotion emulator
	 * 
	 * @param nameOfAVD
	 */
	public static void stopGenymotionEmulator(String nameOfAVD) {
		System.out.println("Stopping emulator...");
		String[] aCommand = new String[] { genemotionPath, "admin", "stop", nameOfAVD };
		try {
			Process process = new ProcessBuilder(aCommand).start();
			process.waitFor(1, TimeUnit.SECONDS);

			BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String line = null;
			boolean anyError = false;
			while ((line = inputStream.readLine()) != null) {
				System.out.println(line);
				anyError = true;
			}
			if (!anyError)
				System.out.println("Emulator stopped successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		String VIRTUAL_DEVICE_NAME = "Google Nexus 7 2013-5.1.0-API22-1200x1920";
		startGenymotionEmulator(VIRTUAL_DEVICE_NAME);
		Thread.sleep(60000);// 1 min
		stopGenymotionEmulator(VIRTUAL_DEVICE_NAME);
		System.out.println("Execution completed!");

		// TODO: We need to have license to execute genymotion command line

		// Unable to refresh license information: No license registered with
		// those credentials.
		// A license is required to use this feature.
	}
}
