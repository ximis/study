package proxyVersion.components;

import Common.WebDrvierHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginComponent extends BaseComponent{
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@id='btn-login']")
    WebElement loginBtn;

    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginBtn.click();

        WebDriver driver = WebDrvierHelper.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(new ExpectedCondition<Alert>() {
            @Override
            public Alert apply(WebDriver driver) {
                try {
                    return driver.switchTo().alert();
                }
                catch (NoAlertPresentException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return "alert to be present";
            }
        });

        driver.switchTo().alert().accept();
    }


    public LoginComponent(WebElement webElement) {
        super(webElement);
    }
}
