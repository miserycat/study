package wenjun.concurrent.chapter15;

public class OctalObserver extends Observer{
    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("OctalValue change to: " +Integer.toOctalString(subject.getState()));
    }
}
