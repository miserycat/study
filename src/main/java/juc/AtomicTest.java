package juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shengchao wu on 4/11/2018.
 */
public class AtomicTest {

    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        AtomicInteger a = new AtomicInteger();
        a.getAndIncrement();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();
        }
    }



}

class AtomicDemo implements Runnable{

    private AtomicInteger serialNumber;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(addSerial());
    }

    private int addSerial() {
        return serialNumber.getAndIncrement();
    }
}
