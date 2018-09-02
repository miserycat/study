package java8;

@FunctionalInterface
public interface ThreeFunction<T, U, K, R> {
  R apply(T t, U u, K k);


}
