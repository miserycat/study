package wenjun.concurrent.chapter4;

public class JoinThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new CaptorInstance("task1", 10000));
        Thread t2 = new Thread(new CaptorInstance("task2", 20000));
        Thread t3 = new Thread(new CaptorInstance("task3", 15000));

        t1.start();
        t2.start();
        t3.start();


        t2.join();
        t3.join();

        System.out.printf("all task finish in %s \n", System.currentTimeMillis());

    }



}

class CaptorInstance implements Runnable{
    private String taskName;
    private long executeTime;

    public CaptorInstance(String taskName, long executeTime) {
        this.taskName = taskName;
        this.executeTime = executeTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(executeTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("task: %s finish in %s \n", taskName, System.currentTimeMillis());
    }
}
