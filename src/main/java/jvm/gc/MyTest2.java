package jvm.gc;

/**
 * java -XX:+PrintCommandLineFlags -version 查看JVM默认启动时带的参数
 *
 *
 * -XX:PretenureSizeThreshold=4194304   对象直接在老年代分配的阈值，超过就在老年代分配，必须和SerialGC配合使用才有效果
 * -XX:+UseSerialGC
 * 经历了多次GC后，存活的对象会在From Survivor和To Survivor之前来回存放，而这里面的一个前提是这两个空间有足够的大小来存放这些数据，在GC算法中，会计算每个对象年龄的大小，
 * 如果达到某个年龄后发现总大小已经大于了Survivor空间的50%，这个时候需要调整阈值，不能再继续等到默认的15次GC后才完成晋升，因为这样会导致Survivor空间不足，所以需要调整阈值，让这些存活的对象尽快完成晋升。
 * -XX:MaxTenuringThreshold=5 设置可以晋升到老年代的经历GC的次数的阈值，该参数默认值为15，CMS中默认是6，G1中默认为15（在JVM中，该数值是由4个bit来表示，所以最大1111，即15）
 *
 * -XX:+PrintTenuringDistribution
 */
public class MyTest2 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] b1 = new byte[size * 5];


    }
}
