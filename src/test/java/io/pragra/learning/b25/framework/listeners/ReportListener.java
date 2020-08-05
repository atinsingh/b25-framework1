package io.pragra.learning.b25.framework.listeners;

import com.aventstack.extentreports.ExtentTest;
import io.pragra.learning.b25.framework.reports.HtmlReports;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = HtmlReports.createTest(result.getName());
        test.pass("Passing our test case automatically");
    }

    @Override
    public void onTestFailure(ITestResult result) {

    }


}
