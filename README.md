###Introduction
This is a common framework for testing mobile applications using **Appium**. Initially I am working for Android applications and later will work to suppost iOS applications as well.

###Key Features
This framework has the following key features:
 - It handles starting/stopping appium server programmatically, user don't need to start/kill it everytime before and after execution of test executions.
 - Allows to capture **screenshot** on test failure/success/skip and also capturing screen during non-application related exceptions for better debugging
 - Logging both **android log** and **application log** automatically with various event listeners and driver commands apart from user defined logs(which is optional)
 - Customized reporting with more test info for easy debugging with screenshots and test summary. This report also tracks all driver commands that are executed/called by tests automatically and shows as part of test execution report.
 - This framework has integration of commonly used framework i.e. **TestNG** with appium for better test execution flow and customizations and is uses maven as build system.
 - Image comparison of various screens with a specific set of devices/emulators/simulators[WIP].
 - Parallel execution of tests with multiple devices/emulators/simulators[WIP].
 
###Usage:
Download the project to your local machine or import using git
 - AppiumCoreAF - This is the core automation framework which can be used for any test project
 - AppiumTestBase - This is a sample test project for testing "WordPress" android application

Once you have downloaded/imported, please execute the following commands to test a sample set of tests using this framework.
Navigate to the appium framework directory i.e. **AppiumCoreAF** location and do
```sh
>mvn clean install
```
And then navigate to the test project directory i.e. **AppiumTestBase** location and do
```sh
>mvn clean test
```

Your tests should execute and prepare the report(I have used ReportNG report and customized a bit to get more user friendly report).

###Report Example:
 - Test Summary(Execution status): 
   ![alt tag](https://cloud.githubusercontent.com/assets/1167000/10606433/7f3df882-7750-11e5-924e-d1ae2dc74269.png)

 - Summary in Highchart: 
   ![alt tag](https://cloud.githubusercontent.com/assets/1167000/10606437/84f4d4b2-7750-11e5-97ca-8f587e363654.png)
 
- Test Summary with %: 
   ![alt tag](https://cloud.githubusercontent.com/assets/1167000/10606440/88fc157a-7750-11e5-988e-12a5dc15d1ab.png)

 - Failed Test Deatils: 
   ![alt tag](https://cloud.githubusercontent.com/assets/1167000/10606441/8b609fc0-7750-11e5-9548-1293e270676f.png)

 - Failed Test Details with all Driver Commands(steps):
   ![alt tag](https://cloud.githubusercontent.com/assets/1167000/10606445/8ddcabc2-7750-11e5-9129-178cc82f3fbc.png)
