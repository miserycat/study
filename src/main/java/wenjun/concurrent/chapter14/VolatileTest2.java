package wenjun.concurrent.chapter14;

public class VolatileTest2 {

    private static int INIT_VALUE = 0;
    private static final int MAX_LIMIT = 50;

    public static void main(String[] args) {
        new Thread(() -> {
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.println("T1->" + ++INIT_VALUE);
            }
        }, "ADDER-1").start();


        new Thread(() -> {
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.println("T2->" + ++INIT_VALUE);
            }
        }, "ADDER-2").start();

    }
}
