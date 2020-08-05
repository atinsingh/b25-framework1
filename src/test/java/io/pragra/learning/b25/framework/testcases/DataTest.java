package io.pragra.learning.b25.framework.testcases;

import com.aventstack.extentreports.ExtentTest;
import io.pragra.learning.b25.framework.data.ExcelData;
import io.pragra.learning.b25.framework.reports.HtmlReports;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataTest {

   //@Parameters({"username", "password"})
    @Test(dataProviderClass = ExcelData.class, dataProvider ="accountData")
    public void createAccount(String email, String company, String first, String last){


    }


    @AfterSuite
    public void tearDown() {
        HtmlReports.flush();
    }
}
