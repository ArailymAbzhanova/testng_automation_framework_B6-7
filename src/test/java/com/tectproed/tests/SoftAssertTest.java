package com.tectproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {
    //When user goes to google home page
    //And search for porcelain teapot
    //Then verify the page title includes teapot
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
    }

    @Test
    public void teapotSearch(){
        driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER);
        String title=driver.getTitle();
        //Title doesn't contain teapot message will show up only if assertion fails.
        //Assert.assertTrue(title.contains("tea pot"),"teapot");
        //The lines after hard assert will run ONLY IF ASSERTION PASS

        //1. Create soft assert object
        SoftAssert softAssert=new SoftAssert();

        //2. Use assertion
        softAssert.assertTrue(title.contains("teapot"),"tea pot");

        softAssert.assertTrue(title.contains("tea pot"),"teapot");

        softAssert.assertTrue(title.contains("porcelain"),"porcelain");
        //3. Use assertAll to mark as Failed or Passed
        //Note that if we don't use assertAll, we get incorrect report
        //Note that if you need to do multiple assertion on a single test case, then use soft assert
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
