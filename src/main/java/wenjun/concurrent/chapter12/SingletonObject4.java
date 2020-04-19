package wenjun.concurrent.chapter12;

//懒汉式3（double check）：会有NPE的风险，在newInstance的时候有可能成员变量没有初始化完成
public class SingletonObject4 {
    private static SingletonObject4 instance = null;

    private static boolean objectInitFinished = false;
    private Object object;

    private SingletonObject4() {
        //下面2行代码不能保证顺序执行，只能保证最终一致性。
        objectInitFinished = true; //
        object = new Object(); //

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
