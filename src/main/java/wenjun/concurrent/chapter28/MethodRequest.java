package wenjun.concurrent.chapter28;

/**
 * 对应ActiveObject 每一个方法
 */
public abstract class MethodRequest {
    protected final Servant servant;
    protected final FutureResult<String> futureResult;

    public MethodRequest(Servant servant, FutureResult<String> futureResult) {
        this.servant = servant;
        this.futureResult = futureResult;
    }

    public abstract void execute();
}
