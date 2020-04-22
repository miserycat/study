package wenjun.concurrent.chapter20;

public class Request {
    private final String value;

    public Request(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
