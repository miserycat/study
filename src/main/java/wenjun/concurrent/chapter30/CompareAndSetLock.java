package wenjun.concurrent.chapter30;

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSetLock {
    private final AtomicInteger value = new AtomicInteger();
    private Thread lockOwner;

    public void tryLock() {
        boolean success = value.compareAndSet(0, 1);
        if (!success) {
            throw new GetLockException("fail to get lock...");
        }
        lockOwner = Thread.currentThread();
    }

    public void unLock() {
        if (value.get() == 0) {
            return;
        }

        if (lockOwner == Thread.currentThread()) {
            value.compareAndSet(1, 0);
        }
    }


    static class GetLockException extends RuntimeException{
        public GetLockException(String message) {
            super(message);
        }
    }
}

