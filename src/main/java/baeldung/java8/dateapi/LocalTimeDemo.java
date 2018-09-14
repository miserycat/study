package baeldung.java8.dateapi;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * The LocalTime represents time without a date.
 *
 * Similar to LocalDate an instance of LocalTime can be created from system clock or by using ¡°parse¡± and ¡°of¡± method.
 */
public class LocalTimeDemo {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime sixThirty = LocalTime.parse("06:30");
//        LocalTime sixThirty = LocalTime.of(6, 30);
        LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
        int six = LocalTime.parse("06:30").getHour();
        boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));

        LocalTime max = LocalTime.MAX;
        System.out.println(max);
    }
}
