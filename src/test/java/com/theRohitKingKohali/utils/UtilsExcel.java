//package com.theRohitKingKohali.utils;
//
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.testng.annotations.DataProvider;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class UtilsExcel {
//    public static String FILE_NAME = "src/test/java/resource/RestAssuredData.xlsx";
//static Workbook book;
//static Sheet sheet;
//
//    public static Object[][] getTestData(String sheetName) {
//        FileInputStream file = null;
//        try {
//            file = new FileInputStream(FILE_NAME);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            book= WorkbookFactory.create(file);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        sheet= book.getSheet(sheetName);
//
//        Object[][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//        for (int i=0;i<sheet.getLastRowNum();i++)
//        {
//            for (int j=0;j<sheet.getRow(0).getLastCellNum();j++ ){
//
//                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
//            }
//        }
//        return null;
//
//    }
//
//        @DataProvider
//        public Object[][] getData () {
//            return getTestData("Sheet1");
//
//
//        }
//
//
//    }
package com.theRohitKingKohali.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilsExcel {
    public static final String FILE_NAME = "src/test/java/resource/RestAssuredData.xlsx";
    static Workbook book;
    static Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(FILE_NAME);
            book = WorkbookFactory.create(file);
            sheet = book.getSheet(sheetName);

            int lastRowNum = sheet.getLastRowNum();
            int lastCellNum = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[lastRowNum][lastCellNum];
            for (int i = 0; i < lastRowNum; i++) {
                for (int j = 0; j < lastCellNum; j++) {
                    data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                }
            }
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("File not found: " + FILE_NAME, e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading the Excel file: " + FILE_NAME, e);
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @DataProvider
    public Object[][] getData() {
        return getTestData("Sheet1");
    }
}
