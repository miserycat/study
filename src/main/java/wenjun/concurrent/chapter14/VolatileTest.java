package wenjun.concurrent.chapter14;

//i = i + 1; main memory ->i -> cache i+1 -> main memory
//在多线程环境下会有缓存一致性问题如下
//cpu1 -> main memory -> i -> cache i+1 -> cache(2) -> main memory(2)
//cpu2 -> main memory -> i -> cache i+1 -> cache(2) -> main memory(2)
//解决方案
//1。给数据总线加锁
//      总线（数据总线，地址总线，控制总线）
//      LOCK#
//2.CPU高速缓存一致性协议 Intel MESI
//核心思想：
//  1。当cpu写入数据的时候，如果发现该变量被共享（也就是说，在其他cpu中也存在该变量的副本），会发出一个信号，通知其他cpu该变量的缓存无效，
//  2。当其他cpu访问该变量的时候，重新到主内存去获取
//
//  并发编程的三个比较重要的概念
// 1。原子性（Atomic）：一个操作或者多个操作要么全部成功，要么都失败，中间不能由于任何的因素中断，
//   i = 10; i++; (1. read from memory 10, 2. i = 10 + 1, 3. i = 11 ) 这种就不满足原子性
// 2。可见性：
// 3。有序性：重排序只要求最终一致性

//volatile 可以保证内存的可见性，禁止代码重排序，但是不能保证原子性。
//  1。保证重排序的时候不会把后面的指令放到屏障的前面，也不会把钱买呢的放到后面，
//  2。强制对缓存的修改操作立刻写入主存
//  3。如果是写操作，会使其他cpu中的缓存失效。

public class VolatileTest {
    private static volatile int INIT_VALUE = 0;

    private static int MAX_LIMIT = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
                if (localValue != INIT_VALUE) {
                    System.out.println("The value updated to " + INIT_VALUE);
                    localValue = INIT_VALUE;

                }
            }
        }, "READER").start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
                System.out.println("Update the value to " + ++localValue);
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "UPDATER").start();
    }
}
