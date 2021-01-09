package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Day08_WindowHandleTest extends TestBase {
    /*
Create a new Class Tests package: Day08_WindowHandleTest
Method name:windowHandle
Given user is on the https://the-internet.herokuapp.com/windows
Then user verifies the text : “Opening a new window”
Then user verifies the title of the page is “The Internet”
When user clicks on the “Click Here” button
Then user verifies the new window title is “New Window”
Then user verifies the text:  “New Window”
When user goes back to the previous window and then verifies the title : “The Internet”
     */
    @Test
    public void windowHandle() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        //Getting the handle of current window(window1)
        //getWindowHandle() return the code of the current window
        //This will return window1 code
        String window1Handle=driver.getWindowHandle();
        System.out.println(window1Handle);

        String window1Text=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(window1Text,"Opening a new window");

        String window1Title=driver.getTitle();
        Assert.assertEquals(window1Title,"The Internet");

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindows=driver.getWindowHandles();
        System.out.println(allWindows);

        //REMEMBER driver IS ON window1Handle
        //We want to switch window2Handle
        for (String eachWindow:allWindows){
            //loop1: eachWindow = window1Handle
            //loop2: eachWindow = window2handle
            if (!eachWindow.equals(window1Handle)){//Benefit is when we have more than 2 windows, then if to compare the current window and other window
            driver.switchTo().window(eachWindow);
            }
        }

        String window2Title=driver.getTitle();
        Assert.assertEquals(window2Title,"New Window");

    }

}
