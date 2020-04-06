package wenjun.concurrent.chapter7;

public class TicketWindow extends Thread {
    public TicketWindow(String name) {
        this.name = name;
    }
    private String name;
    private static final int MAX_SIZE = 500;
    private static int index = 1;
    private static final Object LOCK = new Object();
    @Override
    public void run() {
        synchronized (LOCK) {
            while (index <= MAX_SIZE) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + ": current ticket number is:" + index++);
            }
        }
    }


}
