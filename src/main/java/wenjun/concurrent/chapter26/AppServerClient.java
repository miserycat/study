package wenjun.concurrent.chapter26;

import java.io.IOException;

public class AppServerClient {
    public static void main(String[] args) throws IOException {
        AppServer server = new AppServer(12314);
        server.start();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        server.shutdown();
    }
}
