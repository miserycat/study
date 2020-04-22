package wenjun.concurrent.chapter19;

public class AsynFuture<T> implements Future<T> {
    private volatile boolean isDone;

    private T result;

    public void done(T result) {
        synchronized (this) {
            this.result = result;
            this.isDone = true;
            this.notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException {
        synchronized (this) {
            while (!isDone) {
                this.wait();
            }
        }
        return result;
    }
}
