package wenjun.concurrent.chapter18;

public class ReadWriterLockClient {
    public static void main(String[] args) {
        final SharedData data = new SharedData(10);
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();

        new WriterWorker(data, "abcdefghij").start();
        new WriterWorker(data, "ABCDEFGHIJ").start();

    }
}
