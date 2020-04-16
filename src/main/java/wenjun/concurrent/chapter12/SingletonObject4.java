package wenjun.concurrent.chapter12;

//懒汉式3（double check）：会有NPE的风险，在newInstance的时候有可能成员变量没有初始化完成
public class SingletonObject4 {
    private static SingletonObject4 instance = null;

    private Object object;

    private SingletonObject4() {
        //比如在初始化成员变量
//        object = xxx.buildObject();

        //jvm 不保证代码的执行顺序，只保证结果是正确的。
        //i 和 j谁先被赋值顺序不确定
        int i = 0;
        int j = 10;


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
}
