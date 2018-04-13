package multiThreading.exer;

/**
 * Created by shengchao wu on 4/8/2018.
 */
public class Singleton {
    private Singleton() {}

    private static Singleton singleton = null;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
