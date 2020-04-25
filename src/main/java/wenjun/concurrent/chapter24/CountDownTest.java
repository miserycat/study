package wenjun.concurrent.chapter24;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CountDownTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
//        CountDownLatch countDownLatch = new CountDownLatch(10);
        MyCountDownLatch countDownLatch = new MyCountDownLatch(10);
        IntStream.range(0, 10)
                .forEach(index -> {
                    new Thread(() -> {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        atomicInteger.incrementAndGet();
                        countDownLatch.countDown();
                    }).start();
                });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main Thread calculate count " + atomicInteger.get());
    }
}
