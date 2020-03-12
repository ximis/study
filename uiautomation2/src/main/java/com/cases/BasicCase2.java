package com.cases;

import org.testng.annotations.Test;
import org.testng.annotations.*;

public class BasicCase2 {
    @BeforeTest
    public void prepare() {
        System.out.println("before test");

    }

    @BeforeMethod
    public void mtest1() {
        System.out.println("before method");
    }

    @AfterMethod
    public void mtest2() {
        System.out.println("after method");
    }


    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
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
