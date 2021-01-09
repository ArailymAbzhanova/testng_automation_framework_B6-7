package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_ActionsClass4 extends TestBase {

    /*
    Some web pages are long
    so some elements at the buttom of the page may not load and may not be visible
    Then we must scroll down the page
    When we scroll down enough,then page will load and will be visible
     */
    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");

        Actions actions = new Actions(driver);



        //Page Down
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        //FINDING THE LINK AND VERIFYING IF THAT LINK IS ON THE PAGE
        //We must first scroll down to find the element, bacuase it is only visible when we scroll donw enough
        WebElement personalizedLink=driver.findElement(By.partialLinkText("Sign in to see personalized recommendations"));
        Assert.assertTrue(personalizedLink.isDisplayed());

        //TO GO BACK UP WE CAN USE Page Up
        //Page Up
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();

        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();

        //Arrow Down: Will scroll down very little
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        //Arrow Up:  Will scroll up very little
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();

        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();

    }
}
