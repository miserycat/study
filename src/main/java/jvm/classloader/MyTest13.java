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

        //当一个类或者一个资源文件存在与多个jar中，就会存在jar hell问题。
        //可以通过以下代码来诊断问题：
        Enumeration<URL> urls = classLoader.getResources(resourceName);

        while (urls.hasMoreElements()) {
            System.out.println(urls.nextElement());
        }
    }
}
