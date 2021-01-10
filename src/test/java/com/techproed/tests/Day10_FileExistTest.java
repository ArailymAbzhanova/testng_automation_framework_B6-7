package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day10_FileExistTest {
    @Test
    public void isExist(){
        //Path of a file that we want to test
        String path="/Users/techproed/Desktop/flower.jpg";

        //We need JAVA to deal with Files
        boolean isExist=Files.exists(Paths.get(path));

        //If file exist, returns true. If file doesn't exist, returns false.
        Assert.assertTrue(isExist);

    }
}
