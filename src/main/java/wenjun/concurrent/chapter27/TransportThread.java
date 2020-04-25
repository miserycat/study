package wenjun.concurrent.chapter27;

import java.util.Random;

public class TransportThread extends Thread {
    private final Channel channel;

    private Random random = new Random(System.currentTimeMillis());

    public TransportThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {

            for (int i = 0; ; i++) {
                Request request = new Request(getName(), i);
                this.channel.put(request);
                System.out.println("transport thread:" + getName() + " transport request " + request.toString());
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {

        }
    }
}
