package wenjun.concurrent.chapter27;

import java.util.Arrays;

//Work-Thread（工人流水线）设计模式
//channel 代表了一条流水线， requestQueue 流水线任务队列，
//TransportThread: 代表将任务传送到流水线上的工人 任务从头放到尾
//WorkerThread:代表了到流水线队列里取任务的工人 任务从头开始取
// put-> 10 9 8 7 6 5 4 3 2 1 <-take
public class Channel {
    private static final int MAX_REQUEST = 100;
    private final Request[] requestQueue;
    private final WorkerThread[] workPool;
    private int head;
    private int tail;
    private int count;

    public Channel(final int workers) {
        this.requestQueue = new Request[MAX_REQUEST];
        this.workPool = new WorkerThread[workers];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        this.init();

    }

    private void init() {
        for (int i = 0; i < workPool.length; i++) {
            workPool[i] = new WorkerThread("Woker-" + i, this);
        }
    }

    public void startWorker() {
        Arrays.stream(workPool).forEach(WorkerThread::start);
    }

    public synchronized void put(final Request request) {
        while (count >= requestQueue.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.requestQueue[tail] = request;
        //加1 如果>length 重新从0开始
        this.tail = tail + 1 % requestQueue.length;
        this.count++;
        this.notifyAll();
    }

    public synchronized Request take() {
        while (count <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        final Request request = this.requestQueue[head];
        this.head = head + 1 % requestQueue.length;
        this.count--;
        notifyAll();
        return request;
    }
}
