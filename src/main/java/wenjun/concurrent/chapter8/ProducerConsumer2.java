package wenjun.concurrent.chapter8;

public class ProducerConsumer2 {
    private int i = 1;
    private volatile boolean isProduced = false;
    private static final Object LOCK = new Object();

    public void produce() {
        synchronized (LOCK) {

            //保证consumer notifyAll的时候再次notify了自己导致代码继续往下走重复生产或消费，所以要用while再次检查
            while (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            System.out.println("produce ->" + i);
            isProduced = true;
            LOCK.notifyAll();

        }
    }

    public void consume() {
        synchronized (LOCK) {
            while (!isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("consume ->" + i);
            isProduced = false;
            LOCK.notifyAll();
        }
    }
}
