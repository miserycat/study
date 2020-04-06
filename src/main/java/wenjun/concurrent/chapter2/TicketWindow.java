package wenjun.concurrent.chapter2;

public class TicketWindow extends Thread {
    public TicketWindow(String name) {
        this.name = name;
    }
    private String name;
    private static final int MAX_SIZE = 50;
    private static int index = 1;
    @Override
    public void run() {
        while (index <= MAX_SIZE) {
            System.out.println(name + ": current ticket number is:" + index++);
        }
    }


}
