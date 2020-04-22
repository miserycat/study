package wenjun.concurrent.chapter22;

public final class ActionContext {
    private ActionContext() {
    }
    private static final ThreadLocal<Context> contextThreadLocal = ThreadLocal.withInitial(Context::new);

    public Context getContext() {
        return contextThreadLocal.get();
    }

    private static class ContextHolder {
        private static final ActionContext INSTANCE = new ActionContext();
    }

    public static ActionContext getInstance() {
        return ContextHolder.INSTANCE;
    }


}
