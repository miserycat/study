package jvm.classloader;

/**
 * 当前类加载器(Current classLoader)
 *
 * 每个类都会使用自己的类加载器去加载它所依赖的类(如ClassB 依赖了 ClassA那么ClassA是由ClassB的类加载器加载的，前提是ClassB没有被加载过)
 *
 * 线程的上下文类加载器(context classLoader)
 * Thread中的getContextClassLoader()和setContextClassLoader(ClassLoader c1)分别用来获取和设置上下文类加载器
 *
 * context ClassLoader的应用场景
 * SPI(Service Provider Interface)
 * 对于SPI来说，有些接口是Java核心库提供的，那么这些接口是又bootstrap classloader来加载的，而这些接口的实现确是由不同厂商自己实现，
 * 生成jar包，我们需要将这些jar包放到项目的classpath下，但是bootstrap classloader是无法看到子classloader所加载的类的，
 * 所以设计了context classLoader， 通过给当前线程context classLoader，使用设置的context classloader去加载。
 *
 * 父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所指定的classLoader来加载类，
 * 这就改变了父classLoader不能使用子classLoader或者是没有直接父子关系的ClassLoader加载类的情况，即改变了双亲委托模型。（相当于留了一个后门。。。）
 *
 *
 */
public class MyTest16 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}
