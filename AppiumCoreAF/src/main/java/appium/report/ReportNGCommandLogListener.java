package appium.report;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import appium.base.DriverManager;
import appium.util.ConfigUtil;
import appium.util.ScreenshotCapture;
import appium.util.TestUtility;

/**
 * This class has to be added to the testng task to listen for events.
 * 
 * It has an extra functionality that it takes a screenshot(of the browser
 * window) when a test pass or fails or skip.
 * 
 * Example usage:
 * 
 * <pre>
 * <testng outputdir="reports/reportng" useDefaultListeners="true"
 *         listener="org.uncommons.reportng.HTMLReporter,org.uncommons.reportng.JUnitXMLReporter,appium.report.ReportNGCommandLogListener">
 * </pre>
 * 
 * @author A. K. Sahu
 */
public class ReportNGCommandLogListener extends TestListenerAdapter {

	private int divId = 1;
	private int count = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.TestListenerAdapter#onStart(org.testng.ITestContext)
	 */
	@Override
	public void onStart(ITestContext testContext) {

		super.onStart(testContext);
		CommandList.getInstance().clearCommandLog();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.TestListenerAdapter#onFinish(org.testng.ITestContext)
	 */
	@Override
	public void onFinish(ITestContext testContext) {

		super.onFinish(testContext);
		CommandList.getInstance().clearCommandLog();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.TestListenerAdapter#beforeConfiguration(org.testng.
	 * ITestContext)
	 */
	@Override
	public void beforeConfiguration(ITestResult result) {
		super.beforeConfiguration(result);

		CommandList.getInstance().clearCommandLog();
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		super.onTestSuccess(result);
		doReportNGReporting(result, "PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		super.onTestFailure(result);
		CommandList.getInstance().reportFailure(result.getThrowable().toString());
		// CommandList.getInstance().reportFailure(Arrays.asList(result.getThrowable().getStackTrace()).toString());
		doReportNGReporting(result, "FAILED");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		super.onTestSkipped(result);
		doReportNGReporting(result, "SKIPPED");
	}

	/**
	 * The method does all reporting into ReportsNG.
	 * 
	 * @param result
	 * @param status
	 */
	private void doReportNGReporting(ITestResult result, String status) {

		try {

			String testName = result.getName();
			String screenshotFileUrl = "file:///" + TestUtility.getScreenshotDirectory() + File.separator + testName
					+ ".png";

			if (status.equals("SKIPPED")) {
				if (count == 0) {// take only one screenshot
					ScreenshotCapture.takeScreenshot(new DriverManager().getDriver(), testName);
					count++;
				}
			}

			Reporter.setEscapeHtml(false);
			Reporter.setCurrentTestResult(result);

			Object[] parameters = result.getParameters();
			Reporter.log("<p><font face=arial size=2 color=000099");
			if (parameters.length > 0)
				Reporter.log("<p>Total number of input parameters: " + parameters.length + "<p>");

			for (int i = 0; i < parameters.length; i++) {
				Reporter.log("Parameter: " + parameters[i]);
			}

			Reporter.log("<b>Screenshot</b><br>");
			Reporter.log("<p><a href='" + screenshotFileUrl + "'>" + "<img src='" + screenshotFileUrl
					+ "' height='100' width='100' title='" + testName + "'/></a>");
			Reporter.log("<p>");
			Reporter.log("<font size=1>Click thumbnail image to view screenshot</font><p><br></font>");

			generateCommandLogReport(divId++);

			Reporter.setCurrentTestResult(null);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Log the selenium command output to testNG report area
	 * 
	 * @param divId
	 */
	private void generateCommandLogReport(int divId) {

		if (!ConfigUtil.getProperty("CAPTURE_DRIVER_COMMANDS").equals("true")) {
			CommandList.getInstance().clearCommandLog();
			return;
		}

		String newId = "commandlogdiv" + divId;

		String[] listSuccess = CommandList.getInstance().getSuccessList();

		// Note: toggleElement is a javascript function provided by ReportsNG
		Reporter.log(
				"<p><input style=\"background-color:#ededed;border:1px solid #dcdcdc;padding:3px;border-radius: 5px;box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);\" type=\"button\" onclick=\"javascript:toggleElement('"
						+ newId + "', 'block');\" value=\"Show/Hide Commands Log Report\" /><p><br>");
		Reporter.log("<div class=\"mid\" id=\"" + newId + "\" style=\"DISPLAY: none\">");

		Reporter.log("<style>"
				+ "table tr th:first-child, td:first-child { border-top-left-radius:0.5em;border-bottom-left-radius:0.5em;}"
				+ "table tr th:last-child, td:last-child {  border-top-right-radius:0.5em;border-bottom-right-radius:0.5em;}"
				+ "</style>");

		Reporter.log("<style>.cLog {font-family: Arial, Helvetica, sans-serif;font-size:13px;color:darkBlue;}</style>");// border-collapse:
																														// collapse;
		Reporter.log(
				"<table cellpadding=\"3\" cellspacing=\"3\" class='cLog' style=\"border:2px dotted #778899;border-radius: 5px;\">");
		Reporter.log(
				"<tr><td class='cLog' style=\"background-color:#778899;color:white;padding: 0.5em 1em 0.5em 1em;\"><b>Commands Executed:</b></td><td class='cLog' style=\"background-color:#778899;color:white;padding: 0.5em 1em 0.5em 1em;\"><b>Status</b></td></tr>");

		for (int i = 0; i < listSuccess.length; i++) {

			if (i % 2 == 0) {
				Reporter.log("<tr class='cLog' style=\"background-color:#f2f2f2;\"><td class='cLog'>");
			} else {
				Reporter.log("<tr class='cLog' style=\"background-color:#f4f4f4;\"><td class='cLog'>");
			}
			Reporter.log(listSuccess[i]);
			Reporter.log(
					"</td><td class='cLog' style=\"width:30px;vertical-align: middle;text-align: center;\"><font size=1.6 color=green><b>&#10004;</b></font></td><tr>");
		}

		if (!CommandList.getInstance().isEmptyFailureList()) {
			String[] listFailure = CommandList.getInstance().getFailureList();
			for (int i = 0; i < listFailure.length; i++) {
				if ((listSuccess.length + i) % 2 == 0) {
					Reporter.log("<tr class='cLog' style=\"background-color:#f2f2f2;\"><td class='cLog'>");
				} else {
					Reporter.log("<tr class='cLog' style=\"background-color:#f4f4f4;\"><td class='cLog'>");
				}
				Reporter.log(listFailure[0]);
				Reporter.log(
						"</td><td class='cLog' style=\"width:30px;vertical-align: middle;text-align: center;\"><font size=1.6 color=red><b>&#10008;</b></font></td><tr>");
			}
		}

		Reporter.log("</table>");
		Reporter.log("<br>");

		CommandList.getInstance().clearCommandLog();
	}

}
