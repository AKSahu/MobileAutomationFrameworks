package appium.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import appium.util.ConfigUtil;

public class AVDManager {

	private static String sdkPath = ConfigUtil.getProperty("SDK_INSTALLATION_DIRECTORY");
	private static String adbPath = sdkPath + "platform-tools" + File.separator + "adb";
	private static String emulatorPath = sdkPath + "tools" + File.separator + "emulator";

	/**
	 * Starts an emulator
	 * 
	 * @param nameOfAVD
	 */
	public static void launchEmulator(String nameOfAVD) {
		System.out.println("Starting emulator for '" + nameOfAVD + "' ...");
		String[] aCommand = new String[] { emulatorPath, "-avd", nameOfAVD };
		try {
			Process process = new ProcessBuilder(aCommand).start();
			process.waitFor(180, TimeUnit.SECONDS);
			System.out.println("Emulator started successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Kills all opened emulators
	 */
	public static void closeEmulator() {
		System.out.println("Killing emulator...");
		String[] aCommand = new String[] { adbPath, "emu", "kill" };
		try {
			Process process = new ProcessBuilder(aCommand).start();
			process.waitFor(1, TimeUnit.SECONDS);
			System.out.println("Emulator closed successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Unlocks the emulator screen
	 */
	public static void unlockScreen() {
		String[] aCommand = new String[] { adbPath, "shell", "input", "keyevent", "82" };
		try {
			Process process = new ProcessBuilder(aCommand).start();
			process.waitFor(1, TimeUnit.SECONDS);
			System.out.println("Emulator unlocked successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Waits for the emulator to be ready
	 */
	public static void waitForEmulatorToBeReady() {
		try {
			String[] commandBootComplete = new String[] { adbPath, "shell", "getprop", "dev.bootcomplete" };
			Process process = new ProcessBuilder(commandBootComplete).start();

			BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));

			// wait till the property returns '1'
			while (!inputStream.readLine().equals("1")) {
				process.waitFor(1, TimeUnit.SECONDS);
				process = new ProcessBuilder(commandBootComplete).start();
				inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
			}

			String[] commandBootAnim = new String[] { adbPath, "shell", "getprop", "init.svc.bootanim" };
			process = new ProcessBuilder(commandBootAnim).start();

			inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
			// wait till the property returns 'stopped'
			while (!inputStream.readLine().equals("stopped")) {
				process.waitFor(1, TimeUnit.SECONDS);
				process = new ProcessBuilder(commandBootAnim).start();
				inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
			}
			System.out.println("Emulator is ready to use!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if an emulator or a device is already launched or plugged in
	 * 
	 * Example: <br>
	 * List of devices attached <br>
	 * 192.168.56.101:5555 device <br>
	 * emulator-5554 device
	 * 
	 * @return
	 */
	public static boolean isEmulatorOrDeviceReady() {

		try {
			String[] commandDevices = new String[] { adbPath, "devices" };
			Process process = new ProcessBuilder(commandDevices).start();

			BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String output = "";
			String line = null;
			while ((line = inputStream.readLine()) != null) {
				System.out.println(line);
				output = output + line;
			}
			if (!output.replace("List of devices attached", "").trim().equals("")) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws InterruptedException {
		String nameOfAVD = "AVD_for_Nexus_4_by_Google";

		launchEmulator(nameOfAVD);
		waitForEmulatorToBeReady();
		unlockScreen();
		Thread.sleep(60000);// 1 min
		closeEmulator();

		System.out.println("Is there any emulator launched or a device is plugged in? :" + isEmulatorOrDeviceReady());

		System.out.println("Execution completed!");
	}
}
