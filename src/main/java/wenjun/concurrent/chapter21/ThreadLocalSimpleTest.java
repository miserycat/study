package wenjun.concurrent.chapter21;

public class ThreadLocalSimpleTest {
    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "Cassie");


    public static void main(String[] args) {
        System.out.println(threadLocal.get());

        threadLocal.set("sc");

        System.out.println(threadLocal.get());
    }
}
