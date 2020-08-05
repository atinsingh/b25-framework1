package io.pragra.learning.b25.framework.testcases;

import io.pragra.learning.b25.framework.data.ExcelData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataTest {

   //@Parameters({"username", "password"})
    @Test(dataProviderClass = ExcelData.class, dataProvider ="accountData")
    public void createAccount(String email, String company, String first, String last){
        System.out.println(email);
        System.out.println(company);
        System.out.println(first);
        System.out.println(last);
    }


}
