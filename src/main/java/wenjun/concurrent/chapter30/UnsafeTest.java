package wenjun.concurrent.chapter30;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnsafeTest {
    public static void main(String[] args) throws Exception {
//        Unsafe unsafe = Unsafe.getUnsafe();
//        System.out.println(unsafe);
//
//        Unsafe unsafe = getUnsafe();
//        System.out.println(unsafe);

        ExecutorService executorService = Executors.newFixedThreadPool(1000);
//        Counter counter = new StupidCounter();
//        Counter counter = new SyncCounter();
//        Counter counter = new LockCounter();
        Counter counter = new AtomicCounter();
//        Counter counter = new CASCounter();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new CounterRunnable(counter, 10000));
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);

        long end = System.currentTimeMillis();

        System.out.println(end - start);
        System.out.println(counter.getCounter());

    }

    private static Unsafe getUnsafe() throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);

        return (Unsafe) theUnsafe.get(null);
    }

    interface Counter {
        void increment();

        long getCounter();
    }

    static class StupidCounter implements Counter {
        private long num = 0;
        @Override
        public void increment() {
            num++;
        }

        @Override
        public long getCounter() {
            return num;
        }
    }

    static class SyncCounter implements Counter {
        private volatile long num;
        @Override
        public synchronized void increment() {
            num++;
        }

        @Override
        public long getCounter() {
            return num;
        }
    }

    static class LockCounter implements Counter {
        private static final Lock LOCK = new ReentrantLock();
        private volatile long num;

        @Override
        public void increment() {
            try {
                LOCK.lock();
                num++;
            } finally {
                LOCK.unlock();
            }
        }

        @Override
        public long getCounter() {
            return num;
        }
    }

    static class AtomicCounter implements Counter {
        private AtomicLong num = new AtomicLong();

        @Override
        public void increment() {
            num.incrementAndGet();
        }

        @Override
        public long getCounter() {
            return num.get();
        }
    }





    static class CounterRunnable implements Runnable {
        private final Counter counter;
        private final int num;

        CounterRunnable(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                counter.increment();
            }
        }
    }

    static class CASCounter implements Counter {
        private volatile long num;
        private Unsafe unsafe;
        private long offset;

        public CASCounter() throws Exception {
            unsafe = getUnsafe();
            offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("num"));
            System.out.println(unsafe);
            System.out.println(offset);
        }

        @Override
        public void increment() {
            long current = getCounter();
            while (!unsafe.compareAndSwapLong(this, offset, current, current + 1)) {
                current = getCounter();
            }
        }

        @Override
        public long getCounter() {
            return num;
        }
    }


}
