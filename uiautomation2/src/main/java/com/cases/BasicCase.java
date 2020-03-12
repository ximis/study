package com.cases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class BasicCase {



    @BeforeTest
    public void prepare() {
        System.out.println("before test");

    }

    @BeforeClass
    public void mcls1(){
        System.out.println("before class");

    }

    @AfterClass
    public void mcls2(){
        System.out.println("before class");

    }

    @BeforeMethod
    public void mtest1() {
        System.out.println("before method");
    }

    @AfterMethod
    public void mtest2() {
        System.out.println("after method");
    }


    @Test(testName = "tt")
    public void test1() {
        System.out.println("test1");
        Reporter.log("test to send data to the report.");

    }

    @Test
    public void test2() {
        System.out.println("test2");
        Reporter.log("test to send data to the report.");
//        Assert.fail();
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }


    @AfterTest
    public void clear() {
        System.out.println("after test");

    }
}
