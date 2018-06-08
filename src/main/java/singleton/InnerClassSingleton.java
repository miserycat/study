package singleton;

/**
 * Created by shengchao wu on 4/26/2018.
 */
public class InnerClassSingleton {

    public InnerClassSingleton() {}

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }
}
