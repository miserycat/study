package wenjun.concurrent.chapter12;

//懒汉式1：lazy load, 线程安全问题
public class SingletonObject2 {
    private static SingletonObject2 instance = null;

    private SingletonObject2() {

    }

    public SingletonObject2 getInstance() {
        //线程安全问题
        if (null == instance) {
            instance = new SingletonObject2();
        }

        return SingletonObject2.instance;
    }
}
