package jvm.memory;

/**
 *  stackOverflow
 */
public class MyTest2 {
    private static int length;
    public static void main(String[] args) {
        try {
            test();
        } catch (Throwable ex) {
            System.out.println(length);
            ex.printStackTrace();
        }
    }

    public static void test() {
        length++;
        test();
    }
}
