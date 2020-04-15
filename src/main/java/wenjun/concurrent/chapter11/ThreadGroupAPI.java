package wenjun.concurrent.chapter11;

import java.util.Arrays;

public class ThreadGroupAPI {
    public static void main(String[] args) {
        ThreadGroup tg1 = new ThreadGroup("TG1");
        tg1.setDaemon(true);
        Thread t1 = new Thread(tg1, "T1") {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("T1 finished...");
            }
        };

        t1.start();

        Thread t2 = new Thread(tg1, "T2") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2 finished...");
            }
        };

        t2.start();
        System.out.println(tg1.activeCount());
        Thread[] threads = new Thread[tg1.activeCount()];
        tg1.enumerate(threads);
        Arrays.stream(threads)
                .forEach(System.out::println);

        //interrupt all threads in the threadGroup
        tg1.interrupt();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(tg1.isDestroyed());



    }


}
