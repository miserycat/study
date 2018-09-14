package baeldung.java8.dateapi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * The LocalDate represents a date in ISO format (yyyy-MM-dd) without time.
 *
 * It can be used to store dates like birthdays and paydays.
 *
 * An instance of current date can be created from the system clock as below:
 */
public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        LocalDate.of(2018, 9, 13);

        LocalDate.parse("2018-09-13");

        LocalDate tomorrow = LocalDate.now().plusDays(1);

        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);

        DayOfWeek thursday = LocalDate.parse("2018-09-13").getDayOfWeek();

        int thirteen = LocalDate.parse("2018-09-13").getDayOfMonth();

        boolean isLeapYear = LocalDate.now().isLeapYear();

        boolean notBefore = LocalDate.parse("2018-09-13").isBefore(LocalDate.parse("2018-09-12"));

        boolean isAfter = LocalDate.parse("2018-09-13").isAfter(LocalDate.parse("2018-09-12"));

        /*
         * Date boundaries can be obtained from a given date.
         * In the following two examples we get the LocalDateTime that represents the beginning of the day (2016-06-12T00:00) of the given date and the LocalDate that represents the beginning of the month (2016-06-01) respectively:
         */
        LocalDateTime beginningOfDay = LocalDate.parse("2018-09-13").atStartOfDay();

        System.out.println(beginningOfDay);

        LocalDate firstDayOfMonth = LocalDate.parse("2018-09-13").with(TemporalAdjusters.firstDayOfMonth());

        System.out.println(firstDayOfMonth);

    }
}
