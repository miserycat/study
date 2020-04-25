package wenjun.concurrent.chapter24;

public class MyCountDownLatch {
    private final int countDown;

    private int count;
    public MyCountDownLatch(int countDown) {
        this.countDown = countDown;
    }

    public synchronized void countDown() {
        this.count++;
        this.notifyAll();
    }

    public synchronized void await() throws InterruptedException {
        while (count != countDown) {
            this.wait();
        }
    }


}
