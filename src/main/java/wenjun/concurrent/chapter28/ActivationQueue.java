package wenjun.concurrent.chapter28;

import java.util.LinkedList;

public class ActivationQueue {
    private final int MAX_METHOD_REQUEST_QUEUE_SIZE = 100;
    private final LinkedList<MethodRequest> methodQueue;

    public ActivationQueue() {
        methodQueue = new LinkedList<>();
    }


    public synchronized void put(final MethodRequest methodRequest) {
        while (methodQueue.size() >= MAX_METHOD_REQUEST_QUEUE_SIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.methodQueue.addLast(methodRequest);
        this.notifyAll();
    }

    public synchronized MethodRequest take() {
        while (methodQueue.size() <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        final MethodRequest methodRequest = this.methodQueue.removeFirst();
        this.notifyAll();
        return methodRequest;
    }
}
