package wenjun.concurrent.chapter13;

import org.apache.commons.lang.math.IntRange;

import java.util.stream.IntStream;

/**
 * 1.所有对象都会有一个wait set， 用来存放调用了该对象wait方法之后进入block状态的线程
 * 2.线程被notify之后，不一定立即得到执行。
 * 3.线程从wait set中被唤醒的顺序不一定是FIFO。
 * 4.线程被唤醒后，必须重新获取锁。
 */
public class WaitSet {
    private static final Object LOCK = new Object();
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10)
                .forEach(index -> {
                    new Thread(String.valueOf(index)) {
                        @Override
                        public void run() {
                            synchronized (LOCK) {
                                try {
                                    System.out.println(Thread.currentThread().getName() + "will come to wait set...");
                                    LOCK.wait();
                                    System.out.println(Thread.currentThread().getName() + "will leave from wait set...");
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }.start();
                });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        IntStream.rangeClosed(1, 10)
                .forEach(index -> {
                    synchronized (LOCK) {
                        LOCK.notify();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

//        new Thread(WaitSet::work).start();
//        synchronized (LOCK) {
//            LOCK.notify();
//        }
    }

    private static void work() {
        synchronized (LOCK) {
            System.out.println("work begin...");
            try {
                System.out.println("Thread will coming...");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread will out..");
        }
    }
}
