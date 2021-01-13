package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day12_HotelRoomTest {
    //We can improve this code
    //Create a method and write the code for pre conditions.
    WebElement username;
    WebElement password;
    WebElement loginButton;

    @BeforeMethod
    public void logIn(){
        Driver.getDriver().get(ConfigReader.getProperty("qa_environment"));
        WebElement mainPageLoginButton=Driver.getDriver().findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
        username=Driver.getDriver().findElement(By.id("UserName"));
        password=Driver.getDriver().findElement(By.id("Password"));
        loginButton=Driver.getDriver().findElement(By.id("btnSubmit"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void createHotel(){
        username.sendKeys("manager");
        password.sendKeys("Manager2!");
        loginButton.click();

        WebElement hotelManagement=Driver.getDriver().findElement(By.linkText("Hotel Management"));
        hotelManagement.click();

        WebElement hotelRooms=Driver.getDriver().findElement(By.partialLinkText("Hotel Rooms"));
        hotelRooms.click();

        WebElement addHotelRoomsButton=Driver.getDriver().findElement(By.partialLinkText("ADD HOTELROOM"));
        addHotelRoomsButton.click();
    }
}
