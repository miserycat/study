package wenjun.concurrent.chapter23;

public class ConsumerThread extends Thread {
    private final MessageQueue messageQueue;

    public ConsumerThread(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            Message message = messageQueue.get();
            System.out.println(Thread.currentThread().getName() + " consume " + message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
