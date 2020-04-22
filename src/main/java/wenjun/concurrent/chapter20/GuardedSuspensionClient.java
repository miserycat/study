package wenjun.concurrent.chapter20;
//request -> Tomcat httpServer -> doing
//request -> Tomcat httpServer Queue
public class GuardedSuspensionClient {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();
        new ClientThread(queue, "Cassie").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        serverThread.close();


    }
}
