package wenjun.concurrent.chapter25;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageHandler {
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    private static final Random random = new Random();

    public void request(final Message message) {
        executorService.submit(()-> {
            String data = message.getData();
            System.out.println("The message: " + message.getData() + " will be handle by " + Thread.currentThread().getName());
        });
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
