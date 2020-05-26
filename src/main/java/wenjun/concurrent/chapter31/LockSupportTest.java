package wenjun.concurrent.chapter31;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test1() {
        System.out.println("begin to park");
        LockSupport.park();
        System.out.println("after park");
    }


    //当一个线程调用unpark时，如果参数thread没有持有thread与LockSupport类的关联许可证，则让当前线程持有。
    //如果thread因为之前被调用park之后被挂起，则调用unpark后该线程会被唤醒，如果调用unpark之后再调用park则会立即返回
    private static void test2() {
        System.out.println("begin to park");
        LockSupport.unpark(Thread.currentThread());;
        LockSupport.park();
        System.out.println("end park");
    }

    private static void test3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("thread t1 begin park...");
            LockSupport.park();
            System.out.println("thread t1 unpark...");
        });

        t1.start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println("main thread unpark...");

        LockSupport.unpark(t1);
    }

    private static void test4() throws InterruptedException{
        Thread t1 = new Thread(() -> {
            System.out.println("thread t1 begin park...");
            while (!Thread.currentThread().isInterrupted()) {
                LockSupport.park();
            }
            System.out.println("thread t1 unpark...");
        });

        t1.start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println("main thread unpark...");

        t1.interrupt();
    }
}

