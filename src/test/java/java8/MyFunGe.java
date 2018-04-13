package java8;

/**
 * Created by shengchao wu on 2/13/2018.
 */
@FunctionalInterface
public interface MyFunGe<T, R> {
    public R getValue(T t1, T t2);
}
