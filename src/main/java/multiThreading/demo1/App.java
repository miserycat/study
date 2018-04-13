package multiThreading.demo1;

/**
 * Created by shengchao wu on 3/30/2018.
 */
public class App {
    private int count = 0;

    public synchronized void increase() {
        count ++;
    }

    public static void main(String[] args) {
        App app = new App();
        app.doWork();
    }

    private  void doWork() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increase();
            }
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increase();
            }
        });

        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);

    }
}
