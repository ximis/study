package proxy;

import common.SafeOperation;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SafeLocatingElementHandler implements InvocationHandler {

    private final ElementLocator locator;

    public SafeLocatingElementHandler(ElementLocator locator) {
        this.locator = locator;
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        WebElement element;
        try {
            element = locator.findElement();
        } catch (NoSuchElementException e) {
            if ("toString".equals(method.getName())) {
                return "Proxy element for: " + locator.toString();
            }
            throw e;
        }

        if ("getWrappedElement".equals(method.getName())) {
            return element;
        }

        if(method.getName().equals("sendKeys")){
            SafeOperation.sendKeys(element, (CharSequence[])(objects[0]));
            return null;
        }


        try {
            return method.invoke(element, objects);
        } catch (InvocationTargetException e) {
            // Unwrap the underlying exception
            throw e.getCause();
        }
    }
}
