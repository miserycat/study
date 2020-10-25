package jvm.classloader;

/*
    在编译阶段常量会被存入到调用该常量的方法的所在类的常量池中。
    本质上，调用类并没有直接引用到定义常量的类，因此不会触发定义常量类的初始化。
    注意：这里指的是将常量存放到了MyTest2的常量池中，之后MyTest2与MyParent2就没有任何关系了
    甚至，我们可以将MyParent2的class文件删除。
    javap -c Mytest.class

    //助记符：
      ldc表示将int,float或是String类型的常量值从常量池中推送到栈顶
      bipush表示将单字节（-128 ~ 127）的常量值
      sipush表示将一个短整形常量值 (-32768 ~ 32767)推送至栈顶
      iconst_x(-1<=x<=5)表示将int类型x推送至栈顶

 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.str);
    }
}

class MyParent2 {
    public static final String str = "hello world";

    public static final short s = 127;

    public static final int i = 128;

    public static final int m = 1;

    static {
        System.out.println("myParent2 static block...");
    }
}

