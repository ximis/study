package support;

import Pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class PageFactoryInit {

    public static void init(BasePage page) {

        ElementLocatorFactory factory = null;

        if (page.getWebElement() != null) {
            factory = new DefaultElementLocatorFactory(page.getWebElement());
        }
        else {
            factory = new DefaultElementLocatorFactory(page.getDriver());
        }

        System.out.println("the page name: " + page.getClass());

        PageFactory.initElements(new ComponentFieldDecorator(factory, page.getDriver()), page);

    }


}
