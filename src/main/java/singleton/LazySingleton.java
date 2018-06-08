package singleton;

/**
 * Created by shengchao wu on 4/26/2018.
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {}

    public synchronized static LazySingleton getInstance() {
        if (null != instance) {
            instance = new LazySingleton();
        }
        return instance;
    }


}
