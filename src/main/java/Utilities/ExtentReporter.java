package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

    public static ExtentReports getExtentReports() {
        String reportPath = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Live Proj Automation Report");
        reporter.config().setDocumentTitle("Test Report Title");

        // Create an object for the extent report
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Operating System", "Windows 10");
        extent.setSystemInfo("Tested by", "Elaine");

        return  extent;

    }


}
