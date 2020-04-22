package wenjun.concurrent.chapter19;

//future设计模式，每次调用立即返回一个future票据，可以继续往下执行不会因为该方法执行耗时而阻塞。
//Future -> 代表了是未来的一个凭据
//FutureTask -> 将调用的逻辑进行了隔离
//FutureService -> 桥接Future和FutureTask
public class SyncInvoker {
    public static void main(String[] args) {
//        get();
        FutureService futureService = new FutureService();
        Future<String> future = futureService.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "FINISHED...";
        }, System.out::println);

        try {
            Thread.sleep(1000);
            System.out.println("do other tasks...");
//            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void get() {
        try {
            Thread.sleep(10000);
            System.out.println("DONE...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
