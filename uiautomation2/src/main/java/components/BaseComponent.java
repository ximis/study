package components;

import proxy.PageFactoryInit;
import org.openqa.selenium.WebElement;

public class BaseComponent {
    private WebElement webElement = null;

    public BaseComponent(WebElement webElement) {

        this.webElement = webElement;
        init();
    }
    public BaseComponent(){
        init();
    }

    private void init(){
        PageFactoryInit.initComponent(this, webElement);
    }

}
