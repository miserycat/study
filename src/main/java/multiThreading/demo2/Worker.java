package multiThreading.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by shengchao wu on 4/2/2018.
 */
public class Worker {
    private Random random = new Random();
    private Object lock1 = new Object();

    private Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    private void stageOne() {
        synchronized (lock1) {
            try {
                wait();
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list1.add(random.nextInt());
        }

    }

    private void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list2.add(random.nextInt());
        }

    }

    private void process() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stageOne();
                stageTwo();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stageOne();
                stageTwo();
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    public void main() {
        System.out.println("starting...");

        long start = System.currentTimeMillis();
        process();
        long end = System.currentTimeMillis();

        System.out.println("list1: " + list1.size() + "; list2: "+ list2.size());
        System.out.println("cost " + (end - start) + " ms");
    }





}
