package wenjun.concurrent.chapter28;

public class FutureResult<T> implements Result<T> {
    private Result<T> result;
    private boolean ready = false;

    public synchronized void setResult(final Result<T> result) {
        this.result = result;
        this.ready = true;
        this.notifyAll();
    }

    @Override
    public synchronized T getResultValue() {
        try {
            while (!ready) {
                this.wait();
            }
        } catch (InterruptedException e) {

        }
        return this.result.getResultValue();
    }
}
