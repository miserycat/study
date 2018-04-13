package java8;

/**
 * Created by shengchao wu on 2/9/2018.
 */
public interface MyPredictor<T> {
    boolean filter(T t);
}
