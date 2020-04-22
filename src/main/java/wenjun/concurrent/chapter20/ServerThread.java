package wenjun.concurrent.chapter20;

import java.util.Random;

public class ServerThread extends Thread {
    private final RequestQueue queue;
    private final Random random;
    private volatile boolean closed = false;

    public ServerThread(RequestQueue queue) {
        this.queue = queue;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (!closed) {
            Request request = queue.getRequest();
            if (request == null) {
                System.out.println("Receive the empty request...");
                break;
            }
            System.out.println("Server ->" + request.getValue());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void close() {
        this.closed = true;
        this.interrupt();
    }
}
