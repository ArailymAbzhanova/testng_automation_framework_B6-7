package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class Day11_ConfigReaderTest extends TestBase {

    @Test
    public void googleTitleTest(){
        //driver.get("https://www.google.com"); //hard coded
        // https://www.google.com is the value of the url
        //We can read url using getPropery method
        //We can just call getPropery method using the class name
        //ConfigReader.getProperty("url")   --->>>>>>> https://www.google.com
        driver.get(ConfigReader.getProperty("qa_environment"));
    }
}
