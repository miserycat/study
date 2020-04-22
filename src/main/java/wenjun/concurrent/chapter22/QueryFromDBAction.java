package wenjun.concurrent.chapter22;

public class QueryFromDBAction {
    public void execute() {
        Context context = ActionContext.getInstance().getContext();
        String name = queryName();
        context.setName(name);
    }

    public void execute(Context context) {
        String name = queryName();
        context.setName(name);
    }

    private String queryName() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Cassie " + Thread.currentThread().getName();
    }
}
