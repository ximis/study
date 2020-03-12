package proxyVersion.support;

import Common.WebDrvierHelper;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import proxyVersion.components.BasePage;

public class PageFactoryInit {

    public static <T extends BasePage> Object init(Class<T> cls) {

        ElementLocatorFactory factory = null;


        factory = new DefaultElementLocatorFactory(WebDrvierHelper.getDriver());


        System.out.println("the page name: " + cls.getName());

        return new CompoentProxy().getPageInstance(cls);
    }


}
