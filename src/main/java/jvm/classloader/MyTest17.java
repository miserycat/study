package jvm.classloader;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文加载器的一般使用模式（获取 - 使用 - 还原）
 *
 * ClassLoader classloader = Thread.currentThread().getContextClassLoader(); //获取
 *
 * try{
 *     Thread.currentThread().setContextClassLoader(targetccl)
 *     myMethod(); //使用
 * } finally {
 *     Thread.currentThread().getContextClassLoader(); //还原
 * }
 *
 * myMethod里面调用Thread.currentThread.getContextClassLoader() 获取之前设置的新的contextClassloader来load某些class
 *
 * ContextClassLoader的作用就是为了破坏java的双亲委托机制
 *
 */
public class MyTest17 {
    public static void main(String[] args) throws Exception {
        Thread.currentThread().setContextClassLoader(MyTest17.class.getClassLoader().getParent());
        //扫描context classloader 和所有父classloader目录中的 META-INF/services/java.sql.Driver文件
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);

        for (Iterator<Driver> iterator = loader.iterator(); iterator.hasNext();) {
            final Driver driver = iterator.next();

            System.out.println("driver: " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }

        System.out.println("current context class loader: " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader class loader: " + ServiceLoader.class.getClassLoader());

        //在高版本jdbc实现上都是通过ServiceLoader.load()的SPI统一实现的方式，这行代码就可以去掉了
        //见DriverManager中的static代码块中的 loadInitialDrivers(); 最终在nextService()
//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "username", "password");

    }
 }
