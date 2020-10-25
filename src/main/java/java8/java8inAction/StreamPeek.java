package java8.java8inAction;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class StreamPeek {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a", "b", "c");
        //peek不会关闭stream
        list.stream()
                .peek(System.out::println)
                .map(s -> s + "1")
                .collect(Collectors.toList());


    }
}
