package java8;
import bean.Employee;
import bean.Status;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * Created by shengchao wu on 3/1/2018.
 */
public class ForkJoinTest {

    private static List<Employee> employees = new ArrayList<>();


    static {
        for (double i = 0; i <= 100000000; i++) {
            Employee employee = new Employee("user" + i, 29, i + 1000, Status.ONLINE);
            employees.add(employee);
        }
    }


    @Test
    public void test1() {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 50000000000l);
        long start = System.currentTimeMillis();
        long sum =  pool.invoke(task);

        long end = System.currentTimeMillis();

        System.out.println(sum);
        System.out.println("takes :" + (end - start) + "ms");

    }

    @Test
    public void test2() {
        long sum = 0;
        long start = System.currentTimeMillis();
        for(long i = 0; i <= 50000000000l; i++) {
            sum += i;
        }

        long end = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println("takes :" + (end - start) + "ms");

    }




    @Test
    public void test3() {
        Instant start = Instant.now();
        LongStream.rangeClosed(0, 1000000000L)
                  .parallel()
                  .reduce(0, Long::sum);

        Instant end = Instant.now();

        System.out.println("takes :" + Duration.between(start, end).toMillis() + "ms");

    }

    @Test
    public void test4() {
        Optional<Double> sumOpt = employees.stream()
                .map(employee -> employee.getSalary())
                .parallel()
                .reduce(Double::sum);

        sumOpt.ifPresent(System.out::println);


    }

}
