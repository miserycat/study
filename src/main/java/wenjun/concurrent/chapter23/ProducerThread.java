package wenjun.concurrent.chapter23;

import java.util.Random;

public class ProducerThread extends Thread {
    private final MessageQueue messageQueue;

    private final Random random = new Random(System.currentTimeMillis());

    public ProducerThread(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            Message message = new Message("data" + random.nextInt(1000));
            messageQueue.put(message);

            System.out.println(Thread.currentThread().getName() + " produce " +message.toString() );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
