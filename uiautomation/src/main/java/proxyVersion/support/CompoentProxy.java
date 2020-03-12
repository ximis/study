package proxyVersion.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;

public class CompoentProxy implements MethodInterceptor {

    private Enhancer getEnhancer(Class cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setInterceptDuringConstruction(false);
        enhancer.setCallback(this);
        return enhancer;
    }


    //use class BaseComponent
    public Object getComponentInstance(Class cls, final WebElement element) {
        return getEnhancer(cls).create(new Class[]{WebElement.class}, new Object[]{element});
    }

    //use class BasePage
    public Object getPageInstance(Class cls) {
        return getEnhancer(cls).create(new Class[]{}, new Object[]{});
    }

//    private WebElement getElement(SearchContext searchContext) {
//        DefaultElementLocatorFactory factory = new DefaultElementLocatorFactory(searchContext);
//        ElementLocator locator = factory.createLocator(field);
//        return locator.findElement();
//    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        // findby 代理; 其他的，直接调用父方法。

        System.out.println("tttt");
        return proxy.invokeSuper(obj, args);
    }

}
