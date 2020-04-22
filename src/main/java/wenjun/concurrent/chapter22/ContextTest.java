package wenjun.concurrent.chapter22;

import java.util.stream.IntStream;

public class ContextTest {
    public static void main(String[] args) {
        ExecutionTask executionTask = new ExecutionTask();
        IntStream.range(0, 5)
                .forEach(index -> {
                    new Thread(executionTask)
                            .start();
                });
    }
}
