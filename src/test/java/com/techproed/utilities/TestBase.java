package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;
//Test base should be abstract
//We only want to use TestBase methods.
//Don't want to create an object of TestBase
public abstract class TestBase {
    protected WebDriver driver;//this can be reached from the child classes,
    // this is not visible in the entire framework like public
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
