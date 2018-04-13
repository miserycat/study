package juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by shengchao wu on 4/13/2018.
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ThreadPoolDemo tp = new ThreadPoolDemo();
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = pool.submit(() -> {
                int random = new Random().nextInt(100);
                int sum = 0;
                for (int j = 0; j <= random; j++) {
                    sum += j;
                }
                return sum;
            });
            futures.add(future);
        }
        pool.shutdown();

        for (Future<Integer> future : futures) {
            System.out.println(future.get());
        }


        ScheduledExecutorService schedulePool = Executors.newScheduledThreadPool(5);

        ScheduledFuture<String> schedule = schedulePool.schedule(tp, 1, TimeUnit.SECONDS);

        System.out.println(schedule.get());

    }
}

class ThreadPoolDemo implements Callable<String>{

    @Override
    public String call() throws Exception {
        String s1 = "s1";
        String s2 = "s2";
        return s1.concat(s2);
    }
}



