package wenjun.concurrent.chapter29;

//bootstrap classloader
//ext classloader
//app classloader

public class ClassLoaderTest {
    public static void main(String[] args) {
        //我们自己建了一个java.lang.String类，如果我们通过反射能否去初始化我们的String呢？
        try {
            //通过反射得到的String不是我们自己的String，因为classloader的双亲委托机制(先去bootstrap加载，加载不了去ext加载然后才会去app加载)
            //保证了程序的安全性，比如我们也定义一个java.lang.Object。。。
            final Class<?> clazz = Class.forName("java.lang.String");
            System.out.println(clazz.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
