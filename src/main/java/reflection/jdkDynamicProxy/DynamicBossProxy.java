package reflection.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shengchao wu on 4/25/2018.
 */
public class DynamicBossProxy implements InvocationHandler {
    private Object target;

    public Object newBossProxyInstance(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do post job...");
        Object result = method.invoke(this.target, args);
        System.out.println("do last job...");
        return result;
    }
}
