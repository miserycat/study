package wenjun.concurrent.chapter18;

import java.util.Random;

public class WriterWorker extends Thread {
    private static final Random random = new Random(System.currentTimeMillis());

    private final SharedData data;

    private final String filter;

    private int index;

    public WriterWorker(SharedData data, String filter) {
        this.data = data;
        this.filter = filter;
    }

    @Override
    public void run() {
        try {
            while (true) {
                data.write(nextChar());
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {

        }
    }

    private char nextChar() {
        char c = filter.charAt(index);
        index++;
        if (index >= filter.length()) {
            index = 0;
        }

        return c;
    }
}
