package wenjun.concurrent.chapter5;

public class InterruptThread3 {
    public static void main(String[] args){
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };

        Thread mainThread = Thread.currentThread();

        new Thread() {
            @Override
            public void run() {
                mainThread.interrupt();
            }
        }.start();

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
