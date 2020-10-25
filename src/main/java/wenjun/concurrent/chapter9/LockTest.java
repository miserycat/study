package wenjun.concurrent.chapter9;

import java.util.stream.Stream;

public class LockTest {
    public static void main(String[] args) {
        Lock lock = new BooleanLock();

        Stream.of("T1", "T2", "T3", "T4")
                .forEach(name -> {
                    new Thread(() -> {
                        try {
                            lock.lock(1000L);
                            working();
                        } catch (InterruptedException | Lock.TimeOutException e) {
                            e.printStackTrace();
                        } finally {
                            lock.unlock();
                        }
                    }, name).start();
                });
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        lock.unlock();
    }

    private static void working() {
        try {
            System.out.println(Thread.currentThread().getName() + " is working...");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
