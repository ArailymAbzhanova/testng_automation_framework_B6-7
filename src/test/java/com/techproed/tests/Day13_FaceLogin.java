package com.techproed.tests;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day13_FaceLogin {
    FaceLoginPage faceLoginPage;
    @Test
    public void logIn() throws InterruptedException {
        Driver.getDriver().get("https://www.facebook.com/");
        faceLoginPage=new FaceLoginPage();
        faceLoginPage.username.sendKeys("gseghsethgsrth");
        faceLoginPage.password.sendKeys("asgsdthsrthn");
        faceLoginPage.loginButton.click();
        Thread.sleep(1000);
        String expectedErrorMessage="The email or phone number you’ve entered doesn’t match any account. Sign up for an account.";
        Assert.assertEquals(faceLoginPage.errorMessage.getText(),expectedErrorMessage);

    }
}
