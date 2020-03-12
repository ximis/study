package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SafeOperation {
    public static void sendKeys(WebElement element, CharSequence ... value){
        new WebDriverWait(WebDrvierHelper.getDriver(), 10, 1).until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(value);
        System.out.println("I have run the safe sendKeys");
    }
}
