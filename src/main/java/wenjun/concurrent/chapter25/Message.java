package wenjun.concurrent.chapter25;

public class Message {
    private final String data;

    public Message(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
