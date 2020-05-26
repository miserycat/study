package jvm.bytecode;

/**
 *  栈帧（stack frame）
 *
 *  栈帧用于帮助虚拟机执行方法调用与方法执行的数据结构。
 *  栈帧本身是一种数据结构，封装了方法的局部变量表、动态链接信息、方法的返回地址以及操作数栈等信息。
 *
 *  符号引用（常量池中）， 直接引用
 *  有些符号引用在类加载阶段或者第一次使用时就会转换为直接引用，这种转换叫做静态解析，另外一些符号引用是在每次运行期间转换为直接引用，这种转换叫做动态链接，体现为java的多态性。
 *
 *  比如有2个类ClassA 和 ClassB, ClassB 中存在着ClassA的一个方法调用，在编译期间ClassB对ClassA的调用他们之间的地址关系是无法确定的，那什么时候可以知道呢？
 *  有2种情况：1。在类加载的时候 ， 2，在真正调用ClassB的哪个ClassA的方法时
 *  所以java设计了2个中引用：符号引用（常量池中），直接引用（一个指向ClassA的指针)
 *
 *  1.invokeinterface: 调用接口中的方法，实际上是在运行期决定的，决定到底调用哪个实现方法。
 *  2.invokestatic:调用静态方法。
 *  3.invokespecial:调用自己的私有方法，构造方法（<init>）以及父类的方法。
 *  4.invokevirtual:调用虚方法，运行期动态查找的过程。
 *  5.invokedynamic:动态调用方法。
 *
 *  静态解析的四种情况：
 *  1.静态方法
 *  2.父类方法
 *  3.构造方法
 *  4.私有方法
 *  以上4中方法称作非虚方法，他们是在类加载阶段就可以将符号引用转换为直接引用的。
 *
 */
public class MyTest3 {
    public static void test() {
        System.out.println("test invoked");
    }

    public static void main(String[] args) {
        test();
    }
}
