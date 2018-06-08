package nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

/**
 * Created by shengchao wu on 4/16/2018.
 */
public class ChannelTest {

    @Test
    public void test1() throws Exception {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            fis = new FileInputStream("C:\\txts\\1.txt");
            fos = new FileOutputStream("C:\\txts\\2.txt");

            ByteBuffer buf = ByteBuffer.allocate(1024);
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            while(inChannel.read(buf) != -1) {
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (inChannel != null) {
                inChannel.close();
            }
            if (outChannel != null) {
                outChannel.close();
            }
        }
    }

    @Test
    public void test2() throws IOException {
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            inChannel = FileChannel.open(Paths.get("C:\\", "txts\\", "1.txt"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("C:\\", "txts\\", "2.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            MappedByteBuffer mappedInChannel = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer mappedOutChannel = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            byte[] dst = new byte[mappedInChannel.limit()];
            mappedInChannel.get(dst);
            mappedOutChannel.put(dst);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                inChannel.close();
            }
            if (outChannel != null) {
                outChannel.close();
            }
        }
    }


    @Test
    public void test3() throws IOException{
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            inChannel = FileChannel.open(Paths.get("C:\\", "txts\\", "1.txt"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("C:\\", "txts\\", "2.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
//            inChannel.transferTo(0, inChannel.size(), outChannel);
            outChannel.transferFrom(inChannel, 0, inChannel.size());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4() throws IOException {
        //scatter and gather
        RandomAccessFile raf1 = new RandomAccessFile("C:\\txts\\1.txt", "rw");
        FileChannel channel1 = raf1.getChannel();

        ByteBuffer buf1 = ByteBuffer.allocate(20);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        ByteBuffer[] bufs = {buf1, buf2};
        channel1.read(bufs);
        for (ByteBuffer buf : bufs) {
            buf.flip();
        }

        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("===============================================");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));


        RandomAccessFile raf2 = new RandomAccessFile("C:\\txts\\2.txt", "rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);

        channel1.close();
        channel2.close();

    }

    @Test
    public void test5() throws CharacterCodingException {
        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entries = map.entrySet();

        Charset utf8 = Charset.forName("UTF-8");

        CharsetEncoder encoder = utf8.newEncoder();

        CharsetDecoder decoder = utf8.newDecoder();

        CharBuffer cbuf = CharBuffer.allocate(1024);

        cbuf.put("hello world");
        cbuf.flip();

        ByteBuffer bBuffer = encoder.encode(cbuf);

        for (int i = 0; i < 9; i++) {
            System.out.print(bBuffer.getChar(i));
        }
        System.out.println();

        bBuffer.flip();
        CharBuffer decode1 = decoder.decode(bBuffer);
        System.out.println(decode1.toString());

        Charset gbk = Charset.forName("GBK");
        bBuffer.flip();
        CharBuffer decode2 = gbk.newDecoder().decode(bBuffer);
        decode2.flip();
        System.out.println(decode2.toString());


    }
}
