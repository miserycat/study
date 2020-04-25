package wenjun.concurrent.chapter28;

public class DisplayStringClientThread extends Thread {
    private ActiveObject activeObject;

    public DisplayStringClientThread(ActiveObject activeObject, String name) {
        super(name);
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        for (int i = 0; true ; i++) {
            String text = Thread.currentThread().getName() + "=>" + i;
            activeObject.displayString(text);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
