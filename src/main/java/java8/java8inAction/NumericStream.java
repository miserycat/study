package java8.java8inAction;

import java.util.stream.IntStream;

public class NumericStream {

  public static void main(String[] args) {
//    Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
//    IntStream intStream = stream.mapToInt(Integer::intValue);
//    int result = intStream.filter(i -> i > 3).reduce(0, (i, j) -> i + j);
//    System.out.println(result);
//
    int a = 9;
    //1 ... 100 中满足勾股定理的数  sqrt(a*a + b*b)%1==0;

//    IntStream.rangeClosed(0 ,100)
//        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//        .boxed()
//        .map(b -> new int[] {a, b, (int)Math.sqrt(a * a + b * b) })
//        .forEach(r -> System.out.println("a:" + r[0] + " b:" + r[1] + " c:" + r[2]));

    IntStream.rangeClosed(0 ,100)
        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
        .mapToObj(b -> new int[] {a, b, (int)Math.sqrt(a * a + b * b) })
        .forEach(r -> System.out.println("a:" + r[0] + " b:" + r[1] + " c:" + r[2]));
  }

}
