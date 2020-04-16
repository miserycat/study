package wenjun.concurrent.chapter12;

//懒汉式4（double check）：volatile保证内存可见性，禁止代码重排序
public class SingletonObject5 {
    private static volatile SingletonObject5 instance = null;

    private SingletonObject5() {

    }

    //instance不为null的情况下多线程不需要争夺锁，提高了效率
    public SingletonObject5 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject5.class) {
                if (null == instance) {
                    instance = new SingletonObject5();
                }
            }
        }

        return SingletonObject5.instance;
    }
}
