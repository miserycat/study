package jvm.classloader;

import java.util.UUID;

/*
    ��һ��������ֵ�����ٱ����ڼ�ȷ������ô��ֵ���ᱻ�ŵ�������ĳ������У�
    ��ʱ�ڳ�������ʱ���ᵼ������ʹ������������ڵ��࣬��Ȼ�ᵼ������౻��ʼ����
 */

public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static block...");
    }
}
