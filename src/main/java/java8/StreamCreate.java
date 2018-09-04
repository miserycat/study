package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreate {

  public static void main(String[] args) {
//    createStreamByPath();
//
//    createIteratorStream().forEach(System.out::println);
//
//    createRandomStream().forEach(System.out::println);

//    createInfiniteStream().forEach(System.out::println);

    IntStream.range(0, 10)
            .forEach(index -> System.out.print(index));
  }

  private static Stream<String> createStreamByCollection() {
    return Arrays.asList("hello", "world", "stream", "world")
        .stream();

  }

  private static Stream<String> createStreamByStreamOf() {
    return Stream.of("hello");
  }

  private static Stream<String> createStreamByPath() {
    Path path  = Paths.get("C:\\study\\src\\main\\java\\java8\\ThreeFunction.java");

    try (Stream<String> streamFromFile = Files.lines(path)) {
      streamFromFile.forEach(System.out::println);
      return streamFromFile;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  private static Stream<Integer> createIteratorStream() {
    return Stream.iterate(0, n -> n+2).limit(100);
  }

  private static Stream<Double> createRandomStream() {
    return Stream.generate(Math::random).limit(10);
  }

  private static Stream<Obj> createInfiniteStream() {
    return Stream.generate(new ObjSupplier()).limit(10);
  }


  static class ObjSupplier implements Supplier<Obj> {
    private int index;

    private Random random = new Random(System.currentTimeMillis());


    @Override
    public Obj get() {
      index = random.nextInt(100);
      return new Obj(index, "name: " + index);
    }
  }


  static class Obj {
    private int id;

    private String name;

    public Obj(int id, String name) {
      this.id = id;
      this.name = name;
    }

    @Override
    public String toString() {
      return "Obj{" +
          "id=" + id +
          ", name='" + name + '\'' +
          '}';
    }
  }






}
