import org.junit.Test;
import org.apache.commons.lang.StringUtils;

public class Demo {
    private volatile int var;
    int b;
    int c;

    @Test
    public void test1() {
        String input = "I love Java";

        String result1 = StringUtils.leftPad(input, 20, "*");
        String result2 = StringUtils.rightPad(input, 20, "*");
        String result3 = StringUtils.center(input, 20, "*");

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        int a = b = 0;


    }

    @Test
    public void test2() {
        Thread t1 = new Thread(() -> {
            b = 4;
            System.out.println(b);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            var = 3;
        });

        Thread t2 = new Thread(() -> {
            c = var;
            System.out.println(c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c = b;
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {

    }
}
