package juc;

/**
 * Created by shengchao wu on 4/11/2018.
 */
public class CompareAndSwapDemo {
    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();
        cas.compareAndSet(cas.get(), 100);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int expectedValue = cas.get();
                boolean b = cas.compareAndSet(expectedValue, (int) Math.random() * 101);
                System.out.println(b);
            }).start();
        }


    }
}

class CompareAndSwap {
    private int value;


    //get from rom
    public int get() {
        return value;
    }



    //compare value in rom and expectedValue
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            this.value = newValue;
        }
        return oldValue;

    }

    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }

}
