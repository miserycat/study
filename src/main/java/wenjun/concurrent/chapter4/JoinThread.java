package wenjun.concurrent.chapter4;

import java.util.stream.IntStream;

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> IntStream
                .range(1, 1000).forEach(i -> System.out.println(Thread.currentThread().getName() + ":"+ i)));

        t1.start();
        t1.join();
//        t1.join(100);

        IntStream.range(1, 1000).forEach(i -> System.out.println(Thread.currentThread().getName() + ":" + i));


        //自己等自己，防止daemon thread 退出
//        Thread.currentThread().join();
    }
}
