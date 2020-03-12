package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URI;

public class LoginPage extends BasePage {
//    private static String URL = "https://qauat01at.logicmonitor.com/santaba/index.jsp?signout=true";
    private static String URL = "https://qauat02.logicmonitor.com/santaba/index.jsp?signout=true";

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

    public LoginPage(WebDriver driver) {
        super(driver, "Logicmonitor Hosted Monitoring System", URL);
    }

}
