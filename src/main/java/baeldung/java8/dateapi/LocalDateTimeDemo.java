package baeldung.java8.dateapi;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * The LocalDateTime is used to represent a combination of date and time.
 *
 * This is the most commonly used class when we need a combination of date and time.
 * The class offers a variety of APIs and we will look at some of the most commonly used ones.
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);

        LocalDateTime.parse("2015-02-20T06:30:00");

        localDateTime.plusDays(1);

        localDateTime.minusHours(2);

        localDateTime.getMonth();
    }
}
