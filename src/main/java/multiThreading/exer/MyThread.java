package multiThreading.exer;

/**
 * Created by shengchao wu on 4/9/2018.
 */
public class MyThread implements Runnable {
    int num = 0;

    @Override
    public void run() {
        while(true) {
            synchronized (this) {
                notify();
                if (num <=100) {
                    System.out.println(Thread.currentThread() + ":" + num++);
                }

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
