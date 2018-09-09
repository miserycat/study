package nio;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Iterator;

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
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel fileChannel = FileChannel.open(Paths.get("C:\\", "txts\\", "add.png"), StandardOpenOption.READ);
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
    public void server() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        FileChannel fileChannel = FileChannel.open(Paths.get("C:\\", "txts\\", "receive.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 9898));

        SocketChannel accept = serverSocketChannel.accept();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (accept.read(byteBuffer) != -1) {
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        serverSocketChannel.close();
        fileChannel.close();
    }


    @Test
    public void client1() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel fileChannel = FileChannel.open(Paths.get("C:\\", "txts\\", "add.png"), StandardOpenOption.READ);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (fileChannel.read(buf) != -1) {
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }

        socketChannel.shutdownOutput();

        int len = 0;
        while ((len = socketChannel.read(buf)) != -1 ) {
            buf.flip();
            System.out.println(new String(buf.array(), 0, len));
            buf.clear();
        }

        socketChannel.close();
        fileChannel.close();

    }

    @Test
    public void server1() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        FileChannel fileChannel = FileChannel.open(Paths.get("C:\\", "txts\\", "receive.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 9898));

        SocketChannel outputChannel = serverSocketChannel.accept();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (outputChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        byteBuffer.put("receive finished.... this is server".getBytes());
        byteBuffer.flip();
        outputChannel.write(byteBuffer);
        byteBuffer.clear();
        outputChannel.close();

        serverSocketChannel.close();
        fileChannel.close();
    }


    @Test
    public void client2() throws IOException {
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        sChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put((LocalDateTime.now().toString() + "\n" + "this is jack").getBytes());
        buffer.flip();
        sChannel.write(buffer);
        buffer.clear();
        sChannel.close();
    }

    @Test
    public void server2() throws Exception {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.bind(new InetSocketAddress("127.0.0.1", 9898));
        //get Selector
        Selector selector = Selector.open();
        //register selector to channel
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    try {
                        SocketChannel sChannel = ssChannel.accept();
                        sChannel.configureBlocking(false);
                        sChannel.register(selector,SelectionKey.OP_READ);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    try {
                        while ((len = socketChannel.read(buffer)) != -1) {
                            buffer.flip();
                            System.out.println(new String(buffer.array(), 0, len));
                            buffer.clear();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                iterator.remove();
            }
        }
    }


    @Test
    public void client3() throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put((LocalDateTime.now() + "\n" + "this is jack").getBytes());
        buffer.flip();
        datagramChannel.send(buffer, new InetSocketAddress("127.0.0.1", 9898));
        buffer.clear();
        datagramChannel.close();
    }

    @Test
    public void server3() throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);

        datagramChannel.bind(new InetSocketAddress("127.0.0.1", 9898));

        Selector selector = Selector.open();

        datagramChannel.register(selector, SelectionKey.OP_READ);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while(iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isReadable()) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    datagramChannel.receive(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(), 0, buffer.limit()));
                    buffer.clear();
                }
            }
            iterator.remove();
        }

        datagramChannel.close();
    }



    @Test
    public void pipeTest() throws IOException {
        final Pipe pipe = Pipe.open();

        Thread t1 = new Thread(() -> {
            Pipe.SinkChannel sinkChannel = pipe.sink();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("pipe sink message".getBytes());
            buffer.flip();
            try {
                sinkChannel.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    sinkChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread t2 = new Thread(() -> {
            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            try {
                int len = sourceChannel.read(buffer);
                System.out.println(new String(buffer.array(), 0, len));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }


    @Test
    public void test11() {
        String dest = "adasdadad<sub>2</sub>xxxasdasdas<sup>3</sup>asdsads<sub>4</sub>asdsadadadada";
        while (dest.contains("<sub>") || dest.contains("<sup>")) {
            int subStartIndex = dest.indexOf("<sub>");
            int supStartIndex = dest.indexOf("<sup>");
            if ((subStartIndex < supStartIndex) || (subStartIndex > 0 && supStartIndex == -1 )) {
                String divText = dest.substring(0, subStartIndex);
                System.out.println(divText);
                dest = dest.substring(subStartIndex);
                int subEndIndex = dest.indexOf("</sub>");
                String subText = dest.substring(5, subEndIndex);
                System.out.println(subText);
                dest = dest.substring(subEndIndex + 6);
            } else if ((supStartIndex < subStartIndex) || (supStartIndex > 0 && subStartIndex == -1)) {
                String divText = dest.substring(0, supStartIndex);
                System.out.println(divText);
                dest = dest.substring(supStartIndex);
                int supEndIndex = dest.indexOf("</sup>");
                String subText = dest.substring(5, supEndIndex);
                System.out.println(subText);
                dest = dest.substring(supEndIndex + 6);
            }
        }
        System.out.println(dest);
    }

}
