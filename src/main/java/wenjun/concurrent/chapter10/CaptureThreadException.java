package wenjun.concurrent.chapter10;

public class CaptureThreadException {
    private static final int A = 10;
    private static final int B = 0;
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(A / B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(e.getMessage());
            System.out.println(t);
        });

        thread.start();

        Test1 test1 = new Test1();
        test1.test();


    }
}
