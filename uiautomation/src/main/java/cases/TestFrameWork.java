package cases;

import Common.WebDrvierHelper;
import Components.SearchBox;
import Pages.AlertPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import support.PageFactoryInit;

public class TestFrameWork {
    public static void main(String[] args){
        WebDriver driver= WebDrvierHelper.getDriver();

        HomePage page = new HomePage(driver);

        PageFactoryInit.init(page);
        PageFactoryInit.init(page.loginPageT);

        page.loginPageT.login("automation", "!!!L0g1cm0n");


        new AlertPage(driver);
        new SearchBox(driver).search("dp");

        driver.quit();
        System.out.println("ttt");
    }
}
