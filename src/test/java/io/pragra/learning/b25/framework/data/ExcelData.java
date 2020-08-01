package io.pragra.learning.b25.framework.data;

import io.pragra.learning.b25.framework.config.Config;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelData {

    private  Workbook workbook;
    private static   ExcelData instance;


    private ExcelData() throws IOException {
        Path path = Paths.get(Config.getInstance().getProperty("excel.path"));
        InputStream stream = new FileInputStream(path.toFile());
        workbook = new XSSFWorkbook(stream);
    }

    @DataProvider
    public static Iterator<Object []>  getContactData(){
        return getDataFromSheet("contact");
    }


    public static Iterator<Object []> getDataFromSheet(String sheetName){
        List<Object[]> data = new ArrayList<>();
        if(instance==null) {
            try {
                instance = new ExcelData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Sheet sheet = instance.workbook.getSheet(sheetName);

        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            List<Object> cellData = new ArrayList<>();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                if(cell.getCellType()== CellType.STRING){
                    cellData.add(cell.getStringCellValue());
                }
                if(cell.getCellType()== CellType.NUMERIC){
                    cellData.add(cell.getNumericCellValue());
                }
                if(cell.getCellType()== CellType.BOOLEAN){
                    cellData.add(cell.getBooleanCellValue());
                }
            }
            data.add(cellData.toArray());
        }
        return data.iterator();
    }

}
