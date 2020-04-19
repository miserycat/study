package wenjun.concurrent.chapter18;

import io.vavr.collection.Array;

import java.util.Arrays;

public class SharedData {
    private char[] buff;

    private static final  ReadWriteLock lock = new ReadWriteLock();

    public SharedData(int size) {
        buff = new char[size];
        Arrays.fill(buff, '*');
    }

    public char[] read() throws InterruptedException {
        try {
            lock.readLock();
            return doRead();
        } finally {
            lock.readUnlock();
        }
    }

    private char[] doRead() {
        char[] newBuf = new char[buff.length];
        System.arraycopy(buff, 0, newBuf, 0, buff.length);
        slow(50);
        return newBuf;
    }

    public void write(final char c) throws InterruptedException {
        try {
            lock.writeLock();
            doWrite(c);
        } finally {
            lock.writeUnlock();
        }
    }

    private void doWrite(char c) {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = c;
            slow(10);
        }
    }

    private void slow(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
