package proxyVersion.components;

import org.openqa.selenium.WebElement;

public class BaseComponent {
    protected WebElement webElement = null;


    public BaseComponent(WebElement webElement) {
        this.webElement = webElement;
    }

}
