package wenjun.concurrent.chapter10;

import java.util.Arrays;

public class Test2 {
    public void test() {
        Arrays.stream(
                Thread.currentThread()
                        .getStackTrace())
                .filter(stackTraceElement ->!stackTraceElement.isNativeMethod())
                .forEach(stackTraceElement -> {
                    System.out.println(stackTraceElement.getClassName() + ":" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber());
                });
    }
}
