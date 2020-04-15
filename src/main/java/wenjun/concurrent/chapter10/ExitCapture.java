package wenjun.concurrent.chapter10;

//如何给Thread添加钩子
public class ExitCapture {
    public static void main(String[] args) {
        Runtime.getRuntime()
                .addShutdownHook(new Thread(() -> System.out.println("The application will exit")));


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };
    }
}
