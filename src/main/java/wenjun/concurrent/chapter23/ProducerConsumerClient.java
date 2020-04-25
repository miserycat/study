package wenjun.concurrent.chapter23;

public class ProducerConsumerClient {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        ProducerThread p1 = new ProducerThread(queue);
        ProducerThread p2 = new ProducerThread(queue);
        ConsumerThread c1 = new ConsumerThread(queue);
        p1.start();
        p2.start();
        c1.start();
    }
}
