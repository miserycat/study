package wenjun.concurrent.chapter6;

public class CloseThreadGracefully {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.shutdown();
    }

}

class Worker extends Thread{
    private boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("loading heavy resources...");
        }
    }

    public void shutdown() {
        this.flag = false;
    }
}
