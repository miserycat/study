package juc;

/**
 * Created by shengchao wu on 4/12/2018.
 */
public class ProducerAndConsumerTest {
    public static void main(String[] args) {

        Clerk clerk = new Clerk();

        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();

        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}

class Clerk {
    private int product;

    public synchronized void get() {

        //不能用if，会有虚假唤醒
        while (product >= 10) {
            System.out.println("product is full...");
            try {
                wait();
            } catch (InterruptedException e) {
            }

        }
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " get : " + ++product);
    }

    public synchronized void sale() {
        while (product <= 0) {
            System.out.println("product is empty...");
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + " sale: " + --product);
        notifyAll();

    }
}

class Producer implements Runnable{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            clerk.get();
        }
    }
}

class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            clerk.sale();
        }
    }
}
