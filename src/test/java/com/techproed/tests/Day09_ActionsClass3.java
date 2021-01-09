package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day09_ActionsClass3 extends TestBase {
//    Create a class: ActionsClass3
//    Create test method : keysUpDown()
//    Go to google
//    Send 'iPhone X prices' => convert small letter capital vice versa.
//    Highlight the search box by double clicking
    @Test
    public void keysUpDown(){
        driver.get("https://www.google.com");
        WebElement searchBox=driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        //We want to press shift and type
        //We can use actions class to perform mouse- keyboards events. We can use different combinations.
        actions.
                keyDown(searchBox, Keys.SHIFT).//Pressing shift button in the searchbox
                sendKeys("iPhone X prices").//Typing in. This will be upper case due to the shift
                keyUp(searchBox,Keys.SHIFT).//Releasing the shift button
                sendKeys(" too expensive IN SOME COUNTRIES").//Tying in. This will be displayed as it is
                perform();//Execution the task
    }
}

