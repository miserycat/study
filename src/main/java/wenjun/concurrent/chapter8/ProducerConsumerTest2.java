package wenjun.concurrent.chapter8;

import java.util.stream.Stream;

//notify 会唤醒wait queue中的任意一个
public class ProducerConsumerTest2 {
    public static void main(String[] args) {
        ProducerConsumer2 producerConsumer = new ProducerConsumer2();

        Stream.of("P1", "P2").forEach(name -> {
            new Thread(() -> {
                while (true) {
                    producerConsumer.produce();
                }
            }, name).start();
        });

        Stream.of("C1", "C2").forEach(name -> {
            new Thread(() -> {
                while (true) {
                    producerConsumer.consume();
                }
            }, name).start();
        });

    }
}
