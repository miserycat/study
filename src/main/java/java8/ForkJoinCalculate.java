package java8;

import java.util.concurrent.RecursiveTask;

/**
 * Created by shengchao wu on 3/1/2018.
 */
public class ForkJoinCalculate extends RecursiveTask<Long>{
    private long start;

    private long end;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public static final long THRESHOLD = 1000;

    @Override
    protected Long compute() {
        long length = end - start;

        long sum = 0;

        if (length <= THRESHOLD) {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;

            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);

            left.fork();

            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);

            right.fork();

            return left.join() + right.join();
        }
    }
}
