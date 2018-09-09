package java8;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by shengchao wu on 8/21/2018.
 */
public class TestDate {

    @Test
    public void test1() {
//        List<String> list = Arrays.asList("a", "b", "c", "d");
        List<String> list = null;

        Map<String, Object> map = new HashMap<>();
        map.put("header", null);

        Map<String, String> map2 = new HashMap<>();

        map.entrySet().forEach(entry -> map2.put(entry.getKey(), entry.getValue() == null ? null : entry.getValue().toString()));
        map.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue() == null ? null : entry.getValue()));
    }

    @Test
    public void test2() {
        System.out.println(String.format("%s loves %s", "A", "B"));
    }
}
