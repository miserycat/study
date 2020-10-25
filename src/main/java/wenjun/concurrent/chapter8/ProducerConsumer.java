package wenjun.concurrent.chapter8;

import javax.xml.transform.Source;

public class ProducerConsumer {
    private int i = 1;
    private volatile boolean isProduced = false;
    private static final Object LOCK = new Object();

    public void produce() {
        synchronized (LOCK) {
            if (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i++;
                System.out.println("produce ->" + i);
                isProduced = true;
                LOCK.notify();
            }
        }
    }

    public void consume() {
        synchronized (LOCK) {
            if (isProduced) {
                System.out.println("consume ->" + i);
                isProduced = false;
                LOCK.notify();
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
