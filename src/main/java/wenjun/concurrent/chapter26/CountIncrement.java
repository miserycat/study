package wenjun.concurrent.chapter26;

public class CountIncrement extends Thread {
    private volatile boolean isTerminated = false;

    private int counter = 0;

    @Override
    public void run() {
        try {
            while (!isTerminated) {
                System.out.println(Thread.currentThread().getName() + " " + counter++);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
        } finally {
            clean();
        }
    }

    private void clean() {
        System.out.println("do some clean work for the second phase, current counter is " + counter);
    }

    public void close() {
        this.isTerminated = true;
        this.interrupt();
    }
}
