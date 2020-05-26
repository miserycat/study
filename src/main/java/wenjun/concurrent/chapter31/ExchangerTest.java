package wenjun.concurrent.chapter31;

import java.util.concurrent.Exchanger;
//Exchanger 两个线程之间交换数据
// T r exchange(T t): t:要发送的数据， r从另外一个线程接收的数据, 交换的对象和各种传送的数据是同一个。
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread t1 = new Thread(() -> {
            try {
                String receive = exchanger.exchange("t1 data");
                System.out.println(Thread.currentThread().getName() + " receive data: [" + receive + "]");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                String receive = exchanger.exchange("t2 data");
                System.out.println(Thread.currentThread().getName() + " receive data: [" + receive + "]");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
