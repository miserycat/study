package wenjun.concurrent.chapter28;

public class ActiveObjectTest {
    public static void main(String[] args) {
        final ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakeStringClientThread(activeObject, "Alice").start();
        new MakeStringClientThread(activeObject, "Bob").start();

        new DisplayStringClientThread(activeObject, "Cassie").start();

    }
}
