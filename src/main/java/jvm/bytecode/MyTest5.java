package jvm.bytecode;

/**
 *  dup:Duplicate the top value on the operand stack and push the duplicated value onto the operand stack.
 *  astore_[index]:Store reference into local variable index position
 *  invokevirtual:Invoke instance method; dispatch based on class
 *
 *  方法的动态分派
 *  方法的动态分派的一个重要概念：方法接收者。
 *  invokevirtual字节码指令的多态查找流程
 *  1。到操作数栈顶第一个位子寻找对象的实际类型。
 *  2。去常量池中找匹配的描述符、名称相同的并且有权限，就返回目标方法的直接引用，
 *  如果没有找到，去父类中找，如果还没有再去父类的父类找。。。
 *
 *  如apple.test() 会找如Fruit.test()方法在常量池中的描述符、名称相同且有权限的方法。
 *
 */
public class MyTest5 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }


}

class Fruit {
    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {
    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("Orange");
    }
}

