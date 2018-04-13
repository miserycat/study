package bean;

/**
 * Created by shengchao wu on 10/12/2017.
 */
public abstract class Fu implements FuLocal{
    protected abstract void method1(String msg);

    private void method2() {
        method1(methodLocal());
    }

    public String methodLocal() {
        return methodZi();
    }

    public void methodFu() {
        method2();
    }
}
