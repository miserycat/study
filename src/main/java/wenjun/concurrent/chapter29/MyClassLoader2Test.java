package wenjun.concurrent.chapter29;

import java.sql.DriverManager;

//classloader父亲委托机制
//A<-B<-C<-D: D load class 先去找 C load， C去load先找 B load， B load 先找 A load， A能load则A load A load不了则返回给B load 重复一直到A load
public class MyClassLoader2Test {
    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader1 = new MyClassLoader("classLoader1");
        MyClassLoader classLoader2 = new MyClassLoader("classLoader2", classLoader1);
//        MyClassLoader classLoader2 = new MyClassLoader("classLoader2");
        //dir not exist
        classLoader2.setDir("/Users/Shengchaowu/MyClassLoaderDir2");


//        DecryptClassLoader decryptClassLoader = new DecryptClassLoader();
        BrokenParentClassLoader brokenParentClassLoader = new BrokenParentClassLoader();
        final Class<?> aClass = brokenParentClassLoader.loadClass("wenjun.concurrent.chapter29.MyObject");
        final Class<?> bClass = classLoader1.loadClass("wenjun.concurrent.chapter29.MyObject");
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());

        final Class<?> cClass = brokenParentClassLoader.loadClass("wenjun.concurrent.chapter29.SimpleObject");
        //java.lang.ClassCastException: wenjun.concurrent.chapter29.SimpleObject cannot be cast to wenjun.concurrent.chapter29.SimpleObject
        //因为当前MyClassLoader2Test是app classloader 加载的, 所以simpleObject这个引用的命名空间是app classloader开头的, 而cClass是由brokenParentClassLoader加载的
        //父类加载器看不到子类加载器加载的类
        //不同命名空间下的类加载器之间的类互相不可访问
        SimpleObject simpleObject = (SimpleObject) cClass.newInstance();
        Class.forName("com.jdbc.mysql.Driver");
        DriverManager.getConnection("xx");


//        System.out.println(((MyClassLoader)aClass.getClassLoader()).getClassLoaderName());
//        System.out.println(((MyClassLoader) aClass.getClassLoader()).getParent());



    }
}
