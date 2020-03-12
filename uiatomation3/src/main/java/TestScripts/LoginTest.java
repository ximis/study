package TestScripts;

import UIObjects.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utils.ReadExcel;
import utils.WebDrvierHelper;

import java.io.IOException;

public class LoginTest {

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                { "automation", "!!!L0g1cmon" },
                { "test name", "test2 password"},
        };
    }

    @DataProvider(name = "test2")
    public Object[][] createData2() throws IOException {

        return ReadExcel.readExcel("login.xlsx");
    }



    @BeforeMethod
    public void before() throws Exception{
        WebDrvierHelper.getDriver().get("https://qauat01at.logicmonitor.com/santaba/index.jsp?signout=true");

        Thread.sleep(6 * 1000);

    }

    @Test(dataProvider = "test1")
    @Ignore
    public void login(String name, String password){

        new LoginPage(WebDrvierHelper.getDriver()).login(name, password);
    }

    @Test(dataProvider = "test2")
    public void loginWithResult(String name, String password, String loginResult){

        new LoginPage(WebDrvierHelper.getDriver()).login(name, password);
    }


}
