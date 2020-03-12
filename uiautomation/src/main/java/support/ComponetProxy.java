package support;

import Pages.BasePage;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ComponetProxy implements MethodInterceptor {
    private ElementLocator locator = null;
    private Field field;

    public ComponetProxy(Field field) {
        this.field = field;
    }

    public ComponetProxy(ElementLocator locator) {
        this.locator = locator;
    }


    private Enhancer getEnhancer(Class cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setInterceptDuringConstruction(false);
        enhancer.setCallback(this);
        return enhancer;
    }

    public Object getInstance(Class cls, final WebDriver driver, final WebElement element) {
        return getEnhancer(cls).create(new Class[]{WebDriver.class}, new Object[]{driver});
    }

    private WebElement getElement(SearchContext searchContext) {
        DefaultElementLocatorFactory factory = new DefaultElementLocatorFactory(searchContext);
        ElementLocator locator = factory.createLocator(field);
        return locator.findElement();
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        WebElement webElement = locator.findElement();
        ((BasePage)obj).setWebElement(webElement);

        return  proxy.invokeSuper(obj, args);
    }

    private void handleFindBy() {

    }


}
