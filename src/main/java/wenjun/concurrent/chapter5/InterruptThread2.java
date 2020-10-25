package wenjun.concurrent.chapter5;

public class InterruptThread2 {
    private static final Object MONITOR = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (MONITOR) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        System.out.println(t1.isInterrupted());
        t1.interrupt();
        System.out.println(t1.isInterrupted());
    }
}
