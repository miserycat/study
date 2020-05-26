package jvm.bytecode;

import java.util.Date;

/**
 *  针对方法调用动态分派的过程，虚拟机会在类的方法区建立一个虚方法表的数据结构（virtual method table, vtable）
 *  虚方法表当中的每个方法都描述了一个方法的入口地址，子类的虚方法表中不会存在没有重写父类的方法。父子类有相同描述符的方法（重写）都有相同索引以便于子类访问父类的方法。
 *  针对invokeinterface指令来说，虚拟机会建立一个叫做接口方法表的数据结构（interfaces method table, itable）
 */
public class MyTest6 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test("hello");
        dog.test(new Date());
    }
}

class Animal {

    public void test(String str) {
        System.out.println("animal str");
    }

    public void test(Date date) {
        System.out.println("animal date");
    }
}

class Dog extends Animal {
    @Override
    public void test(String str) {
        System.out.println("dog str");
    }

    @Override
    public void test(Date date) {
        System.out.println("dog date");
    }
}
