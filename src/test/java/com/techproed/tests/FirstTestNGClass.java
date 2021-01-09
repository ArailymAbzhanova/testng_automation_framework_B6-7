package com.techproed.tests;

import org.testng.annotations.*;

public class FirstTestNGClass {

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }
    @Test(priority = 4)
    public void test1(){
        System.out.println("Test 1");
    }
    @Ignore
    @Test(priority = 2)
    public void test2(){
        System.out.println("Test 2");
    }
    @Test(priority = 1+4)
    public void test3(){
        System.out.println("Test 3");
    }
    @Test(priority = 3)
    public void test4(){
        System.out.println("Test 4");
    }
}
