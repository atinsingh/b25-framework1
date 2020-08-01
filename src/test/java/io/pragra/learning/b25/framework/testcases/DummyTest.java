package io.pragra.learning.b25.framework.testcases;

import io.pragra.learning.b25.framework.config.Config;
import io.pragra.learning.b25.framework.drivermanager.DriverManager;
import io.pragra.learning.b25.framework.listeners.ScreenShotListener;
import io.pragra.learning.b25.framework.pages.RequestADemoPage;
import io.pragra.learning.b25.framework.pages.TopNavigationBar;
import io.pragra.learning.b25.framework.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners({ScreenShotListener.class})
public class DummyTest {

    // Check if broswer value is chrome.

    /**
     * @Bhaumik to add more test cases
     */
    WebDriver driver;

    @BeforeSuite
    public void openZomoto() throws InterruptedException, IOException {
        driver = DriverManager.getDriver();
        driver.get(Config.getInstance().getProperty("app.url"));
    }

    @Test
    public void testRequestDemo() {
        TopNavigationBar topNavigationBar = new TopNavigationBar(driver);
       // RequestADemoPage demoPage = topNavigationBar.clickOnRequestDemo();
        //Assert.assertEquals(demoPage.getHeadingText(), "Request a Demo");

        topNavigationBar.clickOnDownloadZoom();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        if(wait.until(ExpectedConditions.titleContains("Download Center"))){
            Assert.assertEquals(driver.getTitle(),"Download Center - Zoom");
        }


//        demoPage
//                .keyInEmail("atin@gmail.com")
//                .and()
//                .keyCompany("Pragra");
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        DriverManager.getDriver().quit();
    }
}
