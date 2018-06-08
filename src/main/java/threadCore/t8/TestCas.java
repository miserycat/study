package threadCore.t8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shengchao wu on 5/25/2018.
 */
public class TestCas {
    public static void main(String[] args) {
        Cas cas = new Cas();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                int expectValue = cas.getValue();
                boolean isSuccess = cas.compareAndSet(expectValue, (int) Math.random() * 101);
                System.out.println(isSuccess);
            });
        }
    }
}
