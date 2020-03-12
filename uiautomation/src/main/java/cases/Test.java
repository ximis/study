package cases;

import Common.WebDrvierHelper;
import Pages.AlertPage;
import Pages.LoginPage;
import Components.SearchBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class Test {
    public static void main(String args[]){

        WebDriver driver= WebDrvierHelper.getDriver();

        LoginPage page = new LoginPage(driver);



        page.login("automation", "!!!L0g1cm0n");


        new AlertPage(driver);
        new SearchBox(driver).search("dp");

        driver.quit();
        System.out.println("ttt");

    }
}
