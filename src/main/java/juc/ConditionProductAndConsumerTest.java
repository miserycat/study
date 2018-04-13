package juc;

import java.util.concurrent.locks.Condition;

/**
 * Created by shengchao wu on 4/12/2018.
 */
public class ConditionProductAndConsumerTest {
    public static void main(String[] args) {
        Clerk2 clerk2 = new Clerk2();
        Producer2 producer2 = new Producer2(clerk2);
        Consumer2 consumer2 = new Consumer2(clerk2);

        new Thread(producer2).start();
        new Thread(producer2).start();
        new Thread(producer2).start();

        new Thread(consumer2).start();
        new Thread(consumer2).start();
        new Thread(consumer2).start();
    }
}

class Clerk2 {
    private int product;
    private java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();
    private Condition condition = lock.newCondition();



    public  void get() {
        try{
            lock.lock();
            while (product >= 10) {
                System.out.println("product is full...");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            condition.signalAll();
            System.out.println(Thread.currentThread().getName() + " get : " + ++product);
        } finally {
            lock.unlock();
        }

    }

    public void sale() {

        try {
            lock.lock();
            while (product <= 0) {
                System.out.println("product is empty...");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + " sale: " + --product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }


    }
}

class Producer2 implements Runnable{
    private Clerk2 clerk2;

    public Producer2(Clerk2 clerk2) {
        this.clerk2 = clerk2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            clerk2.get();
        }
    }
}

class Consumer2 implements Runnable{

    private Clerk2 clerk2;

    public Consumer2(Clerk2 clerk2) {
        this.clerk2 = clerk2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            clerk2.sale();
        }
    }
}