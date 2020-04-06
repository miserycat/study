package wenjun.concurrent.chapter1;

public class CreateThread {
    public static void main(String[] args) {
        new Thread("Read Thread") {
            @Override
            public void run() {
                try {
                    System.out.println("Start to read from database...");
                    Thread.sleep(1000 * 30L);
                    System.out.println("read from database finish...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread("Write Thread") {
            @Override
            public void run() {
                try {
                    System.out.println("Start to write to file...");
                    Thread.sleep(1000 * 30L);
                    System.out.println("Write to file finish...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

//Thread class method start() is a template method pattern
class TemplateMethod {
    public final void print(final String message) {
        System.out.println("print start...");
        wrapPrint(message);
        System.out.println("print end...");
    }

    protected void wrapPrint(String message) {

    }

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+" + message + "+");
            }
        };

        TemplateMethod t2 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("#" + message + "#");
            }
        };

        t1.print("cassie");
        t2.print("cassie");
    }
}
