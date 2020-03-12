package TestsDynamicProxy;

import net.sf.cglib.proxy.Enhancer;

public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());

        TargetObject proxy = (TargetObject) enhancer.create(new Class[]{String.class, int.class}, new Object[]{"joy", 10});

        proxy.school = "aaa";
        System.out.println(proxy.school);

//        System.out.println(proxy.getAge());
//        System.out.println(proxy.getName());
//        System.out.println(proxy.sum(1, 2));

    }
}
