package wenjun.concurrent.chapter6;

public class CloseThreadForce {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        ThreadService threadService = new ThreadService();
        threadService.execute(() ->{
            while (true) {

            }
        });
        long end = System.currentTimeMillis();

        threadService.shutdown(5000);

        System.out.println(end - start);
    }
}
