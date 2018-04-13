package multiThreading.demo1;

/**
 * Created by shengchao wu on 4/3/2018.
 */
public class FinalizeTest {
    public static FinalizeTest flt = null;
    public static void main(String[] args) throws InterruptedException {
        flt = new FinalizeTest();
        flt = null;
        System.gc();
        Thread.sleep(500);

        if (null != flt) {
            System.out.println("I am alive");
        } else {
            System.out.println("I am dead");
        }

        flt = null;

        if (null != flt) {
            System.out.println("I am alive");
        } else {
            System.out.println("I am dead");
        }

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("execute method finalize...");
        flt = this;
    }
}
