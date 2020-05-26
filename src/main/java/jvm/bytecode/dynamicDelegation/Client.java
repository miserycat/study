package jvm.bytecode.dynamicDelegation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
//        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject target = new RealSubject();
        InvocationHandler handler = new DynamicSubject(target);

        Subject delegation = (Subject) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);

        delegation.request();
        System.out.println(delegation.getClass());
        System.out.println(delegation.getClass().getSuperclass());

        System.out.println("==============================");
        System.out.println(delegation.toString());
    }
}
