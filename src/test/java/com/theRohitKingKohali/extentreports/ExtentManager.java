package com.theRohitKingKohali.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentTest test;

    public static ExtentReports getInstance() {

        if (extent == null) {
            htmlReporter = new ExtentHtmlReporter("extentReportRestAssuredAPI.html");
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle("API Automation Report");
            htmlReporter.config().setReportName("Test Report");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("os", "Windows");
            extent.setSystemInfo("Tester", "Pro Tester");

        }
        return extent;

        }
        public static ExtentTest createTest(String testName, String description){
        test=extent.createTest(testName,description);
        return test;
        }
    }