package appium.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
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
 * It has an extra functionality that it takes a screenshot, command log and the
 * test summary when a test pass or fails or skip.
 * 
 * @author A. K. Sahu
 */
public class ReportNGListener extends TestListenerAdapter {

	private static Logger log = Logger.getLogger(ReportNGListener.class);

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.TestListenerAdapter#onFinish(org.testng.ITestContext)
	 */
	@Override
	public void onFinish(ITestContext testContext) {

		super.onFinish(testContext);
		CommandList.getInstance().clearCommandLog();

		generateTestExecutionSumamry(testContext);
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
			Reporter.log("<p><a href='" + screenshotFileUrl + "' target='_blank'>" + "<img src='" + screenshotFileUrl
					+ "' height='100' width='100' title='" + testName + "'/></a>");
			Reporter.log("<p>");
			Reporter.log("<font size=1>Click thumbnail image to view screenshot</font><p><br></font>");

			generateCommandLogReport(divId++);

			Reporter.setCurrentTestResult(null);

		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	/**
	 * Log the selenium command output to testNG report area
	 * 
	 * @param divId
	 */
	private void generateCommandLogReport(int divId) {

		if (CommandList.getInstance().isEmptySuccessList()
				|| !ConfigUtil.getProperty("CAPTURE_DRIVER_COMMANDS").equals("true")) {
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

	/**
	 * Generates the customized report summary
	 */
	private void generateTestExecutionSumamry(ITestContext testContext) {

		try {
			ITestNGMethod[] iTestNGMethods = testContext.getAllTestMethods();
			int totalTestCount = iTestNGMethods.length;
			int passedTestCount = testContext.getPassedTests().size();
			int failedTestCount = testContext.getFailedTests().size();
			int skippedTestCount = testContext.getSkippedTests().size();
			int pendingTestCount = totalTestCount - (passedTestCount + failedTestCount + skippedTestCount);
			log.info("Total:" + totalTestCount + " Passed:" + passedTestCount + " Failed:" + failedTestCount
					+ " Skipped:" + skippedTestCount + " Pending:" + pendingTestCount);

			File classPathRoot = new File(System.getProperty("user.dir"));
			File report = new File(new File(classPathRoot, File.separator + "target"), "indexHTML.html");
			report.createNewFile();

			BufferedWriter bw = new BufferedWriter(new FileWriter(report));
			bw.write("<html><head><title>Test Report - Overview</title>");
			String scriptHtml0 = "<script src=\"http://code.jquery.com/jquery-1.6.3.min.js\"></script>"
					+ "<script src=\"http://code.highcharts.com/highcharts.js\"></script>"
					+ "<script src=\"http://code.highcharts.com/modules/exporting.js\"></script>";
			bw.write(scriptHtml0);

			String scriptHtml1 = "<script type=\"text/javascript\">" + "function toggleVisibility(id, self) {"
					+ "   var e = document.getElementById(id);"
					+ "   if(e.style.display == 'block'){ e.style.display = 'none';}"
					+ "   else{ e.style.display = 'block';}" + "	  " + "   var f = self.innerText;"
					+ "   var g = self.textContent;" + "   var text = '';" + "   if(f != 'undefined'){text=f;}"
					+ "   if(g != 'undefined'){text=g;}"
					+ "   if(text.indexOf('Show Details')!=-1){ self.innerText='Hide Details'; self.textContent='Hide Details'; }"
					+ "   else{ self.innerText='Show Details'; self.textContent='Show Details'; }" + "}"

					+ "function toggleContent(id) {" + "	var contentId = document.getElementById(id);"
					+ "	contentId.style.display == \"block\" ? contentId.style.display = \"none\" : "
					+ "	contentId.style.display = \"block\"; " + "}" +

			"</script>";
			bw.write(scriptHtml1);

			String passedPercent = String.format("%.2f", ((float) passedTestCount / totalTestCount) * 100);
			String failedPercent = String.format("%.2f", ((float) failedTestCount / totalTestCount) * 100);
			String skippedPercent = String.format("%.2f", ((float) skippedTestCount / totalTestCount) * 100);
			String pendingPercent = String.format("%.2f", ((float) pendingTestCount / totalTestCount) * 100);

			String scriptHtml2 = "<script>" + "function createChart() {" + "	if (!navigator.onLine) {"
					+ "	  alert('Seems you are offline, chart summary can be viewed only if you are connected to internet. Please check your internet connectivity!');"
					+ "	  return false;" + "	}" + "	var chartLabel = \"Test Summary - Overview\"; "
					+ "	var seriesName = 'Report Summary';"
					+ "	var lagendNames = ['Passed', 'Failed', 'Skipped', 'Pending'];"
					+ "	var colorValues = ['#50B432', '#ED561B', 'gold', '#A9A9A9'];	" + "	var passedValue = "
					+ passedPercent + ";" + "	var failedValue = " + failedPercent + ";" + "	var skippedValue = "
					+ skippedPercent + ";" + "	var pendingValue = " + pendingPercent + ";" + "	var chartWidth = 350;"
					+ "	var chartHeight = 300;		" + "    $('#pieChart').highcharts({" + "        chart: {"
					+ "            plotBackgroundColor: null," + "            plotBorderWidth: null,"
					+ "			borderWidth: 1," + "			borderColor: 'lightGrey',"
					+ "            plotShadow: false," + "			width: chartWidth,"
					+ "			height: chartHeight,"
					+ "			style: { fontFamily: 'Calibri, sans-serif', fontSize: '14px', color: 'grey' }			"
					+ "        }," + "        title: {" + "            text: chartLabel +' (pie)',"
					+ "			style: { fontFamily: 'Calibri, sans-serif', lineHeight: '16px', fontSize: '15px', color: 'purple'}"
					+ "        }," + "        tooltip: {" + "            formatter: function () {"
					+ "				return '<b>' + this.point.name + '</b>: ' + Highcharts.numberFormat(this.percentage, 2) + ' %';"
					+ "			}" + "        }," + "		credits: {" + "		    enabled: false" + "		},		"
					+ "        plotOptions: {" + "            pie: {" + "                allowPointSelect: true,"
					+ "                cursor: 'pointer'," + "                dataLabels: {"
					+ "                    enabled: true,"
					+ "                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',"
					+ "                    style: { color: 'darkBlue'},"
					+ "					connectorColor: 'silver'" + "                }" + "            }"
					+ "        },		" + "		colors: colorValues," + "        series: [{"
					+ "            type: 'pie'," + "			name: seriesName," + "            data: [			"
					+ "                ['Passed',passedValue]," + "                ['Failed',failedValue],"
					+ "                ['Skipped',skippedValue]," + "                {"
					+ "                    name: 'Pending'," + "                    y: pendingValue,"
					+ "                    sliced: true," + "                    selected: true" + "                }"
					+ "            ]" + "        }]" + "    });" + "	$('#columnChart').highcharts({"
					+ "        chart: {" + "            type: 'column',			" + "            plotBorderWidth: 0,"
					+ "			borderWidth: 1," + "			borderColor: 'lightGrey',"
					+ "			width: chartWidth," + "			height: chartHeight,"
					+ "			style: { fontFamily: 'Calibri, sans-serif', lineHeight: '16px', fontSize: '12px', color: 'grey'}"
					+ "        }," + "		title: {" + "			text: chartLabel+' (column)',"
					+ "			style: { fontFamily: 'Calibri, sans-serif', lineHeight: '16px', fontSize: '15px', color: 'purple'}"
					+ "		}," + "        xAxis: {" + "            categories: lagendNames," + "			title: {"
					+ "				text: 'TC Status',"
					+ "				style: { fontFamily: 'Calibri, sans-serif', lineHeight: '16px', fontSize: '12px', color: 'darkBlue' }"
					+ "			}," + "			labels: {                "
					+ "				style: { fontFamily: 'Calibri, sans-serif', lineHeight: '16px', fontSize: '12px', color: 'grey' }"
					+ "            }" + "        }," + "		yAxis: {" + "			title: {"
					+ "				text: 'Values (in %)',"
					+ "				style: { fontFamily: 'Calibri, sans-serif', lineHeight: '16px', fontSize: '12px', color: 'darkBlue' }"
					+ "			}" + "		}," + "		credits: {" + "		    enabled: false" + "		},"
					+ "        plotOptions: {" + "            series: {" + "                allowPointSelect: true,"
					+ "				dataLabels: {" + "					enabled: true,"
					+ "					 format: '{point.y:.1f}%'" + "				}" + "            },"
					+ "			column: {" + "				colorByPoint: true," + "				events: {"
					+ "					legendItemClick: function () {" + "						return false;"
					+ "					}" + "				},				" + "				allowPointSelect: false"
					+ "			}" + "        }," + "		tooltip: {" + "			formatter: function() {"
					+ "                return '<b>'+this.x +'</b>: '+ Highcharts.numberFormat(this.y, 2) +'%';"
					+ "			}" + "		}," + "		colors: colorValues," + "		series: [{"
					+ "			type: 'column'," + "			name: seriesName," + "			showInLegend: false,"
					+ "			allowPointSelect: false,"
					+ "			data: [passedValue, failedValue, skippedValue, pendingValue]" + "		}]" + "    });"
					+ "}" + "</script>";
			bw.write(scriptHtml2);

			String styleHtml = "<style type=\"text/css\">" + "body {"
					+ "    font-family: calibri,verdana,helvetica,arial,sans-serif;" + "    font-size: 11px;"
					+ "    color: rgb(95, 96, 98);" + "}" + "" + "table tr th:first-child, td:first-child {"
					+ "    border-top-left-radius: 0.5em;" + "    border-bottom-left-radius: 0.5em;" + "}" + ""
					+ "table tr th:last-child, td:last-child {" + "    border-top-right-radius: 0.5em;"
					+ "    border-bottom-right-radius: 0.5em;" + "}" + "" + "tr.reportTableRow: {" + "}" + ""
					+ "tr.reportTableRow:hover {" + "    background-color: #eee;" + "    color: maroon;"
					+ "    background-image: linear-gradient(#CCC, #AAA);" + "}" + "" + "#showChart {"
					+ "    border: 1px solid #CCCCCC;" + "    color: #4A4A4A;"
					+ "    background-image: linear-gradient(to bottom, #F7F5F6, #DDDDDD);"
					+ "    -webkit-border-radius: 10px;" + "    -moz-border-radius: 10px;" + "    border-radius: 10px;"
					+ "    line-height: 20px;" + "    cursor: pointer;" + "}" + "" + "#showChart:hover {"
					+ "    border: 1px solid #ADADAD;"
					+ "    background-image: linear-gradient(to bottom, #F7F5F6, #CCCCCC);" + "}" + "</style>";
			bw.write(styleHtml);
			bw.write("</head><body><center>");

			String summaryHtml = "<fieldset style=\"width:550px;padding:15px;border:1px dashed grey;-webkit-border-radius:10px;-moz-border-radius:10px;border-radius:10px;\">"
					+ "<legend><h2>Test Execution Summary</h2></legend>"
					+ "<table cellpadding=\"5\" style=\"width:500px;border:0px dashed maroon;text-align:center;\">"
					+ "<tbody><tr>" + "<td style=\"background-color:green;color:white;\">Passed</td>"
					+ "<td style=\"background-color:#D5B96A;color:white;\">Skipped</td>"
					+ "<td style=\"background-color:#F08080;color:white;\">Failed</td>"
					+ "<td style=\"background-color:#A9A9A9;color:white;\">Pending</td>"
					+ "<td style=\"background-color:#778899;color:white;\">Total</td></tr>"
					+ "<tr><td style=\"background-color:#AAD279;\">" + passedTestCount + "</td>"
					+ "<td style=\"background-color:#FCEDB0;\">" + skippedTestCount + "</td>"
					+ "<td style=\"background-color:#F7C9BA;\">" + failedTestCount + "</td>"
					+ "<td style=\"background-color:#F5F5F5;\">" + pendingTestCount + "</td>"
					+ "<td style=\"background-color:#D3D3D3;\">" + totalTestCount + "</td></tr></tbody></table>"
					+ "<br><button id=\'showChart\' onClick=\"createChart();toggleContent('charts');\">Show/Hide Chart Summary</button>"
					+ "</fieldset><br>";
			bw.write(summaryHtml);

			String highChartHtml = "<div style=\"width:710px;\">" + "	<div id=\"charts\" style=\"display:none;\">"
					+ "	   <div id=\"pieChart\" style=\"float:left;background-color:white;\"></div>"
					+ "	   <div style=\"float:left;\"> </div>"
					+ "	   <div id=\"columnChart\" style=\"float:left;background-color:white;\"></div>	" + "	</div>"
					+ "</div><br><br>";
			bw.write(highChartHtml);
			bw.write("<iframe src=\"html/index.html\" width=\"100%\" height=\"100%\" frameBorder=\"0\"></iframe>");
			bw.write("</center>");
			bw.write("</body></html>");
			bw.close();

		} catch (Exception e) {
			log.error("Couldn't show intermediate execution report." + e.getMessage());
		}
	}
}
