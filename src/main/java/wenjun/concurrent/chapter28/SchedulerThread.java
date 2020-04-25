package wenjun.concurrent.chapter28;

public class SchedulerThread extends Thread {
    private final ActivationQueue activationQueue;

    public SchedulerThread(ActivationQueue activationQueue) {
        this.activationQueue = activationQueue;
    }

    public void invoke(final MethodRequest methodRequest) {
        this.activationQueue.put(methodRequest);
    }

    @Override
    public void run() {
        for (; ; ) {
            activationQueue.take().execute();
        }
    }
}
