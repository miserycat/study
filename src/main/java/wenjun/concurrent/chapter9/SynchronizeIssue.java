package wenjun.concurrent.chapter9;


//synchronize 在一个线程争夺到lock后其他线程只能等当前线程跑完才有机会执行，如果该线程的工作时间很长但是无法打断
public class SynchronizeIssue {
    public static void main(String[] args) {
        Thread t1 = new Thread(SynchronizeIssue::working);
        t1.start();
        Thread t2 = new Thread(SynchronizeIssue::working);
        t2.start();
    }

    //simulate some time consuming job
    private static synchronized void working() {
        System.out.println(Thread.currentThread());
        while (true) {

        }
    }
}
