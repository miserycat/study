package jvm.classloader;

public class MyTest10 {
    static {
        System.out.println("MyTest10 static invoked...");
    }
    public static void main(String[] args) {
        Parent2 parent2;
        System.out.println("===============");
        parent2 = new Parent2();
        System.out.println(parent2.a);
        System.out.println("===============");
        System.out.println(Child2.b);
    }
}

class Parent2 {
    static int a = 1;

    static {
        System.out.println("parent2 static invoked...");
    }
}

class Child2 extends Parent2{
    static int b = 2;

    static {
        System.out.println("child2 static invoked...");
    }
}
