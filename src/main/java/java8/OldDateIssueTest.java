package java8;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by shengchao wu on 3/2/2018.
 */
public class OldDateIssueTest {

    @Test
    public void test1() throws ExecutionException, InterruptedException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Callable<Date> task = () -> DateFormatThreadLocal.convert("2018-3-20");

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for (Future<Date> future : results) {
            System.out.println(future.get());
        }

        pool.shutdown();

    }

}
