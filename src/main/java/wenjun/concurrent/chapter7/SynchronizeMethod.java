package wenjun.concurrent.chapter7;


//可以看到m1 m2没有同时输出，因为同步方法的锁的this，他们公用同一把锁。
//static method的锁是本类的Class
public class SynchronizeMethod {
    public static void main(String[] args) {
        SynchronizeMethod synchronizeMethod = new SynchronizeMethod();
        Thread t1 = new Thread(synchronizeMethod::m1);
        Thread t2 = new Thread(synchronizeMethod::m2);

        t1.start();
        t2.start();

        Thread t3 = new Thread(SynchronizeMethod::m3);
        Thread t4 = new Thread(SynchronizeMethod::m4);

        t3.start();
        t4.start();

    }


    private synchronized void m1() {
        System.out.println("m1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void m2() {
        System.out.println("m2");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void m3() {
        System.out.println("m3");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void m4() {
        System.out.println("m4");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
