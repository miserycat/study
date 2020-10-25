package wenjun.concurrent.chapter8;
//The difference of sleep and wait
//    1.sleep is the method of Thread, but wait is the method of Object.
//    2.sleep will not release the object monitor(lock), but the wait will be release the monitor and add to the Object monitor waiting queue.
//    3.use sleep not depend on the monitor, but wait need.
//    4.sleep not need to be waked up, but wait need exclude(wait(num))
public class WaitSleepDifference {
    private static final Object LOCK = new Object();
    public static void m1() {
        try {
            LOCK.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m1();
    }
}

