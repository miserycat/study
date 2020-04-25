package wenjun.concurrent.chapter26;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppServer extends Thread {
    private static final int DEFAULT_PORT = 12888;
    private final int port;
    private ServerSocket server;
    private volatile boolean start = true;
    private List<ClientHandler> clientHandlers = new ArrayList<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public AppServer() {
        this(DEFAULT_PORT);
    }

    public AppServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            this.server = new ServerSocket(port);
            while (start) {
                Socket client = server.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                executorService.submit(clientHandler);
                this.clientHandlers.add(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.dispose();
        }
    }

    private void dispose() {
        clientHandlers.forEach(ClientHandler::stop);
        this.executorService.shutdown();
    }

    public void shutdown() throws IOException {
        this.start = false;
        this.interrupt();
        this.server.close();
    }
}
