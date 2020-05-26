package wenjun.concurrent.chapter30;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    //volatile不能保证原子性
    private volatile static int value = 0;

    //AtomicXXX(原子类)可以保证可见性，有序性，原子性
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        final Thread t1 = new Thread(() -> {
            int x = 0;
            while (x < 500) {
                int tmp = atomicInteger.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + ": value" + tmp);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                value++;
                /**
                 * value++
                 * (1) get value from main memory to local memory
                 * (2) add 1 => x
                 * (3) assign value to x
                 * (4) flush to main memory
                 */
                x++;
            }
        });

        final Thread t2 = new Thread(() -> {
            int x = 0;
            while (x < 500) {
                int tmp = atomicInteger.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + ": value" + tmp);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                value++;
                x++;
            }
        });

        final Thread t3 = new Thread(() -> {
            int x = 0;
            while (x < 500) {
                int tmp = atomicInteger.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + ": value" + tmp);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                value++;
                x++;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
