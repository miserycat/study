package wenjun.concurrent.chapter30;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

//frequent occurred errors
public class AtomicIntegerFieldUpdaterFailedTest {
    public static void main(String[] args) {
//        testPrivateField();
//        testTargetNull();
//        testFieldTypeNotMatch();
        testNoneVolatile();
    }


    //private field not allowed
    public static void testPrivateField() {
        AtomicIntegerFieldUpdater<TestMe> updater = AtomicIntegerFieldUpdater.newUpdater(TestMe.class, "i2");
        TestMe me = new TestMe();
        updater.compareAndSet(me, 0, 1);
    }

    public static void testTargetNull() {
        AtomicIntegerFieldUpdater<TestMe> updater = AtomicIntegerFieldUpdater.newUpdater(TestMe.class, "i1");
        updater.compareAndSet(null, 0, 1);
    }

    public static void testFieldTypeNotMatch() {
//        AtomicReferenceFieldUpdater<TestMe, Integer> updater = AtomicReferenceFieldUpdater.newUpdater(TestMe.class, Integer.class, "integer");
        AtomicReferenceFieldUpdater<TestMe, Long> updater = AtomicReferenceFieldUpdater.newUpdater(TestMe.class, Long.class, "integer");
        TestMe me = new TestMe();
        updater.compareAndSet(me, null, 1L);
    }

    public static void testNoneVolatile() {
        AtomicReferenceFieldUpdater<TestMe, Integer> updater = AtomicReferenceFieldUpdater.newUpdater(TestMe.class, Integer.class, "noneVolatile");
        TestMe me = new TestMe();
        updater.compareAndSet(me, null, 1);
    }
}
