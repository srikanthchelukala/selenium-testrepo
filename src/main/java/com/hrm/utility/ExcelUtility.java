package com.hrm.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelUtility {
    public static String getTestData(int rowNumber,int cellNumber) throws InvalidFormatException, IOException {
        File file=new File("src/test/resources/usersdata.xlsx"); //create file class object
        XSSFWorkbook wrkbook =new XSSFWorkbook(file);
        XSSFSheet sheet=wrkbook.getSheetAt(0);
        return sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
    }

    public static String getTestData1(int rowNumber,int cellNumber) throws InvalidFormatException, IOException {
        File file=new File("src/test/resources/usersdata.xlsx"); //create file class object
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet=workbook.getSheetAt(0);
        return sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
    }

    public static Object[][] getAllTestData(String filePath,String SheetName) throws IOException {
    File file = new File(filePath);
    try (Workbook workbook = WorkbookFactory.create(file)) {
        // Sheet sheet = workbook.getSheetAt(0);
         Sheet sheet = workbook.getSheet(SheetName);
        int firstDataRow = 1; // Skip header row
        int lastRow = sheet.getLastRowNum();
        int totalRows = lastRow - firstDataRow + 1;
        Object[][] data = new Object[totalRows][2];
        DataFormatter formatter = new DataFormatter();
        for (int rowIndex = firstDataRow;
             rowIndex <= lastRow;
             rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            data[rowIndex - firstDataRow][0] = formatter.formatCellValue(row.getCell(0));
            data[rowIndex - firstDataRow][1] = formatter.formatCellValue(row.getCell(1));
        }
        return data;
    }
}


}
