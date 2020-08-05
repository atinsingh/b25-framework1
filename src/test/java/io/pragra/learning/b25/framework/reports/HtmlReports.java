package io.pragra.learning.b25.framework.reports;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.pragra.learning.b25.framework.utils.Utils;

public class HtmlReports {
    private static HtmlReports reports;
    private ExtentReports extentReports;

    public HtmlReports() {
        extentReports = new ExtentReports();
        ExtentReporter reporter  = new ExtentHtmlReporter(Utils.getReportFileName());
        extentReports.attachReporter(reporter);
    }

    public synchronized static ExtentTest createTest(String testName){
        if(reports == null){
            reports = new HtmlReports();
        }
        return reports.extentReports.createTest(testName);
    }

    public synchronized static void flush(){
        if(reports!=null) {
            reports.extentReports.flush();
        }
    }
}

