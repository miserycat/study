package wenjun.concurrent.chapter16;

import com.google.common.collect.Lists;

public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleListener().concurrentQuery(Lists.newArrayList("1", "2"));
    }
}
