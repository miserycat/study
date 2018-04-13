package java8;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * Created by shengchao wu on 3/8/2018.
 */
public class LocalDataTimeTest {

    //LocalDate LocalTime LocalDateTime

    //Instant:timestamp unix year 1970-1-1 00:00:00

    @Test
    public void test1(){
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime dateTime = LocalDateTime.of(2018, 3, 8, 14, 32, 30);
        System.out.println(dateTime);
        LocalDateTime time = ldt.plusYears(2);
        System.out.println(time);
        time = ldt.minusYears(2);
        System.out.println(time);
    }

    @Test
    public void test2() {
        Instant instant1 = Instant.now(); //timeZone UTC
        System.out.println(instant1);

        OffsetDateTime offsetDateTime = instant1.atOffset(ZoneOffset.ofHours(8));

        System.out.println(offsetDateTime);

        long ms = offsetDateTime.toEpochSecond();//millionSecond

        System.out.println(ms);

        Instant instant2 = Instant.ofEpochSecond(1000);

        System.out.println(instant2);

    }


    @Test
    public void test3() throws InterruptedException {
        Instant instant1 = Instant.now();
        Thread.sleep(2000);
        Instant instant2 = Instant.now();
        Duration d = Duration.between(instant1, instant2);
        long ms = d.toMillis();
        System.out.println(ms);
    }

    @Test
    public void test4() {
        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2017, 12, 1);
        Period period = Period.between(ld2, ld1);

        System.out.println(period.getDays());

    }


    //TemporalAdjuster eg:get the next working day, get next sunday
    @Test
    public void test5() {
        LocalDate now = LocalDate.now();

        LocalDate lt1 = now.withDayOfMonth(31);

        System.out.println(lt1.getDayOfWeek());

        now.with(TemporalAdjusters.firstDayOfMonth());

        now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        //customer adjuster
        //next working day

        LocalDate nexWorkingDay = now.with(l -> {
            LocalDate ld = (LocalDate) l;

            DayOfWeek dayOfWeek = ld.getDayOfWeek();

            switch (dayOfWeek) {
                case FRIDAY:
                    return ld.plusDays(3);
                case SATURDAY:
                    return ld.plusDays(2);
                default:
                    return ld.plusDays(1);
            }
        });
        System.out.println(nexWorkingDay);
    }


    //DateTimeFormatter
    @Test
    public void test6() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

        LocalDateTime ldt = LocalDateTime.now();

        System.out.println(formatter.format(ldt));

        //custom pattern

        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(customFormatter.format(ldt));

        LocalDateTime parseDate = ldt.parse("2016-12-12 12:12:12", customFormatter);

        System.out.println(parseDate);

    }

    //ZonedDate ZonedTime ZonedDateTime
    @Test
    public void test7() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();

//        for (Iterator<String> iterator = availableZoneIds.iterator(); iterator.hasNext();) {
//            String next = iterator.next();
//            System.out.println(next);
//        }
//        availableZoneIds.forEach(System.out::println);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));

        System.out.println(now);

        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);

    }



}
