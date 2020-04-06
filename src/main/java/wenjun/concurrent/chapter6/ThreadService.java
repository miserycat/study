package wenjun.concurrent.chapter6;

public class ThreadService {
    private Thread executedThread;
    private boolean finished = false;
    public void execute(final Runnable task) {
        //等待executeThread 等待 daemonThread
        executedThread = new Thread(() -> {
            Thread daemonThread = new Thread(task);
            daemonThread.setDaemon(true);
            daemonThread.start();
            try {
                //等待executeThread 等待 daemonThread
                daemonThread.join();
                finished = true;
            } catch (InterruptedException e) {
                System.out.println("force closed successfully");
            }
        });

        executedThread.start();
    }

    public void shutdown(long millSec) {
        long start = System.currentTimeMillis();
        while (!finished) {
            if (System.currentTimeMillis() - start >= millSec) {
                System.out.println("over time ...");
                executedThread.interrupt();
                break;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
