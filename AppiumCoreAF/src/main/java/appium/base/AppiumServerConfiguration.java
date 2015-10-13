package appium.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This page models Appium server using command line executions
 * 
 * @author A. K. Sahu
 *
 */
public class AppiumServerConfiguration {

	String appiumInstallationDir = "C:/Program Files (x86)";
	String appiumNode = appiumInstallationDir + File.separator + "Appium" + File.separator + "node.exe";
	String appiumNodeModule = appiumInstallationDir + File.separator + "Appium" + File.separator + "node_modules"
			+ File.separator + "appium" + File.separator + "bin" + File.separator + "Appium.js";
	String appiumServicePort = "4723";

	/**
	 * Starts appium server
	 */
	public void startAppiumServer() {
		executeCommand("\"" + appiumNode + "\" \"" + appiumNodeModule + "\" " + "--no-reset --local-timezone");
	}

	/**
	 * Stops appium server
	 */
	public void stopAppiumServer() {
		executeCommand("cmd /c echo off & FOR /F \"usebackq tokens=5\" %a in" + " (`netstat -nao ^| findstr /R /C:\""
				+ appiumServicePort + "\"`) do (FOR /F \"usebackq\" %b in"
				+ " (`TASKLIST /FI \"PID eq %a\" ^| findstr /I node.exe`) " + "do taskkill /F /PID %a)");
	}

	/**
	 * Executes any command for Windows using ProcessBuilder of Java You can
	 * change the first input parameter of ProcessBuilder constructor if your OS
	 * is not windows operating system
	 * 
	 * @param aCommand
	 */
	public void executeCommand(String aCommand) {
		File currDir = new File(System.getProperty("user.dir"));
		String line;
		try {
			ProcessBuilder probuilder = new ProcessBuilder("CMD", "/C", aCommand);
			probuilder.directory(currDir);
			Process process = probuilder.start();

			BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader errorStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			// reading output of the command
			int inputLine = 0;
			while ((line = inputStream.readLine()) != null) {
				if (inputLine == 0) {
					System.out.printf("Output of the running command is: \n");
				}
				System.out.println(line);
				inputLine++;
			}

			// reading errors from the command
			int errLine = 0;
			while ((line = errorStream.readLine()) != null) {
				if (errLine == 0) {
					System.out.println("Error of the command is: \n");
				}
				System.out.println(line);
				errLine++;
			}

			// exitValue = process.waitFor();
		} catch (IOException e) {
			System.err.println("Exception occured: \n");
			System.err.println(e.getMessage());
		}
	}
}
