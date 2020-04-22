package wenjun.concurrent.chapter20;

import java.util.LinkedList;

public class RequestQueue {
    private final LinkedList<Request> queue = new LinkedList<>();

    public Request getRequest() {
        synchronized (queue) {
            while (queue.size() <= 0) {

                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    return null;
                }
            }

            return queue.removeFirst();
        }
    }

    public void putRequest(final Request request) {
        synchronized (queue) {
            queue.addLast(request);
            queue.notifyAll();
        }
    }

}
