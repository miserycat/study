package wenjun.concurrent.chapter21;

public class ThreadLocalComplexTest {
//    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static ThreadLocalSimulator<String> threadLocal = new ThreadLocalSimulator<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            threadLocal.set("Thread-1 local value");
            System.out.println(threadLocal.get());
        });

        Thread t2 = new Thread(() -> {
            threadLocal.set("Thread-2 local value");
            System.out.println(threadLocal.get());
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(threadLocal.get());


    }

}
