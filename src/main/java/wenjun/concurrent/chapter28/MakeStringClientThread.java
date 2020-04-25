package wenjun.concurrent.chapter28;

public class MakeStringClientThread extends Thread{
    private final ActiveObject activeObject;
    private final char fillChar;

    public MakeStringClientThread(ActiveObject activeObject, String name) {
        super(name);
        this.activeObject = activeObject;
        this.fillChar = name.charAt(0);
    }

    @Override
    public void run() {
        for (int i = 0; true; i++) {
            final Result<String> result = activeObject.makeString(i + 1, fillChar);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final String resultValue = result.getResultValue();
            System.out.println(Thread.currentThread().getName() + ": value = " + resultValue);
        }
    }
}
