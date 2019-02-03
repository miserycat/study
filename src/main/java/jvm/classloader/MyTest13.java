package jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest13 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        while (classLoader != null) {
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }

        classLoader = Thread.currentThread().getContextClassLoader();

        String resourceName = "jvm/classloader/MyTest13.class";

        Enumeration<URL> urls = classLoader.getResources(resourceName);

        while (urls.hasMoreElements()) {
            System.out.println(urls.nextElement());
        }
    }
}
