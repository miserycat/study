package juc;

import java.util.concurrent.CountDownLatch;

/**
 * Created by shengchao wu on 4/11/2018.
 */
public class CountDownLockTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        LatchDemo latch = new LatchDemo(countDownLatch);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            new Thread(latch).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("cost time :" + (end - start) + "ms");

    }
}


class LatchDemo implements Runnable {

    private CountDownLatch countDownLatch;

    public LatchDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < 50000; i++) {
                if (i % 2 ==0) {
                    System.out.println(i);
                }
            }
        } finally {
            countDownLatch.countDown();
        }

    }
}
