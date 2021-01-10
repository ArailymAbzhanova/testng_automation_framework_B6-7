package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day10_FileUploadTest extends TestBase {
//    Class Name: FileUploadTest
//    Method Name: fileUploadTest
//    When user goes to https://the-internet.herokuapp.com/upload
//    And click on the chooseFile button
//    And selects an image from the computer
//    And click on the upload button
//    Then verify the File Uploaded!  Message displayed
    @Test
    public void fileUploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseAFile=driver.findElement(By.id("file-upload"));

        String path="/Users/techproed/Desktop/flower.jpg";//WORKS ONLY ON MY COMPUTER
        //C:\\Users\\YourComputerName\\Desktop\\flower.jpg  //sample window path

        //send the path of the file to chooseAFile element
        chooseAFile.sendKeys(path);

        //Locating upload button and clicking on it
        WebElement upload=driver.findElement(By.id("file-submit"));
        upload.click();

        //Locating the uploaded message and Verifying the text
        String uploadedMessage=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(uploadedMessage,"File Uploaded!");
    }
}
