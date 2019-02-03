package jvm.classloader;

/**
 * 调用ClassLoader.loadClass("xxx")并不是对类的主动使用，不会导致类的初始化。
 */

public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("jvm.classloader.CL"); //并不会导致CL的初始化
        System.out.println(clazz);
        System.out.println("============");
        clazz = Class.forName("jvm.classloader.CL");
        System.out.println(clazz);
    }
}

class CL {
    static {
        System.out.println("Class CL");
    }
}
