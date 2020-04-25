package wenjun.concurrent.chapter23;

import java.util.LinkedList;

public class MessageQueue {
    private final LinkedList<Message> queue;

    private final int queueLimit;

    private static final int DEFAULT_SIZE = 10;

    public MessageQueue() {
        this(DEFAULT_SIZE);
    }

    public MessageQueue(int queueLimit) {
        this.queueLimit = queueLimit;
        queue = new LinkedList<>();
    }


    public synchronized void put(final Message message) {
        while (queue.size() >= queueLimit) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                break;
            }
        }

        this.queue.addLast(message);
        this.notifyAll();
    }

    public synchronized Message get() {
        while (queue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                break;
            }
        }

        Message message = this.queue.removeFirst();
        this.notifyAll();

        return message;
    }
}
