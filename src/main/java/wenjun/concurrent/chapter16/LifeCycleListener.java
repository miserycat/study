package wenjun.concurrent.chapter16;

public interface LifeCycleListener {

    void onEvent(ObservableRunnable.RunnableEvent event);
}
