package baeldung.iteratorEnum;
import org.junit.Test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Stream;

/**
 * Created by shengchao wu on 7/19/2018.
 */
public class IteratorEnumTest {

    @Test
    public void givenEnum_iteratorWithForeach() {
//        EnumSet.allOf(DayOfWeekEnum.class).forEach(System.out::println);

//        Arrays.asList(DayOfWeekEnum.values()).forEach(System.out::println);

//        Stream.of(DayOfWeekEnum.values()).forEach(System.out::println);

        DayOfWeekEnum.stream()
                .filter(day -> day.getTypeOfDay().equals("off"))
                .forEach(System.out::println);


    }
}
