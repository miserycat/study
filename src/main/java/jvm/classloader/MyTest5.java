package jvm.classloader;

/*
    当一个接口在初始化时并不要求其父接口都完成初始化
    只有在真正使用到父接口的时候(如引用接口中定义的常量时)才会初始化
 */

import java.util.Random;

public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.a);
    }
}

interface MyParent5 {
    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent5 invoked...");
        }
    };
}

class MyChild5 implements MyParent5 {
    public static int a = new Random().nextInt(10);
}


