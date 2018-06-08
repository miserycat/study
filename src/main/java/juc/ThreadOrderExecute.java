package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shengchao wu on 5/8/2018.
 */
public class ThreadOrderExecute {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        final Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " run 1");
            }
        }, "T1");
        final Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " run 2");
            try {
                t1.join(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2");
        final Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " run 3");
            try {
                t2.join(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T3");
        // method1
        //t1.start();
        //t2.start();
        //t3.start();

//        method 2 ʹ�� ����������̳߳���ʵ�֡���֤�̵߳�����ִ��
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        executor.shutdown();
    }
}
