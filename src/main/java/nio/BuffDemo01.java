package nio;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Created by shengchao wu on 4/16/2018.
 */


public class BuffDemo01 {

    @Test
    public void test1() {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //position:0 limit:1024 capacity:1024
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("put 'abcde'>>>>>>>>>>>>>>>>>>>>>>>>");
        String str = "abcde";
        buf.put(str.getBytes());

        //position:5 limit:1024 capacity:1024
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("read >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        //set limit to current position and set position to 0
        buf.flip();

        //position:0 limit:5 capacity:1024
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());


        System.out.println("get >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        byte[] bytes = new byte[buf.limit()];

        buf.get(bytes);

        //position:5 limit:5 capacity:1024
        System.out.println(new String(bytes, 0 , bytes.length));

        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //rewind reset to read mode
        System.out.println("rewind: set position to 0 >>>>>>>>>>>>>>>>>>>>>>>");
        buf.rewind();
        //position:0 limit:5 capacity:1024
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //clear:
        System.out.println("clear: position limit to origin status, data still exist  >>>>>>>>>>>>>>>>>>>");
        buf.clear();
        //position:0 limit:1024 capacity:1024
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        buf.get(bytes, 0, 3);
        System.out.println(new String(bytes, 0 , 3));
    }

    @Test
    public void test2() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put("abcde".getBytes());
        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];

        buffer.get(bytes, 0, 2);
        buffer.mark();

        System.out.println(new String(bytes, 0, 2));

        buffer.get(bytes, 2, 2);
        System.out.println(new String(bytes, 2, 2));


        //return to mark position
        buffer.reset();

        System.out.println(buffer.position());

        if (buffer.hasRemaining()) {
            System.out.println(buffer.remaining());
        }
    }


    @Test
    public void test3() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        System.out.println(buffer.isDirect());

    }

    @Test
    public void test4() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String str = "hello";
        buffer.put(str.getBytes());

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.flip();

        byte[] buf = new byte[buffer.limit()];
        buffer.get(buf, 0, 2);
        System.out.println(new String(buf, 0, 2));

        buffer.get(buf, 2, 2);

        buffer.mark();

        System.out.println(new String(buf, 2, 2));

        buffer.reset();
        System.out.println(buffer.position());
    }
}
