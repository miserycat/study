package jvm.memory;

public class MyTest3 {
    public static void main(String[] args) {
        new Thread(A::method).start();
        new Thread(B::method).start();
    }
}

class A {
    public static synchronized void method() {
        System.out.println("method from A...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        B.method();
    }
}

class B {
    public static synchronized void method() {
        System.out.println("method from B...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        A.method();
    }
}


