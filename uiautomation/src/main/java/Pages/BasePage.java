package Pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.PageFactoryInit;

public class BasePage {

    protected WebDriver driver = null;
    protected WebElement webElement = null;
    private final int TIMEOUT = 3;

    public BasePage(WebDriver driver, String title) {
        this.driver = driver;

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(new ExpectedCondition<String>() {
            @NullableDecl
            @Override
            public String apply(@NullableDecl WebDriver input) {
                return input.getTitle();
            }
        });

        if (!driver.getTitle().contains(title)) {
            throw new IllegalStateException("This page isn't on the correct page: " + title);
        }

//        PageFactory.initElements(driver, this);
//        PageFactoryInit.init(this);
    }

    public BasePage(WebDriver driver, String title, String url) {
        this.driver = driver;
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(new ExpectedCondition<String>() {
            @NullableDecl
            @Override
            public String apply(@NullableDecl WebDriver input) {
                return input.getTitle();
            }
        });


        if (!driver.getTitle().contains(title)) {
            throw new IllegalStateException("This page isn't on the correct page: " + title);
        }

//        PageFactory.initElements(driver, this);
//        PageFactoryInit.init(this);

    }


    public BasePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.webElement = element;
    }


    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(WebElement element) {
        this.webElement = element;
    }
}
