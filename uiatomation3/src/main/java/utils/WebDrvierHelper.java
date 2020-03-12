package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDrvierHelper {
    private static WebDriver _driver = null;
    private final long TIMEOUT = 5;

    private static void initDriver(){
        Properties properties = System.getProperties();
        properties.setProperty("webdriver.chrome.driver", "/Users/supinrong/code/driver/chromedriver");
        System.setProperties(properties);

        _driver = new ChromeDriver();

        _driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver(){
        if(_driver == null){
            initDriver();
        }
        return _driver;
    }
}
