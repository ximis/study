package proxy;

import common.WebDrvierHelper;
import components.BaseComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import pages.BasePage;

import java.nio.file.Path;

public class PageFactoryInit {

    public static void initPage(BasePage page) {

        ElementLocatorFactory factory = null;


        factory = new DefaultElementLocatorFactory(WebDrvierHelper.getDriver());


        System.out.println("the page name: " + page.getClass());

        PageFactory.initElements(new SafeFieldDecorator(factory), page);
    }

    public static void initComponent(BaseComponent component, WebElement webElement){
        ElementLocatorFactory factory = null;

        if(webElement == null){
            factory = new DefaultElementLocatorFactory(WebDrvierHelper.getDriver());
        }else {
            factory = new DefaultElementLocatorFactory(webElement);
        }

        System.out.println("the component name: " + component.getClass());

        PageFactory.initElements(new SafeFieldDecorator(factory), component);
    }

}
