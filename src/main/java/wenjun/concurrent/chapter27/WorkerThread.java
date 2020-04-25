package wenjun.concurrent.chapter27;

import java.util.Random;

public class WorkerThread extends Thread{

    private final Channel channel;

    private static final Random random = new Random(System.currentTimeMillis());

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        for (; ; ) {
            final Request request = channel.take();
            System.out.println("worker thread:" +getName() + " take request:" + request.toString());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
