package bean;

/**
 * Created by shengchao wu on 10/12/2017.
 */
public class Zi1 extends Fu {
    @Override
    public void method1(String msg) {
        System.out.println("Zi1:" + msg);
    }

    public String methodZi() {
        return "This is Zi1";
    }
}
