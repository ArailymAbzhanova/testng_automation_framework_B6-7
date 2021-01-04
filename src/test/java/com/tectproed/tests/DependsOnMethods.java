package com.tectproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {
    //login->homePage->search->results
    //homePage testcase depends on login
    @Test
    public void logIn(){
        System.out.println("Login Test");
        Assert.assertTrue(false);//Failing the code on purpose
    }
    @Test(dependsOnMethods = "logIn")//homePage runs only if login successfully passes
    public void homePage(){
        System.out.println("Home Page Test");
    }
    @Test(priority = 3)
    public void search(){
        System.out.println("Search Test");
    }
    @Test(priority = 4)
    public void results(){
        System.out.println("ResultTest");
    }

}
