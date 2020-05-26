package wenjun.concurrent.chapter31;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest1 {
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);
    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        int[] data = getData();
        final CountDownLatch countDownLatch = new CountDownLatch(data.length);
        for (int i = 0; i < data.length; i++) {
            executorService.submit(new SimpleRunnable(data, i, countDownLatch));
        }

        executorService.shutdown();
//        executorService.awaitTermination(1, TimeUnit.HOURS);
        countDownLatch.await();
        printData(data);
    }


    private static int[] getData() {
        return new int[]{1,2,3,4,5,6,7,8,9};
    }

    private static void changeData(final int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                data[i] = data[i] * 2;
            }
        }
    }

    private static void printData(final int[] data) {
        Arrays.stream(data)
                .forEach(System.out::println);
    }

    static class SimpleRunnable implements Runnable {
        private final int[] data;
        private final int index;
        private final CountDownLatch countDownLatch;

        SimpleRunnable(int[] data, int index, CountDownLatch countDownLatch) {
            this.data = data;
            this.index = index;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            if (data[index] % 2 == 0) {
                data[index] = data[index] * 2;
            }
            System.out.println("change data:" +data[index]);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }
    }
}
