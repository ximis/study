package Pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseComponent {
    protected WebDriver driver;
    protected WebElement webElement;
    private final int TIMEOUT = 3;

    public BaseComponent(WebDriver driver, WebElement element){
        this.driver = driver;
        this.webElement = element;
    }


    public WebDriver getDriver(){
        return driver;
    }
    public WebElement getWebElement() { return  webElement; }
}
