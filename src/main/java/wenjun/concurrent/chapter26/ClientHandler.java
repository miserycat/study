package wenjun.concurrent.chapter26;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;

    private volatile boolean running = true;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(final InputStream inputStream = socket.getInputStream();
            final OutputStream outputStream = socket.getOutputStream();
            final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter printWriter = new PrintWriter(outputStream);
        ) {
            while (running) {
                String message = br.readLine();
                if (message == null) {
                    break;
                }
                System.out.println("come from client >" + message);
                printWriter.write("echo " + message + "\n");
                printWriter.flush();
            }
        } catch (IOException e) {
            this.running = false;
        } finally {
            this.stop();
        }
    }

    public void stop() {
        if (!running) {
            return;
        }

        this.running = true;
        try {
            this.socket.close();
        } catch (IOException e) {

        }
    }
}
