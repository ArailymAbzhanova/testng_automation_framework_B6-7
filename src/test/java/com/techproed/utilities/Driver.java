package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    //Similar to TestBase, This is a utilities class
    private static WebDriver driver;
    //setup, create, and return the driver instance
    public static WebDriver getDriver(){
        /*
        If driver is not being used, if it is not pointing anywhere, then instantiate the driver
        We want to use only one driver in the entire framework
         */
        if(driver==null) {
            //ConfigReader.getProperty("browser") ==>chrome
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
        }
        return driver;
    }
}
