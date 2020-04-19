package wenjun.concurrent.chapter18;

//读写锁，读读不需要加锁，读写、写写都要加锁
public class ReadWriteLock {
    private int readingReaders = 0;
    private int waitingReader = 0;
    private int writingWriters = 0;
    private int waitingWriters = 0;

    //增加读的执行机会
    private boolean preferWriter = true;

    public ReadWriteLock() {
        this(true);
    }

    public ReadWriteLock(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    public synchronized void readLock() throws InterruptedException {
        this.waitingReader++;
        try {
            while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
                this.wait();
            }
            this.readingReaders++;
        } finally {
            this.waitingReader--;
        }
    }

    public synchronized void readUnlock() {
        this.readingReaders--;
        this.notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        this.waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                this.wait();
            }
            this.writingWriters++;
        } finally {
            this.waitingWriters--;
        }
    }

    public synchronized void writeUnlock() {
        this.writingWriters--;
        this.notifyAll();
    }
}
