package multiThreading.exer;

/**
 * Created by shengchao wu on 4/9/2018.
 */
public class MyThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread).start();
        new Thread(myThread).start();
    }
}
