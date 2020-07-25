package io.pragra.learning.b25.framework.listeners;

import io.pragra.learning.b25.framework.drivermanager.DriverManager;
import io.pragra.learning.b25.framework.utils.Utils;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ScreenShotListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        captureScreen(result, true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreen(result, false);
    }


    private void captureScreen(ITestResult result, boolean b) {
        try {
            Utils.captureScreenShot(DriverManager.getDriver(), result.getName(), b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
