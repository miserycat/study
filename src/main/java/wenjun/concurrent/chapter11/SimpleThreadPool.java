package wenjun.concurrent.chapter11;


import org.fusesource.hawtdispatch.internal.pool.SimpleThread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//线程池几个基本概念
//1.任务队列：taskQueue
//2.拒绝策略：任务队列已满，新的请求拒绝的策略（抛出异常，直接丢弃，阻塞，临时队列）
//3.线程池的init大小（min）, active大小，max大小，init <= active <= max
public class SimpleThreadPool extends Thread{
    private int size;
    private final int queueSize;
    private static final int DEFAULT_TASK_QUEUE_SIZE = 2000;

    private static volatile int seq = 0;
    private static final String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";
    private static final ThreadGroup GROUP = new ThreadGroup("pool_group");

    private static final LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private static final List<WorkerTask> THREAD_QUEUE = new ArrayList<>();
    private static final DiscardPolicy DEFAULT_DISCARD_POLICY = () -> {
        throw new DiscardException("Discard This Task...");
    };
    private DiscardPolicy discardPolicy;
    private volatile boolean destroy;
    private int min;
    private int active;
    private int max;

    public SimpleThreadPool() {
        this(4, 8, 12, DEFAULT_TASK_QUEUE_SIZE,DEFAULT_DISCARD_POLICY);
    }

    public SimpleThreadPool(int min, int active, int max, int queueSize, DiscardPolicy discardPolicy ) {
        this.min = min;
        this.active = active;
        this.max = max;
        this.queueSize = queueSize;
        this.discardPolicy = discardPolicy;
        init();
    }

    public void submit(Runnable runnable) {
        if (isDestroy()) {
            throw new IllegalArgumentException("pool has been destroy...");
        }
        synchronized (TASK_QUEUE) {
            if (TASK_QUEUE.size() > queueSize) {
                discardPolicy.discard();
            }
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    private void init() {
        this.size = min;
        for (int i = 0; i < size; i++) {
            createWorkTask();
        }
        this.start();

    }

    private void createWorkTask() {
        WorkerTask workerTask = new WorkerTask(GROUP, THREAD_PREFIX + seq++);
        workerTask.start();
        THREAD_QUEUE.add(workerTask);
    }

    public static class DiscardException extends RuntimeException {
        public DiscardException(String message) {
            super(message);
        }
    }


    public interface DiscardPolicy {
        public void discard() throws DiscardException;
    }

    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD
    }


    private static class WorkerTask extends Thread {
        private volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            OUTER:
            while (TaskState.DEAD != this.taskState) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            System.out.println("close...");
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                }
                if (runnable != null) {
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }
        }

        public TaskState getTaskState() {
            return this.taskState;
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }

    }

    @Override
    public void run() {
        while (!destroy) {
            System.out.printf("Pool#Min:%d, Active:%d, Max:%d, Current:%d, QueueSize:%d \n", this.min, this.active, this.max, this.size, TASK_QUEUE.size());
            try {
                Thread.sleep(5000);
                if (TASK_QUEUE.size() > active && size < active) {
                    for (int i = size; i < active; i++) {
                        createWorkTask();
                    }
                    System.out.println("The pool incremented to active...");
                    size = active;
                } else if (TASK_QUEUE.size() > max && size < max) {
                    for (int i = size; i < max; i++) {
                        createWorkTask();
                    }
                    System.out.println("The pool incremented to max...");
                    size = max;
                }

                synchronized (THREAD_QUEUE) {
                    if (TASK_QUEUE.isEmpty() && size > active) {
                        int releaseSize = size - active;
                        for (Iterator<WorkerTask> iterator = THREAD_QUEUE.iterator(); iterator.hasNext(); ) {
                            if (releaseSize <= 0) {
                                break;
                            }
                            WorkerTask task = iterator.next();
                            if (task.getTaskState() != TaskState.BLOCKED) {
                                continue;
                            }
                            task.close();
                            task.interrupt();
                            iterator.remove();
                            releaseSize--;
                        }
                        size = active;
                    }
                }



            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        while (!TASK_QUEUE.isEmpty()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int initVal = THREAD_QUEUE.size();
        while (initVal > 0) {
            for (WorkerTask workerTask : THREAD_QUEUE) {
                if (workerTask.getTaskState() == TaskState.BLOCKED) {
                    workerTask.interrupt();
                    workerTask.close();
                    initVal--;
                } else {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        destroy = true;
        System.out.println("The Thread pool disposed...");
    }

    public int getSize() {
        return size;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public int getMin() {
        return min;
    }

    public int getActive() {
        return active;
    }

    public int getMax() {
        return max;
    }

    public boolean isDestroy() {
        return this.destroy;
    }
}
