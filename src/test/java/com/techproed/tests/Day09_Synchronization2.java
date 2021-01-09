package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_Synchronization2 extends TestBase {
    /*
Create a class:Day09_Synchronization2. Create a method: isEnabled
Go to https://the-internet.herokuapp.com/dynamic_controls
Click enable Button
And verify the message is equal to “It's enabled!”
And verify the textbox is enabled (I can type in the box)
And click on Disable button
And verify the message is equal to “It's disabled!”
And verify the textbox is disabled (I cannot type in the box)
     */
    @Test
    public void isEnabled(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebElement enabledMessage=driver.findElement(By.id("message"));
        String enabledMessageText=enabledMessage.getText();
        Assert.assertEquals(enabledMessageText,"It's enabled!");

        //Locating disable button and clicking on it
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        //And verify the message is equal to “It's disabled!”
        WebElement disabledMessage=driver.findElement(By.id("message"));
        String disabledMessageText=disabledMessage.getText();
        Assert.assertEquals(disabledMessageText,"It's disabled!");

        //Locating the input element
        WebElement inputElement=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(!inputElement.isEnabled());
        //!inputElement.isEnabled()  => is not enabled,which means disabled

    }
    //Homework"
    //Create a new method: isExampled1()
    //Use Explicit Wait On The Correct WebElements
}
