package wenjun.concurrent.chapter8;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread p = new Thread(() -> {
            while (true) {
                producerConsumer.produce();
            }
        });

        Thread c = new Thread(() -> {
            while (true) {
                producerConsumer.consume();
            }
        });
        p.start();
        c.start();
    }
}
