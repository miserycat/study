package baeldung.java8.dateapi;

import java.time.*;

/**
 * Java 8 provides ZonedDateTime when we need to deal with time zone specific date and time.
 * The ZoneId is an identifier used to represent different zones.
 * There are about 40 different time zones and the ZoneId are used to represent them as follows.
 */
public class TimeZoneDemo {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");

        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(s -> s.startsWith("Asia"))
                .forEach(System.out::println);

        //The LocalDateTime can be converted to a specific zone:
        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(localDateTime1, zoneId);

        //The ZonedDateTime provides parse method to get time zone specific date time:
        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");


        //Another way to work with time zone is by using OffsetDateTime.
        //The OffsetDateTime is an immutable representation of a date-time with an offset.
        //This class stores all date and time fields, to a precision of nanoseconds, as well as the offset from UTC/Greenwich.
        LocalDateTime localDateTime2 = LocalDateTime.of(2015, Month.FEBRUARY, 20, 6, 30);
        ZoneOffset offset = ZoneOffset.of("+02:00");
        OffsetDateTime offSetByTwo = OffsetDateTime.of(localDateTime2, offset);

    }

}
