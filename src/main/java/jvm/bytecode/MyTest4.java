package jvm.bytecode;

/**
 *  方法的静态分派。
 *  Grandpa g1 = new Father();
 *  g1的静态类型是Grandpa, 而g1的实际类型（真正指向的类型）是father
 *  我们可以得出这杨一个结论，变量的静态类型是不会发生变化的，而变脸的实际类型是可以发生变化的（多态的一种体现），实际类型是在运行期才能确定，
 *
 *
 */

public class MyTest4 {
    //方法重载是一种静态的行为，jvm只会根据方法参数的静态类型判断具体调用的是哪个方法。
    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }

    public void test(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        MyTest4 myTest4 = new MyTest4();
        myTest4.test(g1);
        myTest4.test(g2);
    }
}

class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father{

}
