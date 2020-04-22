package wenjun.concurrent.chapter21;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalSimulator <T>{
    private final Map<Thread, T> storage = new HashMap<>();

    public synchronized void set(T t) {
        Thread key = Thread.currentThread();
        storage.put(key, t);
    }

    public synchronized T get() {
        T t = storage.get(Thread.currentThread());
        if (t == null) {
            return initValue();
        }

        return t;
    }

    protected T initValue() {
        return null;
    }
}
