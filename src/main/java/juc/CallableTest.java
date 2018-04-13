package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by shengchao wu on 4/11/2018.
 */
public class CallableTest {

    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();

        FutureTask<Integer> futureTask = new FutureTask<>(helloThread);

        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class HelloThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }

        return sum;
    }
}
