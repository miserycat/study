package wenjun.concurrent.chapter12;

//懒汉式3（double check）：会有NPE的风险，在newInstance的时候有可能成员变量没有初始化完成
public class SingletonObject4 {
    private static SingletonObject4 instance = null;

    private static boolean objectInitFinished = false;
    private Object object;
    private int i;

    private SingletonObject4() {
        /**
         * new SingletonObject4的过程
         * 1.在堆内存中开辟空间
         * 2.初始化成员变量 object = null, i = 0
         * 3.初始化成员变量，执行构造方法
         * 4.将instance引用和堆中SingletonObject4建立连接（此时instance就不为null了）
         *  由于jvm在代码之间没有依赖的情况下会重排序进行优化
         *  有可能的顺序是 1 2 4 3, 在执行到4的时候另外的线程判断到intance不为null了，去访问里面的object 和 i并不是期望的值。
         */
        i = 10; //1
        objectInitFinished = true; //2
        object = new Object(); //3

    }

    //instance不为null的情况下多线程不需要争夺锁，提高了效率
    public SingletonObject4 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject4.class) {
                if (null == instance) {
                    instance = new SingletonObject4();
                }
            }
        }

        return SingletonObject4.instance;
    }

    public static boolean isObjectInitFinished() {
        return objectInitFinished;
    }
    // other thread
    // SingletonObject4 instance = SingletonObject4.getInstance();
    // while (instance.isObjectFinished()) {
    //      sleep(100);
    // }
    // instance.object.xxx(); 这个时候object由于代码重新排序了导致object是null
}
