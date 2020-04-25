package wenjun.concurrent.chapter28;

/**
 *
 * {@link ActiveObject#makeString(int, char)}
 */
public class MakeStringRequest extends MethodRequest {
    private final int count;
    private final char fillChar;

    public MakeStringRequest(Servant servant, FutureResult<String> futureResult, int count, char fillChar) {
        super(servant, futureResult);
        this.count = count;
        this.fillChar = fillChar;
    }


    @Override
    public void execute() {
        final Result<java.lang.String> result = servant.makeString(count, fillChar);
        futureResult.setResult(result);
    }
}
