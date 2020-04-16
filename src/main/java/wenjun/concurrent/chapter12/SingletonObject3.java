package wenjun.concurrent.chapter12;

//懒汉式2：lazy load, 解决了线程安全问题，但是锁范围太大，导致即使instance 不是 null还是会出现多个线程争夺一把lock的情况
public class SingletonObject3 {
    private static SingletonObject3 instance = null;

    private SingletonObject3() {

    }

    //多个线程永远会有锁争夺
    public synchronized SingletonObject3 getInstance() {
        if (null == instance) {
            instance = new SingletonObject3();
        }

        return SingletonObject3.instance;
    }
}
