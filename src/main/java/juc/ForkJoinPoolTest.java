package juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by shengchao wu on 4/13/2018.
 */
public class ForkJoinPoolTest {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(10);

        ForkJoinTask<Long> task = new ForkJoinAccumulate(0, 100000000l);
        Long sum = pool.invoke(task);
        System.out.println(sum);

    }
}


class ForkJoinAccumulate extends RecursiveTask<Long> {

    private long start;

    private long end;

    public ForkJoinAccumulate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public static final long THRESHOLD = 10000L;

    @Override
    protected Long compute() {
        long length = end - start;
        if (length  <= THRESHOLD) {
            long sum = 0l;
            for (long i = start; i <=end ; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;

            ForkJoinAccumulate left = new ForkJoinAccumulate(start, middle);
            ForkJoinAccumulate right = new ForkJoinAccumulate(middle + 1, end);
            left.fork();
            right.fork();

            return left.join() + right.join();
        }

    }
}
