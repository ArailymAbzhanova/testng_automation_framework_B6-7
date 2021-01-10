package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day10_FileDownloadTest extends TestBase {
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[.='flower.jpg']")).click();
        //After click, file will be downloaded on teh downloads folder
        //Get the path of the file that is in download folder
        //And check is the path exist

        Thread.sleep(1000);//waiting for 1 sec to complete the download
        //HOMEWORK : Try to handle this wait issue using explicit wait
        //Pointing to the flower.jpg in the Downloads folder

        String userFolder=System.getProperty("user.home");// /Users/techproed  =>gives you the user folder
        //System.out.println(userFolder);
        String path   =  userFolder   +   "/Downloads/flower.jpg";
        //System.out.println(path);
        //String path = "/Users/techproed/Downloads/flower.jpg";

        boolean isDownloaded=Files.exists(Paths.get(path));
        //This pass is isFileExist in the downloaded folder
        Assert.assertTrue(isDownloaded);
    }
}
