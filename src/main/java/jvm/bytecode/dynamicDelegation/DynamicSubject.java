package jvm.bytecode.dynamicDelegation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler {
    private Subject obj;

    public DynamicSubject(Subject obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before subject " + method);
        method.invoke(obj, args);
        System.out.println("after subject " + method);
        return null;
    }
}
