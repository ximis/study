package Components;

import Common.SafeOperation;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBox extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement input;

    @FindBy(xpath = "")
    WebElement searchBtn;


    public void search(String value) {
        SafeOperation.sendKeys(input, value);
    }


    public SearchBox(WebDriver webDriver) {
        super(webDriver);
    }
}
