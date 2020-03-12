package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SafeOperation {

    public static void sendKeys(WebElement element, String value){
        new WebDriverWait(WebDrvierHelper.getDriver(), 10, 1).until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(value);
    }


}
