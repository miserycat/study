package threadCore.ta7;

/**
 * Created by shengchao wu on 5/29/2018.
 */
public class PrintABC2 {

    public static void main(String[] args) {
        Object lock = new Object();
        FlagNum num = new FlagNum();

        Thread t1 = new Thread(()-> {
            synchronized (lock) {
                try {
                    while (num.num != 0) {
                        lock.wait();
                    }
                    for (int i = 0; i < 10; i++) {
                        num.printA();
                    }
                    num.num = 1;
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()-> {
            synchronized (lock) {
                try {
                    while (num.num != 1) {
                        lock.wait();
                    }
                    for (int i = 0; i < 10; i++) {
                        num.printB();
                    }
                    num.num = 2;
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(()-> {
            synchronized (lock) {
                try {
                    while (num.num != 2) {
                        lock.wait();
                    }
                    for (int i = 0; i < 10; i++) {
                        num.printC();
                    }
                    num.num = 0;
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
