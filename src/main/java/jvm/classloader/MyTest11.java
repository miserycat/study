package jvm.classloader;

/**
 *  ���ͨ��������ʸ����static field ���� static method ���ǶԸ����ֱ��ʹ��ֻ��Ը�����г�ʼ����
 */
public class MyTest11 {
    public static void main(String[] args) {
        System.out.println(Child3.a);
        System.out.println("============");
        Child3.doSomething();
    }
}

class Parent3 {
    static int a = 1;

    static {
        System.out.println("parent3 static invoked...");
    }

    static void doSomething() {
        System.out.println("do something...");
    }
}

class Child3 extends Parent3 {
    static {
        System.out.println("child3 static invoked...");
    }

}
