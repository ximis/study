package TestsDynamicProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TargetInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {

        System.out.println("调用前");

        Object result = methodProxy.invokeSuper(o, params);

        System.out.println("调用后");

        return result;
    }
}
