package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
//    private static String URL = "https://qauat01at.logicmonitor.com/santaba/index.jsp?signout=true";
    private static String URL = "https://qauat02.logicmonitor.com/santaba/index.jsp?signout=true";

    @FindBy(xpath = "//form[@id='login-section']")
    public LoginPageT loginPageT;


    public HomePage(WebDriver driver) {
        super(driver, "Logicmonitor Hosted Monitoring System", URL);
    }

}
