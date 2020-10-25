package wenjun.concurrent.chapter7;

//synchronized 加锁
// javap -c 反编译可以看出synchronized原理 monitorenter monitorexit

public class BankOrder {
    public static void main(String[] args) {
        TicketWindow t1 = new TicketWindow("window1");
        t1.start();
        TicketWindow t2 = new TicketWindow("window2");
        t2.start();
        TicketWindow t3 = new TicketWindow("window3");
        t3.start();
    }
}
