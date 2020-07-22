package io.pragra.learning.b25.framework.testcases;

import io.pragra.learning.b25.framework.config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DummyTest {

    // Check if broswer value is chrome.
    @Test
    public void tc1() {
      String browser=  Config.getInstance().getProperty("browser.type");
        Assert.assertEquals(browser,"chrome");
    }
}
