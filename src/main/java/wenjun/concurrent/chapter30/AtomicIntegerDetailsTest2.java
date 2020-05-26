package wenjun.concurrent.chapter30;

public class AtomicIntegerDetailsTest2 {
    private static final CompareAndSetLock LOCK = new CompareAndSetLock();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(()-> {
                try {
                    work2();
                } catch (CompareAndSetLock.GetLockException | InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


    private synchronized static void work1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " get lock") ;
        System.out.println("do something...");
        Thread.sleep(100000);
    }

    private static void work2() throws InterruptedException {
        try {
            LOCK.tryLock();
            System.out.println(Thread.currentThread().getName() + " get lock") ;
            System.out.println("do some heavy works...");
            Thread.sleep(100000);

        } finally {
            LOCK.unLock();
        }
    }


}
