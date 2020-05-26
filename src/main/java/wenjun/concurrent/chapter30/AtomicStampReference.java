package wenjun.concurrent.chapter30;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 解决ABA问题
 */
public class AtomicStampReference {
    public static void main(String[] args) throws InterruptedException {
        AtomicStampedReference<Integer> atomicRef = new AtomicStampedReference<>(100, 0);
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(atomicRef.compareAndSet(100, 101, atomicRef.getStamp(), atomicRef.getStamp() + 1));
                int[] holder = new int[1];
                System.out.println(Thread.currentThread().getName() + ":" +atomicRef.get(holder) + " stamp:" + holder[0]);

                System.out.println(atomicRef.compareAndSet(101, 100, atomicRef.getStamp(), atomicRef.getStamp() + 1));
                System.out.println(Thread.currentThread().getName() + ":" +atomicRef.get(holder) + " stamp:" + holder[0]);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread t2 = new Thread(() -> {
            try {
                int stamp = atomicRef.getStamp();
                int[] holder = new int[1];
                TimeUnit.SECONDS.sleep(2);
                System.out.println(atomicRef.compareAndSet(100, 101, stamp, stamp + 1));
                System.out.println(Thread.currentThread().getName() + ":" +atomicRef.get(holder) + " stamp:" + holder[0]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
