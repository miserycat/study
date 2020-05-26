package wenjun.concurrent.chapter30;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicFieldUpdater使用场景
 * 1。想让类的属性操作具有原子性
 * 2。不想使用显示锁或者synchronized
 * 3. 大量需要原子类型修饰的对象，相比耗费内存。
 *
 */
public class AtomicFiledUpdaterScenario {
    private volatile int i;

    private AtomicIntegerFieldUpdater<AtomicFiledUpdaterScenario> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicFiledUpdaterScenario.class, "i");

    public void update(int newValue) {
        updater.compareAndSet(this, i , newValue);
    }

    public int get() {
        return i;
    }

    public static void main(String[] args) {
        AtomicFiledUpdaterScenario scenario = new AtomicFiledUpdaterScenario();
        scenario.update(10);
        System.out.println(scenario.get());
    }
}
