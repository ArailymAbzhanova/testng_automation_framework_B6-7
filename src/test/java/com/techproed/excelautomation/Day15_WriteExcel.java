package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day15_WriteExcel {
    @Test
    public void writeExcel() throws IOException {
        //Locating the path of the excel workbook
        String path ="./src/test/java/resources/Capitals.xlsx";//MAC
        //String path =".\\src\\test\\java\\resources\\Capitals.xlsx";//WINDOWS
        FileInputStream fileInputStream = new FileInputStream(path);
        //Opening the workbook using fileinputstream
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);//Reading the first sheet
        Row row=sheet.getRow(0);//Going to the first row
        Cell cell4=row.createCell(3);//Create a cell on the 3rd index on the first row
        cell4.setCellValue("POPULATION");
        //Create a cell on the 2nd row 4th cell(index3), and write 150000
        //WE CAN CHAIN THE METHODS
        sheet.getRow(1).createCell(3).setCellValue("150000");
        //Create a cell on the 3rd row 4th cell(index3), and write 250000
        sheet.getRow(2).createCell(3).setCellValue("250000");
        //Create a cell on the 4th row 4th cell(index3), and write 54000
        sheet.getRow(3).createCell(3).setCellValue("54000");

        //Write and Save the values, use fileoutputstream
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);

        //Closing the files
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }
}
