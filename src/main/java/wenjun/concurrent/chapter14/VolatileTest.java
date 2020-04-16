package wenjun.concurrent.chapter14;

public class VolatileTest {
    private static volatile int INIT_VALUE = 0;

    private static int MAX_LIMIT = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
                if (localValue != INIT_VALUE) {
                    System.out.println("The value updated to " + INIT_VALUE);
                    localValue = INIT_VALUE;

                }
            }
        }, "READER").start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
                System.out.println("Update the value to " + ++localValue);
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "UPDATER").start();
    }
}
