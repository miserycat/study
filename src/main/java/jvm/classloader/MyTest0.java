package jvm.classloader;

public class MyTest0 {
    public static void main(String[] args) {
        System.out.println(MyChild0.a);
    }
}

class MyParent0 {
    public static final int a = 1;
}

class MyChild0 extends MyParent0{
    public static final int a = 2;
}

