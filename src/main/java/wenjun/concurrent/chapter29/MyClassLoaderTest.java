package wenjun.concurrent.chapter29;

import java.lang.reflect.Method;

public class MyClassLoaderTest {
    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("MyClassLoader");
        final Class<?> clazz = myClassLoader.loadClass("wenjun.concurrent.chapter29.MyObject");
        final Object obj = clazz.newInstance();
        final Method helloWorld = clazz.getMethod("helloWorld");
        helloWorld.invoke(obj);
        System.out.println(clazz);
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getClassLoader().getParent());

    }
}
