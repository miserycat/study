package jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *  方法区产生内存溢出错误
 *
 *  
 *  元空间：https://www.infoq.cn/article/Java-permgen-Removed
 *
 * 设置最大元空间大小，不设置默认21m，超过会自动扩容。
 * -XX:MaxMetaspaceSize=??
 * 元空间初始值
 * -XX:MetaspaceSize=？？
 */
public class MyTest4 {
    public static void main(String[] args) {
        for (; ; ) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, objects, methodProxy) -> methodProxy.invokeSuper(obj, args));

            System.out.println("create cglib class");

            enhancer.create();
        }
    }
}
