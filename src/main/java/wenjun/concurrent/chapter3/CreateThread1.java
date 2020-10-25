package wenjun.concurrent.chapter3;
//创建线程对象Thread, 默认有一个线程名,以Thread-开头,从0开始计数
//如果构造方法中没有传入Runnable接口或者重写run方法则不会执行任何方法,如果传入了Runnable或者重写了run方法则会执行该方法的执行单元
public class CreateThread1 {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.start();
        Thread t2 = new Thread();
        t2.start();

        System.out.println(t1.getName());
        System.out.println(t2.getName());

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "runnable thread").start();

        new Thread("custom thread"){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
    }
}
