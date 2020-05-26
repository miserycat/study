package jvm.gc;

//-verbose:gc
//-Xms20M 堆初始化大小20m
//-Xmx20M 堆最大20m
//-xmn10M 新生代10m
//-XX:+PrintGCDetails 打印垃圾回收详细信息
//-XX:SurvivorRatio=8 eden:survivor = 8 : 1 : 1

//下面两个垃圾收集器是jdk1.8默认的新生代和老年代垃圾收集器
//PSYoungGen:Parallel Scavenge(新生代垃圾收集器)
//ParOldGen:Parallel old(老年代垃圾收集器)



//gc log
//[GC (Allocation Failure) [PSYoungGen: 8060K->995K(9216K)] 8060K->5288K(19456K), 0.0052109 secs] [Times: user=0.05 sys=0.00, real=0.00 secs]
// GG/Full GC
//(Allocation Failure) ： GC的原因
//[PSYoungGen: 8060K->995K(9216K)] 新生代在垃圾收集前存活的对象大小8060k, 垃圾收集后存活对象占995k, 新生代总容量9216k
//8060K->5288K(19456K):在执行GC之前堆总空间大小是8060k，在执行GC之后堆中存活的对象大小5288，19456k堆的总容量。
//[Times: user=0.05 sys=0.00, real=0.00 secs] 此次垃圾回收用户空间用时0.05秒，内核空间0.00, 实际执行时间0.0.0

//如果在给对象分配内存的时候发现新生代已经分配不下了，那么这个对象直接在老年代分配内存。
public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] allocate1 = new byte[2 * size];
        byte[] allocate2 = new byte[2 * size];
        byte[] allocate3 = new byte[2 * size];
        byte[] allocate4 = new byte[2 * size];

        System.out.println("Hello World");
    }


}
