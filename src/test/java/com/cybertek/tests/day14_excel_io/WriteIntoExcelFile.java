package com.cybertek.tests.day14_excel_io;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteIntoExcelFile {

    public static void main(String[] args) throws IOException {

        //whenever you are writing data back into excel file, do not open it!
        String path = "vytrack_testusers.xlsx";

        //FileInputStream - read into the file but we have to close it in the end
        //FileOutputStream - write into the file, also has to be closed in the end
        FileInputStream file = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("QA2-short");
        Row row1 = sheet.getRow(1);
        //lets set N/A to PASSED
        Cell cell5 = row1.getCell(4);

        System.out.println("value: " + cell5);
        //to change value:
        cell5.setCellValue("FAILED");

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
        System.out.println(cell5);

    }

}
