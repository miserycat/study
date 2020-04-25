package wenjun.concurrent.chapter28;

public class DisplayStringRequest extends MethodRequest {
    private String text;

    public DisplayStringRequest(Servant servant, String text) {
        super(servant, null);
        this.text = text;
    }

    @Override
    public void execute() {
        this.servant.displayString(text);
    }
}
