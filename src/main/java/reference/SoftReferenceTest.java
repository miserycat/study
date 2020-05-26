package reference;

import java.lang.ref.SoftReference;
//soft reference often use in cache
public class SoftReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
//        m = null;
        System.out.println(m.get());
        System.gc();
        Thread.sleep(500);
        System.out.println(m.get());

        //re allocate a new array, exceed max heap size, system will gc once, if size not enough, kill soft reference.
        byte[] b = new byte[1024 * 1024 * 15];
        System.out.println(m.get());

    }
}
