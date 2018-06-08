package threadCore.ta7;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shengchao wu on 5/28/2018.
 */
public class PrintABC {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        FlagNum num = new FlagNum();

        Thread t1 = new Thread(()-> {
            try {
                lock.lock();
                while (num.num != 0) {
                    c1.await();
                }
                for (int i = 0; i < 10; i++) {
                    num.printA();
                }
                num.num = 1;
                c2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        });

        Thread t2 = new Thread(()-> {
            try {
                lock.lock();
                while (num.num != 1) {
                    c2.await();
                }
                for (int i = 0; i < 10; i++) {
                    num.printB();
                }
                num.num = 2;
                c3.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t3 = new Thread(()-> {
            try {
                lock.lock();
                while (num.num != 2) {
                    c3.await();
                }
                for (int i = 0; i < 10; i++) {
                    num.printC();
                }
                num.num = 0;
                c1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
