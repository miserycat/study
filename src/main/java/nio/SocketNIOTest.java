package nio;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;

/**
 * channel: responsible for connect
 *      SelectableChannel
 *              SocketChannel
 *              ServerSocketChannel
 *              DatagramChannel
 *
 *              Pipe.SinkChannel
 *              Pipe.SourceChannel
 *
 * Buffer: responsible for read
 *
 * selector： 是 SelectableChannel的多路复用器。用于监控SelectableChannel的IO状况
 */
public class SocketNIOTest {
    @Test
    public void client() throws IOException {

        // 1. getChannel
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        FileChannel fileChannel = FileChannel.open(Paths.get("C:\\", "txts\\", "add.png"));
        // 2. allocate buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 3. transfer to server
        while (fileChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        socketChannel.close();
        fileChannel.close();
    }



    @Test
    public void server() throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8888));

        SocketChannel accept = serverSocketChannel.accept();


    }
}
