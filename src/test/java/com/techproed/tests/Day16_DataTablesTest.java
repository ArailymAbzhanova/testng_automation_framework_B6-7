package com.techproed.tests;

import com.techproed.pages.DTPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_DataTablesTest {

    DTPage dtPage;
    @Test
    public void dataTables() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("dt_url"));
        dtPage=new DTPage();
        dtPage.newButton.click();
        dtPage.firstName.sendKeys("Jimmy");
        dtPage.lastName.sendKeys("Carrey");
        dtPage.position.sendKeys("SDET");
        dtPage.office.sendKeys("Dallas");
        dtPage.extension.sendKeys("1234");
        //wait
        dtPage.startDate.sendKeys("2021-01-19");
        //wait
        /*
        dtPage.startDate.click();
        Driver.getDriver().findElement(By.xpath("//button[@data-day='19']")).click()
         */
        dtPage.salary.sendKeys("100000");
        dtPage.createButton.click();
        dtPage.searchBox.sendKeys("Jimmy");
        //PUT SOME WAIT IN HERE IF YOUR CODE FAILS
        Thread.sleep(1000);
        String actualName=dtPage.nameField.getText();//abcdef tuil
        Assert.assertTrue(actualName.contains("Jimmy"));
    }

}
