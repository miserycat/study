package wenjun.concurrent.chapter23;

public class  Message {
    public Message(String content) {
        this.content = content;
    }

    private final String content;

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                '}';
    }
}
