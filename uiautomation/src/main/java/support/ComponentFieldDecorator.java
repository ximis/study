package support;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementListHandler;

import java.lang.reflect.*;
import java.util.List;

public class ComponentFieldDecorator implements FieldDecorator {
    private ElementLocatorFactory factory = null;
    private WebDriver webDriver = null;


    public ComponentFieldDecorator(ElementLocatorFactory factory, WebDriver webDriver) {
        this.factory = factory;
        this.webDriver = webDriver;
    }


    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (!(BasePage.class.isAssignableFrom(field.getType())
                || isDecoratableList(field))) {
            return null;
        }

        ElementLocator locator = factory.createLocator(field);
        if (locator == null) {
            return null;
        }

        if (BasePage.class.isAssignableFrom(field.getType())) {
            return proxyForLocator(loader, locator, field);
        }
        else if (List.class.isAssignableFrom(field.getType())) {
            return proxyForListLocator(loader, locator);
        }
        else {
            return null;
        }

//        if (field.isAnnotationPresent(FindBy.class)) {
//            if (List.class.isAssignableFrom(field.getType())) {
//
//            }
//            else {
//
//            }
//        }

//        return null;
    }

    protected boolean isDecoratableList(Field field) {
        if (!List.class.isAssignableFrom(field.getType())) {
            return false;
        }

        // Type erasure in Java isn't complete. Attempt to discover the generic
        // type of the list.
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType)) {
            return false;
        }

        Type listType = ((ParameterizedType) genericType).getActualTypeArguments()[0];

        if (!WebElement.class.equals(listType)) {
            return false;
        }

        if (field.getAnnotation(FindBy.class) == null &&
                field.getAnnotation(FindBys.class) == null &&
                field.getAnnotation(FindAll.class) == null) {
            return false;
        }

        return true;
    }

    protected Object proxyForLocator(ClassLoader loader, ElementLocator locator, Field field) {

        return new ComponetProxy(locator).getInstance(field.getType(), webDriver, locator.findElement());
    }

    @SuppressWarnings("unchecked")
    protected List<WebElement> proxyForListLocator(ClassLoader loader, ElementLocator locator) {
        InvocationHandler handler = new LocatingElementListHandler(locator);

        List<WebElement> proxy;
        proxy = (List<WebElement>) Proxy.newProxyInstance(
                loader, new Class[]{List.class}, handler);
        return proxy;
    }

}
