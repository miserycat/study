package wenjun.concurrent.chapter25;

import java.util.stream.IntStream;

public class PerThreadClient {
    public static void main(String[] args) {
        final MessageHandler messageHandler = new MessageHandler();
        IntStream.range(0, 10)
                .forEach(index -> {
                    messageHandler.request(new Message(String.valueOf(index)));
                });

        messageHandler.shutdown();
    }
}
