package io.pragra.learning.b25.framework.testcases;

import io.pragra.learning.b25.framework.config.Config;
import io.pragra.learning.b25.framework.drivermanager.DriverManager;
import io.pragra.learning.b25.framework.listeners.ScreenShotListener;
import io.pragra.learning.b25.framework.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({ScreenShotListener.class})
public class DummyTest {

    // Check if broswer value is chrome.

    /**
     * @Bhaumik to add more test cases
     */

    @Test
    public void openZomoto() throws InterruptedException, IOException {
        WebDriver driver = DriverManager.getDriver();
        driver.get(Config.getInstance().getProperty("app.url"));
        Thread.sleep(10000);
    }

    @AfterSuite
    public void tearDown() {
        DriverManager.getDriver().quit();
    }
}
