package thread02.com.atguigu.java1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengchao wu on 5/28/2018.
 */
public class ConsumerAndProducerTest {
    public static void main(String[] args) {
        Object lock = new Object();
        List<Integer> goods = new ArrayList<>();
//        goods.add(88);

        new Thread(()->{
            synchronized (lock) {
                while (true) {
                    while (goods.size() >= 10) {
                        System.out.println("size > 10  wait for consumer to consume");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer good = (int) (Math.random() * 100);
                    goods.add(good);
                    System.out.println("add new good "+ good);
                    lock.notify();
                }
            }
        }).start();


        new Thread(()-> {
            synchronized (lock) {
                while (true) {
                    while (goods.size() <= 5) {
                        System.out.println("size <= 5 wait for producer to produce...");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer good = goods.remove(0);
                    System.out.println("consume good " + good);
                    lock.notify();
                }
            }
        }).start();

    }
}
