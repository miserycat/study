package reference;

import java.io.IOException;
//强引用类型，没有引用指堆中(reference = null)，会被GC回收
public class NormalReferenceTest {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc();
        System.in.read();
    }
}
