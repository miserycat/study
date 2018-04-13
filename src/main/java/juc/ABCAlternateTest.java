package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by shengchao wu on 4/12/2018.
 */
public class ABCAlternateTest {
    public static void main(String[] args) {
        AlternateDemo ad = new AlternateDemo();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                ad.loopA(i);
            }
        }, "A").start();


        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                ad.loopB(i);
            }
        }, "B").start();


        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                ad.loopC(i);
            }
        }, "C").start();
    }

}

class AlternateDemo {
    private int num = 1;

    private Lock lock = new java.util.concurrent.locks.ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA (int times) {
        try {
            lock.lock();
            while(num != 1) {
                condition1.await();
            }

            for (int i = 0; i <= 0; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + times);
            }

            num = 2;
            condition2.signal();

        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }


    public void loopB (int times) {
        try {
            lock.lock();
            while(num != 2) {
                condition2.await();
            }

            for (int i = 0; i <= 0; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + times);
            }
            num = 3;
            condition3.signal();

        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }


    public void loopC (int times) {
        try {
            lock.lock();
            while(num != 3) {
                condition3.await();
            }

            for (int i = 0; i <= 0; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + times);
            }

            num = 1;
            condition1.signal();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }
}
