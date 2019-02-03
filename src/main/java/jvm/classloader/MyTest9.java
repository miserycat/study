package jvm.classloader;

public class MyTest9 {
    static {
        System.out.println("MyTest9 static invoked...");
    }
    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}

class Parent {
    static int a = 1;

    static {
        System.out.println("Parent static invoked...");
    }
}

class Child extends Parent {
    static int b = 2;

    static {
        System.out.println("Child static invoked...");
    }
}
