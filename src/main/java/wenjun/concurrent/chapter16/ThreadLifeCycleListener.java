package wenjun.concurrent.chapter16;

import java.util.List;

public class ThreadLifeCycleListener implements LifeCycleListener {
    private final Object LOCK = new Object();

    public void concurrentQuery(List<String> ids) {
        ids.forEach(id -> {
            new Thread(new ObservableRunnable(this) {
                @Override
                public void run() {
                    try {
                        notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                        System.out.println("query for the id " + id);
//                        int i = 1 / 0;
                        notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                    } catch (Exception e) {
                        notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
                    }
                }
            }, id).start();
        });
    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (LOCK) {
            System.out.printf("The runnable [%s] data changed and state is [%s] \n", event.getThread().getName(), event.getState());

            if (event.getCause() != null) {
                event.getCause().printStackTrace();
            }
        }
    }
}
