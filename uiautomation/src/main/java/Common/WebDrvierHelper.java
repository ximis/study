package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class WebDrvierHelper {
    private static WebDriver _driver = null;

    private static void initDriver(){
        Properties properties = System.getProperties();
        properties.setProperty("webdriver.chrome.driver", "/Users/supinrong/code/driver/chromedriver");
        System.setProperties(properties);

        _driver = new ChromeDriver();
    }

    public static WebDriver getDriver(){
        if(_driver == null){
            initDriver();
        }
        return _driver;
    }
}
