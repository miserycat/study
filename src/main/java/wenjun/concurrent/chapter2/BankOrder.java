package wenjun.concurrent.chapter2;

//runnable 将业务执行单元从线程中抽离出来

public class BankOrder {
    public static void main(String[] args) {
//        threadInvoke();
        runnableInvoke();
    }

    public static void threadInvoke() {
        TicketWindow t1 = new TicketWindow("window1");
        t1.start();
        TicketWindow t2 = new TicketWindow("window2");
        t2.start();
        TicketWindow t3 = new TicketWindow("window3");
        t3.start();
    }

    public static void runnableInvoke() {
        Runnable runnable = () -> {
            int index = 1;
            final int MAX_SIZE = 50;
            while (index < MAX_SIZE) {
                System.out.println(Thread.currentThread().getName() + ": current ticket" + index++);
            }
        };

        Thread t1 = new Thread(runnable, "window1");
        Thread t2 = new Thread(runnable, "window2");
        Thread t3 = new Thread(runnable, "window3");

        t1.start();
        t2.start();
        t3.start();
    }
}
