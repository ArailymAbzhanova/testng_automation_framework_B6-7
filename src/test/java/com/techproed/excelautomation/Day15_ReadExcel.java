package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Workbook > Worksheet > Row > Cell.
public class Day15_ReadExcel {
    @Test
    public void readExcel() throws Exception {
        //Locating the path of the excel workbook
        String path ="./src/test/java/resources/Capitals.xlsx";//MAC
        //String path =".\\src\\test\\java\\resources\\Capitals.xlsx";//WINDOWS
        FileInputStream fileInputStream = new FileInputStream(path);
        //Opening the workbook using fileinputstream
        Workbook workbook=WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);//Reading the first sheet
        Row row=sheet.getRow(0);
        Cell cell=row.getCell(0);
        System.out.println(cell);
//==================================================================
        //We can chain sheet, row, and cell
        Cell usaCell=sheet.getRow(1).getCell(0);
        System.out.println(usaCell);

        //We can convert a cell object to a string and do string manipulation with that data
        String DCCell=sheet.getRow(1).getCell(1).toString();
        Assert.assertEquals(DCCell,"DC");

        System.out.println(DCCell.length());

        //Find the number of row
        int lastRowNum=sheet.getLastRowNum()+1;//Returns the last row number that has a data
        //getLastRowNum() index starts at 0. So we need to add 1 to find the total number of row
        System.out.println("Row Num : "+lastRowNum);

        int physicalNumOfRow=sheet.getPhysicalNumberOfRows();//Returns the number of row that is used.
        //getPhysicalNumberOfRows() index starts at 1
        System.out.println("Number of row that is used : "+physicalNumOfRow);
        //{USA, DC},{France,Paris},{TURKEY, Ankara},...
        Map<String,String> worldCapitals=new HashMap<>();
        int countryColumn=0;
        int capitalColumn=1;
        for (int rowNum=1;rowNum<lastRowNum;rowNum++){
            String country=sheet.getRow(rowNum).getCell(countryColumn).toString();
            //System.out.println(country);
            String capitals=sheet.getRow(rowNum).getCell(capitalColumn).toString();
            //System.out.println(capitals);
            worldCapitals.put(country,capitals);
        }
        System.out.println(worldCapitals);

        //closing the workbook
        fileInputStream.close();
        workbook.close();
    }

}
