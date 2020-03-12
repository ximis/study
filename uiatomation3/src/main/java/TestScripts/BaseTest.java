package TestScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.WebDrvierHelper;

public class BaseTest {


    @BeforeTest
    public void setUp() {

    }


    @AfterTest
    public void Clear() {

        WebDrvierHelper.getDriver().quit();
    }

}
