package cases;

import Common.WebDrvierHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TestForWait {
    public static void main(String[] args) throws Exception {
        WebDriver driver = WebDrvierHelper.getDriver();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.get("https://qauat01at.logicmonitor.com/santaba/index.jsp?signout=true");


//        Thread.sleep(30 * 1000);

        long start = System.currentTimeMillis();

        WebElement element = driver.findElement(By.xpath("//input[@id='username']"));
        long end = System.currentTimeMillis();
        long time = (end - start);

        System.out.println("spend time: " +time);


    }
}
