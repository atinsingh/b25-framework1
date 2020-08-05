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

    private Workbook workbook;

    public ExcelData() {
        Path path = Paths.get(Config.getInstance().getProperty("datafile.path"));
        try {
            InputStream stream = new FileInputStream(path.toFile());
            workbook = new XSSFWorkbook(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Object []> getDataFromSheet(String sheetName, boolean skipHeader){
        Sheet sheet = workbook.getSheet("Contact");

        Iterator<Row> rowIterator = sheet.rowIterator();
        List<Object[]> sheetData = new ArrayList<>();
        if(skipHeader){
            rowIterator.next();
        }
        while (rowIterator.hasNext()) {
            // Get the row using next method
            Row row = rowIterator.next();
            // get the cell iterator from row
            Iterator<Cell> cellIterator = row.cellIterator();
            List<Object> rowData = new ArrayList<>();
            while (cellIterator.hasNext()) {
                // get the cell using next method
                Cell cell = cellIterator.next();
                // check the type of cell to read the value
                if(cell.getCellType() == CellType.STRING) {
                    // if string value read as string and add to row data
                    rowData.add(cell.getStringCellValue());
                }
                if(cell.getCellType() == CellType.NUMERIC) {
                    // if string value read as string and add to row data
                    rowData.add(cell.getNumericCellValue());
                }
                if(cell.getCellType() == CellType.BOOLEAN) {
                    // if string value read as string and add to row data
                    rowData.add(cell.getBooleanCellValue());
                }
            } // completed iteraton of all cells in the row, now we will do to
            // next row as we are in outer loop
            sheetData.add(rowData.toArray());

        }// all rows are done here
        return sheetData;

    }

    @DataProvider
    public Iterator<Object[]> accountData(){
        return getDataFromSheet("Contact", true).iterator();
    }

}
