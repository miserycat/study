package jvm.classloader;

/**
 *  如果通过子类访问父类的static field 或者 static method 都是对父类的直接使用只会对父类进行初始化。
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
