package wenjun.concurrent.chapter15;

public class ObserverClient {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer binaryObserver = new BinaryObserver(subject);
        Observer octalObserver = new OctalObserver(subject);

        System.out.println("===============================");
        subject.setState(10);
    }
}
