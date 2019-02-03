package jvm.classloader;

/**
 * javap -c 查看反编译字节码的执行
 */

import java.util.Random;

public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalClass.i);
    }
}

class FinalClass {
    public static final int i = new Random().nextInt(3);
    static {
        System.out.println("FinalClass static invoked...");
    }
}
