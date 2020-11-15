package com.cybertek.tests.day14_excel_io;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelFile {

    public static void main(String[] args) throws IOException {

        String path = "vytrack_testusers.xlsx";
        File file = new File(path);

        //Step 1. Create excel file object:
        //workbook object represents excel file
        //it has spread sheets that we are going to read as well
        //work book is an interface
        Workbook workbook = WorkbookFactory.create(file);
        int numOfSheets = workbook.getNumberOfSheets();
        System.out.println("Number of sheets: " + numOfSheets);

        //Step 2. Create object of spreadsheet:
        Sheet sheet = workbook.getSheet("QA3-short");

        //Step 3. Read a row:
        Row row = sheet.getRow(0);

        //Step 4. Read a cell:
        Cell cell1 = row.getCell(0);

        //Step 5. Extract value
        String value1 = cell1.getStringCellValue();

        //Step 6. Use value
        System.out.println("Value of 1st row 1st column: " + value1);

        //get all spreadsheets names
        //sh - temporary variable
        workbook.forEach(sh -> System.out.println(sh.getSheetName()));

        //how do we get data from an entire row:
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()){
            String value = cellIterator.next().getStringCellValue();
            System.out.print(value + " ");
        }

        System.out.println("\n===============================================================");

        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()){
            Iterator<Cell> tempCellIter = rowIterator.next().cellIterator();
            while (tempCellIter.hasNext()){
                String value = tempCellIter.next().getStringCellValue();
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }

}
