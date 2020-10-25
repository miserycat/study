package wenjun.concurrent.chapter4;

//有2类线程，用户线程（User Thread）和守护线程(Daemon Thread)
//守护线程是JVM运行时为用户线程提供服务的线程，当所有用户线程都退出后JVM就会退出。
//守护线程中产生的线程也是守护线程
//守护线程Thread.setDaemon(true)必须在启动线程前执行，否则会抛出IllegalThreadStateException

public class DaemonThread {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("connection health check...");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
//            innerThread.setDaemon(true);
            innerThread.start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t thread dead");
        });

        t.start();
    }

}
