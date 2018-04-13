package juc;


/**
 * Created by shengchao wu on 4/12/2018.
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }

}

class Ticket implements Runnable{
    private int num = 100;

    private static final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {

        while (true){
            try {
                lock.lock();
                if (num > 0) {
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + ": " + --num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
