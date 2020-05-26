package jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 *  虚拟机栈： Stack Frame 栈帧
 *  程序计数器(Program counter)
 *  本地方法栈: native 方法
 *  堆(heap)：JVM管理的最大一块内存空间。与堆相关的一个重要概念是垃圾收集器。现代几乎所有的垃圾收集器都是采用分带手机算法。所以堆空间基于这点进行了相应的划分：新生代与老年代。
 *  eden空间、From Survivor空间与To Survivor空间。
 *  方法区(Method area): 存储元信息。永久代（Permanent Generation, 从JDK1.8开始，已经彻底废弃了永久代，使用元空间（meta space）。
 *  运行士常量池：方法区的一部分内容
 *  直接内存： Direct memory, 与Java NIO密切相关，JVM通过堆上的DirectByteBuffer来操作内存。
 *
 *  关于Java对象创建的3个步骤：
 *  1。在堆内存中创建出对象的实例。
 *  2。为对象的实例成员变量赋初始值。
 *  3。将对象的引用返回。
 *
 *  指针碰撞（前提是堆内存的空间通过一个指针进行分割，一侧是已经占用的空间，另一侧是未被占用的空间），一般是采用压缩算法的垃圾收集器采用。
 *  空闲列表（前提是堆内存的空间中已被使用和未被使用的空间是交织在一起的，虚拟机通过一个列表来记录哪些空间是可用的，哪些空间是被占用的，创建新对象时找出可以容纳下这个新对象的且未被占用的空间存放，同时修改列表上的记录）
 *
 *  对象在内存中的布局：
 *  1。对象头
 *  2。实例数据（）
 *
 *
 *  tools:
 *  jvisualvm
 */
public class MyTest1 {
    public static void main(String[] args) {
        List<MyTest1> list = new ArrayList<>();

        for (; ; ) {
            list.add(new MyTest1());
        }

    }
}
