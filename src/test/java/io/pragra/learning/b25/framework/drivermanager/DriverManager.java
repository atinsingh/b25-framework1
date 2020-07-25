package io.pragra.learning.b25.framework.drivermanager;

import io.pragra.learning.b25.framework.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @Navdeep to add logger and error handling in class
 */

public class DriverManager {
    // Declare the web driver
    private WebDriver driver;
    //define instance to restrict the one broswer at a time
    // we will change it when grid will be added.
    private static DriverManager instance;
    private DriverManager(){
        init();
    }
    private void init(){
        if( Config.getInstance()
                .getProperty("browser.type")
                .equalsIgnoreCase(BrowserTypes.CHROME)){
            System.setProperty("webdriver.chrome.driver",
                    Config.getInstance().getProperty("chrome.executable"));
            driver = new ChromeDriver();
        }else if(Config.getInstance()
                .getProperty("browser.type")
                .equalsIgnoreCase(BrowserTypes.FIREFOX)){
            System.setProperty("webdriver.gecko.driver",
                    Config.getInstance().getProperty("firefox.executable"));
            driver = new FirefoxDriver();
        }
        // Mehak to add all browser support
        else {
            // if none matches default is CHROME
            System.setProperty("webdriver.chrome.driver",
                    Config.getInstance().getProperty("chrome.executable"));
            driver = new ChromeDriver();
        }
    }

    public synchronized static WebDriver getDriver(){
        if(instance == null){
            instance = new DriverManager();
        }
        return instance.driver;
    }
}
