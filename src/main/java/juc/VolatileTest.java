package juc;

/**
 * Created by shengchao wu on 4/11/2018.
 */
public class VolatileTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread);
        t1.start();
        while(true) {
            if (myThread.isFlag()) {
                System.out.println("flag is set to true");
                break;
            }
        }
    }

}

class MyThread implements Runnable{
    private volatile boolean flag = false;

    @Override
    public void run() {
        flag = true;
        System.out.println(flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
