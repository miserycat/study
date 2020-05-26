package wenjun.concurrent.chapter31;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, ()-> System.out.println("all Thread finished..."));
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("T1 is waiting for other Threads..");
                cyclicBarrier.await();
                System.out.println("T1 and other thread finished...");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("T2 is waiting for other Threads..");
                cyclicBarrier.await();
                System.out.println("T2 and other thread finished...");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });


        t1.start();
        t2.start();




    }
}
