package wenjun.concurrent.chapter12;

//一种比double check懒汉是更为优雅的singleton实现，也实现了lazy load, static只会被加载一次，只会在getInstance被调用的时候加载。
public class SingletonObject6 {
    private SingletonObject6() {
    }

    private static class InstanceHolder {
        private final static SingletonObject6 instance = new SingletonObject6();
    }

    public static SingletonObject6 getInstance() {
        return InstanceHolder.instance;
    }
}
