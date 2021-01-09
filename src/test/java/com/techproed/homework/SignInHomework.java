package com.techproed.homework;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SignInHomework {

    WebDriver driver;
    Faker faker;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void signInClick() throws InterruptedException {
        faker = new Faker();
        //sigin click
        WebElement signIn = driver.findElement(By.xpath("//a[@class='login']"));
        signIn.click();
        //email send
        WebElement emailCreate = driver.findElement(By.xpath("//input[@name='email_create']"));
        emailCreate.sendKeys(faker.name().firstName() + "@gmail.com");
        //submit
        WebElement submitCreate = driver.findElement(By.id("SubmitCreate"));
        submitCreate.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //verifying
        //create account
        WebElement verifyCreateAccount = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(verifyCreateAccount.isDisplayed());
        //personal info
        WebElement verifyPersonalInfo = driver.findElement(By.xpath("//h3[@class='page-subheading']"));
        Assert.assertTrue(verifyPersonalInfo.isDisplayed());
        //title
        WebElement verifyTextTitle = driver.findElement(By.xpath("//label[.='Title']"));
        Assert.assertTrue(verifyTextTitle.isDisplayed());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //filling the fields
        //gender
        WebElement selectTitle = driver.findElement(By.id("uniform-id_gender1"));
        selectTitle.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //name
        WebElement firstName = driver.findElement(By.xpath("//input[@name='customer_firstname']"));
        firstName.sendKeys(faker.name().firstName());
        //lastname
        WebElement lastName = driver.findElement(By.xpath("//input[@name='customer_lastname']"));
        lastName.sendKeys(faker.name().lastName());
        //password
        WebElement passwd = driver.findElement(By.xpath("//input[@name='passwd']"));
        passwd.sendKeys(faker.lorem().characters(5,10));
//        randomize numbers
        Random random = new Random();
        int randomDay= random.nextInt(30);
        int randomMonth = random.nextInt(11);
        int randomYear = random.nextInt(20);


        //dateOfBirth dropbox
        //days
        WebElement daysDrop =driver.findElement(By.id("days"));
        Select daysOptions = new Select(daysDrop);
        daysOptions.selectByIndex(randomDay);
        //month
        WebElement monthsDrop = driver.findElement(By.id("months"));
        Select monthOptions = new Select(monthsDrop);
        monthOptions.selectByIndex(randomMonth);
        //year
        WebElement yearsDrop = driver.findElement(By.id("years"));
        Select yearOptions = new Select(yearsDrop);
        yearOptions.selectByIndex(randomYear);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        //SignUp news letter
        WebElement newsLetterCheckBox = driver.findElement(By.xpath("//input[@name='newsletter']"));
        newsLetterCheckBox.click();

        //company
        WebElement company = driver.findElement(By.xpath("//input[@name='company']"));
        company.sendKeys(faker.company().name());

        //address
        WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
        address.sendKeys(faker.address().buildingNumber() +faker.address().streetName());

        //city
        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys(faker.address().cityName());

        //state dropdown
        WebElement statesDropDown = driver.findElement(By.xpath("//select[@name='id_state']"));
        Select statesOptions = new Select(statesDropDown);
        statesOptions.selectByValue("23");

        //zipcode
        WebElement zipCode = driver.findElement(By.xpath("//input[@name='postcode']"));
        zipCode.sendKeys(faker.number().digits(5));


        //country dropdown
        WebElement countryDrop = driver.findElement(By.xpath("//select[@name='id_country']"));
        Select countryOptions = new Select(countryDrop);
        countryOptions.selectByValue("21");

        //additional info
        WebElement additionalInfo = driver.findElement(By.xpath("//textarea[@name='other']"));
        additionalInfo.sendKeys(faker.pokemon().name());

        //home phone
        WebElement homePhone = driver.findElement(By.xpath("//input[@name='phone']"));
        homePhone.sendKeys(faker.phoneNumber().cellPhone());

        //mobile phone
        WebElement mobilePhone = driver.findElement(By.xpath("//input[@name='phone_mobile']"));
        mobilePhone.sendKeys(faker.phoneNumber().cellPhone());

        //assign reference name
        WebElement referenceName = driver.findElement(By.xpath("//input[@name='alias']"));
        referenceName.sendKeys(" "+faker.name().fullName() );

        //submitAccount
        WebElement submitAccount = driver.findElement(By.id("submitAccount"));
        submitAccount.click();

        //verify myAccount
        WebElement verifyMyAccount = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(verifyMyAccount.isDisplayed());

    }

}


