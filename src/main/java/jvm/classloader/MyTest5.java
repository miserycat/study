package jvm.classloader;

/*
    ��һ���ӿ��ڳ�ʼ��ʱ����Ҫ���丸�ӿڶ���ɳ�ʼ��
    ֻ��������ʹ�õ����ӿڵ�ʱ��(�����ýӿ��ж���ĳ���ʱ)�Ż��ʼ��
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


