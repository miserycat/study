package reflection.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by shengchao wu on 7/9/2018.
 */
public class ShipProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("proxy begins.... method name : " + method.getName());
        methodProxy.invokeSuper(o, objects);
        System.out.println("proxy ended...");
        return null;
    }
}
