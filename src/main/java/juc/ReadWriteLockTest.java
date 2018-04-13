package juc;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by shengchao wu on 4/13/2018.
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        ReadWriteDemo rw = new ReadWriteDemo();

        new Thread(() -> {
            rw.write(new Random().nextInt(100));
        }).start();

        for (int i = 0; i < 100; i++) {
            rw.read();
        }
    }
}

class ReadWriteDemo {
    private int num = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try{
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + ":" + num);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write(int num) {
        try {
            this.num = num;
            lock.writeLock().lock();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
