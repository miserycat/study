package wenjun.concurrent.chapter6;
//优雅的方式关闭线程
public class CloseThreadGracefully2 {
    public static void main(String[] args) {
        Worker2 worker = new Worker2();
        worker.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.shutdown();
    }

}

class Worker2 extends Thread{
    @Override
    public void run() {
        while (!this.isInterrupted()) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                break;
//            }


            System.out.println("loading heavy resources...");
        }
    }

    public void shutdown() {
        this.interrupt();
    }
}
