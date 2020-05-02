package wenjun.concurrent.chapter29;
//累加载器的命名空间与运行时包
//Runtime Package
//wenjun.concurrent.chapter29
//Boot.Ext.App.wenjun.concurrent.chapter29
//Boot.Ext.App.BrokenParentClassLoader.wenjun.concurrent.chapter29

public class NameSpace {
    public static void main(String[] args) throws ClassNotFoundException {
        final ClassLoader classLoader = NameSpace.class.getClassLoader();
        final Class<?> aClass = classLoader.loadClass("java.lang.String");
        final Class<?> bClass = classLoader.loadClass("java.lang.String");

        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
    }
}
