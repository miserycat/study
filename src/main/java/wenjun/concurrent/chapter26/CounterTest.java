package wenjun.concurrent.chapter26;

public class CounterTest {
    public static void main(String[] args) {
        CountIncrement countIncrement = new CountIncrement();
        countIncrement.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countIncrement.close();
    }

}
