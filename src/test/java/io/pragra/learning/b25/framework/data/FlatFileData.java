package io.pragra.learning.b25.framework.data;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlatFileData {

    @DataProvider
    public static Iterator<Object []> getSalesData() throws IOException {
        List<Object [] > data = new ArrayList<>();
        List<String>lines = Files.readAllLines(Paths.get("data/contactdata.csv"));
        for (String line: lines) {
           String [] testdata =  line.split(",");
           data.add(testdata);
        }
        return data.iterator();
    }
}
