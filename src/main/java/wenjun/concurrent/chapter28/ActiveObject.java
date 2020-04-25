package wenjun.concurrent.chapter28;

/**
 * 接受异步消息的主动方法
 */
public interface ActiveObject {
    Result<String> makeString(final int count, final char fillChar);

    void displayString(final String text);
}
