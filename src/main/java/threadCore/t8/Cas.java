package threadCore.t8;

/**
 * Created by shengchao wu on 5/25/2018.
 */
public class Cas {

    //ÄÚ´æÖµ
    private volatile int value;

    public int getValue() {
        return value;
    }

    public synchronized int compareAndSwap(int expectValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectValue) {
            value = newValue;
        }

        return oldValue;
    }


    public synchronized boolean compareAndSet(int expectValue, int newValue) {
        return expectValue == compareAndSwap(expectValue, newValue);
    }
}
