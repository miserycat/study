package wenjun.concurrent.chapter9;

import java.util.Collection;
import java.util.concurrent.TimeoutException;

public interface Lock {
    class TimeOutException extends Exception {
        public TimeOutException(String message) {
            super(message);
        }
    }
    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeOutException;

    void unlock();

    Collection<Thread> getBlockedThreads();

    int getBlockedSize();

}
