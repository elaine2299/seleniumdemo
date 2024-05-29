package Listeners;

import Utilities.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;

import java.io.IOException;
import java.lang.reflect.Field;

public class Listeners extends Base implements ITestListener {
    WebDriver driver;

    ExtentReports extentReport = ExtentReporter.getExtentReports();
    ExtentTest extentTest;
    ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<>();

    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        extentTest = extentReport.createTest(testName + " execution started");
        extentTestThread.set(extentTest);
    }

    public void onFinish(ITestContext context) {
        String testName1 = context.getName();
        System.out.printf(testName1 + " execution completed");
        extentReport.flush();
    }

    public void onTestSuccess(ITestResult result) {
        String testName = result.getName();
        extentTestThread.get().log(Status.PASS, testName + " passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testMethodName = result.getName();
        extentTestThread.get().fail(result.getThrowable());

        try {
            // Attempt to retrieve the WebDriver instance
            Object instance = result.getInstance();
            if (instance instanceof Base) {
                driver = ((Base) instance).getDriver();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (driver != null) {
            try {
                String screenshotFilePath = takeScreenshots(testMethodName, driver);
                extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Driver is not initialized. Cannot take screenshot.");
        }
    }

    /*
    @Override
    public void onTestFailure(ITestResult result) {
        String testMethodName = result.getName();
        extentTestThread.get().fail(result.getThrowable());

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException | SecurityException e1) {
            e1.printStackTrace();
        }

        //if (driver != null) {
        try {
                String screenshotFilePath = takeScreenshots(testMethodName, driver);
                extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


     */

    public void onTestSkipped(ITestResult result) {
        // Skipped test handling logic
    }
}
