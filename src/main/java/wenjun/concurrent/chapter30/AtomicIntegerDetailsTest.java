package wenjun.concurrent.chapter30;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

public class AtomicIntegerDetailsTest {
    public static void main(String[] args) {
        //create
        AtomicInteger i = new AtomicInteger();
        System.out.println(i.get());
        i = new AtomicInteger(10);
        System.out.println(i.get());

        //set
        i.set(12);
        System.out.println(i.get());
        i.lazySet(13);
        System.out.println(i.get());

        //get and add
        AtomicInteger atomicInteger = new AtomicInteger(10);
        int result = atomicInteger.getAndAdd(10);
        System.out.println(result);
        System.out.println(atomicInteger.get());

        atomicInteger.getAndUpdate(operand -> operand + 10);
        System.out.println(atomicInteger.get());



    }
}
