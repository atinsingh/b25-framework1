package io.pragra.learning.b25.framework.testcases;

import io.pragra.learning.b25.framework.config.Config;
import io.pragra.learning.b25.framework.drivermanager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DummyTest {

    // Check if broswer value is chrome.
    @Test
    public void tc1() {
      String browser=  Config.getInstance().getProperty("browser.type");
        Assert.assertEquals(browser,"chrome");
    }

    /**
     * @Bhaumik to add more test cases
     */

    @Test
    public void openZomoto() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        driver.get(Config.getInstance().getProperty("app.url"));

        Thread.sleep(10000);
        driver.quit();

    }

}
