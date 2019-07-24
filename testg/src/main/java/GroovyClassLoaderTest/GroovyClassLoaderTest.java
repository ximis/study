package GroovyClassLoaderTest;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

public class GroovyClassLoaderTest {
    public static void main(String args[]) throws Exception{
        GroovyClassLoader loader = new GroovyClassLoader();
        Class cls = loader.loadClass("GroovyClassLoaderTest.HelloGroovy");
        GroovyObject object = (GroovyObject)cls.newInstance();
        object.invokeMethod("sayHello", "Joy");
        Integer data = (Integer) object.invokeMethod("add", new Integer[]{1, 2});
        System.out.println(data);
    }
}
