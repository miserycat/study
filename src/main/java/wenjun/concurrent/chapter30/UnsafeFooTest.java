package wenjun.concurrent.chapter30;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * unsafe 可以new Object 并且跳过初始化
 */
public class UnsafeFooTest {
    public static void main(String[] args) throws Exception {
        Unsafe unsafe = getUnsafe();
        Simple simple = (Simple) unsafe.allocateInstance(Simple.class);
        System.out.println(simple.getI());
        System.out.println(simple.getClass());
        System.out.println(simple.getClass().getClassLoader());

        simple = new Simple();
        simple.work();

        Field field = simple.getClass().getDeclaredField("ACCESS_ALLOWED");
//        field.setAccessible(true);
//        field.set(simple, 42);
//        simple.work();
        unsafe.putInt(simple, unsafe.objectFieldOffset(field), 42);
        simple.work();

    }

    static class Simple {
        private int i = 0;
        private int ACCESS_ALLOWED = 1;

        public Simple() {
            this.i = 1;
            System.out.println("init simple...");
        }

        public int getI() {
            return this.i;
        }

        private boolean allow() {
            return 42 == ACCESS_ALLOWED;
        }

        public void work() {
            if (allow()) {
                System.out.println("working...");
            }
        }
    }

    private static Unsafe getUnsafe() throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);

        return (Unsafe) theUnsafe.get(null);
    }

}
