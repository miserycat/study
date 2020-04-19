package wenjun.concurrent.chapter15;

public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("binaryValue change to : " + Integer.toBinaryString(subject.getState()));
    }
}
