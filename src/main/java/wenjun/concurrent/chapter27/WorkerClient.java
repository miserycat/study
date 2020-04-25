package wenjun.concurrent.chapter27;

public class WorkerClient {
    public static void main(String[] args) {
        final Channel channel = new Channel(5);
        channel.startWorker();

        new TransportThread("Sun", channel)
                .start();
        new TransportThread("Moon", channel)
                .start();
        new TransportThread("you", channel)
                .start();


    }
}
