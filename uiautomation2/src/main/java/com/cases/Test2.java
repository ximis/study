package com.cases;

import components.SearchBox;
import pages.AlertPage;
import pages.LoginPage;

public class Test2 {
    public static void main(String[] args) {
        new LoginPage().login("automation", "!!!L0g1cm0n");
        new AlertPage();

        SearchBox searchBox = new SearchBox();
        searchBox.sendKeys("dp");

        System.out.println("ss");

//        WebDrvierHelper.getDriver().quit();


    }
}
