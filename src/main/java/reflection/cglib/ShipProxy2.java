package reflection.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by shengchao wu on 7/9/2018.
 */
public class ShipProxy2 implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("this proxy2 begin methodName:" + method.getName());
        proxy.invokeSuper(obj, args);
        System.out.println("this proxy2 end");
        return null;
    }
}
