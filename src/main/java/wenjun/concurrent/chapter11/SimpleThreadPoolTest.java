package wenjun.concurrent.chapter11;

import java.util.stream.IntStream;

public class SimpleThreadPoolTest {
    public static void main(String[] args) {
        SimpleThreadPool pool = new SimpleThreadPool();
//        SimpleThreadPool pool = new SimpleThreadPool(6, 12);
        IntStream.range(0, 40)
                .forEach(index -> {
                    pool.submit(()-> {
                        System.out.println("The runnable " + index + " be serviced by " + Thread.currentThread() + " start...");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("The runnable " + index + " be serviced by " + Thread.currentThread() + " finished..");
                    });
                });

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pool.shutdown();
//        System.out.println(pool.isDestroy());
//        pool.submit(()-> System.out.println("submit after destroy..."));
    }
}
