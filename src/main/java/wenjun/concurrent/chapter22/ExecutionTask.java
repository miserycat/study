package wenjun.concurrent.chapter22;

//使用ThreadLocal来实现线程上下文（context）设计模式
public class ExecutionTask implements Runnable {
    private QueryFromDBAction queryAction = new QueryFromDBAction();

    private QueryFromHttpAction httpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        Context context = ActionContext.getInstance().getContext();
//        Context context = new Context();
//        queryAction.execute(context);
        queryAction.execute();
        System.out.println("the name query successfully...");
//        httpAction.execute(context);
        httpAction.execute();
        System.out.println("the card id query successfully...");
        System.out.println("the context name is " + context.getName() + " context card id is " + context.getCardId());
    }
}
