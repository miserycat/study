package wenjun.concurrent.chapter9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class BooleanLock implements Lock {
    public BooleanLock() {
        isLocked = false;
    }

    private boolean isLocked;

    private Collection<Thread> blockedThreads = new ArrayList<>();

    private Thread lockOwner;

    @Override
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            blockedThreads.add(Thread.currentThread());
            wait();
        }

        this.isLocked = true;
        blockedThreads.remove(Thread.currentThread());
        lockOwner = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " own the lock");

    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        if (mills <= 0) {
            lock();
        }

        long endTime = System.currentTimeMillis() + mills;
        while (isLocked) {
            blockedThreads.add(Thread.currentThread());
            wait(mills);
            if (System.currentTimeMillis() > endTime) {
                throw new TimeOutException(Thread.currentThread().getName() + " time out...");
            }
        }

        this.isLocked = true;
        blockedThreads.remove(Thread.currentThread());
        lockOwner = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " own the lock");
    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() != lockOwner) {
            System.out.println("current Thread " + Thread.currentThread().getName() + " does not own the lock...");
            return;
        }
        this.isLocked = false;
        Optional.of(Thread.currentThread().getName())
                .ifPresent(name -> System.out.println(name + " release the lock..."));

        notifyAll();
    }

    @Override
    public Collection<Thread> getBlockedThreads() {
        return Collections.unmodifiableCollection(blockedThreads);
    }

    @Override
    public int getBlockedSize() {
        return blockedThreads.size();
    }
}
